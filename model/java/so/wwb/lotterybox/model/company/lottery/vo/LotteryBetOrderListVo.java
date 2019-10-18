package so.wwb.lotterybox.model.company.lottery.vo;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.lotterybox.model.company.lottery.so.LotteryBetOrderSo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 投注记录表列表页值对象
 *
 * @author fei
 * @time 2017-4-8 14:33:26
 */
//region your codes 1
public class LotteryBetOrderListVo extends BaseListVo<LotteryBetOrder, LotteryBetOrderSo, LotteryBetOrderListVo.LotteryBetOrderQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7875071553277485753L;
    private List<Map> reportList;
    private List<String> years;
    private Integer[] ids;
    private SysSite sysSite;
    //endregion your codes 5

    /**
     *  投注记录表列表查询逻辑
     */
    public static class LotteryBetOrderQuery extends AbstractQuery<LotteryBetOrderSo> {

        //region your codes 6
        private static final long serialVersionUID = -1424610082674506372L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryBetOrder.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryBetOrder.PROP_BET_CODE, Operator.EQ, searchObject.getBetCode());
            criteria.addAnd(LotteryBetOrder.PROP_STATUS, Operator.EQ, searchObject.getStatus());
            criteria.addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.LT, searchObject.getBetTime());
            criteria.addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.GE, searchObject.getBetTime());
            criteria.addAnd(LotteryBetOrder.PROP_PAYOUT_TIME, Operator.GE, searchObject.getPayoutStartDate());
            criteria.addAnd(LotteryBetOrder.PROP_PAYOUT_TIME, Operator.LT, searchObject.getPayoutEndDate());
            criteria.addAnd(LotteryBetOrder.PROP_BET_TIME,Operator.GE,searchObject.getQueryStartDate());
            criteria.addAnd(LotteryBetOrder.PROP_BET_TIME,Operator.LT,searchObject.getQueryEndDate());
            criteria.addAnd(LotteryBetOrder.PROP_ID,Operator.EQ,searchObject.getId());
            criteria.addAnd(LotteryBetOrder.PROP_EXPECT,Operator.EQ,searchObject.getExpect());
            criteria.addAnd(LotteryBetOrder.PROP_BILL_NO,Operator.EQ,searchObject.getBillNo());
            criteria.addAnd(LotteryBetOrder.PROP_USER_ID,Operator.EQ,searchObject.getUserId());
            criteria.addAnd(LotteryBetOrder.PROP_USER_ID,Operator.NOT_IN,searchObject.getUserIds());//过滤试玩
            criteria.addAnd(LotteryBetOrder.PROP_STATUS,Operator.IN,searchObject.getStatuss());
            criteria.addAnd(LotteryBetOrder.PROP_CODE,Operator.IN,searchObject.getCodes());
            criteria.addAnd(LotteryBetOrder.PROP_PARENT_AGENTER_NAME, Operator.EQ, searchObject.getParentAgenterName());
            if(StringTool.isNotBlank(this.searchObject.getUsername())){
                String names = this.searchObject.getUsername().toLowerCase();
                if (names.contains(",")){
                    List<String> nameList = Arrays.asList(names.split(","));
                    criteria.addAnd(LotteryBetOrder.PROP_USERNAME,Operator.IN,nameList);
                }else if (names.contains("，")){
                    List<String> nameList = Arrays.asList(names.split("，"));
                    criteria.addAnd(LotteryBetOrder.PROP_USERNAME,Operator.IN,nameList);
                }else {
                    criteria.addAnd(LotteryBetOrder.PROP_USERNAME,Operator.EQ,names);
                }
            }
            return criteria;
            //endregion your codes 2
        }

        /**
         * 中奖记录
         * @return
         */
        public Criteria getRewardCriteria() {
            //region your codes 2
            Criteria criteria = getCriteria();
            criteria.addAnd(LotteryBetOrder.PROP_PAYOUT, Operator.GT,0);
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3

        @Override
        public Sort getDefaultSort() {
            Sort sort = new Sort(Order.desc(LotteryBetOrder.PROP_BET_TIME),Order.desc(LotteryBetOrder.PROP_ID),Order.desc(LotteryBetOrder.PROP_EXPECT));
            return sort;
        }

        //endregion your codes 3
    }

    //region your codes 4
    public List<Map> getReportList() {
        return reportList;
    }

    public void setReportList(List<Map> reportList) {
        this.reportList = reportList;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public SysSite getSysSite() {
        return sysSite;
    }

    public void setSysSite(SysSite sysSite) {
        this.sysSite = sysSite;
    }


    //endregion your codes 4

}