package support.yz.data.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import support.yz.data.entity.entityInfo.*;
import support.yz.data.entity.response.DataResponse;
import support.yz.data.mvc.service.inter.TechnologyService;

import java.util.List;

@CrossOrigin // 请求跨域处理
@RestController
@RequestMapping(value = "/KGV/technology")
public class TechnologyController {

    private final static Logger logger = LoggerFactory.getLogger(TechnologyController.class);

    @Autowired
    private TechnologyService technologyService;

    /**
     * @Descriptor 查技术成果
     * @param achievementsDomain
     * @return
     */
    @RequestMapping(value = "getEnterpriseAchievementsByTechnology/{achievementsDomain}",method = RequestMethod.GET)
    public DataResponse getCompanyAchievementsByTechnology(@PathVariable("achievementsDomain") String achievementsDomain){
        try{
            List<EnterpriseAchievements> list = technologyService.getCompanyAchievementsByTechnology(achievementsDomain);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CompanyController.getCompanyAchievementsByTechnology", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * @Descriptor 查技术公司
     * @param companyDomain
     * @return
     */
    @RequestMapping(value = "getEnterpriseByTechnology/{companyDomain}",method = RequestMethod.GET)
    public DataResponse getCompanyByTechnology(@PathVariable("companyDomain") String companyDomain){
        try{
            List<EnterpriseInfo> list = technologyService.getCompanyByTechnology(companyDomain);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CompanyController.getCompanyByTechnology", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * @Desciptor 查技术新闻
     */
    @RequestMapping(value = "getCompanyNewsByTechnology/{newsDomain}",method = RequestMethod.GET)
    public DataResponse getCompanyNewsById(@PathVariable("newsDomain") String newsDomain){
        try{
            List<EnterpriseNews> list = technologyService.getCompanyNewsByTechnology(newsDomain);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CompanyController.getCompanyNewsByTechnology", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * @Desciptor 查技术专利
     */
    @RequestMapping(value = "getCompanyPatentByTechnology/{patentDomain}",method = RequestMethod.GET)
    public DataResponse getCompanyPatentByTechnology(@PathVariable("patentDomain") String patentDomain){
        try{
            List<EnterprisePatent> list = technologyService.getCompanyPatentByTechnology(patentDomain);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CompanyController.getCompanyPatentByTechnology", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * @Desciptor 查技术信息
     */
    @RequestMapping(value = "getTechnologyInfoByName/{name}",method = RequestMethod.GET)
    public DataResponse getTechnologyInfoByName(@PathVariable("name") String name){
        try{
            TechnologyInfo list = technologyService.getTechnologyInfoByName(name);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to TechnologyController.getTechnologyInfoByName", e);
            return DataResponse.buildErrorResponse();
        }
    }
}

