package so.wwb.lotterybox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrderSend;
import so.wwb.lotterybox.model.company.lottery.so.LotteryBetOrderSendSo;


/**
 * 下注推送注单失败记录表列表页值对象
 *
 * @author diego
 * @time 2018-11-20 19:11:05
 */
//region your codes 1
public class LotteryBetOrderSendListVo extends BaseListVo<LotteryBetOrderSend, LotteryBetOrderSendSo, LotteryBetOrderSendListVo.LotteryBetOrderSendQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -7201632175939342848L;
    //endregion your codes 5

    private SysSite sysSite;

    public SysSite getSysSite() {
        return sysSite;
    }

    public void setSysSite(SysSite sysSite) {
        this.sysSite = sysSite;
    }

    /**
     *  下注推送注单失败记录表列表查询逻辑
     */
    public static class LotteryBetOrderSendQuery extends AbstractQuery<LotteryBetOrderSendSo> {

        //region your codes 6
        private static final long serialVersionUID = 7943870200360382815L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            Criteria criteria = new Criteria();
            criteria.addAnd(LotteryBetOrderSend.PROP_ID, Operator.EQ, searchObject.getId())
                    .addAnd(LotteryBetOrderSend.PROP_CODE, Operator.EQ, searchObject.getCode())
                    .addAnd(LotteryBetOrderSend.PROP_EXPECT, Operator.EQ, searchObject.getExpect())
                    .addAnd(LotteryBetOrderSend.PROP_SEND_STATUS, Operator.EQ, searchObject.getSendStatus())
                    .addAnd(LotteryBetOrderSend.PROP_BET_TIME,Operator.GE,searchObject.getQueryStartDate())
                    .addAnd(LotteryBetOrderSend.PROP_BET_TIME,Operator.LT,searchObject.getQueryEndDate())
                    .addAnd(LotteryBetOrderSend.PROP_USERNAME, Operator.EQ, searchObject.getUsername());
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}