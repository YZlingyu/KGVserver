package support.yz.data.entity.node;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TechnologyChain2 {
    private Long id;
    private String name;
    private List<TechnologyChain2> children = new ArrayList<TechnologyChain2>();
}
