package so.wwb.lotterybox.mdcenter.notice.service;

import org.soul.comet.notice.service.BaseSmsMqConsumeService;
import org.soul.model.msg.notice.enums.IContactWayType;
import org.soul.model.sms_interface.po.SmsInterface;
import so.wwb.lotterybox.model.enums.notice.ContactWayType;
import so.wwb.lotterybox.web.cache.Cache;

import java.util.Map;

/**
 * 队列手机短信通知消息消费服务
 *
 * @author mical
 * @time 7/27/15 4:33 PM
 */
public class SmsMqConsumeService extends BaseSmsMqConsumeService {


    @Override
    public Map<String, SmsInterface> getCommonSmsInterfaces() {
        return Cache.getCommonSmsInterfaces();
    }

    @Override
    protected IContactWayType getIContactWayType() {
        return ContactWayType.CELLPHONE;
    }


}
