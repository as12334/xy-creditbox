package so.wwb.lotterybox.model.manager.mq.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import org.soul.model.mq.po.MqExceptionMsg;
import so.wwb.lotterybox.model.manager.mq.so.MqExceptionMsgSo;

/**
 * MQ异常消息列表页值对象
 *
 * @author mark
 * @time 2015-8-13 10:39:01
 */
//region your codes 1
public class MqExceptionMsgListVo extends BaseListVo<MqExceptionMsg, MqExceptionMsgSo, MqExceptionMsgListVo.MqExceptionMsgQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -2017746161622735220L;
    //endregion your codes 5

    /**
     *  MQ异常消息列表查询逻辑
     */
    public static class MqExceptionMsgQuery extends AbstractQuery<MqExceptionMsgSo> {

        //region your codes 6
        private static final long serialVersionUID = 3758510207252014690L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return Criteria.add(MqExceptionMsg.PROP_ID, Operator.LIKE, this.searchObject.getId())
                    .addAnd(MqExceptionMsg.PROP_TOPIC, Operator.LIKE,this.searchObject.getTopic())
                    .addAnd(MqExceptionMsg.PROP_IS_RECONSUME_SUCCESS, Operator.EQ,this.searchObject.getIsReconsumeSuccess())
                    .addAnd(MqExceptionMsg.PROP_LAST_TIME, Operator.GE,this.searchObject.getLastTime());
            //endregion your codes 2
        }

        @Override
        public Sort getDefaultSort() {
            return Sort.add(MqExceptionMsg.PROP_LAST_TIME, Direction.DESC);
        }

        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}