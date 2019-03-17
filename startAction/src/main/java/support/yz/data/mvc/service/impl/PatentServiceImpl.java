package support.yz.data.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import support.yz.data.entity.entityInfo.EnterprisePatent;
import support.yz.data.mvc.mapper.PatentMapper;
import support.yz.data.mvc.service.inter.PatentService;

@Service
public class PatentServiceImpl implements PatentService {
    @Autowired
    private PatentMapper patentMapper;
    public EnterprisePatent getPatentByName(String patentName) throws Exception {
        return patentMapper.getPatentByName(patentName);
    }
}
