package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrderSend;
import so.wwb.creditbox.model.company.lottery.so.LotteryBetOrderSendSo;


/**
 * 下注推送注单失败记录表值对象
 *
 * @author diego
 * @time 2018-11-20 19:11:05
 */
//region your codes 1
public class LotteryBetOrderSendVo extends BaseObjectVo<LotteryBetOrderSend, LotteryBetOrderSendSo, LotteryBetOrderSendVo.LotteryBetOrderSendQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 6536829836750631541L;
    //endregion your codes 5

    /**
     *  下注推送注单失败记录表查询逻辑
     */
    public static class LotteryBetOrderSendQuery extends AbstractQuery<LotteryBetOrderSendSo> {

        //region your codes 6
        private static final long serialVersionUID = -6195364549423263988L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}