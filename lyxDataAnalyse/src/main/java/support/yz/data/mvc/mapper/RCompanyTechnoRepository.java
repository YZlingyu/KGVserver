package support.yz.data.mvc.mapper;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import support.yz.data.entity.neo4j.Technology;
import support.yz.data.entity.node.RelationShipCompanyTechno;

@Repository
public interface RCompanyTechnoRepository extends GraphRepository<RelationShipCompanyTechno>{

	RelationShipCompanyTechno findByNo(@Param("no") String no);
	Long deleteByNo(@Param("no") String no);
	
	RelationShipCompanyTechno findByName(@Param("name") String name);
	Long deleteByName(@Param("name") String name);
	
	@Query("match (n1:Group)-[r]->(n2:技术关键字) where n1.name = {group} return n2")
	List<Technology> findByGroup(@Param("group") String group);
	
}
