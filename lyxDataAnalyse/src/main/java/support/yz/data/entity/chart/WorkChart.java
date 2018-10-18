package support.yz.data.entity.chart;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class WorkChart implements Serializable {

    private String id;
    private String name;
    // 维度
    private String abscissa;
    // 度量
    private String ordinate;
    // 技术链id
    private String technologyId;
}
