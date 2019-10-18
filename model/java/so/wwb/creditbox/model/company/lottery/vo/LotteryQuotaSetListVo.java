package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryQuotaSet;
import so.wwb.creditbox.model.company.lottery.so.LotteryQuotaSetSo;

/**
 * 彩票限额设置表页值对象
 *
 * @author diego
 * @time 2018-02-11
 */
public class LotteryQuotaSetListVo extends BaseListVo<LotteryQuotaSet, LotteryQuotaSetSo, LotteryQuotaSetListVo.LotteryQuotaSetQuery> {


    private static final long serialVersionUID = 5356407064426195281L;

    /**
     * 彩票限额设置表查询逻辑
     */
    public static class LotteryQuotaSetQuery extends AbstractQuery<LotteryQuotaSetSo> {


        private static final long serialVersionUID = 861042084813210571L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(LotteryQuotaSet.PROP_ID, Operator.EQ, searchObject.getId());
            criteria.addAnd(LotteryQuotaSet.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryQuotaSet.PROP_PLAY_CODE, Operator.EQ, searchObject.getPlayCode());
            criteria.addAnd(LotteryQuotaSet.PROP_ID, Operator.IN, searchObject.getIds());
            return criteria;
        }


    }



}