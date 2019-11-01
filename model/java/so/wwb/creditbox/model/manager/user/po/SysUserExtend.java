package so.wwb.creditbox.model.manager.user.po;

import org.apache.xmlbeans.UserType;
import org.soul.commons.bean.IEntity;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.Nonpersistent;
import org.soul.model.security.privilege.po.SysUser;


/**
 * 用户扩展表实体
 *
 * @author block
 * @time 2019-10-25 17:25:10
 */
//region your codes 1
public class SysUserExtend extends SysUser {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 8789285198108194273L;
	//endregion your codes 3

	//region property name constants

	public static final String PROP_KEY = "key";
	public static final String PROP_SUPERIOR_OCCUPY = "superiorOccupy";
	public static final String PROP_HID = "hid";
	public static final String PROP_CREDITS = "credits";
	public static final String PROP_UPDATE_NAME = "updateName";
	public static final String PROP_STINT_OCCUPY = "stintOccupy";
	public static final String PROP_BREAKPOINT = "breakpoint";
	public static final String PROP_MANUAL_AUTO_SHIPMENTS = "manualAutoShipments";
	public static final String PROP_MODE_SELECTION = "modeSelection";
	public static final String PROP_GENERAL = "general";
	public static final String PROP_TEST_ACCOUNT = "testAccount";
	public static final String PROP_SET_ODDS = "setOdds";
	public static final String OWNER_NAME = "ownerName";
	public static final String OWNER_USER_TYPE = "ownerUserType";
	public static final String HANDICAP = "handicap";
	//endregion
	
	
	//region properties
	/** 钥匙 */
	private String key;
	/** 上级占成 */
	private Double superiorOccupy;
	/** ID标示(每级8位) */
	private String hid;
	/** 信用额 */
	private Double credits;
	/**  */
	private String updateName;
	/** 限制占成 */
	private Double stintOccupy;
	/** 1占余归总监、2占余归分公司 */
	private String breakpoint;
	/** 补货设定  1:启用  0:禁用 */
	private String manualAutoShipments;
	/** 模式选择，1现金模式、0信用模式 */
	private String modeSelection;
	/** 查询总账报表，0否，1查询总账、2查询总账包括明细 */
	private String general;
	/** 是否是测试账号 */
	private String testAccount;
	/** 赔率设置 1:启用  0:禁用 */
	private String setOdds;


	/** 上級用戶名 */
	private String ownerName;

	/** 上級用戶类型 */
	private String ownerUserType;

	/**盘口 1 A盘、2 B盘 3 C盘*/
	private Integer handicap;
	//endregion

	
	//region constuctors
	public SysUserExtend(){
	}

	//endregion


	//region getters and setters
	public String getKey() {
		return this.key;
	}

	public void setKey(String value) {
		this.key = value;
	}
	public Double getSuperiorOccupy() {
		return this.superiorOccupy;
	}

	public void setSuperiorOccupy(Double value) {
		this.superiorOccupy = value;
	}
	public String getHid() {
		return this.hid;
	}

	public void setHid(String value) {
		this.hid = value;
	}
	public Double getCredits() {
		return this.credits;
	}

	public void setCredits(Double value) {
		this.credits = value;
	}
	public String getUpdateName() {
		return this.updateName;
	}

	public void setUpdateName(String value) {
		this.updateName = value;
	}
	public Double getStintOccupy() {
		return this.stintOccupy;
	}

	public void setStintOccupy(Double value) {
		this.stintOccupy = value;
	}
	public String getBreakpoint() {
		return this.breakpoint;
	}

	public void setBreakpoint(String value) {
		this.breakpoint = value;
	}
	public String getManualAutoShipments() {
		return this.manualAutoShipments;
	}

	public void setManualAutoShipments(String value) {
		this.manualAutoShipments = value;
	}
	public String getModeSelection() {
		return this.modeSelection;
	}

	public void setModeSelection(String value) {
		this.modeSelection = value;
	}
	public String getGeneral() {
		return this.general;
	}

	public void setGeneral(String value) {
		this.general = value;
	}
	public String getTestAccount() {
		return this.testAccount;
	}

	public void setTestAccount(String value) {
		this.testAccount = value;
	}
	public String getSetOdds() {
		return this.setOdds;
	}

	public void setSetOdds(String value) {
		this.setOdds = value;
	}


	public Integer getHandicap() {
		return handicap;
	}

	public void setHandicap(Integer handicap) {
		this.handicap = handicap;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerUserType() {
		return ownerUserType;
	}

	public void setOwnerUserType(String ownerUserType) {
		this.ownerUserType = ownerUserType;
	}

	//endregion

	//region your codes 2

	//endregion your codes 2

}