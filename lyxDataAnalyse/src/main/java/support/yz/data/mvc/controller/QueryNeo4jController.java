package support.yz.data.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import support.yz.data.entity.neo4j.Technology;
import support.yz.data.entity.node.EnterpriseBaseImport;
import support.yz.data.entity.node.Group;
import support.yz.data.entity.node.News;
import support.yz.data.entity.node.NewsBaseOriginal;
import support.yz.data.entity.node.RelationShipGroupGroup;
import support.yz.data.entity.node.TechnologyChain;
import support.yz.data.entity.response.DataResponse;
import support.yz.data.mvc.mapper.RCompanyTechnoRepository;
import support.yz.data.mvc.mapper.RGroupGroupRepository;
import support.yz.data.mvc.mapper.RTechnoCompanyRepository;
import support.yz.data.mvc.mapper.TechnologyRepository;
import support.yz.data.mvc.service.inter.ChartService;
import support.yz.data.mvc.service.inter.QueryNeo4jService;

/**
 * @Author: yangzhuo
 * @Description: 图数据库相关接口
 * @Date: 2018/7/25
 */
@CrossOrigin
@RestController
@RequestMapping("/KGV/neo4j")
public class QueryNeo4jController {
	
	private final static Logger logger = LoggerFactory.getLogger(QueryNeo4jController.class);
	
	@Autowired
	private QueryNeo4jService queryNeo4jService;
	
	@Autowired
	private TechnologyRepository technologyRepository;
	
	@Autowired
    private ChartService chartService;
	
	@Autowired
	private RCompanyTechnoRepository rCompanyTechnoRepository;
	
	@Autowired
	RTechnoCompanyRepository rTechnoCompanyRepository;
	
	@Autowired
	RGroupGroupRepository rGroupGroupRepository;

	/**
     * @Author: yangzhuo
     * @Descriptor: 通过技术关键字查所有子技术关键字
     * @Date: 11:23 2018/7/25
     */
	@RequestMapping(value = "/findTechnologyChildrens", method = RequestMethod.GET)
	public DataResponse findTechnologyChildrens(@RequestParam(value="technology") String technology){		
		try {
			List<Technology> list = queryNeo4jService.findTechnologyChildrens(technology);
			return new DataResponse("success","200",list);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findTechnologyChildrens", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 通过技术关键字查企业
     * @Date: 13:54 2018/7/25
     */
	@RequestMapping(value = "/findCompanyByTechnology", method = RequestMethod.GET)
	public DataResponse findCompanyByTechnology(@RequestParam(value="technology") String technology){
		try {
			List<Group> list = queryNeo4jService.findCompanyByTechnology(technology);
			return new DataResponse("success","200",list);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findCompanyByTechnology", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 通过企业查技术关键字
     * @Date: 14:19 2018/7/25
     */
	@RequestMapping(value = "/findTechnologyByCompany", method = RequestMethod.GET)
	public DataResponse findTechnologyByCompany(@RequestParam(value="company") String company){
		try {
			List<Technology> list = queryNeo4jService.findTechnologyByCompany(company);
			return new DataResponse("success","200",list);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findTechnologyByCompany", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 通过企业查新闻id
     * @Date: 14:28 2018/7/25
     */
	@RequestMapping(value = "/findNewsByCompany", method = RequestMethod.GET)
	public DataResponse findNewsByCompany(@RequestParam(value="company") String company){
		try {
			List<News> list = queryNeo4jService.findNewsByCompany(company);
			return new DataResponse("success","200",list);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findNewsByCompany", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 通过企业查询所有关联企业
     * @Date: 14:45 2018/7/25
     */
	@RequestMapping(value = "/findCompanyByCompany", method = RequestMethod.GET)
	public DataResponse findCompanyByCompany(@RequestParam(value="company") String company){
		try {
			List<Group> list = queryNeo4jService.findCompanyByCompany(company);
			return new DataResponse("success","200",list);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findCompanyByCompany", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 返回技术链
     * @Date: 14:45 2018/7/25
     */
	@RequestMapping(value = "/findTechnologyChain", method = RequestMethod.GET)
	public DataResponse findTechnologyChain(){
		try {
			TechnologyChain technologyChain = queryNeo4jService.findTechnologyChain();
			return new DataResponse("success","200",technologyChain);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findTechnologyChain", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 返回所有技术标签（方法一）
     * @Date: 14:45 2018/7/25
     */
	@RequestMapping(value = "/findTechnologyAll", method = RequestMethod.GET)
	Iterable<Technology> findTechnologyAll(){
		return technologyRepository.findAll();
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 返回所有技术标签（方法二）
     * @Date: 14:45 2018/7/25
     */
	@RequestMapping(value = "/findTechnologyA", method = RequestMethod.GET)
	public DataResponse findTechnologyA(){
		try {
			Set<String> set = queryNeo4jService.findTechnologyChildren("人工智能");
			return new DataResponse("success","200",set);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findTechnologyA", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 从mysql查找所有的已经导入到neo4j的新闻
     * @Date: 15:16 2018/7/25
     */
	@RequestMapping(value = "/findNewsAll", method = RequestMethod.GET)
	public DataResponse findNewsAll() {
		try {
			List<NewsBaseOriginal> etList = chartService.findImports();
			return new DataResponse("success","200",etList);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findNewsAll", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 查找所有的已经导入到neo4j的企业
     * @Date: 15:29 2018/7/25
     */
	@RequestMapping(value = "/findCompanysAll", method = RequestMethod.GET)
	public DataResponse findCompanysAll() {
		try {
			Set<EnterpriseBaseImport> result = new HashSet<EnterpriseBaseImport>();
			List<EnterpriseBaseImport> etList = chartService.findImport();
			for(EnterpriseBaseImport e : etList) {
				String str="";
				for (Technology technology : rCompanyTechnoRepository.findByGroup(e.getCom_name())) {
					str=str + technology.getName() + " ";
				}
				e.setKeywords(str);
				result.add(e);
			}
			return new DataResponse("success","200",result);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findCompanysAll", e);
            return DataResponse.buildErrorResponse();
		}
	}

	/**
     * @Author: yangzhuo
     * @Descriptor: 根据技术关键字查找新闻
     * @Date: 15:29 2018/7/25
     */
	@RequestMapping(value = "/findNewsByTechnology", method = RequestMethod.GET)
	public DataResponse findNewsByTechnology(@RequestParam(value="technologyName") String technologyName) {
		try {
			Set<NewsBaseOriginal> result = new HashSet<NewsBaseOriginal>();
			Set<String> techs = queryNeo4jService.findTechnologyChildren(technologyName);
			for(String s : techs) {
				Set<News> news = queryNeo4jService.findNewsByTechnology(s);
				for(News n : news) {
					result.add(chartService.findByNewsId(n.getNewsId()));
				}
			}
			return new DataResponse("success","200",result);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findNewsByTechnology", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 查找所有投融资关系
     * @Date: 15:29 2018/7/25
     */
	@RequestMapping(value = "/findRGGAll", method = RequestMethod.GET)
	public Map findRGGAll() {
		Set<Map> Relations =  new HashSet<Map>();
		Set<String> nodes =  new HashSet<String>();
		Iterable<RelationShipGroupGroup> result2 =  rGroupGroupRepository.findAll();
		for(RelationShipGroupGroup r : result2) {
			nodes.add(r.getGroupF().getName());
			nodes.add(r.getGroupS().getName());
		}
		List<String> setList = new ArrayList<String>(nodes);
		for(RelationShipGroupGroup r : result2) {
			Map<String, Integer> maps = new HashMap<String, Integer>();
			for(int i=0; i<setList.size();i++){  
				if(setList.get(i).equals(r.getGroupF().getName())){
					maps.put("source",i) ;
				}
				if(setList.get(i).equals(r.getGroupS().getName())){
					maps.put("target",i) ;
				}
			}
			Relations.add(maps);
		}
		Map<String, Set> result= new HashMap<String, Set>();
		result.put("nodes", nodes);
		result.put("Relations", Relations);
		return result;
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 按照技术关键字查找企业
     * @Date: 15:29 2018/7/25
     */
	@RequestMapping(value = "/findComByTech", method = RequestMethod.GET)
	public DataResponse findComByTech(@RequestParam(value="technologyName") String technologyName) {
		try {
			Set<String> result = new HashSet<String>();
			Set<String> techs = queryNeo4jService.findTechnologyChildren(technologyName);
			for(String t : techs) {
				List<Group> tech = rTechnoCompanyRepository.findByTechnology(t);
				for(Group g : tech) {
					result.add(g.getName());
				}
			}
			return new DataResponse("success","200",result);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findComByTech", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 按照技术关键字查找企业（带技术结构信息）
     * @Date: 15:29 2018/7/25
     */
	@RequestMapping(value = "/findComByTechInTChain", method = RequestMethod.GET)
	public DataResponse findComByTechInTChain(@RequestParam(value="technologyName") String technologyName) {
		try {
			TechnologyChain technologyChain = queryNeo4jService.findComByTechInTChain(technologyName);
			return new DataResponse("success","200",technologyChain);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findComByTechInTChain", e);
            return DataResponse.buildErrorResponse();
		}
	}
	
	/**
	 * @Author: yangzhuo
     * @Descriptor: 根据技术关键字查询公司和技术
     * @Date: 15:29 2018/7/25
	 */
	@RequestMapping(value = "/findComAndTechInTChainByTechInTChain", method = RequestMethod.GET)
	public DataResponse findComAndTechInTChainByTechInTChain(@RequestParam(value="technologyName") String technologyName) {
		try {
			Set<String> groupAll = new HashSet<String>();
			Set<String> technologyAll = new HashSet<String>();
			Map<String,String> map = new HashMap<String,String>();
			Set<Map<String,Integer>> Relations =  new HashSet<Map<String,Integer>>();
			Set<String> techs = queryNeo4jService.findTechnologyChildren(technologyName);
			for(String t : techs) {
				List<Group> tech = rTechnoCompanyRepository.findByTechnology(t);
				for(Group group : tech) {
					groupAll.add(group.getName());
					List<Technology> list = queryNeo4jService.findTechnologyByCompany(group.getName());
					for(Technology technology : list){
						technologyAll.add(technology.getName());
						map.put(group.getName(), map.get(group.getName()) == null? technology.getName():map.get(group.getName())+","+technology.getName());
					}
				}
			}
			groupAll.addAll(technologyAll);
			List<String> listAll = new ArrayList<String>(groupAll);
			for(String key:map.keySet()){
				String[] values = map.get(key).toString().split(",");
				for(int i = 0; i< values.length ; i ++){
					Map<String, Integer> maps = new HashMap<String, Integer>();
					maps.put("source",listAll.indexOf(key));
					maps.put("target",listAll.indexOf(values[i]));
					Relations.add(maps);
				}
			}
			Map<String, Set> result= new HashMap<String, Set>();
			result.put("nodes", groupAll);
			result.put("Relations", Relations);
			return new DataResponse("success","200",result);
		} catch (Exception e) {
			logger.error("failed to QueryNeo4jController.findComAndTechInTChainByTechInTChain", e);
            return DataResponse.buildErrorResponse();
		}
	}
}
