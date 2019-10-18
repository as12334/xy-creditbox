package so.wwb.lotterybox.manager.session.listener;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.vo.SysUserListVo;
import org.soul.web.shiro.common.delegate.PassportEvent;
import org.soul.web.shiro.common.delegate.PassportListenerAdapter;
import org.soul.web.support.BaseWebBeanFactory;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.manager.session.SessionManager;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;
import so.wwb.lotterybox.web.init.ConfigBase;

import java.util.List;

public class UserInfoListener extends PassportListenerAdapter {

    private Log log = LogFactory.getLog(UserInfoListener.class);

    @Override
    public void onLoginSuccess(PassportEvent passportEvent) {
        SysUser sysUser = passportEvent.getSysUser();
        log.debug("用户登录成功:{0}-{1}-{2}", sysUser.getUserType(), sysUser.getId(), sysUser.getUsername());
        SysUserListVo mastervo = new SysUserListVo();
        mastervo._setDataSourceId(SessionManager.getSiteParentId());
        mastervo.getSearch().setId(SessionManager.getSiteUserId());
        mastervo = ServiceTool.sysUserService().search(mastervo);
        List<SysUser> users = mastervo.getResult();
        if (CollectionTool.isNotEmpty(users)) {
            SessionManager.setMasterInfo(users.get(0));
        }
        //是否提醒消息session标识
        SessionManager.setIsReminderMsg(true);

        //设置subSysCode
        setSubSysCode(sysUser);
    }

    /**
     * 根据用户类型设置系统标识
     *
     * @param sysUser
     */
    private void setSubSysCode(SysUser sysUser) {
        String subSysCode = BaseWebBeanFactory.getBaseWebConf().getSubsysCode();
        String userType = sysUser.getUserType();
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class,userType);
        switch (userTypeEnum) {
            case BOSS:
            case BOSS_SUB:
                subSysCode = SubSysCodeEnum.BOSS.getCode();
                break;
            case SHAREHOLDER:
            case SHAREHOLDER_SUB:
                subSysCode = SubSysCodeEnum.SHAREHOLDER.getCode();
                break;
            case COMPANY:
            case COMPANY_SUB:
                subSysCode = SubSysCodeEnum.COMPANY.getCode();
                break;
            case DISTRIBUTOR:
            case DISTRIBUTOR_SUB:
                subSysCode = SubSysCodeEnum.DISTRIBUTOR.getCode();
                break;
            default:
                break;
        }
        BaseWebBeanFactory.getBaseWebConf().setSubsysCode(subSysCode);
        ConfigBase.get().setSubsysCode(subSysCode);
        log.debug("用户登录成功:用户【{0}】subSysCode【{1}】", sysUser.getUsername(),  BaseWebBeanFactory.getBaseWebConf().getSubsysCode());
    }

}
