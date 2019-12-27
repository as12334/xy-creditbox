package so.wwb.creditbox.model.manager.user.po;

import org.apache.xmlbeans.UserType;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.Nonpersistent;
import org.soul.model.security.privilege.po.SysUser;
import so.wwb.creditbox.model.common.Const;
import so.wwb.creditbox.model.common.HidTool;
import so.wwb.creditbox.model.company.user.po.CzUsersChild;
import so.wwb.creditbox.model.enums.lottery.*;
import java.util.Date;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 用户扩展表实体
 *
 * @author block
 * @time 2019-12-26 23:58:23
 */
//region your codes 1
public class SysUserExtend extends SysUser {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 8789285198108194273L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_KEY = "key";
	public static final String PROP_UID = "uid";
	public static final String PROP_SALT = "salt";
	public static final String PROP_USKIN = "uskin";
	public static final String PROP_SUP_NAME = "supName";
	public static final String PROP_ADD_DATE = "addDate";
	public static final String PROP_UTYPE = "utype";
	public static final String PROP_SU_TYPE = "suType";
	public static final String PROP_SIX_RATE = "sixRate";
	public static final String PROP_SIX_CREDIT = "sixCredit";
	public static final String PROP_SIX_USABLE_CREDIT = "sixUsableCredit";
	public static final String PROP_SIX_KIND = "sixKind";
	public static final String PROP_ASTATE = "astate";
	public static final String PROP_SIX_ALLOW_SALE = "sixAllowSale";
	public static final String PROP_ALLOW_VIEW_REPORT = "allowViewReport";
	public static final String PROP_SIX_ALLOW_MAXRATE = "sixAllowMaxrate";
	public static final String PROP_SIX_LOW_MAXRATE = "sixLowMaxrate";
	public static final String PROP_SIX_RATE_OWNER = "sixRateOwner";
	public static final String PROP_SIX_ISCASH = "sixIscash";
	public static final String PROP_ALLOW_OPT = "allowOpt";
	public static final String PROP_IS_CHANGED = "isChanged";
	public static final String PROP_KC_RATE = "kcRate";
	public static final String PROP_KC_CREDIT = "kcCredit";
	public static final String PROP_KC_USABLE_CREDIT = "kcUsableCredit";
	public static final String PROP_KC_KIND = "kcKind";
	public static final String PROP_KC_ALLOW_SALE = "kcAllowSale";
	public static final String PROP_KC_ALLOW_MAXRATE = "kcAllowMaxrate";
	public static final String PROP_KC_LOW_MAXRATE = "kcLowMaxrate";
	public static final String PROP_KC_RATE_OWNER = "kcRateOwner";
	public static final String PROP_KC_CRASH_PAYMENT = "kcCrashPayment";
	public static final String PROP_KC_ISCASH = "kcIscash";
	public static final String PROP_SIX_OP_ODDS = "sixOpOdds";
	public static final String PROP_KC_OP_ODDS = "kcOpOdds";
	public static final String PROP_KC_ISAUTO_BACK = "kcIsautoBack";
	public static final String PROP_SIX_ISAUTO_BACK = "sixIsautoBack";
	public static final String PROP_LAST_CHANGED_DATE = "lastChangedDate";
	//endregion
	
	
	//region properties
	/** 钥匙 */
	private String key;
	/** 用户唯一串 */
	private String uid;
	/** 密码加密盐 */
	private String salt;
	/** 皮肤 SkinEnum */
	private String uskin;
	/** 上级用户名 */
	private String supName;
	/** 用户新增时间 */
	private java.util.Date addDate;
	/** 用户类型 UtypeEnum */
	private String utype;
	/** 上级用户类型 UtypeEnum */
	private String suType;
	/** ⑥合彩占成 */
	private Integer sixRate;
	/** ⑥合彩信用额度 */
	private Double sixCredit;
	/** ⑥合彩可用额度 */
	private Double sixUsableCredit;
	/** ⑥合彩盘口 */
	private String sixKind;
	/**  */
	private Integer astate;
	/** ⑥合彩補貨功能 */
	private String sixAllowSale;
	/** 開放公司報錶功能 1:開放 0:禁看 */
	private String allowViewReport;
	/** ⑥合彩下線占成上限功能 1:限製下綫可占成數 0:占餘成數下綫任占 */
	private String sixAllowMaxrate;
	/** ⑥合彩限製下綫可占成數 */
	private Integer sixLowMaxrate;
	/** ⑥合彩占餘成數歸 1:總監 0:分公司 */
	private String sixRateOwner;
	/** 1:现金 0:信用 */
	private String sixIscash;
	/**  */
	private Integer allowOpt;
	/** 0:新密碼首次登錄,需重置密碼 1:不需要重置 */
	private String isChanged;
	/** 快彩占成 */
	private Integer kcRate;
	/** 快彩信用额度 */
	private Double kcCredit;
	/** 快彩可用额度 */
	private Double kcUsableCredit;
	/** 快彩盘口 */
	private String kcKind;
	/** 快彩補貨功能 */
	private String kcAllowSale;
	/** 快彩下線占成上限功能 1:限製下綫可占成數 0:占餘成數下綫任占 */
	private String kcAllowMaxrate;
	/** 快彩限製下綫可占成數 */
	private Integer kcLowMaxrate;
	/** 快彩占餘成數歸 1:總監 0:分公司 */
	private String kcRateOwner;
	/**  */
	private Integer kcCrashPayment;
	/** 1:现金 0:信用 */
	private String kcIscash;
	/** ⑥合彩操盤 */
	private String sixOpOdds;
	/** 快彩操盤 */
	private String kcOpOdds;
	/** 快彩會員現金自動回收 */
	private String kcIsautoBack;
	/** ⑥合彩會員現金自動回收 */
	private String sixIsautoBack;
	/** 密码最后修改时间 */
	private java.util.Date lastChangedDate;
	//endregion

	
	//region constuctors
	//endregion


	//region getters and setters
	public String getKey() {
		return this.key;
	}

	public void setKey(String value) {
		this.key = value;
	}
	public String getUid() {
		return this.uid;
	}

	public void setUid(String value) {
		this.uid = value;
	}
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String value) {
		this.salt = value;
	}
	public String getUskin() {
		return this.uskin;
	}

	public void setUskin(String value) {
		this.uskin = value;
	}
	public String getSupName() {
		return this.supName;
	}

	public void setSupName(String value) {
		this.supName = value;
	}
	public java.util.Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(java.util.Date value) {
		this.addDate = value;
	}
	public String getUtype() {
		return this.utype;
	}

	public void setUtype(String value) {
		this.utype = value;
	}
	public String getSuType() {
		return this.suType;
	}

	public void setSuType(String value) {
		this.suType = value;
	}
	public Integer getSixRate() {
		return this.sixRate;
	}

	public void setSixRate(Integer value) {
		this.sixRate = value;
	}
	public Double getSixCredit() {
		return this.sixCredit;
	}

	public void setSixCredit(Double value) {
		this.sixCredit = value;
	}
	public Double getSixUsableCredit() {
		return this.sixUsableCredit;
	}

	public void setSixUsableCredit(Double value) {
		this.sixUsableCredit = value;
	}
	public String getSixKind() {
		return this.sixKind;
	}

	public void setSixKind(String value) {
		this.sixKind = value;
	}
	public Integer getAstate() {
		return this.astate;
	}

	public void setAstate(Integer value) {
		this.astate = value;
	}
	public String getSixAllowSale() {
		return this.sixAllowSale;
	}

	public void setSixAllowSale(String value) {
		this.sixAllowSale = value;
	}
	public String getAllowViewReport() {
		return this.allowViewReport;
	}

	public void setAllowViewReport(String value) {
		this.allowViewReport = value;
	}
	public String getSixAllowMaxrate() {
		return this.sixAllowMaxrate;
	}

	public void setSixAllowMaxrate(String value) {
		this.sixAllowMaxrate = value;
	}
	public Integer getSixLowMaxrate() {
		return this.sixLowMaxrate;
	}

	public void setSixLowMaxrate(Integer value) {
		this.sixLowMaxrate = value;
	}
	public String getSixRateOwner() {
		return this.sixRateOwner;
	}

	public void setSixRateOwner(String value) {
		this.sixRateOwner = value;
	}
	public String getSixIscash() {
		return this.sixIscash;
	}

	public void setSixIscash(String value) {
		this.sixIscash = value;
	}
	public Integer getAllowOpt() {
		return this.allowOpt;
	}

	public void setAllowOpt(Integer value) {
		this.allowOpt = value;
	}
	public String getIsChanged() {
		return this.isChanged;
	}

	public void setIsChanged(String value) {
		this.isChanged = value;
	}
	public Integer getKcRate() {
		return this.kcRate;
	}

	public void setKcRate(Integer value) {
		this.kcRate = value;
	}
	public Double getKcCredit() {
		return this.kcCredit;
	}

	public void setKcCredit(Double value) {
		this.kcCredit = value;
	}
	public Double getKcUsableCredit() {
		return this.kcUsableCredit;
	}

	public void setKcUsableCredit(Double value) {
		this.kcUsableCredit = value;
	}
	public String getKcKind() {
		return this.kcKind;
	}

	public void setKcKind(String value) {
		this.kcKind = value;
	}
	public String getKcAllowSale() {
		return this.kcAllowSale;
	}

	public void setKcAllowSale(String value) {
		this.kcAllowSale = value;
	}
	public String getKcAllowMaxrate() {
		return this.kcAllowMaxrate;
	}

	public void setKcAllowMaxrate(String value) {
		this.kcAllowMaxrate = value;
	}
	public Integer getKcLowMaxrate() {
		return this.kcLowMaxrate;
	}

	public void setKcLowMaxrate(Integer value) {
		this.kcLowMaxrate = value;
	}
	public String getKcRateOwner() {
		return this.kcRateOwner;
	}

	public void setKcRateOwner(String value) {
		this.kcRateOwner = value;
	}
	public Integer getKcCrashPayment() {
		return this.kcCrashPayment;
	}

	public void setKcCrashPayment(Integer value) {
		this.kcCrashPayment = value;
	}
	public String getKcIscash() {
		return this.kcIscash;
	}

	public void setKcIscash(String value) {
		this.kcIscash = value;
	}
	public String getSixOpOdds() {
		return this.sixOpOdds;
	}

	public void setSixOpOdds(String value) {
		this.sixOpOdds = value;
	}
	public String getKcOpOdds() {
		return this.kcOpOdds;
	}

	public void setKcOpOdds(String value) {
		this.kcOpOdds = value;
	}
	public String getKcIsautoBack() {
		return this.kcIsautoBack;
	}

	public void setKcIsautoBack(String value) {
		this.kcIsautoBack = value;
	}
	public String getSixIsautoBack() {
		return this.sixIsautoBack;
	}

	public void setSixIsautoBack(String value) {
		this.sixIsautoBack = value;
	}
	public java.util.Date getLastChangedDate() {
		return this.lastChangedDate;
	}

	public void setLastChangedDate(java.util.Date value) {
		this.lastChangedDate = value;
	}
	//endregion

	//region your codes 2
	private CzUsersChild sessionUserChild;

	public CzUsersChild getSessionUserChild() {
		return sessionUserChild;
	}

	public void setSessionUserChild(CzUsersChild sessionUserChild) {
		this.sessionUserChild = sessionUserChild;
	}
	//endregion your codes 2

}