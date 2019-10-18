package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryBetOrderPayout;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryBetOrderPayoutSo;


/**
 * 派彩推送失败记录表查询对象
 *
 * @author diego
 * @time 2018-11-22 10:30:05
 */
public class LotteryBetOrderPayoutListVo extends BaseListVo<LotteryBetOrderPayout, LotteryBetOrderPayoutSo, LotteryBetOrderPayoutListVo.LotteryBetOrderPayoutQuery> {


    private static final long serialVersionUID = 3318490508989818548L;

    /**
     *  派彩推送失败记录表查询逻辑
     */
    public static class LotteryBetOrderPayoutQuery extends AbstractQuery<LotteryBetOrderPayoutSo> {


        private static final long serialVersionUID = -8270352345657575238L;

        @Override
        public Criteria getCriteria() {
            return null;
        }



    }


}