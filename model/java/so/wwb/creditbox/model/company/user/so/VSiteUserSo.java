package so.wwb.creditbox.model.company.user.so;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.Nonpersistent;
import so.wwb.creditbox.model.company.user.po.VSiteUser;


/**
 * 查询对象
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
//region your codes 1
public class VSiteUserSo extends VSiteUser {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 4233585721545149685L;
	//endregion your codes 3

	//region your codes 2
	/**
	 * 上級的userType
	 */
	private String ownerUserType;


	@Nonpersistent
	public String getOwnerUserType() {
		if(StringTool.isNotBlank(this.getUserType())){
			return (Integer.valueOf(this.getUserType())-1)+"";
		}
		return ownerUserType;
	}

	public void setOwnerUserType(String ownerUserType) {
		this.ownerUserType = ownerUserType;
	}

	//endregion your codes 2
}