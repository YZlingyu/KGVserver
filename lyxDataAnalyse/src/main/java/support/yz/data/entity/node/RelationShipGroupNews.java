package support.yz.data.entity.node;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yangzhuo
 * @Description 技术关键字 --> 企业
 * @Date: 2018/7/25
 */

@Setter
@Getter
@RelationshipEntity(type="GroupNews")
public class RelationShipGroupNews {
	@GraphId  
    private Long id;
	private String no;
	private String name; 
	private String attr;
	@StartNode
	Group group;
	@EndNode
	News news;
}
