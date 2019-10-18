package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;

/**
 * 彩票失败日志实体
 *
 * @author steady
 * @time 2018-5-24 14:52:46
 */
public class LotteryErrorLog implements IEntity<Integer> {
	private static final long serialVersionUID = 5804769573078471902L;

	public static final String PROP_ID = "id";
	public static final String PROP_TYPE = "type";
	public static final String PROP_CODE = "code";
	public static final String PROP_OPERATION_TYPE = "operationType";
	public static final String PROP_OPERATION_MSG_JSON = "operationMsgJson";
	public static final String PROP_ERR_MSG_JSON = "errMsgJson";
	public static final String PROP_CREATE_TIME = "createTime";

	/**
	 * 自增主键
	 */
	private Integer id;
	/**
	 * 彩种类型LotteryTypeEnum
	 */
	private String type;
	/**
	 * 彩种代号LotteryEnum
	 */
	private String code;
	/**
	 * 操作类型
	 */
	private String operationType;
	/**
	 * 操作信息json
	 */
	private String operationMsgJson;
	/**
	 * 错误信息Json
	 */
	private String errMsgJson;
	/**
	 *  创建时间
	 */
	private java.util.Date createTime;

	public LotteryErrorLog() {
	}

	public LotteryErrorLog(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}

	public String getErrMsgJson() {
		return this.errMsgJson;
	}

	public void setErrMsgJson(String value) {
		this.errMsgJson = value;
	}

	@Sortable
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getOperationMsgJson() {
		return operationMsgJson;
	}

	public void setOperationMsgJson(String operationMsgJson) {
		this.operationMsgJson = operationMsgJson;
	}
}