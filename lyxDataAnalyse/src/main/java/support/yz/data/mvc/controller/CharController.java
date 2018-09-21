package support.yz.data.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import support.yz.data.entity.chart.Chart;
import support.yz.data.entity.chart.Chart2;
import support.yz.data.entity.chart.KnowledgeGroup;
import support.yz.data.entity.response.DataResponse;
import support.yz.data.mvc.service.inter.ChartService;

/**
 * @Author: yangzhuo
 * @Description: 图表接口
 * @Date: 2018/7/21
 */
@CrossOrigin // 请求跨域处理
@RestController
@RequestMapping(value = "/KGV/chart/")
public class CharController {
	
	private final static Logger logger = LoggerFactory.getLogger(CharController.class);

	@Autowired
    private ChartService chartService;

	/**
     * @Author: yangzhuo
     * @Descriptor: 保存图表信息
     * @Date: 11:16 2018/7/24
     */
    @RequestMapping(value = "saveChart", method = RequestMethod.POST)
    public DataResponse saveChart(Chart chart){
        try{
            Boolean result = chartService.saveChart(chart);
            return new DataResponse("success","200",result);
        } catch (Exception e){
        	logger.error("failed to CharController.saveChart", e);
            return DataResponse.buildErrorResponse();
        }
    }
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 保存图表信息
     * @Date: 11:16 2018/7/24
     */
    @RequestMapping(value = "saveChart2", method = RequestMethod.POST)
    public DataResponse saveChart2(Chart2 chart){
        try{
            Boolean result = chartService.saveChart2(chart);
            return new DataResponse("success","200",result);
        } catch (Exception e){
        	logger.error("failed to CharController.saveChart2", e);
            return DataResponse.buildErrorResponse();
        }
    }
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 获取图表信息
     * @Date: 13:20 2018/7/24
     */
    @RequestMapping(value = "getChart", method = RequestMethod.GET)
    public DataResponse getChartByTitle(String title){
        try{
        	Chart chart = chartService.getChartByTitle(title);
            return new DataResponse("success","200",chart);
        } catch (Exception e){
        	logger.error("failed to CharController.getChartByTitle", e);
            return DataResponse.buildErrorResponse();
        }
    }
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 保存节点信息
     * @Date: 16:41 2018/9/14
     */
    @RequestMapping(value = "saveKnowledgeGroup", method = RequestMethod.POST)
    public DataResponse saveKnowledgeGroup(KnowledgeGroup knowledgeGroup){
    	try{
            Boolean result = chartService.saveKnowledgeGroup(knowledgeGroup);
            return new DataResponse("success","200",result);
        } catch (Exception e){
        	logger.error("failed to CharController.saveKnowledgeGroup", e);
            return DataResponse.buildErrorResponse();
        }
    }
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 删除节点信息
     * @Date: 16:41 2018/9/14
     */
    @RequestMapping(value = "deleteKnowledgeGroup", method = RequestMethod.GET)
    public DataResponse deleteKnowledgeGroup(String groupId){
    	try{
            Boolean result = chartService.deleteKnowledgeGroup(groupId);
            return new DataResponse("success","200",result);
        } catch (Exception e){
        	logger.error("failed to CharController.deleteKnowledgeGroup", e);
            return DataResponse.buildErrorResponse();
        }
    }
<<<<<<< HEAD

    /**
     * @Author: yangzhuo
     * @Descriptor: 修改节点信息
     * @Date: 21:44 2018/9/14
     */
    @RequestMapping(value = "updateKnowledgeGroup", method = RequestMethod.POST)
    public DataResponse updateKnowledgeGroup(KnowledgeGroup knowledgeGroup){
        try{
            Boolean result = chartService.updateKnowledgeGroup(knowledgeGroup);
            return new DataResponse("success","200",result);
        } catch (Exception e){
            logger.error("failed to CharController.updateKnowledgeGroup", e);
=======
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 修改节点信息
     * @Date: 16:41 2018/9/14
     */
    @RequestMapping(value = "updateKnowledgeGroup", method = RequestMethod.POST)
    public DataResponse updateKnowledgeGroup(KnowledgeGroup knowledgeGroup){
    	try{
            Boolean result = chartService.updateKnowledgeGroup(knowledgeGroup);
            return new DataResponse("success","200",result);
        } catch (Exception e){
        	logger.error("failed to CharController.updateKnowledgeGroup", e);
>>>>>>> e969ab6fa14a93bd9e2295a9ea47b520fad4c744
            return DataResponse.buildErrorResponse();
        }
    }
}
