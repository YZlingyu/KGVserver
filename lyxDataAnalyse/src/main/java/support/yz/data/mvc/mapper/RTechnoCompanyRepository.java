package support.yz.data.mvc.mapper;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import support.yz.data.entity.node.Group;
import support.yz.data.entity.node.RelationShipCompanyTechno;
import support.yz.data.entity.node.RelationShipTechnoCompany;

@Repository
public interface RTechnoCompanyRepository extends GraphRepository<RelationShipTechnoCompany>{

	RelationShipCompanyTechno findByNo(@Param("no") String no);
	Long deleteByNo(@Param("no") String no);
	
	RelationShipCompanyTechno findByName(@Param("name") String name);
	Long deleteByName(@Param("name") String name);
	
	@Query("match (n1:技术关键字)-[r]->(n2:Group) where n1.name = {technology} return n2")
	List<Group> findByTechnology(@Param("technology") String technology);
}
