package support.yz.data.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import support.yz.data.entity.entityInfo.EnterprisePatent;
import support.yz.data.entity.response.DataResponse;
import support.yz.data.mvc.service.inter.PatentService;

@CrossOrigin // 请求跨域处理
@RestController
@RequestMapping(value = "/KGV/patent")
public class PatentController {

    private final static Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private PatentService patentService;
    @RequestMapping(value = "getPatentByName/{patentName}",method = RequestMethod.GET)
    public DataResponse getPatentByName(@PathVariable("patentName") String patentName){
        try{
            EnterprisePatent list = patentService.getPatentByName(patentName);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to PatentController.getPatentByName", e);
            return DataResponse.buildErrorResponse();
        }
    }
}
