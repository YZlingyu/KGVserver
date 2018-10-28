package support.yz.data.mvc.mapper;

import org.apache.ibatis.annotations.*;
import support.yz.data.entity.entityInfo.EnterpriseAchievements;
import support.yz.data.entity.entityInfo.EnterpriseInfo;
import support.yz.data.entity.entityInfo.EnterpriseNews;

import java.util.List;

/**
 * 查技术
 */
@Mapper
public interface TechnologyMapper {
    /**
     * @Desciptor 查技术成果
     * @param achievementsDomain
     * @return
     */
    @Select("SELECT * FROM company_achievements WHERE locate(#{achievementsDomain},achievements_domain)")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="achievementsName",column="achievements_name"),
            @Result(property="publishTime",column="publish_time"),
            @Result(property="achievementsDomain",column="achievements_domain"),
            @Result(property="companyId",column="company_id"),
            @Result(property="createTime",column="create_time"),
            @Result(property="actionTime",column="action_time")
    })
    List<EnterpriseAchievements> getCompanyAchievementsByTechnology(@Param("achievementsDomain") String achievementsDomain);


    /**
     *
     * @Descriptor 查公司信息
     */
    @Select("SELECT * FROM company_info WHERE locate(#{companyDomain},company_domain)")
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
    List <EnterpriseInfo> getCompanyByTechnology(@Param("companyDomain") String companyDomain);

    /**
     * @Descriptor 查技术相关新闻
     */
    @Select("SELECT * FROM company_news WHERE news_domain = #{newsDomain}")
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
    List<EnterpriseNews> getCompanyNewsByTechnology(@Param("newsDomain") String newsDomain);
}
