package support.yz.data.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import support.yz.data.entity.chart.*;
import support.yz.data.entity.neo4j.Technology;
import support.yz.data.entity.response.DataResponse;
import support.yz.data.mvc.mapper.NodeRepository;
import support.yz.data.mvc.mapper.RTechnologyTechnologyRepository;
import support.yz.data.mvc.service.inter.ChartService;
import support.yz.data.mvc.service.inter.QueryNeo4jService;

import java.util.*;

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

    @Autowired
    private QueryNeo4jService queryNeo4jService;

    @Autowired
    private RTechnologyTechnologyRepository rTechnologyTechnologyRepository;

    @Autowired
    private NodeRepository nodeRepository;


    /**
     * @Author: yangzhuo
     * @Descriptor: 保存图表信息
     * @Date: 11:16 2018/7/24
     */
    @RequestMapping(value = "saveChart", method = RequestMethod.POST)
    public DataResponse saveChart(Chart chart) {
        try {
            Boolean result = chartService.saveChart(chart);
            return new DataResponse("success", "200", result);
        } catch (Exception e) {
            logger.error("failed to CharController.saveChart", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * 根据产业链查询图表
     */
    @RequestMapping(value = "getChartByTech/{tech}", method = RequestMethod.GET)
    public DataResponse getChartByTech(@PathVariable("tech") String tech){
        try {
            List<Chart> list = chartService.getChartByTech(tech);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CharController.getChartByTech", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * 保存报告
     */
    @RequestMapping(value = "saveReport", method = RequestMethod.POST)
    public DataResponse saveReport(Report report){
        try {
            Boolean result = chartService.saveReport(report);
            return new DataResponse("success", "200",result);
        } catch (Exception e) {
            logger.error("failed to CharController.saveReport", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * 获取所有报告
     */
    @RequestMapping(value = "getAllReport",method = RequestMethod.GET)
    public DataResponse getAllReport(){
        try {
            List<Report> list = chartService.getAllReport();
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CharController.getAllReport", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * 通过技术名获取报告
     */
    @RequestMapping(value = "getReportByTechnology/{tech}",method = RequestMethod.GET)
    public DataResponse getReportByTechnology(@PathVariable("tech") String tech){
        try {
            List<Report> list = chartService.getReportByTechnology(tech);
            return new DataResponse("success", "200", list);
        } catch (Exception e) {
            logger.error("failed to CharController.getReportByTechnology", e);
            return DataResponse.buildErrorResponse();
        }
    }


    /**
     * @Author: yangzhuo
     * @Descriptor: 获取图表信息
     * @Date: 13:20 2018/7/24
     */
    @RequestMapping(value = "getChart/{chartId}", method = RequestMethod.GET)
    public DataResponse getChartById(@PathVariable("chartId") String chartId) {
        try {
            Chart chart = chartService.getChartById(chartId);
            return new DataResponse("success", "200", chart);
        } catch (Exception e) {
            logger.error("failed to CharController.getChartByTitle", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * 获得技术链
     */
    @RequestMapping(value = "getTechnologyList",method = RequestMethod.GET)
    public DataResponse getTechnologyList(){
        try {
            List<Technology2> technologyList= chartService.getTechnologyList();
            return new DataResponse("success", "200", technologyList);
        } catch (Exception e) {
            logger.error("failed to CharController.getTechnologyList", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * 保存工作表
     */
    @RequestMapping(value = "saveWorkChart/{technologyId}",method = RequestMethod.POST)
    @ResponseBody
    public DataResponse saveWorkChart(@PathVariable("technologyId") String technologyId,@RequestBody WorkChart[] workCharts){
        try {
            for(WorkChart workChart :workCharts){
                chartService.saveWorkChart(technologyId,workChart);
            }
            return new DataResponse("success", "200", true);
        } catch (Exception e) {
            logger.error("failed to CharController.saveWorkChart", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * @Author: yangzhuo
     * @Descriptor: 保存节点信息
     * @Date: 16:41 2018/9/14
     */
    @RequestMapping(value = "saveKnowledgeGroup", method = RequestMethod.POST)
    public DataResponse saveKnowledgeGroup(KnowledgeGroup knowledgeGroup) {
        try {
            Boolean result = chartService.saveKnowledgeGroup(knowledgeGroup);
            return new DataResponse("success", "200", result);
        } catch (Exception e) {
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
    public DataResponse deleteKnowledgeGroup(String groupId) {
        try {
            Boolean result = chartService.deleteKnowledgeGroup(groupId);
            return new DataResponse("success", "200", result);
        } catch (Exception e) {
            logger.error("failed to CharController.deleteKnowledgeGroup", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     * @Author: yangzhuo
     * @Descriptor: 修改节点信息
     * @Date: 16:41 2018/9/14
     */
    @RequestMapping(value = "updateKnowledgeGroup", method = RequestMethod.POST)
    public DataResponse updateKnowledgeGroup(KnowledgeGroup knowledgeGroup) {
        try {
            Boolean result = chartService.updateKnowledgeGroup(knowledgeGroup);
            return new DataResponse("success", "200", result);
        } catch (Exception e) {
            logger.error("failed to CharController.updateKnowledgeGroup", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     *
     */
    @RequestMapping(value = "getAllTechnologyNames", method = RequestMethod.GET)
    public DataResponse getAllTechnologyNames() {
        try {
            Map<Long,String> names = chartService.getAllTechnologyNames();
            return new DataResponse("success", "200", names);
        } catch (Exception e) {
            logger.error("failed to CharController.updateKnowledgeGroup", e);
            return DataResponse.buildErrorResponse();
        }
    }

    /**
     *
     */
    @RequestMapping(value = "getTechnologyChainByName", method = RequestMethod.GET)
    public DataResponse getTechnologyChainByName(Long id,String name) {
        try {
            List<Tech> list = new ArrayList<Tech>();
            List<Relation> Relations = new ArrayList<Relation>();
            list.add(new Tech(id,name));
            Map<Long,String> techs = queryNeo4jService.findTechnologyChildren2(id, name);
            int i = 1;
            for (Map.Entry entry : techs.entrySet()) {
                list.add(new Tech((Long) entry.getKey(),(String) entry.getValue()));
                Relation relation = new Relation(0,i);
                Relations.add(relation);
                Map<Long,String> techs1 = queryNeo4jService.findTechnologyChildren2((Long) entry.getKey(),(String) entry.getValue());
                int j = i;
                for (Map.Entry entry1 : techs1.entrySet()) {
                    j++;
                    list.add(new Tech((Long) entry1.getKey(),(String) entry1.getValue()));
                    Relation relation1 = new Relation(i,j);
                    Relations.add(relation1);
                }
                i = j + 1 ;
            }
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("nodes", JSON.toJSON(list).toString());
            result.put("Relations", JSON.toJSON(Relations).toString());
            return new DataResponse("success", "200", result);
        } catch (Exception e) {
            logger.error("failed to CharController.getTechnologyChainByName", e);
            return DataResponse.buildErrorResponse();
        }
    }

    @RequestMapping(value = "updateTechnology", method = RequestMethod.GET)
    public DataResponse updateTechnology(Long id,String name) {
        try{
            Technology technology = rTechnologyTechnologyRepository.findTechnologyById(id);
            technology.setName(name);
            nodeRepository.save(technology);
            return new DataResponse("success", "200", true);
        } catch (Exception e){
            logger.error("failed to CharController.updateTechnology", e);
            return DataResponse.buildErrorResponse();
        }
    }

    @RequestMapping(value = "deleteTechnology", method = RequestMethod.GET)
    public DataResponse deleteTechnology(Long id){
        try {
            rTechnologyTechnologyRepository.deleteTechnologyById(id);
            List<Technology> list = rTechnologyTechnologyRepository.findChildrens2(id);
            if(null != list){
                for(Technology technology : list){
                    rTechnologyTechnologyRepository.deleteTechnologyById(technology.getId());
                    List<Technology> list2 = rTechnologyTechnologyRepository.findChildrens2(technology.getId());
                    if(null != list2){
                        for(Technology technology2 : list2){
                            rTechnologyTechnologyRepository.deleteTechnologyById(technology2.getId());
                        }
                    }
                }
            }
            return new DataResponse("success","200",true);
        } catch (Exception e){
            logger.error("failed to CharController.deleteTechnology", e);
            return DataResponse.buildErrorResponse();
        }

    }
}
