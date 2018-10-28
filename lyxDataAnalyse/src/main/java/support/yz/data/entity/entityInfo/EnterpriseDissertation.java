package support.yz.data.entity.entityInfo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EnterpriseDissertation {
    private int id;
    private String dissertationName;
    private Date publishTime;
    private String dissertionDomain;
    private int companyId;
    private Date createTime;
    private Date actionTime;
}
