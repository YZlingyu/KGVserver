package support.yz.data.mvc.service.inter;

import support.yz.data.entity.entityInfo.EnterpriseAchievements;

public interface AchievementsService {
    EnterpriseAchievements getAchievementsByName(String achivementsName) throws Exception;
}
