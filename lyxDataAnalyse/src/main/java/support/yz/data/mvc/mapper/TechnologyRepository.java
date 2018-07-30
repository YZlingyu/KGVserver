package support.yz.data.mvc.mapper;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import support.yz.data.entity.neo4j.Technology;

@Repository
public interface TechnologyRepository extends GraphRepository<Technology> {
	
	Technology findByTechno(@Param("techno") String techno);
	Long deleteByTechno(@Param("techno") String techno);
	Technology findByName(@Param("name") String name);
	Long deleteByName(@Param("name") String name);
}
