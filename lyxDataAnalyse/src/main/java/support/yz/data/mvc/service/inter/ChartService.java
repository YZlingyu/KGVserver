package support.yz.data.mvc.service.inter;

import java.util.List;

import support.yz.data.entity.chart.Chart;
import support.yz.data.entity.chart.KnowledgeGroup;
import support.yz.data.entity.node.EnterpriseBaseImport;
import support.yz.data.entity.node.NewsBaseOriginal;

/**
 * 生成图表服务接口
 */
public interface ChartService {

	/**
     * @Author: yangzhuo
     * @Descriptor: 保存图表信息
     * @Date: 11:16 2018/7/24
     */
    public boolean saveChart(Chart chart) throws Exception;
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 获取图表信息
     * @Date: 13:20 2018/7/24
     */
    public Chart getChartByTitle(String title) throws Exception;
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 保存节点信息
     * @Date: 16:41 2018/9/14
     */
    public boolean saveKnowledgeGroup(KnowledgeGroup knowledgeGroup) throws Exception;

    /**
     * @Author: yangzhuo
     * @Descriptor: 从mysql查找所有的已经导入到neo4j的新闻
     * @Date: 15:24 2018/7/25
     */
	List<NewsBaseOriginal> findImports() throws Exception;

	/**
     * @Author: yangzhuo
     * @Descriptor: 查找所有的已经导入到neo4j的企业
     * @Date: 15:29 2018/7/25
     */
	List<EnterpriseBaseImport> findImport() throws Exception;

	NewsBaseOriginal findByNewsId(String news_id) throws Exception;
}
