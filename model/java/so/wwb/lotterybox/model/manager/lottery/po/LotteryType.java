package so.wwb.lotterybox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;

public class LotteryType implements IEntity<Integer> {

	private static final long serialVersionUID = 2471003400554478672L;

	public static final String PROP_ID = "id";
	public static final String PROP_TYPE_NAME = "typeName";
	public static final String PROP_ORDER_NUM = "orderNum";
	public static final String PROP_TYPE_STATUS = "typeStatus";
	public static final String PROP_TYPE_CODE = "typeCode";
	public static final String PROP_LOTTERY_NUM = "lotteryNum";
//    public static final String PROP_FREQUENCY = "frequency";

	/** id */
	private Integer id;
	/** 类型名称 */
	private String typeName;
	/** 编号 */
	private Integer orderNum;
	/** 类型状态 */
	private Integer typeStatus;

	/** 类型代码 */
	private String typeCode;
	/** 彩种数*/
	private String lotteryNum;
//	/** 彩种频率 */
//    private String frequency;

	public LotteryType(){
	}

	public LotteryType(Integer id){
		this.id = id;
	}

	@org.soul.model.common.Sortable
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	@org.soul.model.common.Sortable
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String value) {
		this.typeName = value;
	}
	@org.soul.model.common.Sortable
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer value) {
		this.orderNum = value;
	}
	public Integer getTypeStatus() {
		return this.typeStatus;
	}

	public void setTypeStatus(Integer value) {
		this.typeStatus = value;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String value) {
		this.typeCode = value;
	}

	public String getLotteryNum() {
		return this.lotteryNum;
	}

	public void setLotteryNum(String value) {
		this.lotteryNum = value;
	}

//	public String getFrequency() {
//		return frequency;
//	}
//
//	public void setFrequency(String frequency) {
//		this.frequency = frequency;
//	}

}