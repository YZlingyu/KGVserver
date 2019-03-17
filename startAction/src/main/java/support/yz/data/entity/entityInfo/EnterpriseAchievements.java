package support.yz.data.entity.entityInfo;

import lombok.Data;

import java.sql.Date;

/**
 * 公司成果实体类
 */
@Data
public class EnterpriseAchievements {
    private int id;
    private String achievementsName;
    private Date publishTime;
    private String achievementsDomain;
    private int companyId;
    private Date createTime;
    private Date actionTime;
}
