package support.yz.data.mvc.service.inter;

import support.yz.data.entity.entityInfo.EnterpriseAchievements;
import support.yz.data.entity.entityInfo.EnterpriseInfo;
import support.yz.data.entity.entityInfo.EnterpriseNews;
import support.yz.data.entity.entityInfo.EnterprisePatent;

import java.util.List;

public interface CompanyService {
    public List<EnterpriseAchievements> getCompanyAchievementsById(String companyId) throws Exception;

    EnterpriseInfo getCompanyInfoById(String companyId) throws Exception;

    public List<EnterpriseNews> getCompanyNewsById(String companyId) throws Exception;

    public List<EnterprisePatent> getCompanyPatentById(String companyId) throws Exception;

    EnterpriseInfo getCompanyInfoByName(String companyName) throws Exception;

    List<EnterpriseNews> getCompanyNewsByName(String companyName) throws Exception;
}
