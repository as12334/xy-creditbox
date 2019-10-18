package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryOddSet;
import so.wwb.creditbox.model.company.lottery.so.LotteryOddSetSo;

/**
 * 彩票赔率设置表页值对象
 *
 * @author diego
 * @time 2018-02-11
 */
public class LotteryOddSetListVo extends BaseListVo<LotteryOddSet, LotteryOddSetSo, LotteryOddSetListVo.LotteryOddSetQuery> {


    private static final long serialVersionUID = -7537157712546703512L;

    /**
     *  彩票赔率设置表查询逻辑
     */
    public static class LotteryOddSetQuery extends AbstractQuery<LotteryOddSetSo> {


        private static final long serialVersionUID = 2869169168152497233L;

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryOddSet.PROP_ID, Operator.EQ, searchObject.getId());
            criteria.addAnd(LotteryOddSet.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryOddSet.PROP_BET_CODE, Operator.EQ, searchObject.getBetCode());
            criteria.addAnd(LotteryOddSet.PROP_BET_NUM, Operator.EQ, searchObject.getBetNum());
            criteria.addAnd(LotteryOddSet.PROP_ODD, Operator.EQ, searchObject.getOdd());
            criteria.addAnd(LotteryOddSet.PROP_BET_CODE, Operator.IN,searchObject.getBetcodes());
            criteria.addAnd(LotteryOddSet.PROP_PROJECT_ID, Operator.EQ,searchObject.getProjectId());
            criteria.addAnd(LotteryOddSet.PROP_ID, Operator.IN, searchObject.getIds());
            return criteria;
            //endregion your codes 2
        }


    }



}