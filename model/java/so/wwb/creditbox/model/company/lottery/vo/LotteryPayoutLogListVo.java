package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryPayoutLog;
import so.wwb.creditbox.model.company.lottery.so.LotteryPayoutLogSo;


/**
 * 站点派彩记录表 create by marz列表页值对象
 *
 * @author block
 * @time 2019-11-30 16:01:34
 */
//region your codes 1
public class LotteryPayoutLogListVo extends BaseListVo<LotteryPayoutLog, LotteryPayoutLogSo, LotteryPayoutLogListVo.LotteryPayoutLogQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 8051244189865567785L;
    //endregion your codes 5

    /**
     *  站点派彩记录表 create by marz列表查询逻辑
     */
    public static class LotteryPayoutLogQuery extends AbstractQuery<LotteryPayoutLogSo> {

        //region your codes 6
        private static final long serialVersionUID = -831683376421253236L;
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