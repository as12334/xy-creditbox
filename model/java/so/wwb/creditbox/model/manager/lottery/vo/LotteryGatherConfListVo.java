package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.so.LotteryGatherConfSo;


/**
 * 彩票采集接口配置表列表页值对象
 *
 * @author block
 * @time 2019-11-15 10:46:12
 */
//region your codes 1
public class LotteryGatherConfListVo extends BaseListVo<LotteryGatherConf, LotteryGatherConfSo, LotteryGatherConfListVo.LotteryGatherConfQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 784231546567298978L;
    //endregion your codes 5

    /**
     *  彩票采集接口配置表列表查询逻辑
     */
    public static class LotteryGatherConfQuery extends AbstractQuery<LotteryGatherConfSo> {

        //region your codes 6
        private static final long serialVersionUID = 1339067799092955171L;
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