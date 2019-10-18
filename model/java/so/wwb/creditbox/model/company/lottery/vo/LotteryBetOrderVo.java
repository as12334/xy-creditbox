package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.support.Nonpersistent;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.security.privilege.po.SysUser;
import so.wwb.creditbox.model.manager.lottery.bean.OrderBean;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.so.LotteryBetOrderSo;

import java.util.Date;

/**
 * 投注记录表值对象
 *
 * @author fei
 * @time 2017-4-8 14:33:26
 */
//region your codes 1
public class LotteryBetOrderVo extends BaseObjectVo<LotteryBetOrder, LotteryBetOrderSo, LotteryBetOrderVo.LotteryBetOrderQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 3962810464448477011L;
    private SysUser user;
    private Date betTime;
    private String terminal;
    private Integer gameId;
    private String subsysCode;
    private OrderBean orderBean;

    /** 彩种 */
    private Lottery lottery;
    /** 注单的记录ID集合 */
    private Integer[] betIds;
    /** 投注冻结金额 */
    private double freezAmount;
    /** 投注总金额 */
    private double betAmount;
    /** item项目 */
    private String item;
    /** 查询注单详情
     * team --团队注单详情
     * self --自己注单详情
     */
    private String orign;
    /** 投注ip */
    private Long ip;
    /** 投注ＩＰＣＯＤＥ */
    private String ipCode;

    //endregion your codes 5

    /**
     *  投注记录表查询逻辑
     */
    public static class LotteryBetOrderQuery extends AbstractQuery<LotteryBetOrderSo> {

        //region your codes 6
        private static final long serialVersionUID = -7656344108253909128L;
        //endregion your codes 6

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryBetOrder.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryBetOrder.PROP_BET_CODE, Operator.EQ, searchObject.getBetCode());
            criteria.addAnd(LotteryBetOrder.PROP_STATUS, Operator.EQ, searchObject.getStatus());
            criteria.addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.LT, searchObject.getBetTime());
            criteria.addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.GE, searchObject.getBetTime());
            criteria.addAnd(LotteryBetOrder.PROP_PAYOUT_TIME, Operator.LT, searchObject.getPayoutTime());
            criteria.addAnd(LotteryBetOrder.PROP_PAYOUT_TIME, Operator.GE, searchObject.getPayoutTime());

            criteria.addAnd(LotteryBetOrder.PROP_BET_TIME,Operator.GE,searchObject.getQueryStartDate());
            criteria.addAnd(LotteryBetOrder.PROP_BET_TIME,Operator.LT,searchObject.getQueryEndDate());
            criteria.addAnd(LotteryBetOrder.PROP_USERNAME,Operator.LIKE,searchObject.getUsername());
            criteria.addAnd(LotteryBetOrder.PROP_ID,Operator.EQ,searchObject.getId());
            criteria.addAnd(LotteryBetOrder.PROP_PLAY_CODE,Operator.EQ,searchObject.getPlayCode());
            criteria.addAnd(LotteryBetOrder.PROP_EXPECT,Operator.EQ,searchObject.getExpect());
            criteria.addAnd(LotteryBetOrder.PROP_USER_ID,Operator.EQ,searchObject.getUserId());
            criteria.addAnd(LotteryBetOrder.PROP_BET_COUNT,Operator.EQ,searchObject.getBetCount());
            return criteria;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4
    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    private Date benginBetTime;

    private Date endBetTime;

    public Date getBenginBetTime() {
        return benginBetTime;
    }

    public void setBenginBetTime(Date benginBetTime) {
        this.benginBetTime = benginBetTime;
    }

    public Date getEndBetTime() {
        return endBetTime;
    }

    public void setEndBetTime(Date endBetTime) {
        this.endBetTime = endBetTime;
    }

    public String getSubsysCode() {
        return subsysCode;
    }

    public void setSubsysCode(String subsysCode) {
        this.subsysCode = subsysCode;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }
    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public Integer[] getBetIds() {
        return betIds;
    }

    public void setBetIds(Integer[] betIds) {
        this.betIds = betIds;
    }




    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getOrign() {
        return orign;
    }

    public void setOrign(String orign) {
        this.orign = orign;
    }

    public double getFreezAmount() {
        return freezAmount;
    }

    public void setFreezAmount(double freezAmount) {
        this.freezAmount = freezAmount;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }
    @Nonpersistent
    public Long getIp() { return ip; }

    public void setIp(Long ip) { this.ip = ip;}

    @Nonpersistent
    public String getIpCode() { return ipCode; }

    public void setIpCode(String ipCode) { this.ipCode = ipCode; }

    //endregion your codes 4

}