package so.wwb.lotterybox.model.manager.mq.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.gameapi.result.RecordResult;
import org.soul.model.mq.po.MqExceptionMsg;
import so.wwb.lotterybox.model.manager.mq.so.MqExceptionMsgSo;


/**
 * MQ异常消息值对象
 *
 * @author mark
 * @time 2015-8-13 10:39:01
 */
//region your codes 1
public class MqExceptionMsgVo extends BaseObjectVo<MqExceptionMsg, MqExceptionMsgSo, MqExceptionMsgVo.MqExceptionMsgQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 829302382893126013L;
    private String msgId;
    private String consumerGroup;
    private String consumerClientId;
    private RecordResult recordResult;

    public String getConsumerClientId() {
        return consumerClientId;
    }

    public void setConsumerClientId(String consumerClientId) {
        this.consumerClientId = consumerClientId;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public RecordResult getRecordResult() {
        return recordResult;
    }

    public void setRecordResult(RecordResult recordResult) {
        this.recordResult = recordResult;
    }

    //endregion your codes 5

    /**
     *  MQ异常消息查询逻辑
     */
    public static class MqExceptionMsgQuery extends AbstractQuery<MqExceptionMsgSo> {

        //region your codes 6
        private static final long serialVersionUID = 619168360881904118L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}