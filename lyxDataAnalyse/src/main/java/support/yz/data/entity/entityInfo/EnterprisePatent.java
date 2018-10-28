package support.yz.data.entity.entityInfo;

import lombok.Data;

import java.sql.Date;

@Data
public class EnterprisePatent {
    private int id;
    private String patentName;
    private Date publishTime;
    private String patentDomain;
    private int companyId;
    private String patentDetail;
    private Date createTime;
    private Date actionTime;
}
