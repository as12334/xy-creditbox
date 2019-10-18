package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;

/**
 * 派彩推送失败记录表查询对象
 *
 * @author diego
 * @time 2018-11-22 09:30:05
 */

public class LotteryBetOrderPayout implements IEntity<Integer> {

    private static final long serialVersionUID = 1720588625657751021L;

    public static final String PROP_ID = "id";
    public static final String PROP_SITE_ID = "siteId";
    public static final String PROP_CODE = "code";
    public static final String PROP_EXPECT = "expect";
    public static final String PROP_PAYOUT_TIME = "payoutTime";
    public static final String PROP_SEND_SUM = "sendSum";
    public static final String PROP_SEND_STATUS = "sendStatus";


    /** 自增主键 */
    private Integer id;
    /** 站点id */
    private Integer siteId;
    /** 彩种代号LotteryCodeEnum */
    private String code;
    /** 彩种期数 */
    private String expect;
    /** 派彩时间 */
    private String payoutTime;
    /** 发送记录数 */
    private Integer sendSum;
    /** 发送状态 */
    private Integer sendStatus;

    public LotteryBetOrderPayout(){
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getPayoutTime() {
        return payoutTime;
    }

    public void setPayoutTime(String payoutTime) {
        this.payoutTime = payoutTime;
    }

    public Integer getSendSum() {
        return sendSum;
    }

    public void setSendSum(Integer sendSum) {
        this.sendSum = sendSum;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
}
