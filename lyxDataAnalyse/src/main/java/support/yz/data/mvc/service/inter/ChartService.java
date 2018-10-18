package support.yz.data.mvc.service.inter;

import java.util.List;
import java.util.Map;

import support.yz.data.entity.chart.*;
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
     * @Descriptor: 保存图表信息
     * @Date: 11:16 2018/7/24
     */
    public boolean saveChart2(Chart2 chart) throws Exception;
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 获取图表信息
     * @Date: 13:20 2018/7/24
     */
    public Chart getChartByTitle(String title) throws Exception;

    /**
     * 查询工作表
     */
    public List<Technology2> getTechnologyList() throws Exception;

    /**
     * 保存工作表
     */
    public boolean saveWorkChart(String technologyId,WorkChart workChart) throws Exception;

    /**
     * @Author: yangzhuo
     * @Descriptor: 保存节点信息
     * @Date: 16:41 2018/9/14
     */
    public boolean saveKnowledgeGroup(KnowledgeGroup knowledgeGroup) throws Exception;

    /**
     * @Author: yangzhuo
     * @Descriptor: 删除节点信息
     * @Date: 16:41 2018/9/14
     */
    public boolean deleteKnowledgeGroup(String groupId) throws Exception;
    
    /**
     * @Author: yangzhuo
     * @Descriptor: 修改节点信息
     * @Date: 16:41 2018/9/14
     */
    public boolean updateKnowledgeGroup(KnowledgeGroup knowledgeGroup) throws Exception;
    
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

	public Map<Long,String> getAllTechnologyNames() throws Exception;
}
