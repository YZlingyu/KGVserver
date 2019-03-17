package support.yz.data.mvc.mapper;

import org.apache.ibatis.annotations.*;
import support.yz.data.entity.entityInfo.EnterpriseAchievements;

@Mapper
public interface AchievementMapper {
    /**
     *
     * @Descriptor 查成果信息
     */
    @Select("SELECT * FROM company_achievements WHERE achievements_name = #{achievementsName}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="achievementsName",column="achievements_name"),
            @Result(property="publishTime",column="publish_time"),
            @Result(property="achievementsDomain",column="achievements_domain"),
            @Result(property="companyId",column="company_id"),
            @Result(property="createTime",column="create_time"),
            @Result(property="actionTime",column="action_time")
    })
    EnterpriseAchievements getAchievemnetsByName(@Param("achievementsName") String achievementsName);
}
