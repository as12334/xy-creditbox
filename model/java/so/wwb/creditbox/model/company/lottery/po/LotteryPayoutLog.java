package so.wwb.creditbox.model.company.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 站点派彩记录表 create by marz实体
 *
 * @author block
 * @time 2019-11-30 16:01:34
 */
//region your codes 1
public class LotteryPayoutLog implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -7326661700052405440L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_CODE = "code";
	public static final String PROP_TYPE = "type";
	public static final String PROP_OPEN_CODE = "openCode";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_STATUS = "status";
	public static final String PROP_REMARK = "remark";
	public static final String PROP_PAYOUT_HASH = "payoutHash";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 开奖期数 */
	private String expect;
	/** 彩种代号 */
	private String code;
	/** 彩种类型 */
	private String type;
	/** 开奖号码 */
	private String openCode;
	/** 入库时间 */
	private java.util.Date createTime;
	/** 状态 */
	private String status;
	/** 备注 */
	private String remark;
	/** 开奖hash，避免同时开奖 */
	private String payoutHash;
	//endregion

	
	//region constuctors
	public LotteryPayoutLog(){
	}

	public LotteryPayoutLog(Integer id){
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
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
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
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}
	public String getPayoutHash() {
		return this.payoutHash;
	}

	public void setPayoutHash(String value) {
		this.payoutHash = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}