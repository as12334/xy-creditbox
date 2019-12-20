package so.wwb.creditbox.model.company.user.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-12-19 23:19:54
 */
//region your codes 1
public class CzUsers implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 161568816284276815L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_UID = "uid";
	public static final String PROP_UNAME = "uname";
	public static final String PROP_SALT = "salt";
	public static final String PROP_UNICKER = "unicker";
	public static final String PROP_USKIN = "uskin";
	public static final String PROP_SUP_NAME = "supName";
	public static final String PROP_UTYPE = "utype";
	public static final String PROP_SU_TYPE = "suType";
	public static final String PROP_ADD_DATE = "addDate";
	public static final String PROP_SIX_RATE = "sixRate";
	public static final String PROP_SIX_CREDIT = "sixCredit";
	public static final String PROP_SIX_USABLE_CREDIT = "sixUsableCredit";
	public static final String PROP_SIX_KIND = "sixKind";
	public static final String PROP_ASTATE = "astate";
	public static final String PROP_ALLOW_SALE = "allowSale";
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
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private String uid;
	/**  */
	private String uname;
	/**  */
	private String salt;
	/**  */
	private String unicker;
	/**  */
	private String uskin;
	/**  */
	private String supName;
	/**  */
	private String utype;
	/**  */
	private String suType;
	/**  */
	private java.util.Date addDate;
	/**  */
	private Integer sixRate;
	/**  */
	private Double sixCredit;
	/**  */
	private Double sixUsableCredit;
	/**  */
	private String sixKind;
	/**  */
	private Integer astate;
	/**  */
	private Integer allowSale;
	/**  */
	private Integer allowViewReport;
	/**  */
	private Integer sixAllowMaxrate;
	/**  */
	private Integer sixLowMaxrate;
	/**  */
	private Integer sixRateOwner;
	/**  */
	private Integer sixIscash;
	/**  */
	private Integer allowOpt;
	/**  */
	private Integer isChanged;
	/**  */
	private Integer kcRate;
	/**  */
	private Double kcCredit;
	/**  */
	private Double kcUsableCredit;
	/**  */
	private String kcKind;
	/**  */
	private Integer kcAllowSale;
	/**  */
	private Integer kcAllowMaxrate;
	/**  */
	private Integer kcLowMaxrate;
	/**  */
	private Integer kcRateOwner;
	/**  */
	private Integer kcCrashPayment;
	/**  */
	private Integer kcIscash;
	/**  */
	private Integer sixOpOdds;
	/**  */
	private Integer kcOpOdds;
	//endregion

	
	//region constuctors
	public CzUsers(){
	}

	public CzUsers(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public String getUid() {
		return this.uid;
	}

	public void setUid(String value) {
		this.uid = value;
	}
	public String getUname() {
		return this.uname;
	}

	public void setUname(String value) {
		this.uname = value;
	}
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String value) {
		this.salt = value;
	}
	public String getUnicker() {
		return this.unicker;
	}

	public void setUnicker(String value) {
		this.unicker = value;
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
	public java.util.Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(java.util.Date value) {
		this.addDate = value;
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
	public Integer getAllowSale() {
		return this.allowSale;
	}

	public void setAllowSale(Integer value) {
		this.allowSale = value;
	}
	public Integer getAllowViewReport() {
		return this.allowViewReport;
	}

	public void setAllowViewReport(Integer value) {
		this.allowViewReport = value;
	}
	public Integer getSixAllowMaxrate() {
		return this.sixAllowMaxrate;
	}

	public void setSixAllowMaxrate(Integer value) {
		this.sixAllowMaxrate = value;
	}
	public Integer getSixLowMaxrate() {
		return this.sixLowMaxrate;
	}

	public void setSixLowMaxrate(Integer value) {
		this.sixLowMaxrate = value;
	}
	public Integer getSixRateOwner() {
		return this.sixRateOwner;
	}

	public void setSixRateOwner(Integer value) {
		this.sixRateOwner = value;
	}
	public Integer getSixIscash() {
		return this.sixIscash;
	}

	public void setSixIscash(Integer value) {
		this.sixIscash = value;
	}
	public Integer getAllowOpt() {
		return this.allowOpt;
	}

	public void setAllowOpt(Integer value) {
		this.allowOpt = value;
	}
	public Integer getIsChanged() {
		return this.isChanged;
	}

	public void setIsChanged(Integer value) {
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
	public Integer getKcAllowSale() {
		return this.kcAllowSale;
	}

	public void setKcAllowSale(Integer value) {
		this.kcAllowSale = value;
	}
	public Integer getKcAllowMaxrate() {
		return this.kcAllowMaxrate;
	}

	public void setKcAllowMaxrate(Integer value) {
		this.kcAllowMaxrate = value;
	}
	public Integer getKcLowMaxrate() {
		return this.kcLowMaxrate;
	}

	public void setKcLowMaxrate(Integer value) {
		this.kcLowMaxrate = value;
	}
	public Integer getKcRateOwner() {
		return this.kcRateOwner;
	}

	public void setKcRateOwner(Integer value) {
		this.kcRateOwner = value;
	}
	public Integer getKcCrashPayment() {
		return this.kcCrashPayment;
	}

	public void setKcCrashPayment(Integer value) {
		this.kcCrashPayment = value;
	}
	public Integer getKcIscash() {
		return this.kcIscash;
	}

	public void setKcIscash(Integer value) {
		this.kcIscash = value;
	}
	public Integer getSixOpOdds() {
		return this.sixOpOdds;
	}

	public void setSixOpOdds(Integer value) {
		this.sixOpOdds = value;
	}
	public Integer getKcOpOdds() {
		return this.kcOpOdds;
	}

	public void setKcOpOdds(Integer value) {
		this.kcOpOdds = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}