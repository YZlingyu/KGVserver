package support.yz.data.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import support.yz.data.entity.entityInfo.*;
import support.yz.data.mvc.mapper.TechnologyMapper;
import support.yz.data.mvc.service.inter.TechnologyService;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    private TechnologyMapper technologyMapper;

    public List<EnterpriseAchievements> getCompanyAchievementsByTechnology(String achievementsDomain) throws Exception {
        return technologyMapper.getCompanyAchievementsByTechnology(achievementsDomain);
    }

    public List<EnterpriseInfo> getCompanyByTechnology(String companyDomain) throws Exception {
        return technologyMapper.getCompanyByTechnology(companyDomain);
    }

    public List<EnterpriseNews> getCompanyNewsByTechnology(String newsDomain) throws Exception {
        return technologyMapper.getCompanyNewsByTechnology(newsDomain);
    }

    public List<EnterprisePatent> getCompanyPatentByTechnology(String patentDomain) throws Exception {
        return technologyMapper.getCompanyPatentByTechnology(patentDomain);
    }

    public TechnologyInfo getTechnologyInfoByName(String name) throws Exception {
        return technologyMapper.getTechnologyInfoByName(name);
    }
}

