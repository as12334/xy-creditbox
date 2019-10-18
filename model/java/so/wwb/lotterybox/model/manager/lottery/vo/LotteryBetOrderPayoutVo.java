package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryBetOrderPayout;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryBetOrderPayoutSo;


/**
 * 派彩推送失败记录表查询对象
 *
 * @author diego
 * @time 2018-11-22 09:30:05
 */
public class LotteryBetOrderPayoutVo extends BaseObjectVo<LotteryBetOrderPayout, LotteryBetOrderPayoutSo, LotteryBetOrderPayoutVo.LotteryBetOrderPayoutQuery> {


    private static final long serialVersionUID = 2172470549572765008L;

    /**
     *  派彩推送失败记录表查询逻辑
     */
    public static class LotteryBetOrderPayoutQuery extends AbstractQuery<LotteryBetOrderPayoutSo> {


        private static final long serialVersionUID = 7706686881382269624L;

        @Override
        public Criteria getCriteria() {
            return null;
        }



    }


}