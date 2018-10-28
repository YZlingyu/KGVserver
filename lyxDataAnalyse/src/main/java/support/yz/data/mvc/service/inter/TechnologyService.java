package support.yz.data.mvc.service.inter;

import support.yz.data.entity.entityInfo.EnterpriseAchievements;
import support.yz.data.entity.entityInfo.EnterpriseInfo;
import support.yz.data.entity.entityInfo.EnterpriseNews;

import java.util.List;

public interface TechnologyService {
    public List<EnterpriseAchievements> getCompanyAchievementsByTechnology(String achievementsDomain) throws Exception;

    public List<EnterpriseInfo> getCompanyByTechnology(String companyDomain) throws Exception;

    //public List<EnterpriseNews> getCompanyNewsByTechnology(String newsDomain) throws Exception;
}
