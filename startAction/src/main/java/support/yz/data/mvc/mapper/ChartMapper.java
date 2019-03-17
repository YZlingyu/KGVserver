package support.yz.data.mvc.mapper;

import java.sql.Date;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Service;
import support.yz.data.entity.chart.*;
import support.yz.data.entity.node.EnterpriseBaseImport;
import support.yz.data.entity.node.NewsBaseOriginal;

/**
 * @Author: yangzhuo
 * @Description: 图表mapper
 * @Date: 2018/7/23
 */
@Mapper
public interface ChartMapper {
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 图表保存
     * @Date: 12:40 2018/7/23
     */
    @Insert("INSERT INTO chart (chart_id,chart_info,layout,tech, note) VALUES(#{chartId},#{chartInfo},#{layout},#{tech}, #{note})")
    @SelectKey(keyProperty = "chartId", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    Boolean saveChart(Chart chart);

    
    /**
     * @Author: yangzhuo
     * @Descriptor: 获取图表
     * @Date: 12:40 2018/7/24
     */
    @Select("SELECT * FROM chart WHERE chart_id = #{chartId}")
    @Results({
		@Result(id=true,property="chartId",column="chart_id"),
		@Result(property="chartInfo",column="chart_info"),
		@Result(property="layout",column="layout"),
		@Result(property="tech",column="tech")
	})
    Chart getChartById(@Param("chartId") String chartId);

    @Select("SELECT * FROM technology LIMIT 10")
    @Results({
        @Result(id=true,property="id",column="id"),
        @Result(property="name",column="name")
    })
    List<Technology2> getTechnologyList();

    @Insert("INSERT INTO WorkChart(technologyId,id,name,abscissa,ordinate) VALUES(#{technologyId},#{id},#{workChart.name},#{workChart.abscissa},#{workChart.ordinate})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    Boolean saveWorkChart(@Param("technologyId") String technologyId,@Param("workChart")WorkChart workChart);
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 保存节点信息
     * @Date: 16:41 2018/9/14
     */
    @Insert("INSERT INTO knowledgeGroup VALUES(#{groupId},#{groupName},#{groupExplain},#{groupNode})")
    @SelectKey(keyProperty = "groupId", resultType = String.class, before = true, 
	statement = "select replace(uuid(), '-', '') as id from dual")
    Boolean saveKnowledgeGroup(KnowledgeGroup knowledgeGroup);
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 删除节点信息
     * @Date: 16:41 2018/9/14
     */
    @Delete("delete from knowledgeGroup where groupId = #{groupId}")
    Boolean deleteKnowledgeGroup(String groupId);
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 修改节点信息
     * @Date: 16:41 2018/9/14
     */
    @Update("update knowledgeGroup set groupName=#{groupName},groupExplain=#{groupExplain},groupNode=#{groupNode} where groupId=#{groupId}")
    Boolean updateKnowledgeGroup(KnowledgeGroup knowledgeGroup);
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 从mysql查找所有的已经导入到neo4j的新闻
     * @Date: 15:24 2018/7/25
     */
    @Select("SELECT news_id,title,abstract,keywords,time,ner_names FROM NEWS_BASE_ORIGINAL WHERE import_flag = 1")
    List<NewsBaseOriginal> findImports();
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 查找所有的已经导入到neo4j的企业
     * @Date: 15:29 2018/7/25
     */
    @Select("SELECT com_name,uni_code,persons,est_date,reg_capital,address FROM ENTERPRISE_BASE_IMPORT WHERE import_flag = 0")
    List<EnterpriseBaseImport> findImport();
    
    @Select("SELECT news_id,ner_names,time,title,abstract,keywords FROM NEWS_BASE_ORIGINAL WHERE news_id = ?")
    NewsBaseOriginal findByNewsId(String news_id);

    @Select("SELECT * FROM chart WHERE tech = #{tech}")
    @Results({
            @Result(id=true,property="chartId",column="chart_id"),
            @Result(property="chartInfo",column="chart_info"),
            @Result(property="reportName",column="report_name"),
            @Result(property="layout",column="layout"),
            @Result(property="tech",column="tech")
    })
    List<Chart> getChartByTech(String tech);

    @Insert("INSERT INTO report (report_id,tech,report_name,layouts,chart_name,chart_note,create_time) VALUES(#{reportId},#{tech},#{reportName},#{layouts},#{chartName},#{chartNote},NOW())")
    @SelectKey(keyProperty = "reportId", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    Boolean saveReport(Report report);

    @Select("SELECT * FROM report ORDER BY create_time DESC")
    @Results({
            @Result(id=true,property="reportId",column="report_id"),
            @Result(property="tech",column="tech"),
            @Result(property="reportName",column="report_name"),
            @Result(property="layouts",column="layouts"),
            @Result(property="chartName",column="chart_name"),
            @Result(property="chartNote",column="chart_note"),
            @Result(property="createTime",column="create_time")
    })
    List<Report> getAllReport();

    @Select("SELECT * FROM report WHERE tech = #{tech}")
    @Results({
            @Result(id=true,property="reportId",column="report_id"),
            @Result(property="tech",column="tech"),
            @Result(property="reportName",column="report_name"),
            @Result(property="layouts",column="layouts"),
            @Result(property="chartName",column="chart_name"),
            @Result(property="chartNote",column="chart_note"),
            @Result(property="createTime",column="create_time")
    })
    List<Report> getReportByTechnology(String tech);


    /**
     * @Author: yangzhuo
     * @Descriptor: 增加子节点信息
     * @Date: 16:41 2018/9/14
     */
//    @Update("update knowledgeGroup set groupName=#{groupName},groupExplain=#{groupExplain},groupNode=#{groupNode} where groupId=#{groupId}")
//    Boolean addKnowledgeGroup(KnowledgeGroup knowledgeGroup);

}
