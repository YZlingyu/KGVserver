package support.yz.data.mvc.mapper;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import support.yz.data.entity.node.News;
import support.yz.data.entity.node.RelationShipGroupNews;

@Repository
public interface RGroupNewsRepository extends GraphRepository<RelationShipGroupNews> {
	
	@Query("match (g:Group)-[r:GroupNews]->(n:News)"
			+ "where g.name = {groupName} and n.newsId = {newsId}"
			+ "return r")
	RelationShipGroupNews findRelation(@Param("groupName") String groupName, @Param("newsId") String newsId);

	@Query("match (n1:Group)-[r]->(n2:News) where n1.name = {group} return n2")
	List<News> findByGroup(@Param("group") String group);
}
