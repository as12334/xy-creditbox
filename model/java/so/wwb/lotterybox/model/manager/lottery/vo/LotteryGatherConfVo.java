package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryGatherConfSo;

/**
 * 彩票采集接口配置表值对象
 *
 * @author admin
 * @time 2017-4-14 13:54:43
 */
//region your codes 1
public class LotteryGatherConfVo extends BaseObjectVo<LotteryGatherConf, LotteryGatherConfSo, LotteryGatherConfVo.LotteryGatherConfQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 2050390075918478000L;
    //endregion your codes 5

    /**
     *  彩票采集接口配置表查询逻辑
     */
    public static class LotteryGatherConfQuery extends AbstractQuery<LotteryGatherConfSo> {

        //region your codes 6
        private static final long serialVersionUID = -6990612045083729140L;
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