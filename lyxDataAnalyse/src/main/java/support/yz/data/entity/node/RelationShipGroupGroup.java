package support.yz.data.entity.node;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@RelationshipEntity(type="Related")
public class RelationShipGroupGroup {
	@GraphId  
    private Long id;
	private String no;
	private String name; 
	private String attr;
	@StartNode
	Group groupF;
	@EndNode
	Group groupS;
}
