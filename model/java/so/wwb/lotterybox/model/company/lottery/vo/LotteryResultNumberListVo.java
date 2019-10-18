package so.wwb.lotterybox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.lotterybox.model.company.lottery.so.LotteryResultNumberSo;

/**
 * 彩票开奖号码列表页值对象
 *
 * @author diego
 * @time 2018-02-11
 */
public class LotteryResultNumberListVo extends BaseListVo<LotteryResultNumber, LotteryResultNumberSo, LotteryResultNumberListVo.LotteryResultNumberQuery> {


    private static final long serialVersionUID = -1556204128076302384L;

    /**
     *  彩票开奖号码表查询逻辑
     */
    public static class LotteryResultNumberQuery extends AbstractQuery<LotteryResultNumberSo> {


        private static final long serialVersionUID = -5717254200268643608L;

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryResultNumber.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryResultNumber.PROP_EXPECT, Operator.EQ, searchObject.getExpect());
            criteria.addAnd(LotteryResultNumber.PROP_TYPE, Operator.EQ, searchObject.getType());
            criteria.addAnd(LotteryResultNumber.PROP_ASCRIPTION, Operator.EQ, searchObject.getQueryDate());
            criteria.addAnd(LotteryResultNumber.PROP_OPEN_TIME, Operator.GE, searchObject.getQueryStartDate());
            criteria.addAnd(LotteryResultNumber.PROP_OPEN_TIME, Operator.LT, searchObject.getQueryEndDate());
            if (searchObject.getOpenCodeFlag()) {
                criteria.addAnd(LotteryResultNumber.PROP_OPEN_CODE, Operator.IS_NOT_NULL, null);
            }
            return criteria;
            //endregion your codes 2
        }

        public Criteria queryNotOpenResult() {
            Criteria criteria = Criteria.add(LotteryResultNumber.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryResultNumber.PROP_EXPECT, Operator.LIKE_S, searchObject.getExpect());
            criteria.addAnd(LotteryResultNumber.PROP_TYPE, Operator.EQ, searchObject.getType());
            criteria.addAnd(LotteryResultNumber.PROP_OPEN_TIME, Operator.GE, searchObject.getQueryStartDate());
            criteria.addAnd(LotteryResultNumber.PROP_OPEN_TIME, Operator.LT, searchObject.getQueryEndDate());
            criteria.addAnd(LotteryResultNumber.PROP_OPEN_CODE, Operator.IS_NULL, null);
            criteria.addAnd(LotteryResultNumber.PROP_CODE, Operator.IN, searchObject.getCodes());
            return criteria;
        }
        public Criteria queryRecentRecordCriteria() {
            Criteria criteria = Criteria.add(LotteryResultNumber.PROP_CODE, Operator.EQ, searchObject.getCode());
            return criteria;
        }

        public Criteria queryRecentRecordNoOpenCriteria() {
            Criteria criteria = Criteria.add(LotteryResultNumber.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryResultNumber.PROP_OPEN_CODE,Operator.IS_NOT_NULL,searchObject.getOpenCode());
            return criteria;
        }

    }



}