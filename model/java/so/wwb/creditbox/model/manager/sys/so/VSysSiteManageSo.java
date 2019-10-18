package so.wwb.creditbox.model.manager.sys.so;

import so.wwb.creditbox.model.manager.sys.po.VSysSiteManage;

/**
 * 查询对象
 *
 * @author jerry
 * @time 2017-4-6 22:23:42
 */
//region your codes 1
public class VSysSiteManageSo extends VSysSiteManage {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -9166211051954266071L;
	//endregion your codes 3

	//region your codes 2
// 步骤
	private String step;

	private String lastStep;

	private String searchEnable;


	private String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getLastStep() {
		return lastStep;
	}

	public void setLastStep(String lastStep) {
		this.lastStep = lastStep;
	}

	public String getSearchEnable() {
		return searchEnable;
	}

	public void setSearchEnable(String searchEnable) {
		this.searchEnable = searchEnable;
	}

	//endregion your codes 2
}