package support.yz.data.mvc.mapper;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import support.yz.data.entity.chart.Node;
import support.yz.data.entity.neo4j.Technology;

@Repository
public interface NodeRepository extends GraphRepository<Technology> {


}
