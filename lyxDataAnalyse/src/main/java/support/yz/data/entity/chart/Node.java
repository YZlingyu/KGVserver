package support.yz.data.entity.chart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * @Author: yangzhuo
 * @Description: 用户添加的节点
 * @Date: 2018/7/25
 */
@Setter
@Getter
@NodeEntity
public class Node {
    @GraphId
    private Long id;

    private String name;

    @Relationship(type = "Have")
    @JsonProperty("拥有")
    private List<Node> nextNodes;

    public Node(){
        setName("默认");
    }

    public Node(String name){
        setName(name);
    }
}
