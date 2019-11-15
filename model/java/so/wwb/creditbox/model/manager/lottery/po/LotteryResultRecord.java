package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 开奖结果记录表实体
 *
 * @author block
 * @time 2019-11-15 14:17:33
 */
//region your codes 1
public class LotteryResultRecord implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -577561519040386160L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_CODE = "code";
	public static final String PROP_RECORD_TYPE = "recordType";
	public static final String PROP_OPEN_CODE = "openCode";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_USER_NAME = "userName";
	public static final String PROP_HASH = "hash";
	public static final String PROP_REMARK = "remark";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 开奖期数 */
	private String expect;
	/** 彩种代号 */
	private String code;
	/** 记录类型,0新增,1修改 */
	private String recordType;
	/** 开奖号码 */
	private String openCode;
	/** 入库时间 */
	private java.util.Date createTime;
	/** 操作用户名称 */
	private String userName;
	/** 开奖结果hash */
	private String hash;
	/** 备注 */
	private String remark;
	//endregion

	
	//region constuctors
	public LotteryResultRecord(){
	}

	public LotteryResultRecord(Integer id){
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
	public String getExpect() {
		return this.expect;
	}

	public void setExpect(String value) {
		this.expect = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getRecordType() {
		return this.recordType;
	}

	public void setRecordType(String value) {
		this.recordType = value;
	}
	public String getOpenCode() {
		return this.openCode;
	}

	public void setOpenCode(String value) {
		this.openCode = value;
	}
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String value) {
		this.userName = value;
	}
	public String getHash() {
		return this.hash;
	}

	public void setHash(String value) {
		this.hash = value;
	}
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}