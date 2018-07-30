package support.yz.data.mvc.mapper;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import support.yz.data.entity.neo4j.Technology;
import support.yz.data.entity.node.RelationShipTechnology;

@Repository
public interface RTechnologyTechnologyRepository extends GraphRepository<RelationShipTechnology>{
	
	@Query("match (n1:技术关键字)-[r:Have]->(n2:技术关键字) where n1.name={technology} return n2")
	List<Technology> findChildrens(@Param("technology") String technology);

}
