package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.common.Sort;
import so.wwb.lotterybox.model.manager.lottery.po.Lottery;
import so.wwb.lotterybox.model.manager.lottery.so.LotterySo;


/**
 * 彩种表值对象
 *
 * @author shook
 * @time 2017-4-7 19:50:21
 */
//region your codes 1
public class LotteryVo extends BaseObjectVo<Lottery, LotterySo, LotteryVo.LotteryQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 3187153588021777755L;
    //endregion your codes 5

    /**
     *  彩种表查询逻辑
     */
    public static class LotteryQuery extends AbstractQuery<LotterySo> {

        //region your codes 6
        private static final long serialVersionUID = -6385257832780851502L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(Lottery.PROP_ID, Operator.EQ,searchObject.getId());
            criteria.addAnd(Lottery.PROP_CODE, Operator.EQ,searchObject.getCode());
            return criteria;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }
    private Sort[] orderList;

    public Sort[] getOrderList() {
        return orderList;
    }

    public void setOrderList(Sort[] orderList) {
        this.orderList = orderList;
    }
    //region your codes 4

    //endregion your codes 4

}