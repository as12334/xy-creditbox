package so.wwb.creditbox.model.hall;

import org.soul.commons.enums.EnumTool;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.enums.lottery.LotteryOpTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;

import java.io.Serializable;
import java.util.List;

/**
 * Created by block on 2019/11/28.
 */
public class HandlerForm implements Serializable {

    private static final long serialVersionUID = -1883103354558368531L;

    private String code;
    /**
     * 页面请求
     */
    private String action;

    /**
     * 请求玩法ID
     */
    private String playid;
    /**
     * 请求的玩法页面
     */
    private String playpage;


    private Integer phaseid;
    //下注玩法
    private Integer[]  oddsid;
    //赔率
    private String uPI_P;
    //金额
    private String uPI_M;
    //彩种ID
    private String i_index;

    private Long JeuValidate;

    // 投注总额
    private double totalMoney;

    private String optype;
    //修改赔率值
    private Double wtvalue;

    private SysUserExtend sessionUser;

    private List<LotteryBetOrder> betOrderList;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPlayid() {
        return playid;
    }

    public void setPlayid(String playid) {
        this.playid = playid;
    }

    public String getPlaypage() {
        return playpage;
    }

    public void setPlaypage(String playpage) {
        this.playpage = playpage;
    }

    public Integer getPhaseid() {
        return phaseid;
    }

    public void setPhaseid(Integer phaseid) {
        this.phaseid = phaseid;
    }

    public Integer[] getOddsid() {
        return oddsid;
    }

    public void setOddsid(Integer[] oddsid) {
        this.oddsid = oddsid;
    }

    public String getInSql(){
        StringBuilder inConditions = new StringBuilder();
        for (Integer i : oddsid) {
            inConditions.append(i).append(",");
        }
        return inConditions.subSequence(0, inConditions.length() - 1).toString();
    }
    public String getuPI_P() {
        return uPI_P;
    }

    public void setuPI_P(String uPI_P) {
        this.uPI_P = uPI_P;
    }

    public String getuPI_M() {
        return uPI_M;
    }

    public void setuPI_M(String uPI_M) {
        this.uPI_M = uPI_M;
    }

    public String getI_index() {
        return i_index;
    }

    public void setI_index(String i_index) {
        this.i_index = i_index;
    }

    public Long getJeuValidate() {
        return JeuValidate;
    }

    public void setJeuValidate(Long jeuValidate) {
        JeuValidate = jeuValidate;
    }

    public List<LotteryBetOrder> getBetOrderList() {
        return betOrderList;
    }

    public void setBetOrderList(List<LotteryBetOrder> betOrderList) {
        this.betOrderList = betOrderList;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String[] getBetSortArray() {
        return null;
    }

    public String[] getMoneyArray() {
        return uPI_M.split(",");
    }

    public String[] getOddArray() {
        return uPI_P.split(",");
    }

    public String getOptype() {
        return optype;
    }

    public void setOptype(String optype) {
        this.optype = optype;
    }

    public Double getWtvalue() {
        return wtvalue;
    }

    public void setWtvalue(Double wtvalue) {
        this.wtvalue = wtvalue;
    }
    public LotteryOpTypeEnum getOddOpTypeEnum(){
        return EnumTool.enumOf(LotteryOpTypeEnum.class, optype);
    }

    public SysUserExtend getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(SysUserExtend sessionUser) {
        this.sessionUser = sessionUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
