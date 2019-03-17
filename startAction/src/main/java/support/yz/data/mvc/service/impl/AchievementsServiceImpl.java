package support.yz.data.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import support.yz.data.entity.entityInfo.EnterpriseAchievements;
import support.yz.data.mvc.mapper.AchievementMapper;
import support.yz.data.mvc.service.inter.AchievementsService;

@Service
public class AchievementsServiceImpl implements AchievementsService{
    @Autowired
    private AchievementMapper achievementMapper;
    public EnterpriseAchievements getAchievementsByName(String achievementsName) throws Exception {
        return achievementMapper.getAchievemnetsByName(achievementsName);
    }
}
