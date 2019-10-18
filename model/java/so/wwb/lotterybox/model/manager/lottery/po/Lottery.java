package so.wwb.lotterybox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;

import java.util.Date;

/**
 * 彩种表实体
 *
 * @author Administrator
 * @time 2017-4-25 19:32:21
 */
public class Lottery implements IEntity<Integer> {

	private static final long serialVersionUID = 338401217561430367L;

	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_TYPE = "type";
	public static final String PROP_CODE = "code";
	public static final String PROP_STATUS = "status";
	public static final String PROP_ORDER_NUM = "orderNum";
	public static final String PROP_TERMINAL = "terminal";
	public static final String PROP_MODEL = "model";
	public static final String PROP_NAME = "name";
	public static final String PROP_START_TIME = "startTime";
	public static final String PROP_END_TIME = "endTime";
	public static final String PROP_CLASSIFY = "classify";
	public static final String PROP_FREQUENCY = "frequency";

	public static final String PROP_MEMO = "memo";
	public static final String PROP_IS_HOT = "isHot";
	public static final String PROP_IS_NEW = "isNew";

	/** 主键 */
	private Integer id;
	/** 商户ID */
	private Integer siteId;
	/** 彩种类型LotteryTypeEnum */
	private String type;
	/** 彩种代号LotteryEnum */
	private String code;
	/** 彩种名称 */
	private String name;
	/** 彩种状态LotteryStatusEnum */
	private String status;
	/** 序号 */
	private Integer orderNum;
	/** 支持终端TerminalEnum */
	private String terminal;
	/** 玩法模式LotteryModelEnum */
	private String model;
	/** 开始时间 */
	private Date startTime;
	/** 开始时间 */
	private Date endTime;

	/** 描述 */
	private String memo;
	/** 是否热门 */
	private Boolean isHot;
	/** 是否新彩种 */
	private Boolean isNew;
	/** 彩种彩种归属LotteryClassifyEn */
	private String classify;
	/** 高低频归属FrequencyEnum */
	private String frequency;


	public Lottery(){
	}

	public Lottery(Integer id){
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	@org.soul.model.common.Sortable
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}

	@org.soul.model.common.Sortable
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}

	@org.soul.model.common.Sortable
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	@org.soul.model.common.Sortable
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer value) {
		this.orderNum = value;
	}
	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(String value) {
		this.terminal = value;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@org.soul.model.common.Sortable
	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}

	@org.soul.model.common.Sortable
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean hot) {
		isHot = hot;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean aNew) {
		isNew = aNew;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
}