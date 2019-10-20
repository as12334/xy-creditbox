package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryPlay;
import so.wwb.creditbox.model.manager.lottery.so.LotteryPlaySo;


/**
 * 彩种玩法表列表页值对象
 *
 * @author block
 * @time 2019-10-20 22:59:01
 */
//region your codes 1
public class LotteryPlayListVo extends BaseListVo<LotteryPlay, LotteryPlaySo, LotteryPlayListVo.LotteryPlayQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -6164881451222301508L;
    //endregion your codes 5

    /**
     *  彩种玩法表列表查询逻辑
     */
    public static class LotteryPlayQuery extends AbstractQuery<LotteryPlaySo> {

        //region your codes 6
        private static final long serialVersionUID = 2621404048505932147L;
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