package support.yz.data.mvc.service.inter;

import support.yz.data.entity.entityInfo.EnterprisePatent;

public interface PatentService {
    EnterprisePatent getPatentByName(String patentName) throws Exception;
}
