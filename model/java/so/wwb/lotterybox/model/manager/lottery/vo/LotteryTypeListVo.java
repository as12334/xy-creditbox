package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryType;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryTypeSo;


/**
 * 列表页值对象
 *
 * @author ronnie
 * @time 2017-10-23 19:07:34
 */
//region your codes 1
public class LotteryTypeListVo extends BaseListVo<LotteryType, LotteryTypeSo, LotteryTypeListVo.LotteryTypeQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -3957037016610046822L;
    //endregion your codes 5

    /**
     *  列表查询逻辑
     */
    public static class LotteryTypeQuery extends AbstractQuery<LotteryTypeSo> {

        //region your codes 6
        private static final long serialVersionUID = -6527492931283671489L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryType.PROP_TYPE_NAME, Operator.LIKE,searchObject.getTypeName())
                    .addAnd(LotteryType.PROP_TYPE_STATUS,Operator.IN,searchObject.getTypeStatus())
                    .addAnd(LotteryType.PROP_TYPE_CODE,Operator.LIKE,searchObject.getTypeCode())
                    .addAnd(LotteryType.PROP_LOTTERY_NUM,Operator.LIKE,searchObject.getLotteryNum());
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}