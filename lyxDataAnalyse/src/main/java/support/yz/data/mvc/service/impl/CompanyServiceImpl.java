package support.yz.data.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import support.yz.data.entity.entityInfo.EnterpriseAchievements;
import support.yz.data.entity.entityInfo.EnterpriseInfo;
import support.yz.data.entity.entityInfo.EnterpriseNews;
import support.yz.data.entity.entityInfo.EnterprisePatent;
import support.yz.data.mvc.mapper.CompanyMapper;
import support.yz.data.mvc.service.inter.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public List<EnterpriseAchievements> getCompanyAchievementsById(String companyId) throws Exception {
        return companyMapper.getCompanyAchievementsById(companyId);
    }

    public EnterpriseInfo getCompanyInfoById(String companyId) throws Exception {
        return companyMapper.getCompanyInfoById(companyId);
    }

    public List<EnterpriseNews> getCompanyNewsById(String companyId) throws Exception {
        return companyMapper.getCompanyNewsById(companyId);
    }

    public List<EnterprisePatent> getCompanyPatentById(String companyId) throws Exception {
        return companyMapper.getCompanyPatentById(companyId);
    }
}
