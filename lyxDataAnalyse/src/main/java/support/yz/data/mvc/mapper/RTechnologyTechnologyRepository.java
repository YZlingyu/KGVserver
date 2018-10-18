package support.yz.data.mvc.mapper;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import support.yz.data.entity.chart.Node;
import support.yz.data.entity.neo4j.Technology;
import support.yz.data.entity.node.RelationShipTechnology;

@Repository
public interface RTechnologyTechnologyRepository extends GraphRepository<RelationShipTechnology>{
	
	@Query("match (n1:技术关键字)-[r:Have]->(n2:技术关键字) where n1.name={technology} return n2")
	List<Technology> findChildrens(@Param("technology") String technology);

	@Query("MATCH ()-[r:Have]->(n:技术关键字) where ID(n) = {id} RETURN count(r)")
	int getRootTechnology(@Param("id") Long id);

	@Query("MATCH (n:技术关键字) RETURN n LIMIT 25")
	List<Technology> getAllTechnology();

	@Query("MATCH (n:技术关键字) WHERE n.name={technology} RETURN n")
	Technology getTechnologyByName(@Param("technology")String technology);

	@Query("match (n1:技术关键字)-[r:Have]->(n2:技术关键字) where ID(n1) = {id} return n2")
	List<Technology> findChildrens2(@Param("id") Long id);

	@Query("match (n1:技术关键字) where ID(n1) = {id} return n1")
	Technology findTechnologyById(@Param("id") Long id);

	@Query("match (n1:技术关键字) where ID(n1) = {id} delete n1")
	void deleteTechnologyById(@Param("id") Long id);

}
