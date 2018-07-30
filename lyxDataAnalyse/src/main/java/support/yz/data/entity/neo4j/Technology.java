package support.yz.data.entity.neo4j;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: yangzhuo
 * @Description: 技术关键字
 * @Date: 2018/7/25
 */

@Setter
@Getter
@NodeEntity(label="技术关键字")
public class Technology {
	@GraphId
    private Long id;
	private String techno;//技术关键字编号
	private String name;//技术关键字名称
}
