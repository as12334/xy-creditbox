package so.wwb.lotterybox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;

//region your codes 1
public class LotteryGatherConf implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -645023537678274295L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_ABBR_NAME = "abbrName";
	public static final String PROP_NAME = "name";
	public static final String PROP_CODE = "code";
	public static final String PROP_TYPE = "type";
	public static final String PROP_URL = "url";
	public static final String PROP_METHOD = "method";
	public static final String PROP_JSON_PARAM = "jsonParam";
	public static final String PROP_CHECK = "checkNext";
	public static final String PROP_CONF_TYPE = "confType";
	public static final String PROP_GATHER_INTERVAL = "gatherInterval";
	public static final String PROP_REQUEST_CONTENT_TYPE = "requestContentType";
	public static final String PROP_RESPONSE_CONTENT_TYPE = "responseContentType";
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
	/** 彩票类型,参考LotteryConfTypeEnum*/
	private String confType;
	/** 请求地址 */
	private String url;
	/** 请求方法 */
	private String method;
	/** json参数 */
	private String jsonParam;
	/** 请求类型 */
	private String requestContentType;
	/** 响应类型 */
	private String responseContentType;
	/** 检查下一期的开奖结果 */
	private Boolean checkNext =false;
	private Integer gatherInterval;
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
	public String getJsonParam() {
		return this.jsonParam;
	}

	public void setJsonParam(String value) {
		this.jsonParam = value;
	}

	public String getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(String requestContentType) {
		this.requestContentType = requestContentType;
	}

	public String getResponseContentType() {
		return responseContentType;
	}

	public void setResponseContentType(String responseContentType) {
		this.responseContentType = responseContentType;
	}

	public Boolean getCheckNext() {
		return checkNext;
	}

	public void setCheckNext(Boolean checkNext) {
		this.checkNext = checkNext;
	}

	public String getConfType() {
		return confType;
	}

	public void setConfType(String confType) {
		this.confType = confType;
	}

	public Integer getGatherInterval() {
		return gatherInterval;
	}

	public void setGatherInterval(Integer gatherInterval) {
		this.gatherInterval = gatherInterval;
	}

	//endregion

	//region your codes 2

	//endregion your codes 2
}