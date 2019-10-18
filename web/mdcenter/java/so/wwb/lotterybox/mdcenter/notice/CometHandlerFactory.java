package so.wwb.lotterybox.mdcenter.notice;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.init.context.Const;
import org.soul.commons.init.context.ContextParam;
import org.soul.model.msg.notice.enums.NoticeReceiverGroupType;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.web.msg.notice.context.NoticeConsumerContext;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;

import java.util.Collection;

/**
 * @author Kevice
 * @time 8/3/15 7:53 PM
 */
public class CometHandlerFactory {

    private CometHandlerFactory() {
    }

    public static final String COMET_BOSS = "boss";
    public static final String COMET_MSITE = "msite";
    public static final String COMET_CCENTER = "ccenter";
    public static final String COMET_MCENTER = "mcenter";

    public static String getHandler(NoticeReceiverGroupType groupType, Collection<Integer> userIds) {
        ContextParam param = NoticeConsumerContext.getParam();
        String socketandler = null;
        Integer siteId = param.getSiteId();
        Integer dataSourceId = NoticeConsumerContext.get()._getDataSourceId();
        if (dataSourceId != null) {
            siteId = dataSourceId;
        }
        if (Const.BOSS_DATASOURCE_ID.equals(siteId)) {
            return COMET_BOSS;
        }
        if (siteId < Const.BOSS_DATASOURCE_ID) {
            return COMET_CCENTER;
        }
        if (groupType != null) {
            switch (groupType) {
                case GUEST:
                case ONLINE_FRONT:
                case OFFLINE_FRONT:
                case ALL_FRONT:
                    socketandler = COMET_MSITE;
                    break;
                case ONLINE_BACK:
                case OFFLINE_BACK:
                case ALL_BACK:
                    socketandler = COMET_MCENTER;
                    break;
                default:
                    break;
            }
        }
        if (CollectionTool.isNotEmpty(userIds) && socketandler == null) {
            Integer userId = userIds.iterator().next();
            SysUserVo vo = new SysUserVo();
            vo._setContextParam(param);
            vo._setDataSourceId(NoticeConsumerContext.get()._getDataSourceId());
            vo.getSearch().setId(userId);
            SysUserVo sysUserVo = ServiceTool.sysUserService().get(vo);
            String userType = sysUserVo.getResult().getUserType();
            if (UserTypeEnum.PLAYER.getCode().equals(userType)) {
                socketandler = COMET_MSITE;
            } else {
                socketandler = COMET_MCENTER;
            }
        }
        return socketandler;
    }

}
