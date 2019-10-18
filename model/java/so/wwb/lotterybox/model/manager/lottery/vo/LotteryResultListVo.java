package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryResultSo;

/**
 * 开奖结果表列表页值对象
 *
 * @author shook
 * @time 2017-4-9 9:47:30
 */
public class LotteryResultListVo extends BaseListVo<LotteryResult, LotteryResultSo, LotteryResultListVo.LotteryResultQuery> {

    private static final long serialVersionUID = 9101492036383979187L;

    /**
     * 开奖结果表列表查询逻辑
     */
    public static class LotteryResultQuery extends AbstractQuery<LotteryResultSo> {

        private static final long serialVersionUID = -6766071412708023307L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(LotteryResult.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryResult.PROP_CODE, Operator.IN, searchObject.getCodes());
            criteria.addAnd(LotteryResult.PROP_EXPECT, Operator.EQ, searchObject.getExpect());//彩票期号不要支持模糊搜索
            criteria.addAnd(LotteryResult.PROP_TYPE, Operator.EQ, searchObject.getType());
            criteria.addAnd(LotteryResult.PROP_OPEN_TIME, Operator.GE, searchObject.getQueryStartDate());
            criteria.addAnd(LotteryResult.PROP_OPEN_TIME, Operator.LT, searchObject.getQueryEndDate());
            criteria.addAnd(LotteryResult.PROP_GATHER_ORIGIN, Operator.EQ, searchObject.getGatherOrigin());
            if (searchObject.getOpenCodeFlag()) {
                criteria.addAnd(LotteryResult.PROP_OPEN_CODE, Operator.IS_NOT_NULL, null);
            }
            return criteria;
        }

        public Criteria queryNotOpenResult() {
            Criteria criteria = Criteria.add(LotteryResult.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryResult.PROP_EXPECT, Operator.LIKE_S, searchObject.getExpect());
            criteria.addAnd(LotteryResult.PROP_TYPE, Operator.EQ, searchObject.getType());
            criteria.addAnd(LotteryResult.PROP_OPEN_TIME, Operator.GE, searchObject.getQueryStartDate());
            criteria.addAnd(LotteryResult.PROP_OPEN_TIME, Operator.LT, searchObject.getQueryEndDate());
            criteria.addAnd(LotteryResult.PROP_OPEN_CODE, Operator.IS_NULL, null);
            criteria.addAnd(LotteryResult.PROP_CODE, Operator.IN, searchObject.getCodes());
            return criteria;
        }

        public Criteria queryRecentRecordCriteria() {
            Criteria criteria = Criteria.add(LotteryResult.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryResult.PROP_EXPECT, Operator.LIKE_S, searchObject.getExpect());
            if (searchObject.getOpenCodeFlag()) {
                criteria.addAnd(LotteryResult.PROP_OPEN_CODE, Operator.IS_NOT_NULL, null);
            }
            criteria.addAnd(LotteryResult.PROP_CLOSE_TIME,Operator.LE,searchObject.getCloseTime());
            return criteria;
        }

        public Criteria queryAscriptionTimeCriteria() {
            Criteria criteria = Criteria.add(LotteryResult.PROP_CODE, Operator.IN, searchObject.getCodes());
            criteria.addAnd(LotteryResult.PROP_ASCRIPTON_TIME, Operator.GE,searchObject.getQueryStartDate());
            criteria.addAnd(LotteryResult.PROP_ASCRIPTON_TIME, Operator.LE,searchObject.getQueryEndDate());
            criteria.addAnd(LotteryResult.PROP_OPEN_CODE, Operator.IS_NULL, null);
            return criteria;
        }
    }

}