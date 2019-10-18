package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;

import java.util.Date;

/**
 * 彩种盘口实体
 *
 * @author marz
 * @time 2018-2-22 20:35:57
 */
//region your codes 1
public class LotteryHandicap implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 3038573489894320096L;

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_TYPE = "type";
	public static final String PROP_CODE = "code";
	public static final String PROP_START_EXPECT = "startExpect";
	public static final String PROP_AMOUNT = "amount";
	public static final String PROP_LOTTERY_START_TIME = "lotteryStartTime";
	public static final String PROP_LOTTERY_INTERVAL = "lotteryInterval";
	public static final String PROP_CLOSE_LOTTERY_INTERVAL = "closeLotteryInterval";
	public static final String PROP_OPEN_CLOSE_INTERVAL = "openCloseInterval";
	public static final String PROP_ORDER_NUM = "orderNum";
	//endregion


	//region properties
	/** 自增主键 */
	private Integer id;
	/** 彩种类型 */
	private String type;
	/** 彩种代号 */
	private String code;
	/** 起始期号/期数 */
	private String startExpect;
	/** 生成次数 */
	private Integer amount;
	/** 开奖开始时间 */
	private Date lotteryStartTime;
	/** 开奖时间间隔，单位s */
	private Integer lotteryInterval;
	/** 封盘与开奖时间间隔，单位s */
	private Integer closeLotteryInterval;
	/** 开盘与封盘时间间隔，单位s */
	private Integer openCloseInterval;
	/** 排序 */
	private Integer orderNum;
	//endregion

	//region constuctors
	public LotteryHandicap() {
	}
	//endregion

	//region getters and setters
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@org.soul.model.common.Sortable
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStartExpect() {
		return startExpect;
	}

	public void setStartExpect(String startExpect) {
		this.startExpect = startExpect;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getLotteryStartTime() {
		return lotteryStartTime;
	}

	public void setLotteryStartTime(Date lotteryStartTime) {
		this.lotteryStartTime = lotteryStartTime;
	}

	public Integer getLotteryInterval() {
		return lotteryInterval;
	}

	public void setLotteryInterval(Integer lotteryInterval) {
		this.lotteryInterval = lotteryInterval;
	}

	public Integer getCloseLotteryInterval() {
		return closeLotteryInterval;
	}

	public void setCloseLotteryInterval(Integer closeLotteryInterval) {
		this.closeLotteryInterval = closeLotteryInterval;
	}

	public Integer getOpenCloseInterval() {
		return openCloseInterval;
	}

	public void setOpenCloseInterval(Integer openCloseInterval) {
		this.openCloseInterval = openCloseInterval;
	}
	@org.soul.model.common.Sortable
	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	//endregion getters and setters

	//region your codes 2

	//endregion your codes 2


}