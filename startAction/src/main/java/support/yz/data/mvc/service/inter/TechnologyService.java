package support.yz.data.mvc.service.inter;

import support.yz.data.entity.entityInfo.*;

import java.util.List;

public interface TechnologyService {
    public List<EnterpriseAchievements> getCompanyAchievementsByTechnology(String achievementsDomain) throws Exception;

    public List<EnterpriseInfo> getCompanyByTechnology(String companyDomain) throws Exception;

    public List<EnterpriseNews> getCompanyNewsByTechnology(String newsDomain) throws Exception;

    List<EnterprisePatent> getCompanyPatentByTechnology(String patentDomain) throws Exception;

    public TechnologyInfo getTechnologyInfoByName(String name) throws Exception;
}
