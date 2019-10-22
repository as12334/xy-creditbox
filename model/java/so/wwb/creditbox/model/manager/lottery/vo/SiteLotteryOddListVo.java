package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdd;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotteryOddSo;


/**
 * 赔率设置表列表页值对象
 *
 * @author block
 * @time 2019-10-21 22:52:07
 */
//region your codes 1
public class SiteLotteryOddListVo extends BaseListVo<SiteLotteryOdd, SiteLotteryOddSo, SiteLotteryOddListVo.SiteLotteryOddQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7059990785840645398L;
    //endregion your codes 5

    /**
     *  赔率设置表列表查询逻辑
     */
    public static class SiteLotteryOddQuery extends AbstractQuery<SiteLotteryOddSo> {

        //region your codes 6
        private static final long serialVersionUID = -8222278383312237258L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(SiteLotteryOdd.PROP_ID, Operator.EQ, searchObject.getId());
            criteria.addAnd(SiteLotteryOdd.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(SiteLotteryOdd.PROP_BET_CODE, Operator.EQ, searchObject.getBetCode());
            criteria.addAnd(SiteLotteryOdd.PROP_BET_NUM, Operator.EQ, searchObject.getBetNum());
//            criteria.addAnd(SiteLotteryOdd.PROP_ODD, Operator.EQ, searchObject.getOdd());
            criteria.addAnd(SiteLotteryOdd.PROP_SITE_ID, Operator.EQ, searchObject.getSiteId());
            criteria.addAnd(SiteLotteryOdd.PROP_ID, Operator.IN, searchObject.getIds());
            criteria.addAnd(SiteLotteryOdd.PROP_BET_CODE, Operator.IN, searchObject.getBetCodes());
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}