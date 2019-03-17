package support.yz.data.entity.entityInfo;

import lombok.Data;

import java.sql.Date;

@Data
public class EnterpriseNews {
    private int id;
    private String title;
    private String newsIntroduction;
    private String newsDomain;
    private int companyId;
    private Date createTime;
    private Date actionTime;
    private Date newsTime;
}
