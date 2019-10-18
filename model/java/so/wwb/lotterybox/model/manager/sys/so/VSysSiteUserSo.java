package so.wwb.lotterybox.model.manager.sys.so;

import so.wwb.lotterybox.model.manager.sys.po.VSysSiteUser;

import java.util.List;


/**
 * 用户站点表查询对象
 *
 * @author longer
 * @time Nov 17, 2015 2:22:29 PM
 */
//region your codes 1
public class VSysSiteUserSo extends VSysSiteUser {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -7272809211503709505L;
	//endregion your codes 3

	//region your codes 2
	private String companyId;

	private String type;

	private List<String> subSysCodes;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getSubSysCodes() {
		return subSysCodes;
	}

	public void setSubSysCodes(List<String> subSysCodes) {
		this.subSysCodes = subSysCodes;
	}

	//endregion your codes 2
}