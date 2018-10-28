package support.yz.data.entity.entityInfo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
public class EnterpriseInfo {
    private int id;
    private String companyName;
    private int investmentId;
    private int financingId;
    private String companyDomain;
    private Date companyCreateDate;
    private String companyIntroduction;
    private Date createTime;
    private Date actionTime;
    private String companyAdd;
}
