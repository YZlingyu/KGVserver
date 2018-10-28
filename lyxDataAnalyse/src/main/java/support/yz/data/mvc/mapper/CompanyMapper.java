package support.yz.data.mvc.mapper;

import org.apache.ibatis.annotations.*;

import support.yz.data.entity.entityInfo.EnterpriseAchievements;
import support.yz.data.entity.entityInfo.EnterpriseInfo;
import support.yz.data.entity.entityInfo.EnterpriseNews;
import support.yz.data.entity.entityInfo.EnterprisePatent;

import java.util.List;

/**
 * 公司成果
 */
@Mapper
public interface CompanyMapper {

    /**
     * @Desciptor 查公司成果
     * @param companyId
     * @return
     */
    @Select("SELECT * FROM company_achievements WHERE company_id = #{companyId}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="achievementsName",column="achievements_name"),
            @Result(property="publishTime",column="publish_time"),
            @Result(property="achievementsDomain",column="achievements_domain"),
            @Result(property="companyId",column="company_id"),
            @Result(property="createTime",column="create_time"),
            @Result(property="actionTime",column="action_time")
    })
    List<EnterpriseAchievements> getCompanyAchievementsById(@Param("companyId") String companyId);



    /**
     *
     * @Descriptor 查公司信息
     */
    @Select("SELECT * FROM company_info WHERE id = #{companyId}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="companyName",column="company_name"),
            @Result(property="investmentId",column="investment_id"),
            @Result(property="financingId",column="financing_id"),
            @Result(property="companyDomain",column="company_domain"),
            @Result(property="companyCreateDate",column="company_create_date"),
            @Result(property="companyIntroduction",column="company_introduction"),
            @Result(property="companyAdd",column="company_add"),
            @Result(property="createTime",column="create_time"),
            @Result(property="actionTime",column="action_time")
    })
    EnterpriseInfo getCompanyInfoById(@Param("companyId") String companyId);

    /**
     * @Descriptor 查公司相关新闻
     */
    @Select("SELECT * FROM company_news WHERE company_id = #{companyId}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="title",column="title"),
            @Result(property="newsIntroduction",column="news_introduction"),
            @Result(property="newsDomain",column="news_domain"),
            @Result(property="companyId",column="company_id"),
            @Result(property="newsTime",column="news_time"),
            @Result(property="createTime",column="create_time"),
            @Result(property="actionTime",column="action_time")
    })
    List<EnterpriseNews> getCompanyNewsById(@Param("companyId") String companyId);

    /**
     * @Descriptor 查公司专利
     */
    @Select("SELECT * FROM company_patent WHERE company_id = #{companyId}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="patentName",column="patent_name"),
            @Result(property="publishTime",column="publish_time"),
            @Result(property="patentDomain",column="patent_domain"),
            @Result(property="companyId",column="company_id"),
            @Result(property="patentDetail",column="patent_detail"),
            @Result(property="createTime",column="create_time"),
            @Result(property="actionTime",column="action_time")
    })
    List<EnterprisePatent> getCompanyPatentById(@Param("companyId") String companyId);
}
