package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;

import java.util.Date;

//region your codes 1
public class LotteryResult implements IEntity<Integer> {
//endregion your codes 1

    //region your codes 3
    private static final long serialVersionUID = -2482626304452825504L;
    //endregion your codes 3

    //region property name constants
    public static final String PROP_ID = "id";
    public static final String PROP_EXPECT = "expect";
    public static final String PROP_CODE = "code";
    public static final String PROP_TYPE = "type";
    public static final String PROP_OPEN_CODE = "openCode";
    public static final String PROP_OPEN_CODE_MEMO = "openCodeMemo";
    public static final String PROP_OPEN_TIME = "openTime";
    public static final String PROP_CLOSE_TIME = "closeTime";
    public static final String PROP_OPENING_TIME = "openingTime";
    public static final String PROP_GATHER_TIME = "gatherTime";
    public static final String PROP_GATHER_ORIGIN = "gatherOrigin";
    public static final String PROP_ASCRIPTON_TIME = "ascriptionTime";
    public static final String PROP_GATHER = "gather";
    public static final String PROP_GATHER_OPEN_TIME = "gatherOpenTime";
    //endregion


    //region properties
    /**
     * ID主键
     */
    private Integer id;
    /**
     * 开奖期数
     */
    private String expect;
    /**
     * 彩种代号
     */
    private String code;
    /**
     * 彩种类型
     */
    private String type;
    /**
     * 开奖结果,多个号码逗号隔开
     */
    private String openCode;
    /**
     * 开奖号码备注,暂存香港六合彩生肖,多个逗号隔开
     */
    private String openCodeMemo;
    /**
     * 开奖时间
     */
    private java.util.Date openTime;
    /**
     * 真正开奖时间
     */
    private java.util.Date gatherOpenTime;
    /**
     * 封盘时间
     */
    private java.util.Date closeTime;
    /**
     * 开盘时间
     */
    private java.util.Date openingTime;
    /**
     * 采集时间
     */
    private java.util.Date gatherTime;
    /**
     * 采集来源LotteryGatherOriginEnum
     */
    private String gatherOrigin;
    /**
     * 采集人
     */
    private String gather;

    /** 归属时间 */
    private java.util.Date ascriptionTime;

    //endregion


    //region constuctors
    public LotteryResult() {
    }

    public LotteryResult(Integer id) {
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

    @org.soul.model.common.Sortable
    public String getExpect() {
        return this.expect;
    }

    public void setExpect(String value) {
        this.expect = value;
    }

    @org.soul.model.common.Sortable
    public String getCode() {
        return this.code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    @org.soul.model.common.Sortable
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

    @org.soul.model.common.Sortable
    public java.util.Date getOpenTime() {
        return this.openTime;
    }

    public void setOpenTime(java.util.Date value) {
        this.openTime = value;
    }

    @org.soul.model.common.Sortable
    public java.util.Date getCloseTime() {
        return this.closeTime;
    }

    public void setCloseTime(java.util.Date value) {
        this.closeTime = value;
    }

    @org.soul.model.common.Sortable
    public java.util.Date getOpeningTime() {
        return this.openingTime;
    }

    public void setOpeningTime(java.util.Date value) {
        this.openingTime = value;
    }

    @org.soul.model.common.Sortable
    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    //endregion

    //region your codes 2
    public static String PROP_ORDER_NUM = "orderNum";
    private Integer orderNum;//顺序
    private long leftTime;//距离封盘时间
    private long leftOpenTime;//距离开盘时间

    public String getGatherOrigin() {
        return gatherOrigin;
    }

    public void setGatherOrigin(String gatherOrigin) {
        this.gatherOrigin = gatherOrigin;
    }

    @Nonpersistent
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Nonpersistent
    public long getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(long leftTime) {
        this.leftTime = leftTime;
    }
    @Nonpersistent
    public long getLeftOpenTime() {
        return leftOpenTime;
    }

    public void setLeftOpenTime(long leftOpenTime) {
        this.leftOpenTime = leftOpenTime;
    }

    public Date getAscriptionTime() {
        return ascriptionTime;
    }

    public void setAscriptionTime(Date ascriptionTime) {
        this.ascriptionTime = ascriptionTime;
    }

    public Date getGatherOpenTime() {
        return gatherOpenTime;
    }

    public void setGatherOpenTime(Date gatherOpenTime) {
        this.gatherOpenTime = gatherOpenTime;
    }

    public String getOpenCodeMemo() {
        return openCodeMemo;
    }

    public void setOpenCodeMemo(String openCodeMemo) {
        this.openCodeMemo = openCodeMemo;
    }

    public String getGather() {
        return gather;
    }

    public void setGather(String gather) {
        this.gather = gather;
    }
    //endregion your codes 2

}