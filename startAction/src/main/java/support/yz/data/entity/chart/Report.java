package support.yz.data.entity.chart;

import lombok.Data;

import java.sql.Date;

@Data
public class Report {
    private String reportId;
    private String tech;
    private String reportName;
    private String layouts;
    private String chartName;
    private String chartNote;
    private Date createTime;
}
