package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResultExtend;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultExtendSo;


/**
 * 值对象
 *
 * @author block
 * @time 2019-12-4 21:46:47
 */
//region your codes 1
public class LotteryResultExtendVo extends BaseObjectVo<LotteryResultExtend, LotteryResultExtendSo, LotteryResultExtendVo.LotteryResultExtendQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 653468050587770866L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class LotteryResultExtendQuery extends AbstractQuery<LotteryResultExtendSo> {

        //region your codes 6
        private static final long serialVersionUID = 4878053807207510097L;
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