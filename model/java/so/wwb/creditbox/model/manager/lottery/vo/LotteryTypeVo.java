package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.common.Sort;
import so.wwb.creditbox.model.manager.lottery.po.LotteryType;
import so.wwb.creditbox.model.manager.lottery.so.LotteryTypeSo;


/**
 * 值对象
 *
 * @author ronnie
 * @time 2017-10-23 19:07:34
 */
//region your codes 1
public class LotteryTypeVo extends BaseObjectVo<LotteryType, LotteryTypeSo, LotteryTypeVo.LotteryTypeQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 5515712201742166419L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class LotteryTypeQuery extends AbstractQuery<LotteryTypeSo> {

        //region your codes 6
        private static final long serialVersionUID = 882992156204047811L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryType.PROP_TYPE_NAME, Operator.LIKE,searchObject.getTypeName())
                    .addAnd(LotteryType.PROP_TYPE_STATUS,Operator.IN,searchObject.getTypeStatus());
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

    //endregion your codes 4

}