package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryPayoutLog;
import so.wwb.creditbox.model.company.lottery.so.LotteryPayoutLogSo;


/**
 * 站点派彩记录表 create by marz值对象
 *
 * @author block
 * @time 2019-11-30 16:01:34
 */
//region your codes 1
public class LotteryPayoutLogVo extends BaseObjectVo<LotteryPayoutLog, LotteryPayoutLogSo, LotteryPayoutLogVo.LotteryPayoutLogQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 1233559189290287163L;
    //endregion your codes 5

    /**
     *  站点派彩记录表 create by marz查询逻辑
     */
    public static class LotteryPayoutLogQuery extends AbstractQuery<LotteryPayoutLogSo> {

        //region your codes 6
        private static final long serialVersionUID = 3144899781561175598L;
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