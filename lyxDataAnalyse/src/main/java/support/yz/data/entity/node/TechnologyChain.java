package support.yz.data.entity.node;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yangzhuo
 * @Description 技术链分装类
 * @Date: 2018/7/25
 */

@Setter
@Getter
public class TechnologyChain {
	private String name;
	private List<TechnologyChain> children = new ArrayList<TechnologyChain>();
}
