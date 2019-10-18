package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.so.LotteryGatherConfSo;

/**
 * 彩票采集接口配置表列表页值对象
 *
 * @author admin
 * @time 2017-4-14 13:54:43
 */
//region your codes 1
public class LotteryGatherConfListVo extends BaseListVo<LotteryGatherConf, LotteryGatherConfSo, LotteryGatherConfListVo.LotteryGatherConfQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 3660455453304740662L;
    //endregion your codes 5

    /**
     *  彩票采集接口配置表列表查询逻辑
     */
    public static class LotteryGatherConfQuery extends AbstractQuery<LotteryGatherConfSo> {

        //region your codes 6
        private static final long serialVersionUID = 1434707993310723273L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(LotteryGatherConf.PROP_TYPE, Operator.EQ, searchObject.getType());
            criteria.addAnd(LotteryGatherConf.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryGatherConf.PROP_CONF_TYPE, Operator.EQ, searchObject.getConfType());
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}