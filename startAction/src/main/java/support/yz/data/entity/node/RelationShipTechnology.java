package support.yz.data.entity.node;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Getter;
import lombok.Setter;
import support.yz.data.entity.neo4j.Technology;

/**
 * @author yangzhuo
 * @Description 技术关键字
 * @Date: 2018/7/25
 */

@Setter
@Getter
@RelationshipEntity(type="Have")
public class RelationShipTechnology {
	@GraphId  
    private Long id;
	private String no;
	private String name;
	@StartNode
	Technology technologyF; 
	@EndNode
	Technology technologyS;
}
