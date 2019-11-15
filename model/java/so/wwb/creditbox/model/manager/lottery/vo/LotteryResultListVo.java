package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultSo;


/**
 * 开奖结果主表列表页值对象
 *
 * @author block
 * @time 2019-11-15 9:31:52
 */
//region your codes 1
public class LotteryResultListVo extends BaseListVo<LotteryResult, LotteryResultSo, LotteryResultListVo.LotteryResultQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -7944102658886659215L;
    //endregion your codes 5

    /**
     *  开奖结果主表列表查询逻辑
     */
    public static class LotteryResultQuery extends AbstractQuery<LotteryResultSo> {

        //region your codes 6
        private static final long serialVersionUID = -480392428301318664L;
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