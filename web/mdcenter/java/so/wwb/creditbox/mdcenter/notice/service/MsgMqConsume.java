package so.wwb.creditbox.mdcenter.notice.service;

import org.soul.comet.notice.IMsgMqConsume;
import org.soul.commons.collections.SetTool;
import org.soul.commons.exception.SystemException;
import org.soul.commons.init.context.Const;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.iservice.msg.notice.INoticeReceiverService;
import org.soul.model.comet.vo.MessageVo;
import org.soul.model.msg.notice.enums.NoticeReceiverGroupType;
import org.soul.model.msg.notice.po.NoticeSend;
import org.soul.model.msg.notice.vo.NoticeReceiverVo;
import org.soul.web.msg.notice.context.NoticeConsumerContext;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.common.IMessageService;
import so.wwb.creditbox.mdcenter.notice.CometHandlerFactory;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteUser;
import so.wwb.creditbox.web.cache.Cache;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MsgMqConsume implements IMsgMqConsume {

    private static final Log LOG = LogFactory.getLog(MsgMqConsume.class);

    public void setUserInfo(NoticeReceiverGroupType groupType,NoticeSend send,NoticeReceiverVo vo
            ,Set<Integer> onLineUserIds
            ,Set<Integer> origUserIds
            ,Collection<Integer> unsentUserIds){
        INoticeReceiverService noticeReceiverService = ServiceTool.noticeReceiverService();
        switch (groupType) {
            case ALL_FRONT:
                origUserIds.addAll( noticeReceiverService.fetchAllPlayerIds(vo));
                break;
            case ALL_BACK:
                origUserIds.addAll( noticeReceiverService.fetchAllBackUserIds(vo));
                break;
            case OFFLINE_FRONT:
                vo.setGroupIds(onLineUserIds);
                unsentUserIds.addAll(noticeReceiverService.fetchAllOfflinePlayerIds(vo));
                break;
            case OFFLINE_BACK:
                vo.setGroupIds(onLineUserIds);
                unsentUserIds.addAll(noticeReceiverService.fetchAllOfflineBackUserIds(vo));
                break;
            case RANK:
                vo.setGroupIds(SetTool.newHashSet(send.getReceiverGroupId()));
                origUserIds.addAll(noticeReceiverService.fetchRankUserIds(vo));
                break;
            case TAG:
                vo.setGroupIds(SetTool.newHashSet(send.getReceiverGroupId()));
                origUserIds.addAll(noticeReceiverService.fetchTagUserIds(vo));
                break;
            case LEVEL:

                break;
            case ROLE:
                vo.setGroupIds(SetTool.newHashSet(send.getReceiverGroupId()));
                origUserIds.addAll(noticeReceiverService.fetchRoleUserIds(vo));
                break;
            case ONLINE_BACK:
            case ONLINE_FRONT:
                break;
            case USER:
                origUserIds.addAll(SetTool.newHashSet(send.getReceiverGroupId()));
                break;
            default:
                throw new SystemException("comet不支持群组类型：" + groupType);
        }
    }


    @Override
    public void sendCometMsg(NoticeReceiverGroupType groupType,MessageVo message,Collection<Integer> toSendUserIds){

        String handler = CometHandlerFactory.getHandler(groupType, toSendUserIds);

        IMessageService service = ServiceTool.messageService();
        if (StringTool.isNotBlank(handler)) {
            switch (handler) {
                case CometHandlerFactory.COMET_BOSS:
                    service.sendToBossMsg(message);
                    break;
                case CometHandlerFactory.COMET_CCENTER:
                    service.sendToCcenterMsg(message);
                    break;
                case CometHandlerFactory.COMET_MCENTER:
                    service.sendToMcenterMsg(message);
                    break;
                case CometHandlerFactory.COMET_MSITE:
                    service.sendToMsiteMsg(message);
                    break;
                default:
                    LOG.error("不支持的comet发送接口，handler={0}", handler);
                    break;
            }
        } else {
            LOG.error("调用comet发送消息接口时handler为空");
        }
    }

    @Override
    public MessageVo createMessage() {
        ContextParam param = NoticeConsumerContext.getParam();
        Integer dataSourceId = NoticeConsumerContext.get()._getDataSourceId();
        if (param == null && dataSourceId == null) {
            return null;
        }
        Integer siteId = param.getSiteId();
        Integer masterId = param.getSiteUserId();
        Integer ccenterId = param.getSiteParentId();

        if (dataSourceId != null) {
            Map<String,VSysSiteUser> map = Cache.getSysSiteUser();
            VSysSiteUser vSysSiteUser = map.get(dataSourceId.toString());
            siteId = dataSourceId;
            if (vSysSiteUser.getSiteParentId() != null && !Const.BOSS_DATASOURCE_ID.equals(vSysSiteUser.getSiteParentId())) {//目标库为站点库
                masterId = vSysSiteUser.getSysUserId();
                ccenterId = vSysSiteUser.getCenterId();
            }

        }
//        List<NoticeSend> noticeSends = NoticeConsumerContext.get().getNoticeSends().get(getPublishMethod());
        MessageVo message = new MessageVo();
        message._setSiteId(siteId);
        message._setDataSourceId(dataSourceId);
        message.setSiteId(siteId);
        message.setMasterId(masterId);
        message.setCcenterId(ccenterId);
        return message;
    }



}
