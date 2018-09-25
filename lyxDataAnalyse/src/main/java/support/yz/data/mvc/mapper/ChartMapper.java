package support.yz.data.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import support.yz.data.entity.chart.Chart;
import support.yz.data.entity.chart.Chart2;
import support.yz.data.entity.chart.KnowledgeGroup;
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
    @Insert("INSERT INTO chart VALUES(#{chartId},#{chartTitle},#{chartX},#{chartY},#{chartColor},#{chartType},#{chartXTitle},#{chartXUnit},#{chartYTitle},#{chartYUnit},#{chartMax},#{chartMin})")
    Boolean saveChart(Chart chart);
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 图表保存
     * @Date: 12:40 2018/7/23
     */
    @Insert("INSERT INTO chart2 " +
            "(" +
            "id," +
            "type," +
            "chartX," +
            "title," +
            "chartType," +
            "axisTitle," +
            "axisUnit," +
            "axisMax," +
            "axisMin," +
            "axisRemark," +
            "chartY" +
            ") " +
            "VALUES(" +
            "#{id}," +
            "#{type}," +
            "#{chartX}," +
            "#{title}," +
            "#{chartType}," +
            "#{axisTitle}," +
            "#{axisUnit}," +
            "#{axisMax}," +
            "#{axisMin}," +
            "#{axisRemark}," +
            "#{chartY})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
	statement = "select replace(uuid(), '-', '') as id from dual")
    Boolean saveChart2(Chart2 chart);
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 获取图表
     * @Date: 12:40 2018/7/24
     */
    @Select("SELECT * FROM chart WHERE CHART_TITLE = #{chartTitle}")
    @Results({
		@Result(id=true,property="chartId",column="CHART_ID"),
		@Result(property="chartTitle",column="CHART_TITLE"),
		@Result(property="chartX",column="CHART_X"),
		@Result(property="chartY",column="CHART_Y"),
		@Result(property="chartColor",column="CHART_COLOR"),
		@Result(property="chartType",column="CHART_TYPE"),
		@Result(property="chartXTitle",column="CHART_X_TITLE"),
		@Result(property="chartXUnit",column="CHART_X_UNIT"),
		@Result(property="chartYTitle",column="CHART_Y_TITLE"),
		@Result(property="chartYUnit",column="CHART_Y_UNIT"),
		@Result(property="chartMax",column="CHART_MAX"),
		@Result(property="chartMin",column="CHART_MIN")
	})
    Chart getChartByTitle(@Param("chartTitle") String chartTitle);
    
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
}
