package support.yz.data.entity.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: yangzhuo
 * @Description: 企业图谱
 * @Date: 2018/7/25
 */

@Setter
@Getter
@NodeEntity
public class Group {
	@GraphId
	private Long id;
    private String name;//企业名称
    private String no;//企业编号
    public Group() {
    }
}
