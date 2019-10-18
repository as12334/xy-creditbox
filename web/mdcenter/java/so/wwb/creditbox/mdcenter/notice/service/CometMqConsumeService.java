package so.wwb.creditbox.mdcenter.notice.service;

import org.soul.comet.notice.service.AbstractPostMsgMqConsumeService;
import org.soul.model.msg.notice.enums.IContactWayType;
import org.soul.model.msg.notice.enums.NoticePublishMethod;

/**
 * 队列comet通知消息消费服务
 *
 * @author Kevice
 * @time 7/27/15 4:32 PM
 */
public class CometMqConsumeService extends AbstractPostMsgMqConsumeService {

    @Override
    protected NoticePublishMethod getPublishMethod() {
        return NoticePublishMethod.COMET;
    }

    @Override
    protected IContactWayType getIContactWayType() {
        return null;
    }

}
