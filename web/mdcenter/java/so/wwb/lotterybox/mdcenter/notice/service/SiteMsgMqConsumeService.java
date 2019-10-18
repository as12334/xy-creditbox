package so.wwb.lotterybox.mdcenter.notice.service;

import org.soul.comet.notice.service.AbstractPostMsgMqConsumeService;
import org.soul.model.msg.notice.enums.IContactWayType;
import org.soul.model.msg.notice.enums.NoticePublishMethod;

/**
 * 队列站内信通知消息消费服务
 *
 * @author Kevice
 * @time 7/27/15 4:33 PM
 */
public class SiteMsgMqConsumeService extends AbstractPostMsgMqConsumeService {

    @Override
    protected NoticePublishMethod getPublishMethod() {
        return NoticePublishMethod.SITE_MSG;
    }

    @Override
    protected void send() {
        super.send();
    }

    @Override
    protected IContactWayType getIContactWayType() {
        return null;
    }

}
