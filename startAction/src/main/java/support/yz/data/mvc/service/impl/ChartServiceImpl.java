package support.yz.data.mvc.service.impl;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.yz.data.entity.chart.*;
import support.yz.data.entity.neo4j.Technology;
import support.yz.data.entity.node.EnterpriseBaseImport;
import support.yz.data.entity.node.NewsBaseOriginal;
import support.yz.data.mvc.mapper.ChartMapper;
import support.yz.data.mvc.mapper.NodeRepository;
import support.yz.data.mvc.mapper.RTechnologyTechnologyRepository;
import support.yz.data.mvc.service.inter.ChartService;

/**
 * 生成图表服务类
 */
@Service
public class ChartServiceImpl implements ChartService {
	
	@Autowired
    private ChartMapper chartMapper;

	@Autowired
	private NodeRepository nodeRepository;

	//技术关键字、技术关键字关系
	@Autowired
	RTechnologyTechnologyRepository rTechnologyTechnologyRepository;

	/**
     * @Author: yangzhuo
     * @Descriptor: 保存图表信息
     * @Date: 11:16 2018/7/24
     */
	@Transactional
    @Override
    public boolean saveChart(Chart chart) throws Exception {
        return chartMapper.saveChart(chart);
    }

	/**
     * @Author: yangzhuo
     * @Descriptor: 获取图表信息
     * @Date: 13:20 2018/7/24
     */
	@Transactional
	@Override
	public Chart getChartById(String chartId) throws Exception {
		return chartMapper.getChartById(chartId);
	}

	/**
	 * 查询工作表
	 */
	public List<Technology2> getTechnologyList() throws Exception {
		return chartMapper.getTechnologyList();
	}

	/**
	 * 保存工作表
	 */
	public boolean saveWorkChart(String technologyId,WorkChart workChart){
		return chartMapper.saveWorkChart(technologyId,workChart);
	}
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 从mysql查找所有的已经导入到neo4j的新闻
     * @Date: 15:24 2018/7/25
     */
	@Transactional
	@Override
	public List<NewsBaseOriginal> findImports() throws Exception {
		return chartMapper.findImports();
	}

	/**
     * @Author: yangzhuo
     * @Descriptor: 查找所有的已经导入到neo4j的企业
     * @Date: 15:29 2018/7/25
     */
	@Transactional
	@Override
	public List<EnterpriseBaseImport> findImport() throws Exception {
		return chartMapper.findImport();
	}

	@Transactional
	@Override
	public NewsBaseOriginal findByNewsId(String news_id) throws Exception {
		return chartMapper.findByNewsId(news_id);
	}

	@Override
	public long saveKnowledgeGroup(KnowledgeGroup knowledgeGroup) throws Exception {
		long id = -1;
		JSONArray node1Array = JSONObject.parseArray(knowledgeGroup.getGroupNode());
		for(int i=0;i<node1Array.size();i++){
			List<Technology> list1 = new ArrayList<Technology>();
			JSONObject node1Object = node1Array.getJSONObject(i);
			String name1 = (String)node1Object.get("value");
			Technology technology1 = new Technology();
			technology1.setName(name1);
			technology1.setLevel(1);
			JSONArray node2Array = node1Object.getJSONArray("node1");
			for(int j=0;j<node2Array.size();j++){
				List<Technology> list2 = new ArrayList<Technology>();
				JSONObject node2Object = node2Array.getJSONObject(j);
				String name2 = (String)node2Object.get("value");
				Technology technology2 = new Technology();
				technology2.setName(name2);
				technology2.setLevel(2);
				JSONArray node3Array = node2Object.getJSONArray("node2");
				for(int z=0;z<node3Array.size();z++){
					JSONObject node3Object = node3Array.getJSONObject(z);
					String name3 = (String)node3Object.get("value");
					Technology technology3 = new Technology();
					technology3.setName(name3);
					technology3.setLevel(3);
					list2.add(technology3);
				}
				technology2.setNextTechnology(list2);
				list1.add(technology2);
			}
			technology1.setNextTechnology(list1);
			id = nodeRepository.save(technology1).getId();
		}
		return id;
	}

	@Override
	public boolean deleteKnowledgeGroup(String groupId) throws Exception {
		return chartMapper.deleteKnowledgeGroup(groupId);
	}

	@Override
	public boolean updateKnowledgeGroup(KnowledgeGroup knowledgeGroup) throws Exception {
		return chartMapper.updateKnowledgeGroup(knowledgeGroup);
	}

//	@Override
//	public boolean addKnowledgeGroup(KnowledgeGroup knowledgeGroup) throws Exception {
//		return chartMapper.addKnowledgeGroup(knowledgeGroup);
//	}

	@Override
	public Map<Long,String> getAllTechnologyNames() throws Exception{
		Map<Long,String> names = new HashMap<Long, String>();
		Iterable<Technology> nodeList = nodeRepository.findAll();
		Iterator iterator = nodeList.iterator();
		while (iterator.hasNext()){
			Technology technology = (Technology)iterator.next();
			if(rTechnologyTechnologyRepository.getRootTechnology(technology.getId()) == 0)
				names.put(technology.getId(),technology.getName());
		}
		//List<Technology> nodeList = rTechnologyTechnologyRepository.getAllTechnology();
//		for (Technology technology : nodeList){
//			if(rTechnologyTechnologyRepository.getRootTechnology(technology.getId()) == 0)
//				names.put(technology.getId(),technology.getName());
//		}
		return names;
	}

	@Override
	public List<Chart> getChartByTech(String tech) throws Exception {
		return chartMapper.getChartByTech(tech);
	}

	@Override
	public Boolean saveReport(Report report) throws Exception{
		return chartMapper.saveReport(report);
	}

	@Override
	public List<Report> getAllReport() throws Exception{
		return chartMapper.getAllReport();
	}

	@Override
	public List<Report> getReportByTechnology(String tech) throws Exception{
		return chartMapper.getReportByTechnology(tech);
	}
}
