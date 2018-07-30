package support.yz.data.mvc.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import support.yz.data.entity.neo4j.Technology;
import support.yz.data.entity.node.Group;
import support.yz.data.entity.node.News;
import support.yz.data.entity.node.TechnologyChain;
import support.yz.data.mvc.mapper.RCompanyTechnoRepository;
import support.yz.data.mvc.mapper.RGroupGroupRepository;
import support.yz.data.mvc.mapper.RGroupNewsRepository;
import support.yz.data.mvc.mapper.RTechnoCompanyRepository;
import support.yz.data.mvc.mapper.RTechnologyTechnologyRepository;
import support.yz.data.mvc.service.inter.QueryNeo4jService;

@Service
public class QueryNeo4jServiceImpl implements QueryNeo4jService {
	
	//技术关键字、技术关键字关系
	@Autowired
	RTechnologyTechnologyRepository rTechnologyTechnologyRepository;
	
	//技术关键字、企业关系
	@Autowired
	RTechnoCompanyRepository rTechnoCompanyRepository;
	
	//企业、技术关键字关系
	@Autowired
	RCompanyTechnoRepository rCompanyTechnoRepository;
	
	//企业、新闻关系
	@Autowired
	RGroupNewsRepository rGroupNewsRepository;
	
	//企业、企业关系
	@Autowired
	RGroupGroupRepository rGroupGroupRepository;

	@Override
	public List<Technology> findTechnologyChildrens(String technology) throws Exception {
		return rTechnologyTechnologyRepository.findChildrens(technology);
	}

	@Override
	public List<Group> findCompanyByTechnology(String technology) throws Exception {
		return rTechnoCompanyRepository.findByTechnology(technology);
	}

	@Override
	public List<Technology> findTechnologyByCompany(String company) throws Exception {
		return rCompanyTechnoRepository.findByGroup(company);
	}

	@Override
	public List<News> findNewsByCompany(String com_name) throws Exception {
		return rGroupNewsRepository.findByGroup(com_name);
	}

	@Override
	public List<Group> findCompanyByCompany(String com_name) throws Exception {
		List<Group> list = new ArrayList<Group>();
		List<Group> list1 = rGroupGroupRepository.findByGroup(com_name);
		List<Group> list2 = rGroupGroupRepository.findByGroup2(com_name);
		if (list1 != null)
			list.addAll(list1);
		if (list2 != null)
			list.addAll(list2);
		return list;
	}

	@Override
	public TechnologyChain findTechnologyChain() throws Exception {
		TechnologyChain result = new TechnologyChain();
		result.setName("人工智能");
		Set<String> set = new HashSet<String>();
		set.add("人工智能");
		Queue<TechnologyChain> q = new LinkedList<TechnologyChain>();
		q.add(result);
		while (q.isEmpty() == false) {
			TechnologyChain tc = q.poll();
			List<Technology> childrens= rTechnologyTechnologyRepository.findChildrens(tc.getName());
			for (Technology t : childrens) {
				//判断是否回环，回环表示当前技术关键词已经出现过，不处理会造成死循环
				if (set.contains(t.getName()))
					continue;
				else
					set.add(t.getName());
				TechnologyChain temp = new TechnologyChain();
				temp.setName(t.getName());
				tc.getChildren().add(temp);//加入当前节点的子节点
				q.add(temp);//当前节点的子节点入队列
			}
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Set<String> findTechnologyChildren(String technology_name) throws Exception {
		TechnologyChain result = new TechnologyChain();
		Set<String> result2 = new HashSet<String>();
		result.setName(technology_name);
		Set<String> set = new HashSet<String>();
		set.add(technology_name);
		Queue<TechnologyChain> q = new LinkedList<TechnologyChain>();
		q.add(result);
		result2.add(result.getName());
		while (q.isEmpty() == false) {
			TechnologyChain tc = q.poll();
			List<Technology> childrens= rTechnologyTechnologyRepository.findChildrens(tc.getName());
			for (Technology t : childrens) {
				//判断是否回环，回环表示当前技术关键词已经出现过，不处理会造成死循环
				if (set.contains(t.getName()))
					continue;
				else
					set.add(t.getName());
				TechnologyChain temp = new TechnologyChain();
				temp.setName(t.getName());
				tc.getChildren().add(temp);//加入当前节点的子节点
				q.add(temp);//当前节点的子节点入队列
				result2.add(temp.getName());
			}
		}
		return result2;
	}

	@Override
	public Set<News> findNewsByTechnology(String s) throws Exception {
		Set<News> result = new HashSet<News>();
		List<Group> coms = rTechnoCompanyRepository.findByTechnology(s);
		for(Group g : coms) {
			List<News> news = rGroupNewsRepository.findByGroup(g.getName());
			for(News n : news) {
				result.add(n);
			}
		}
		return result;
	}

	@Override
	public TechnologyChain findComByTechInTChain(String technology_name) throws Exception {
		TechnologyChain result = new TechnologyChain();
		TechnologyChain Layered = new TechnologyChain();
		result.setName("人工智能");
		Layered.setName("Layered");
		Set<String> set = new HashSet<String>();
		set.add("人工智能");
		Queue<TechnologyChain> q = new LinkedList<TechnologyChain>();
		q.add(result);
		q.add(Layered);
		boolean finded = false;
		boolean findInChilded = false;
		boolean lastLayered = false;
		while (q.isEmpty() == false) {
			
			if(technology_name.equals("人工智能")) {
				finded = true;
			}
			TechnologyChain tc = q.poll();
			//判断在目标是不是当前节点的孩子节点
			if( findInChilded == false) {
				for(Technology te : rTechnologyTechnologyRepository.findChildrens(tc.getName())) {
					if(te.getName().equals(technology_name)) {
						findInChilded =true;
						break;
					}
				}
			}
			
			if(tc.getName().equals("Layered")) {
				q.add(Layered);
				if(findInChilded == true) {
					finded = true;
				}
				if(lastLayered == true) {
					break;
				}else {
					lastLayered = true;
				}
			}else {
				lastLayered = false;
			}
			
			if(finded == false) {
				List<Technology> childrens= rTechnologyTechnologyRepository.findChildrens(tc.getName());
				for (Technology t : childrens) {
					//判断是否回环，回环表示当前技术关键词已经出现过，不处理会造成死循环
					if (set.contains(t.getName()))
						continue;
					else
						set.add(t.getName());
					TechnologyChain temp = new TechnologyChain();
					temp.setName(t.getName());
					tc.getChildren().add(temp);//加入当前节点的子节点
					q.add(temp);//当前节点的子节点入队列
				}
			}else {
				if(tc.getName().equals(technology_name)) {
					Set<String> techs = findTechnologyChildren(technology_name);
					for(String t : techs) {
						List<Group> tech = rTechnoCompanyRepository.findByTechnology(t);
						Set<String> sete = new HashSet<String>();
						for(Group g : tech) {
							TechnologyChain temp = new TechnologyChain();
							if(sete.contains(g.getName()) == false) {
								if(g.getName().equals("北京蓦然认知科技有限公司上海圣尧智能科技有限公司")) {
									temp.setName("北京蓦然认知科技有限公司");
								}else {
									temp.setName(g.getName());
								}
								sete.add(g.getName());
								tc.getChildren().add(temp);
							}
						}
					}
					break;
				}else {
					continue;
				}
			}
		}
		return result;
	}

}
