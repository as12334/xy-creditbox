package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 彩票采集接口配置表实体
 *
 * @author block
 * @time 2019-11-15 10:46:12
 */
//region your codes 1
public class LotteryGatherConf implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -320736331660217362L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_ABBR_NAME = "abbrName";
	public static final String PROP_NAME = "name";
	public static final String PROP_CODE = "code";
	public static final String PROP_TYPE = "type";
	public static final String PROP_URL = "url";
	public static final String PROP_METHOD = "method";
	public static final String PROP_REQUEST_CONTENT_TYPE = "requestContentType";
	public static final String PROP_RESPONSE_CONTENT_TYPE = "responseContentType";
	public static final String PROP_JSON_PARAM = "jsonParam";
	public static final String PROP_CONF_TYPE = "confType";
	public static final String PROP_CHECK_NEXT = "checkNext";
	public static final String PROP_STATUS = "status";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 彩票接口名称,参考LotteryGatherEnum */
	private String abbrName;
	/** 彩票接口名称 */
	private String name;
	/** 彩票code,参考LotteryEnum */
	private String code;
	/** 彩票类型,参考LotteryTypeEnum */
	private String type;
	/** 请求地址 */
	private String url;
	/** 请求方法 */
	private String method;
	/** 请求类型 */
	private String requestContentType;
	/** 响应类型 */
	private String responseContentType;
	/** json参数 */
	private String jsonParam;
	/** 开奖hash，避免同时开奖 */
	private String confType;
	/** 是否检验下一期开奖时间 */
	private Boolean checkNext;
	/** 采集接口状态 */
	private String status;
	//endregion

	
	//region constuctors
	public LotteryGatherConf(){
	}

	public LotteryGatherConf(Integer id){
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
	public String getAbbrName() {
		return this.abbrName;
	}

	public void setAbbrName(String value) {
		this.abbrName = value;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String value) {
		this.url = value;
	}
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String value) {
		this.method = value;
	}
	public String getRequestContentType() {
		return this.requestContentType;
	}

	public void setRequestContentType(String value) {
		this.requestContentType = value;
	}
	public String getResponseContentType() {
		return this.responseContentType;
	}

	public void setResponseContentType(String value) {
		this.responseContentType = value;
	}
	public String getJsonParam() {
		return this.jsonParam;
	}

	public void setJsonParam(String value) {
		this.jsonParam = value;
	}
	public String getConfType() {
		return this.confType;
	}

	public void setConfType(String value) {
		this.confType = value;
	}
	public Boolean getCheckNext() {
		return this.checkNext;
	}

	public void setCheckNext(Boolean value) {
		this.checkNext = value;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}