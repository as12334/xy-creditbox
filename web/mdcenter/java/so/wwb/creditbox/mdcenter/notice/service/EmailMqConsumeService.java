package so.wwb.creditbox.mdcenter.notice.service;

import org.soul.comet.notice.service.BaseEmailMqConsumeService;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.msg.notice.enums.IContactWayType;
import so.wwb.creditbox.model.enums.notice.ContactWayType;

import java.util.List;

/**
 * 队列email通知消息消费服务
 *
 * @author Kevice
 * @time 7/27/15 4:32 PM
 */
public class EmailMqConsumeService extends BaseEmailMqConsumeService {

    private static final Log LOG = LogFactory.getLog(EmailMqConsumeService.class);


    @Override
    protected IContactWayType getIContactWayType() {
        return ContactWayType.EMAIL;
    }

    @Override
    public List<Integer> getAllUseableRankId(){
        /*IPlayerRankService service = ServiceSiteTool.playerRankService();
        List<Map<String, Object>> map = service.queryUsableRankList(new PlayerRankVo());
        List<Integer> list = CollectionTool.extractToList(map, PlayerRank.PROP_ID);
        return list;*/
        return null;
    }
}
