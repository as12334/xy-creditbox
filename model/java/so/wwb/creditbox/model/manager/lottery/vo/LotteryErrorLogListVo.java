package so.wwb.creditbox.model.manager.lottery.vo;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryErrorLog;
import so.wwb.creditbox.model.manager.lottery.so.LotteryErrorLogSo;

/**
 * 彩票失败日志列表页值对象
 *
 * @author steady
 * @time 2018-5-24 14:52:46
 */
public class LotteryErrorLogListVo extends BaseListVo<LotteryErrorLog, LotteryErrorLogSo, LotteryErrorLogListVo.LotteryErrorLogQuery> {
    private static final long serialVersionUID = 4609388159029556678L;

    /**
     * 彩票失败日志列表查询逻辑
     */
    public static class LotteryErrorLogQuery extends AbstractQuery<LotteryErrorLogSo> {
        private static final long serialVersionUID = 2310228200678113028L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(LotteryErrorLog.PROP_OPERATION_TYPE, Operator.EQ, searchObject.getOperationType());
            criteria.addAnd(LotteryErrorLog.PROP_CREATE_TIME, Operator.GE, searchObject.getQueryStartDate());
            criteria.addAnd(LotteryErrorLog.PROP_CREATE_TIME, Operator.LT, searchObject.getQueryEndDate());
            return criteria;
        }
    }
}