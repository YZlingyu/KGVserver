package support.yz.data.entity.node;

import lombok.Getter;
import lombok.Setter;

/**
 * 企业实体
 * @author yuyinming
 *
 */
@Setter
@Getter
public class EnterpriseBaseImport {
	private String com_no;
	private String com_name;
	private String uni_code;
	private String persons;
	private String est_date;
	private String reg_capital;
	private String address;
	private String email;
	private String phone;
	private String ope_range;
	private String website;
	private String keywords;  //技术标签（周康新增）
}
