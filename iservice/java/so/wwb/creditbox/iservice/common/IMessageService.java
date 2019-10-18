package so.wwb.creditbox.iservice.common;

import org.soul.model.comet.vo.MessageVo;
import org.soul.model.msg.notice.vo.EmailMsgVo;
import org.soul.model.sms.SmsMessageVo;


/**
 * @author:wilson
 */
public interface IMessageService {
    /**
     *往运维站点推送消息
     * @param message 消息对象
     */
    void sendToBossMsg(MessageVo message);

    /**
     *往股东后台推送消息
     * @param message 消息对象
     */
    void sendToShareholderMsg(MessageVo message);
    /**
     *往商户后台推送消息
     * @param message 消息对象
     */
    void sendToMerchantMsg(MessageVo message);
    /**
     *往总代后台推送消息
     * @param message 消息对象
     */
    void sendToDistributorMsg(MessageVo message);

    /**
     *往商户api后台推送消息
     * @param message 消息对象
     */
    void sendToMerchantApiMsg(MessageVo message);
    /**
     *往总代api后台推送消息
     * @param message 消息对象
     */
    void sendToDistributorApiMsg(MessageVo message);

    /**
     *往玩家中心推送消息
     * @param message 消息对象
     */
    void sendToHallMsg(MessageVo message);

    //-----------分隔符------------

    /**
     *往运营商后台推送消息
     * @param message 消息对象
     */
    void sendToCcenterMsg(MessageVo message);
    /**
     *往站长站后台推送消息
     * @param message 消息对象
     */
    void sendToMcenterMsg(MessageVo message);
    /**
     *往站长站前台、及游戏中心推送消息
     * @param message 消息对象
     */
    void sendToMsiteMsg(MessageVo message);

    /**
     * 发送邮件
     * @param emailMsgVo 邮件对象
     */
    void sendEmail(EmailMsgVo emailMsgVo);

    /**
     * 发送短信
     * @param smsMessage 消息对象
     */
    void sendSmsMessage(SmsMessageVo smsMessage);

    /**
     * 往api推送消息
     * @param message 消息对象
     */
    void sendToApiMsg(MessageVo message);

    }
