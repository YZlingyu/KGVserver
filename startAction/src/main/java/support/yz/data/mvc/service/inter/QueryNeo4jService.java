package support.yz.data.mvc.service.inter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import support.yz.data.entity.neo4j.Technology;
import support.yz.data.entity.node.Group;
import support.yz.data.entity.node.News;
import support.yz.data.entity.node.TechnologyChain;

/**
 * @Author yangzhuo
 * @Description: 图数据库相关接口
 * @Date: 2018/7/25
 * 封装的5个接口：
 * 1）通过技术关键字查所有子技术关键字
 * 2）通过技术关键字查企业
 * 3）通过企业查技术关键字
 * 4）通过企业查新闻id
 * 5）通过企业查询所有关联企业
 */
public interface QueryNeo4jService {
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 通过技术关键字查所有子技术关键字
     * @Date: 11:23 2018/7/25
     */
	List<Technology> findTechnologyChildrens(String technology) throws Exception;
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 通过技术关键字查企业
     * @Date: 13:54 2018/7/25
     */
	List<Group> findCompanyByTechnology(String technology) throws Exception;

	/**
     * @Author: yangzhuo
     * @Descriptor: 通过企业查技术关键字
     * @Date: 14:19 2018/7/25
     */
	List<Technology> findTechnologyByCompany(String company) throws Exception;

	/**
     * @Author: yangzhuo
     * @Descriptor: 通过企业查新闻id
     * @Date: 14:28 2018/7/25
     */
	List<News> findNewsByCompany(String company) throws Exception;

	/**
     * @Author: yangzhuo
     * @Descriptor: 通过企业查询所有关联企业
     * @Date: 14:45 2018/7/25
     */
	List<Group> findCompanyByCompany(String company) throws Exception;

	/**
     * @Author: yangzhuo
     * @Descriptor: 返回技术链
     * @Date: 14:45 2018/7/25
     */
	TechnologyChain findTechnologyChain() throws Exception;

	/**
     * @Author: yangzhuo
     * @Descriptor: 返回technology_name节点及孩子技术列表
     * @Date: 15:15 2018/7/25
     */
	Set<String> findTechnologyChildren(String string) throws Exception;

	/**
     * @Author: yangzhuo
     * @Descriptor: 根据技术关键字查找新闻
     * @Date: 15:40 2018/7/25
     */
	Set<News> findNewsByTechnology(String s) throws Exception;

	TechnologyChain findComByTechInTChain(String technologyName) throws Exception;

	Map<Long,String> findTechnologyChildren2(Long id, String name) throws Exception;
}
