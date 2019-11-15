package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryHandicap;
import so.wwb.creditbox.model.manager.lottery.so.LotteryHandicapSo;


/**
 * 彩种盘口列表页值对象
 *
 * @author block
 * @time 2019-11-15 9:31:34
 */
//region your codes 1
public class LotteryHandicapListVo extends BaseListVo<LotteryHandicap, LotteryHandicapSo, LotteryHandicapListVo.LotteryHandicapQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 2954594556352352032L;
    //endregion your codes 5

    /**
     *  彩种盘口列表查询逻辑
     */
    public static class LotteryHandicapQuery extends AbstractQuery<LotteryHandicapSo> {

        //region your codes 6
        private static final long serialVersionUID = 1629877799811329653L;
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