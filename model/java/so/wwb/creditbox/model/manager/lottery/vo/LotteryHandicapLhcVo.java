package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryHandicapLhc;
import so.wwb.creditbox.model.manager.lottery.so.LotteryHandicapLhcSo;


/**
 * 彩种盘口值对象
 *
 * @author block
 * @time 2019-11-15 9:43:19
 */
//region your codes 1
public class LotteryHandicapLhcVo extends BaseObjectVo<LotteryHandicapLhc, LotteryHandicapLhcSo, LotteryHandicapLhcVo.LotteryHandicapLhcQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8609045098960645806L;
    //endregion your codes 5

    /**
     *  彩种盘口查询逻辑
     */
    public static class LotteryHandicapLhcQuery extends AbstractQuery<LotteryHandicapLhcSo> {

        //region your codes 6
        private static final long serialVersionUID = 4768604027706871651L;
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