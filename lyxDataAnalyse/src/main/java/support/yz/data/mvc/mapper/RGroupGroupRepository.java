package support.yz.data.mvc.mapper;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import support.yz.data.entity.node.Group;
import support.yz.data.entity.node.RelationShipGroupGroup;

@Repository
public interface RGroupGroupRepository extends GraphRepository<RelationShipGroupGroup>{

	RelationShipGroupGroup findByNo(@Param("no") String no);
	Long deleteByNo(@Param("no") String no);
	
	RelationShipGroupGroup findByName(@Param("name") String name);
	Long deleteByName(@Param("name") String name);
	
	@Query("match (g1:Group)-[r:Related]->(g2:Group)"
			+ "where g1.name = {from_name} and g2.name = {target_name} and r.name = {relation}"
			+ "return r")
	RelationShipGroupGroup findRelation(@Param("from_name") String from_name, @Param("target_name") String target_name, @Param("relation") String relation);

	@Query("match (n1:Group)-[r]->(n2:Group) where n1.name = {group} return n2")
	List<Group> findByGroup(@Param("group") String group);
	
	@Query("match (n1:Group)-[r]->(n2:Group) where n2.name = {group} return n1")
	List<Group> findByGroup2(@Param("group") String group);
}
