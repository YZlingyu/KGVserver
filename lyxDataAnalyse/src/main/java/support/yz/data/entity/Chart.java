package support.yz.data.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Chart {
    private String chartId;
    private String chartTitle;
    private String chartX;
    private int chartY;
    private String chartColor;
    private String chartType;
    private String chartXTitle;
    private String chartXUnit;
    private String chartYTitle;
    private String chartYUnit;
    private int chartMax;
    private int chartMin;
}
