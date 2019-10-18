package so.wwb.lotterybox.service.common;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.mq.MqProducer;
import org.soul.model.comet.vo.MessageVo;
import org.soul.model.msg.notice.vo.EmailMsgVo;
import org.soul.model.sms.SmsMessageVo;
import so.wwb.lotterybox.iservice.common.IMessageService;

/**
 * @author:wilson
 * @function:MQ adapter control (message, email, sms)
 */
public class MessageService implements IMessageService {
    private static final Log LOG = LogFactory.getLog(MessageService.class);

    @Override
    @MqProducer
    public void sendToBossMsg(MessageVo message) {
        LOG.info("准备向boss后台发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendToShareholderMsg(MessageVo message) {
        LOG.info("准备向股东后台发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendToMerchantMsg(MessageVo message) {
        LOG.info("准备向商户后台发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendToDistributorMsg(MessageVo message) {
        LOG.info("准备向总代后台发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendToMerchantApiMsg(MessageVo message) {
        LOG.info("准备向api商户后台发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendToDistributorApiMsg(MessageVo message) {
        LOG.info("准备向api总代后台发送消息：{0}", message);
    }


    @Override
    @MqProducer
    public void sendToHallMsg(MessageVo message) {
        LOG.debug("准备向玩家中心发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendToCcenterMsg(MessageVo message) {
        LOG.info("准备向boss发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendToMcenterMsg(MessageVo message) {
        LOG.debug("准备发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendToMsiteMsg(MessageVo message) {
        LOG.debug("准备发送消息：{0}", message);
    }

    @Override
    @MqProducer
    public void sendEmail(EmailMsgVo emailMsgVo) {
        LOG.debug("准备发送邮件：{0}", emailMsgVo);
    }

    @Override
    @MqProducer
    public void sendSmsMessage(SmsMessageVo smsMessageVo) {
        LOG.debug("准备发送短信：{0}", smsMessageVo);
    }

    @Override
    @MqProducer
    public void sendToApiMsg(MessageVo messageVo) {
        LOG.debug("准备向api发送消息：{0}", messageVo);
    }
}
