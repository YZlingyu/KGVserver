package support.yz.data.entity.chart;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Chart {
    private String chartId;// 图表唯一主键
    private String chartInfo;// 图表信息
    private String layout;// 图表样式
    private String tech; // 产业链
}
