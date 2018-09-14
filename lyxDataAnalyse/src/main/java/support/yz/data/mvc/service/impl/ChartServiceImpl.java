package support.yz.data.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.yz.data.entity.chart.Chart;
import support.yz.data.entity.chart.KnowledgeGroup;
import support.yz.data.entity.node.EnterpriseBaseImport;
import support.yz.data.entity.node.NewsBaseOriginal;
import support.yz.data.mvc.mapper.ChartMapper;
import support.yz.data.mvc.service.inter.ChartService;

/**
 * 生成图表服务类
 */
@Service
public class ChartServiceImpl implements ChartService {
	
	@Autowired
    private ChartMapper chartMapper;

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
	public Chart getChartByTitle(String title) throws Exception {
		return chartMapper.getChartByTitle(title);
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
	public boolean saveKnowledgeGroup(KnowledgeGroup knowledgeGroup) throws Exception {
		return chartMapper.saveKnowledgeGroup(knowledgeGroup);
	}
}
