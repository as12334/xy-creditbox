package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.model.company.lottery.so.LotteryResultNumberSo;

import java.util.List;
import java.util.Map;

/**
 * 彩票开奖号码表值对象
 *
 * @author diego
 * @time 2018-02-11
 */

public class LotteryResultNumberVo extends BaseObjectVo<LotteryResultNumber, LotteryResultNumberSo, LotteryResultNumberVo.LotteryResultNumberQuery> {


    private static final long serialVersionUID = 1596678904029020862L;

    private String operator;

    //billItem类型
    private String item;

    //LotteryOperationEnum
    private String operationType;


    //结果中心派彩来源1.站长中心2.总控中心
    private Integer ofPayout;

    //派彩来源1.派彩2.重结派彩
    private Integer payoutSource;

    //待删除
    private String includeIdc;

    private Integer siteId;

    private String initDates;

    private Map<String, Lottery> lotteryMap;

    private List<LotteryWinningRecord> winningRecordList;

    //操作类型
    private String operateType;

    public List<LotteryWinningRecord> getWinningRecordList() {
        return winningRecordList;
    }

    public void setWinningRecordList(List<LotteryWinningRecord> winningRecordList) {
        this.winningRecordList = winningRecordList;
    }

    public Map<String, Lottery> getLotteryMap() {
        return lotteryMap;
    }

    public void setLotteryMap(Map<String, Lottery> lotteryMap) {
        this.lotteryMap = lotteryMap;
    }

    public String getInitDates() {
        return initDates;
    }

    public void setInitDates(String initDates) {
        this.initDates = initDates;
    }

    public Integer getOfPayout() {
        return ofPayout;
    }

    public void setOfPayout(Integer ofPayout) {
        this.ofPayout = ofPayout;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getPayoutSource() {
        return payoutSource;
    }

    public void setPayoutSource(Integer payoutSource) {
        this.payoutSource = payoutSource;
    }

    public String getIncludeIdc() {
        return includeIdc;
    }

    public void setIncludeIdc(String includeIdc) {
        this.includeIdc = includeIdc;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    /**
     * 根据item撤销或撤单文字内容
     * @return
     */
    public String getRevoItemText(){
        if (StringTool.isEmpty(this.item)) {
            return null;
        }
//        BillItemEnum billItemEnum = EnumTool.enumOf(BillItemEnum.class,this.item);
//        if(billItemEnum == null || (!BillItemEnum.REVOKE_REFUND.equals(billItemEnum) && !BillItemEnum.REVOCATION_REFUND.equals(billItemEnum))){
//            return null;
//        }
        return null;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    /**
     *  彩票开奖号码表查询逻辑
     */
    public static class LotteryResultNumberQuery extends AbstractQuery<LotteryResultNumberSo> {


        private static final long serialVersionUID = -2672364188799951441L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(LotteryResultNumber.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryResultNumber.PROP_EXPECT, Operator.EQ, searchObject.getExpect());
            return  criteria;
        }


    }


}