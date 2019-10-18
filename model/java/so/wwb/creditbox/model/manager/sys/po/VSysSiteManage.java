package so.wwb.creditbox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;
import so.wwb.creditbox.model.enums.sys.SysSiteStatusEnum;

import java.util.Date;


/**
 * 站点管理实体
 *
 * @author tony
 * @tableAuthor tom
 * @time 2017-5-8 10:24:13
 */
public class VSysSiteManage implements IEntity<Integer> {

	private static final long serialVersionUID = 6328360893560849767L;
	public static final String PROP_NAME = "name";

	public static final String PROP_ID = "id";
	public static final String PROP_SYS_USER_ID = "sysUserId";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_THEME = "theme";
	public static final String PROP_SSO_THEME = "ssoTheme";
	public static final String PROP_STATUS = "status";
	public static final String PROP_IS_BUILDIN = "isBuildin";
	public static final String PROP_POSTFIX = "postfix";
	public static final String PROP_SHORT_NAME = "shortName";
	public static final String PROP_PARENT_NAME = "parentName";
	public static final String PROP_SITE_NAME = "siteName";
	public static final String PROP_MAIN_CURRENCY = "mainCurrency";
	public static final String PROP_MAIN_LANGUAGE = "mainLanguage";
	public static final String PROP_WEB_SITE = "webSite";
	public static final String PROP_OPENING_TIME = "openingTime";
	public static final String PROP_TIMEZONE = "timezone";
	public static final String PROP_TRAFFIC_STATISTICS = "trafficStatistics";
	public static final String PROP_CODE = "code";
	public static final String PROP_LOGO_PATH = "logoPath";
	public static final String PROP_SITE_CLASSIFY_KEY = "siteClassifyKey";
	public static final String PROP_SITE_NET_SCHEME_ID = "siteNetSchemeId";
	public static final String PROP_MAX_PROFIT = "maxProfit";
	public static final String PROP_OWNER_ID = "ownerId";
	public static final String PROP_CENTER_ID = "centerId";
	public static final String PROP_DEPOSIT = "deposit";
	public static final String PROP_TEMPLATE_CODE = "templateCode";
	public static final String PROP_IMPORT_PLAYERS_TIME = "importPlayersTime";
	public static final String PROP_MAINTAIN_START_TIME = "maintainStartTime";
	public static final String PROP_MAINTAIN_END_TIME = "maintainEndTime";
	public static final String PROP_DB = "db";
	public static final String PROP_LOCALE = "locale";
	public static final String PROP_DOMAIN = "domain";
	public static final String PROP_REMARK = "remark";
	public static final String PROP_IDC = "idc";
	public static final String PROP_MODE = "mode";



	public static final String PROP_PARENT_ID = "parentId";

	/** 主键 */
	private Integer id;
	/** 用户ID */
	private Integer sysUserId;
	/** 站长账号 */
	private String username;
	/** 主题 */
	private String theme;
	/** 标题　*/
	private String title;
	/** 单点主题 */
	private String ssoTheme;
	/** 状态 */
	private String status;
	/** 是否内置 */
	private Boolean isBuildin;
	/** 账号后缀 */
	private String postfix;
	/** 简称 */
	private String shortName;
	/** 上级站点名称 */
	private String parentName;
	/** 站点名称 */
	private String siteName;
	/** 主货币 */
	private String mainCurrency;
	/** 主语言 */
	private String mainLanguage;
	/** 站点网站 */
	private String webSite;
	/** 开站时间 */
	private Date openingTime;
	/** 站点时区 */
	private String timezone;
	/** 流量统计代码 */
	private String trafficStatistics;
	/** 站点代码 */
	private String code;
	/** Logo路径 */
	private String logoPath;
	/** 类型 */
	private String siteClassifyKey;
	/** 包网方案 */
	private Integer siteNetSchemeId;
	/** 盈利上限 */
	private Double maxProfit;
	/** 上级用户ID */
	private Integer ownerId;
	/** 上级站点ID */
	private Integer centerId;
	/** 押金 */
	private Double deposit;
	/** 站点模板 */
	private String templateCode;
	/** 用户导入时间 */
	private Date importPlayersTime;
	/** 维护开始时间 */
	private Date maintainStartTime;
	/** 维护结束时间 */
	private Date maintainEndTime;
	/** 数据库信息 */
	private String db;
	/** 备数据库信息 */
	private String backupdb;
	/** 语言 */
	private String locale;
	/** 默认域名 */
	private String domain;
	/** 备注 */
	private String remark;
	/** 所属机房 */
	private String idc;
	private Integer parentId;
	/**
	 * 模式:测试:1、正式:2
	 */
	private String mode;

	public VSysSiteManage(){
	}

	public VSysSiteManage(Integer id){
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Integer value) {
		this.sysUserId = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String value) {
		this.theme = value;
	}
	public String getSsoTheme() {
		return this.ssoTheme;
	}

	public void setSsoTheme(String value) {
		this.ssoTheme = value;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public Boolean getIsBuildin() {
		return this.isBuildin;
	}

	public void setIsBuildin(Boolean value) {
		this.isBuildin = value;
	}
	public String getPostfix() {
		return this.postfix;
	}

	public void setPostfix(String value) {
		this.postfix = value;
	}
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String value) {
		this.shortName = value;
	}
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String value) {
		this.parentName = value;
	}
	public String getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String value) {
		this.siteName = value;
	}
	public String getMainCurrency() {
		return this.mainCurrency;
	}

	public void setMainCurrency(String value) {
		this.mainCurrency = value;
	}
	public String getMainLanguage() {
		return this.mainLanguage;
	}

	public void setMainLanguage(String value) {
		this.mainLanguage = value;
	}
	public String getWebSite() {
		return this.webSite;
	}

	public void setWebSite(String value) {
		this.webSite = value;
	}
	@org.soul.model.common.Sortable
	public Date getOpeningTime() {
		return this.openingTime;
	}

	public void setOpeningTime(Date value) {
		this.openingTime = value;
	}
	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String value) {
		this.timezone = value;
	}
	public String getTrafficStatistics() {
		return this.trafficStatistics;
	}

	public void setTrafficStatistics(String value) {
		this.trafficStatistics = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String value) {
		this.logoPath = value;
	}
	public String getSiteClassifyKey() {
		return this.siteClassifyKey;
	}

	public void setSiteClassifyKey(String value) {
		this.siteClassifyKey = value;
	}
	public Integer getSiteNetSchemeId() {
		return this.siteNetSchemeId;
	}

	public void setSiteNetSchemeId(Integer value) {
		this.siteNetSchemeId = value;
	}
	public Double getMaxProfit() {
		return this.maxProfit;
	}

	public void setMaxProfit(Double value) {
		this.maxProfit = value;
	}
	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer value) {
		this.ownerId = value;
	}
	public Integer getCenterId() {
		return this.centerId;
	}

	public void setCenterId(Integer value) {
		this.centerId = value;
	}
	public Double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Double value) {
		this.deposit = value;
	}
	public String getTemplateCode() {
		return this.templateCode;
	}

	public void setTemplateCode(String value) {
		this.templateCode = value;
	}
	public Date getImportPlayersTime() {
		return this.importPlayersTime;
	}

	public void setImportPlayersTime(Date value) {
		this.importPlayersTime = value;
	}
	public Date getMaintainStartTime() {
		return this.maintainStartTime;
	}

	public void setMaintainStartTime(Date value) {
		this.maintainStartTime = value;
	}
	public Date getMaintainEndTime() {
		return this.maintainEndTime;
	}

	public void setMaintainEndTime(Date value) {
		this.maintainEndTime = value;
	}
	public String getDb() {
		return this.db;
	}

	public void setDb(String value) {
		this.db = value;
	}
	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String value) {
		this.locale = value;
	}
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String value) {
		this.domain = value;
	}
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}

	public String getBackupdb() {
		return backupdb;
	}

	public void setBackupdb(String backupdb) {
		this.backupdb = backupdb;
	}

	public String getIdc() {
		return idc;
	}

	public void setIdc(String idc) {
		this.idc = idc;
	}


	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public static String getPropName() {
		return PROP_NAME;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	private Boolean isEnable;

	/** 站点名称 */
	private String name;

	/** 包网方案 */
	private String netscheme;

	/** 已使用 */
	private Double usedProfit;

	private String cacheLogo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Nonpersistent
	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	@Nonpersistent
	public String getNetscheme() {
		return netscheme;
	}

	public void setNetscheme(String netscheme) {
		this.netscheme = netscheme;
	}

	@Nonpersistent
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCacheLogo() {
		return cacheLogo;
	}

	public void setCacheLogo(String cacheLogo) {
		this.cacheLogo = cacheLogo;
	}

	public Double getUsedProfit() {
		return usedProfit;
	}

	public void setUsedProfit(Double usedProfit) {
		this.usedProfit = usedProfit;
	}

	public void calIsEnable() {
		if (this.importPlayersTime==null || this.importPlayersTime.compareTo(new Date())<=0) {
			this.isEnable = false;
		} else if (this.importPlayersTime!=null && this.importPlayersTime.compareTo(new Date())>0) {
			this.isEnable = true;
		}
	}

	public void calStatus() {
		if (!SysSiteStatusEnum.STOP.getCode().equals(getStatus())) {
			Date now = new Date();
			if(SysSiteStatusEnum.MAINTAIN.getCode().equals(getStatus())){
				if(getMaintainStartTime()!=null){
					if(now.before(getMaintainStartTime())){
						this.setStatus(SysSiteStatusEnum.PRE_MAINTAIN.getCode());
					}else{
						this.setStatus(SysSiteStatusEnum.MAINTAIN.getCode());
						/*if(getMaintainEndTime()!=null){
							if(now.before(getMaintainEndTime())){
								this.setStatus(SysSiteStatusEnum.MAINTAIN.getCode());
							}else{
								this.setStatus(SysSiteStatusEnum.NORMAL.getCode());
							}
						}else{
							this.setStatus(SysSiteStatusEnum.MAINTAIN.getCode());
						}*/
					}
				}else{
					//返回原值
					this.setStatus(SysSiteStatusEnum.NORMAL.getCode());
				}
			}
		}
		/*if (!SysSiteStatusEnum.STOP.getCode().equals(getStatus())) {
			if (getMaintainStartTime()!=null && getMaintainStartTime().compareTo(new Date())<0 && getMaintainEndTime()!=null && getMaintainEndTime().compareTo(new Date())>0) {
				this.setStatus(SysSiteStatusEnum.MAINTAIN.getCode());
			}
		}*/
	}
	private String paramType;
	private String paramCode;
	private boolean paramValue;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public boolean isParamValue() {
		return paramValue;
	}

	public void setParamValue(boolean paramValue) {
		this.paramValue = paramValue;
	}

}