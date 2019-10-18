package so.wwb.lotterybox.model.company.setting.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.support.Nonpersistent;

import java.util.Date;

//region your codes 1
public class DefenseRecord implements IEntity<Long> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -7663915828413492706L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_CLIENT_ID = "clientId";
	public static final String PROP_ACTION_CODE = "actionCode";
	public static final String PROP_DISPOSE_CODE = "disposeCode";
	public static final String PROP_DISPOSE_END_TIME = "disposeEndTime";
	public static final String PROP_OPERATE_IP = "operateIp";
	public static final String PROP_OPERATE_START_TIME = "operateStartTime";
	public static final String PROP_OPERATE_END_TIME = "operateEndTime";
	public static final String PROP_SUCCESS_TIMES = "successTimes";
	public static final String PROP_ERROR_TIMES = "errorTimes";
	public static final String PROP_DESCRIPTION = "description";
	public static final String PROP_SYS_USER_ID = "sysUserId";
	public static final String PROP_RESET_COLUMNS = "resetColumns";
	//endregion

	//region properties
	/** 主键 */
	private Long id;
	/** 主键 */
	private String clientId;
	/** 功能代码 */
	private String actionCode;
	/** 处置代码(控制操作行为) */
	private String disposeCode;
	/** 处置结束时间 */
	private Date disposeEndTime;
	/** 操作IP */
	private Long operateIp;
	/** 操作开始时间 */
	private Date operateStartTime;
	/** 操作结束时间 */
	private Date operateEndTime;
	/** 操作成功次数 */
	private Integer successTimes;
	/** 操作失败次数 */
	private Integer errorTimes;
	/** 操作描述 */
	private String description;
	/** 系统用户ID */
	private Integer sysUserId;
	/** 需要重置的字段,当处置过期后 */
	private String resetColumns;
	//endregion

	//region constuctors
	public DefenseRecord(){
	}

	public DefenseRecord(Long id){
		this.id = id;
	}
	//endregion

	//region getters and setters
	public Long getId() {
		return this.id;
	}

	public void setId(Long value) {
		this.id = value;
	}
	@org.soul.model.common.Sortable
	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String value) {
		this.clientId = value;
	}
	@org.soul.model.common.Sortable
	public String getActionCode() {
		return this.actionCode;
	}

	public void setActionCode(String value) {
		this.actionCode = value;
	}
	public String getDisposeCode() {
		return this.disposeCode;
	}

	public void setDisposeCode(String value) {
		this.disposeCode = value;
	}
	public Date getDisposeEndTime() {
		return this.disposeEndTime;
	}

	public void setDisposeEndTime(Date value) {
		this.disposeEndTime = value;
	}
	public Long getOperateIp() {
		return this.operateIp;
	}

	public void setOperateIp(Long value) {
		this.operateIp = value;
	}
	@org.soul.model.common.Sortable
	public Date getOperateStartTime() {
		return this.operateStartTime;
	}

	public void setOperateStartTime(Date value) {
		this.operateStartTime = value;
	}
	public Date getOperateEndTime() {
		return this.operateEndTime;
	}

	public void setOperateEndTime(Date value) {
		this.operateEndTime = value;
	}
	public Integer getSuccessTimes() {
		return this.successTimes;
	}

	public void setSuccessTimes(Integer value) {
		this.successTimes = value;
	}
	public Integer getErrorTimes() {
		return this.errorTimes;
	}

	public void setErrorTimes(Integer value) {
		this.errorTimes = value;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String value) {
		this.description = value;
	}
	public Integer getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Integer value) {
		this.sysUserId = value;
	}
	public String getResetColumns() {
		return this.resetColumns;
	}

	public void setResetColumns(String value) {
		this.resetColumns = value;
	}
	//endregion

	//region your codes 2
	//是否操作成功|失败
	private boolean isActionSuccess;

	@Nonpersistent
	public boolean isActionSuccess() {
		return isActionSuccess;
	}

	public void setIsActionSuccess(Boolean isActionSuccess) {
		this.isActionSuccess = isActionSuccess;
	}

	/**
	 * 是否需要重置
	 * @return
	 */
	@Nonpersistent
	public boolean isNeedReset() {
		if (this.disposeEndTime != null) {
			Date now = new Date();
            return now.after(disposeEndTime);
		}
		return false;
	}

	/**
	 * 是否有效
	 * @return
	 */
	public boolean isAvailable(){
		if (id == null) {
			return true;
		}
		return isDisposeTimeOut();
	}

	/**
	 * 是否处置措施时间过期
	 * @return
	 */
	private boolean isDisposeTimeOut(){
		if (this.disposeEndTime == null) {
			return true;
		}
		Date now = new Date();
        return now.after(disposeEndTime);
    }

	@Override
	public String toString() {
		return JsonTool.toJson(this);
	}
	//endregion your codes 2
}