package support.yz.data.entity.chart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Relation {
    private Integer source;
    private Integer target;
}
