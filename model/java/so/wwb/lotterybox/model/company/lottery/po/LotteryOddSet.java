package so.wwb.lotterybox.model.company.lottery.po;

import org.soul.commons.bean.IEntity;

/**
 * 彩票赔率设置表
 *
 * @author diego
 * @time 2018-02-11 19:16:50
 */
public class LotteryOddSet implements IEntity<Integer> {

    private static final long serialVersionUID = -4489617088564561346L;

    public static final String PROP_ID = "id";
    public static final String PROP_CODE = "code";
    public static final String PROP_MODEL = "model";
    public static final String PROP_PLAY_CODE = "playCode";
    public static final String PROP_BET_CODE = "betCode";
    public static final String PROP_BET_NUM = "betNum";
    public static final String PROP_ODD = "odd";
    public static final String PROP_ODD_LIMIT = "oddLimit";
    public static final String PROP_REBATE = "rebate";
    public static final String PROP_REBATE_LIMIT = "rebateLimit";
    public static final String PROP_BASE_NUM = "baseNum";
    public static final String PROP_ORDER_NUM = "orderNum";
    public static final String PROP_PROJECT_ID = "projectId";

    /** 自增主键 */
    private Integer id;
    /** 彩种代号LotteryCodeEnum */
    private String code;
    /** 彩种模式LotteryModelEnum */
    private String model;
    /** 彩种玩法LotteryPlayCodeEnum */
    private String playCode;
    /** 投注方式LotteryBetCodeEnum */
    private String betCode;
    /** 号码 */
    private String betNum;
    /** 赔率 */
    private Double odd;
    /** 赔率上限 */
    private Double oddLimit;
    /** 返点 */
    private Double rebate;
    /** 返点上限 */
    private Double rebateLimit;
    /** 基数 */
    private Double baseNum;
    /** 排序 */
    private Integer orderNum;
    /** 盘口id */
    private Integer projectId;

    public LotteryOddSet(){
    }

    @org.soul.model.common.Sortable
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlayCode() {
        return playCode;
    }

    public void setPlayCode(String playCode) {
        this.playCode = playCode;
    }
    @org.soul.model.common.Sortable
    public String getBetCode() {
        return betCode;
    }

    public void setBetCode(String betCode) {
        this.betCode = betCode;
    }

    @org.soul.model.common.Sortable
    public String getBetNum() {
        return betNum;
    }

    public void setBetNum(String betNum) {
        this.betNum = betNum;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

    public Double getOddLimit() {
        return oddLimit;
    }

    public void setOddLimit(Double oddLimit) {
        this.oddLimit = oddLimit;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    public Double getRebateLimit() {
        return rebateLimit;
    }

    public void setRebateLimit(Double rebateLimit) {
        this.rebateLimit = rebateLimit;
    }

    public Double getBaseNum() {
        return baseNum;
    }

    public void setBaseNum(Double baseNum) {
        this.baseNum = baseNum;
    }

    @org.soul.model.common.Sortable
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}