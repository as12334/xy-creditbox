package so.wwb.creditbox.model.manager.user.so;

import so.wwb.creditbox.model.manager.user.po.VSubAccount;

import java.util.List;


/**
 * 子账户视图查询对象
 *
 * @author jeff
 * @time 2015-10-20 10:49:12
 */
//region your codes 1
public class VSubAccountSo extends VSubAccount {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 3260259469051271323L;
	//endregion your codes 3

	//region your codes 2
	private String subSysCode;

	private List<Integer> sysUserIds;

	private List<Integer> deleteRoleIds;

	private List<Integer> insertRoleIds;

	private Integer roleId;

	private Integer ccenterId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<Integer> getSysUserIds() {
		return sysUserIds;
	}

	public void setSysUserIds(List<Integer> sysUserIds) {
		this.sysUserIds = sysUserIds;
	}

	public String getSubSysCode() {
		return subSysCode;
	}

	public void setSubSysCode(String subSysCode) {
		this.subSysCode = subSysCode;
	}

	public List<Integer> getDeleteRoleIds() {
		return deleteRoleIds;
	}

	public void setDeleteRoleIds(List<Integer> deleteRoleIds) {
		this.deleteRoleIds = deleteRoleIds;
	}

	public List<Integer> getInsertRoleIds() {
		return insertRoleIds;
	}

	public void setInsertRoleIds(List<Integer> insertRoleIds) {
		this.insertRoleIds = insertRoleIds;
	}

	public Integer getCcenterId() {
		return ccenterId;
	}

	public void setCcenterId(Integer ccenterId) {
		this.ccenterId = ccenterId;
	}
//endregion your codes 2
}