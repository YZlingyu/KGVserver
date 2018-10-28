package support.yz.data.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import support.yz.data.entity.entityInfo.EnterpriseAchievements;
import support.yz.data.entity.entityInfo.EnterpriseInfo;
import support.yz.data.entity.entityInfo.EnterpriseNews;
import support.yz.data.entity.entityInfo.EnterprisePatent;
import support.yz.data.entity.response.DataResponse;
import support.yz.data.mvc.service.inter.CompanyService;

import java.util.List;

@CrossOrigin // 请求跨域处理
@RestController
@RequestMapping(value = "/KGV/company")
public class CompanyController {

    private final static Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    /**
     * @Descriptor 查公司成果
     * @param companyId
     * @return
     */
    @RequestMapping(value = "getEnterpriseAchievementsById/{companyId}",method = RequestMethod.GET)
    public DataResponse getCompanyAchievementsById(@PathVariable("companyId") String companyId){
        try{
            List<EnterpriseAchievements> list = companyService.getCompanyAchievementsById(companyId);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CompanyController.getCompanyAchievementsById", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * @Desciptor 查公司信息
     */
    @RequestMapping(value = "getCompanyInfoById/{companyId}",method = RequestMethod.GET)
    public DataResponse getCompanyInfoById(@PathVariable("companyId") String companyId){
        try{
            EnterpriseInfo list = companyService.getCompanyInfoById(companyId);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CompanyController.getCompanyInfoById", e);
            return DataResponse.buildErrorResponse();
        }
    }


    /**
     * @Desciptor 查公司新闻
     */
    @RequestMapping(value = "getCompanyNewsById/{companyId}",method = RequestMethod.GET)
    public DataResponse getCompanyNewsById(@PathVariable("companyId") String companyId){
        try{
            List<EnterpriseNews> list = companyService.getCompanyNewsById(companyId);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CompanyController.getCompanyNewsById", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * @Desciptor 查公司专利
     */
    @RequestMapping(value = "getCompanyPatentById/{companyId}",method = RequestMethod.GET)
    public DataResponse getCompanyPatentById(@PathVariable("companyId") String companyId){
        try{
            List<EnterprisePatent> list = companyService.getCompanyPatentById(companyId);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CompanyController.getCompanyPatentById", e);
            return DataResponse.buildErrorResponse();
        }
    }
}
