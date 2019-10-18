package so.wwb.creditbox.model.company.lottery.po;

import org.soul.commons.bean.IEntity;

/**
 * 下注推送注单失败记录表查询对象
 *
 * @author diego
 * @time 2018-11-20 19:11:05
 */

public class LotteryBetOrderSend implements IEntity<Integer> {


    private static final long serialVersionUID = 6545963003262519196L;

    public static final String PROP_ID = "id";
    public static final String PROP_CODE = "code";
    public static final String PROP_EXPECT = "expect";
    public static final String PROP_USERNAME = "username";
    public static final String PROP_USER_ID = "userId";
    public static final String PROP_BET_TIME = "betTime";
    public static final String PROP_BET_AMOUNT = "betAmount";
    public static final String PROP_SEND_STATUS = "sendStatus";

    /** 自增主键 */
    private Integer id;
    /** 彩种代号LotteryCodeEnum */
    private String code;
    /** 彩种期数 */
    private String expect;
    /** 玩家账号 */
    private String username;
    /** 玩家id */
    private String userId;
    /** 下注时间 */
    private String betTime;
    /** 下注金额 */
    private Double betAmount;
    /** 发送状态 */
    private Integer sendStatus;

    public LotteryBetOrderSend(){
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBetTime() {
        return betTime;
    }

    public void setBetTime(String betTime) {
        this.betTime = betTime;
    }

    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
}
