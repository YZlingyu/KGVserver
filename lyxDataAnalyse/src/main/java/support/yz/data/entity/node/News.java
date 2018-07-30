package support.yz.data.entity.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: yangzhuo
 * @Description: 新闻信息
 * @Date: 2018/7/25
 */

@Setter
@Getter
@NodeEntity
public class News {
	@GraphId
	private Long id;
    private String newsId;//新闻id
    private String no;//新闻编号
    private String time;//发布时间
}
