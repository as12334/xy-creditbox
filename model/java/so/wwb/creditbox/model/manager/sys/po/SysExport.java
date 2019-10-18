package so.wwb.creditbox.model.manager.sys.po;


import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;


/**
 * 导出数据历史表实体
 *
 * @author Administrator
 * @tableAuthor River
 * @time 2016-11-3 15:23:35
 */
//region your codes 1
public class SysExport implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 6806475338987397428L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SERVICE = "service";
	public static final String PROP_METHOD = "method";
	public static final String PROP_EXPORT_TYPE = "exportType";
	public static final String PROP_FILE_NAME = "fileName";
	public static final String PROP_FILE_SUFFIX = "fileSuffix";
	public static final String PROP_EXPORT_CONDITION = "exportCondition";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_STATUS = "status";
	public static final String PROP_CODE = "code";
	public static final String PROP_ORIGIN_CONFITION = "originConfition";
	public static final String PROP_PARAM = "param";
	public static final String PROP_FILE_PATH = "filePath";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_EXPORT_END_TIME = "exportEndTime";
	public static final String PROP_EXPORT_COUNT = "exportCount";
	public static final String PROP_EXPORT_USER_ID = "exportUserId";
	public static final String PROP_EXPORT_USER_SITE_ID = "exportUserSiteId";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 服务对象 */
	private String service;
	/** 服务方法 */
	private String method;
	/** 导出类型 */
	private String exportType;
	/** 导出文件名 */
	private String fileName;
	/** 文件后缀 */
	private String fileSuffix;
	/** 筛选条件 */
	private byte[] exportCondition;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 状态 */
	private String status;
	/** 密码 */
	private String code;
	/** 原始条件 */
	private String originConfition;
	/** 参数类型 */
	private String param;
	/** 文件路径 */
	private String filePath;
	/** 导出用户 */
	private String username;
	/** 这是导出站点的ID，站长账号，运营商，总控导经营报表需要指定站点ID */
	private Integer siteId;
	/** 导出结束时间 */
	private java.util.Date exportEndTime;
	/** 导出记录数 */
	private Integer exportCount;
	/** 导出人ID */
	private Integer exportUserId;
	/** 导出人的站点ID,用于导出历史中的条件过滤 */
	private Integer exportUserSiteId;
	//endregion

	
	//region constuctors
	public SysExport(){
	}

	public SysExport(Integer id){
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
	public String getService() {
		return this.service;
	}

	public void setService(String value) {
		this.service = value;
	}
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String value) {
		this.method = value;
	}
	public String getExportType() {
		return this.exportType;
	}

	public void setExportType(String value) {
		this.exportType = value;
	}
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String value) {
		this.fileName = value;
	}
	public String getFileSuffix() {
		return this.fileSuffix;
	}

	public void setFileSuffix(String value) {
		this.fileSuffix = value;
	}
	public byte[] getExportCondition() {
		return this.exportCondition;
	}

	public void setExportCondition(byte[] value) {
		this.exportCondition = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	@org.soul.model.common.Sortable
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getOriginConfition() {
		return this.originConfition;
	}

	public void setOriginConfition(String value) {
		this.originConfition = value;
	}
	public String getParam() {
		return this.param;
	}

	public void setParam(String value) {
		this.param = value;
	}
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String value) {
		this.filePath = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getExportEndTime() {
		return this.exportEndTime;
	}

	public void setExportEndTime(java.util.Date value) {
		this.exportEndTime = value;
	}
	public Integer getExportCount() {
		return this.exportCount;
	}

	public void setExportCount(Integer value) {
		this.exportCount = value;
	}
	public Integer getExportUserId() {
		return this.exportUserId;
	}

	public void setExportUserId(Integer value) {
		this.exportUserId = value;
	}
	public Integer getExportUserSiteId() {
		return this.exportUserSiteId;
	}

	public void setExportUserSiteId(Integer value) {
		this.exportUserSiteId = value;
	}
	//endregion

	//region your codes 2
    //指定导出的service的dubbo version
	private String _serviceVersion;

	@Nonpersistent
	public String _getServiceVersion() {
		return _serviceVersion;
	}

	public void _setServiceVersion(String _serviceVersion) {
		this._serviceVersion = _serviceVersion;
	}

	//endregion your codes 2

}