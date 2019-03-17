package support.yz.data.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import support.yz.data.entity.entityInfo.EnterpriseAchievements;
import support.yz.data.entity.entityInfo.EnterprisePatent;
import support.yz.data.entity.response.DataResponse;
import support.yz.data.mvc.service.inter.AchievementsService;
import support.yz.data.mvc.service.inter.PatentService;

@CrossOrigin // 请求跨域处理
@RestController
@RequestMapping(value = "/KGV/achievements")
public class AchievementsController {
    private final static Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private AchievementsService achievementsService;
    @RequestMapping(value = "getAchievementsByName/{achievementsName}",method = RequestMethod.GET)
    public DataResponse getPatentByName(@PathVariable("achievementsName") String achievementsName){
        try{
            EnterpriseAchievements list = achievementsService.getAchievementsByName(achievementsName);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to AcievementsController.getAchievementsName", e);
            return DataResponse.buildErrorResponse();
        }
    }
}
