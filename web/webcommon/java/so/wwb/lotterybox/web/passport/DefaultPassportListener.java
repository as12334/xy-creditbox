package so.wwb.lotterybox.web.passport;

import org.soul.commons.enums.YesNot;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.Operator;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleDateTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.support.IModuleTool;
import org.soul.commons.support._Module;
import org.soul.iservice.common.IIpOrAreaResolver;
import org.soul.iservice.log.audit.IAuditService;
import org.soul.iservice.sys.ISysAuditLogService;
import org.soul.model.log.audit.enums.OpType;
import org.soul.model.log.audit.po.IAuditEntity;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.po.SysUserStatus;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.model.session.SessionKey;
import org.soul.model.sys.po.SysAuditLog;
import org.soul.model.sys.vo.SysAuditLogVo;
import org.soul.web.log.audit.AuditLogTool;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.shiro.common.delegate.IPassportListener;
import org.soul.web.shiro.common.delegate.PassportEvent;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.model.enums.base.FreezeTypeEnum;
import so.wwb.lotterybox.model.enums.base.Module;
import so.wwb.lotterybox.model.enums.base.ModuleType;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteVo;

import java.util.Date;

public class DefaultPassportListener implements IPassportListener {
    private static final Log LOG = LogFactory.getLog(DefaultPassportListener.class);
    private IIpOrAreaResolver ipOrAreaResolver;

    @Override
    public void onLoginSuccess(PassportEvent passportEvent) {
        try {
            //i18n
            doSysAuditLog(ModuleType.PASSPORT_LOGIN,
                    passportEvent.getOperator(),
                    Module.Passport_Login,
                    OpType.LOGIN,
                    PassportConst.I18N_LOGIN_SUCCESS, passportEvent.isMaster());
        } catch (Exception e) {
            LOG.error(e, "登录成功的错误日志记录异常!");
        }
    }

    @Override
    public void onLoginFailure(PassportEvent passportEvent) {
        if (passportEvent.isNeedFreeze()) {
            doFreezon(passportEvent);
        }
        try {
            //i18n
            doSysAuditLog(ModuleType.PASSPORT_LOGIN_FAIL,
                    passportEvent.getOperator(),
                    Module.Passport_Login,
                    OpType.LOGIN,
                    PassportConst.I18N_LOGIN_FAIL, passportEvent.isMaster());
        } catch (Exception e) {
            LOG.error(e, "登录失败的错误日志记录异常!");
        }

    }

    @Override
    public void onLogoutSuccess(PassportEvent passportEvent) {
        try {
            //i18n
            doSysAuditLog(ModuleType.PASSPORT_LOGOUT,
                    passportEvent.getOperator(),
                    Module.Passport_Logout,
                    OpType.LOGOUT,
                    PassportConst.I18N_LOGOUT_SUCCESS, passportEvent.isMaster());

        } catch (Exception e) {
            LOG.error(e, "登录成功的错误日志记录异常!");
        }
    }

    /**
     * 账号自动冻结
     *
     * @param passportEvent
     */
    private void doFreezon(PassportEvent passportEvent) {
        Operator operator = passportEvent.getOperator();
        Integer operatorId = operator.getOperatorId();
        if (operatorId == null) {
            LOG.error("单点登录:需要冻结用户名:[{0}],但用户id为空", operatorId);
            return;
        }
        Date now = new Date();
        SysUserVo sysUserVo = new SysUserVo();
        if (passportEvent.isMaster()) {//站长账号保存在运营商库
            sysUserVo._setDataSourceId(CommonContext.get().getSiteParentId());
        }
        sysUserVo.getSearch().setId(operatorId);
        sysUserVo = ServiceTool.sysUserService().get(sysUserVo);
        SysUser sysUser = new SysUser();
        if (sysUserVo.getResult() != null) {
            sysUser = sysUserVo.getResult();
        }
        sysUserVo.setResult(sysUser);
        sysUser.setId(operatorId);
        sysUser.setFreezeCode("2b801fbd304e4b518393bdb9bf1d6c24");//默认值
        sysUser.setFreezeStartTime(now);
        //freeznReason.title=您的账户由于异常操作已被冻结，暂不支持登录！
        //freeznReason.content=您的登录密码输入错误次数超过上限，账户已被系统临时冻结，{0}解冻后将恢复正常登录。您也可以重置登录密码解冻。如有疑问，请{1}处理！
        sysUser.setFreezeEndTime(DateTool.addHours(now, PassportConst.AUTO_FREEZE_HOURS));
        sysUser.setFreezeType(FreezeTypeEnum.AUTO.getCode());
        sysUser.setStatus(SysUserStatus.LOCKED.getCode());
        sysUser.setFreezeUser(null);
        String title = LocaleTool.tranMessage(_Module.Passport, "freeznReason.title");
        sysUser.setFreezeTitle(title);

        String unfreezeTime = DateTool.formatDate(sysUser.getFreezeEndTime(), CommonContext.getDateFormat().getDAY_SECOND());
        String timezone = "GMT 00:00";
        if (StringTool.isNotBlank(sysUser.getDefaultTimezone())) {
            timezone = sysUser.getDefaultTimezone();
            unfreezeTime = LocaleDateTool.formatDate(sysUser.getFreezeEndTime(), CommonContext.getDateFormat().getDAY_SECOND(), sysUser.getDefaultTimezone());
        } else {
            SysSiteVo siteVo = new SysSiteVo();
            siteVo.getSearch().setId(sysUser.getSiteId());
            siteVo = ServiceTool.sysSiteService().get(siteVo);
            if (siteVo.getResult() != null && StringTool.isNotBlank(siteVo.getResult().getTimezone())) {
                timezone = siteVo.getResult().getTimezone();
                unfreezeTime = LocaleDateTool.formatDate(sysUser.getFreezeEndTime(), CommonContext.getDateFormat().getDAY_SECOND(), siteVo.getResult().getTimezone());
            }
        }
        String content = LocaleTool.tranMessage(_Module.Passport, "freeznReason.content", unfreezeTime + "(" + timezone + ")", getCustomerUrl(sysUser));
        sysUser.setFreezeContent(content);
        sysUserVo.setProperties(SysUser.PROP_FREEZE_USER,SysUser.PROP_FREEZE_CODE, SysUser.PROP_STATUS,SysUser.PROP_FREEZE_TYPE, SysUser.PROP_FREEZE_START_TIME, SysUser.PROP_FREEZE_END_TIME, SysUser.PROP_FREEZE_TITLE, SysUser.PROP_FREEZE_CONTENT);
        ServiceTool.sysUserService().updateOnly(sysUserVo);
    }

    private String getCustomerUrl(SysUser sysUser) {
//		SiteCustomerServiceVo serviceVo = new SiteCustomerServiceVo();
//		serviceVo.getSearch().setSiteId(sysUser.getSiteId());
//		String customer = LocaleTool.tranMessage(Module.COMPANY_SETTING, MessageI18nConst.NOTICE_PARAM_CUSTOMER);
//		if(defaultCustomService!=null){
//			customer = "<a href=\""+defaultCustomService.getParameter()+"\" target=\"_blank\">"+customer+"</a>";
//		}
//		return customer;
        return "";
    }

    /**
     * 审计日志:错误日志
     * 日志先统一走MQ,再存储到业务表
     *
     * @param operator
     * @param isMaster
     */
    private void doSysAuditLog(ModuleType moduleType, final Operator operator, Module module, OpType opType, String message, boolean isMaster) {

        String ipStr = IpTool.ipv4LongToString(operator.getOperateIp());
        if (ipOrAreaResolver.isExceptionIp(ipStr, CommonContext.get().getSiteId())) {
            SessionManagerBase.setAttribute(SessionKey.S_IS_IGNORE_AUDIT, true);
            CommonContext.get().setIsIgnoreAudit(true);
            return;
        }

        IAuditEntity entity = new IAuditEntity() {
            @Override
            public Long getEntityId() {
                return operator.getOperatorId() == null ? null : new Long(operator.getOperatorId());
            }
        };
        SysAuditLog sysAuditLog = AuditLogTool.buildAuditLog(entity, operator, YesNot.YES);
        sysAuditLog.setEntityId(operator.getOperatorId() == null ? null : Long.valueOf(operator.getOperatorId()));
        sysAuditLog.setEntityUserId(operator.getOperatorId());
        sysAuditLog.setEntityUsername(operator.getOperator());
        sysAuditLog.setModuleType(moduleType.getCode());
        sysAuditLog.setOperateType(opType.getTrans());
        sysAuditLog.setOperateTypeId(Integer.valueOf(opType.getCode()));
        sysAuditLog.setModuleName(IModuleTool.getModuleRecursive(module));
        sysAuditLog.setModuleObj(module.getCode());
        sysAuditLog.setDescription(message);
        IAuditService auditService = ServiceTool.auditService();
        auditService.submit(sysAuditLog);

        try {
            SysAuditLogVo vo = new SysAuditLogVo();
            vo.setResult(sysAuditLog);
            ISysAuditLogService sysAuditLogService = ServiceTool.sysAuditLogService();
            sysAuditLogService.insert(vo);
        } catch (Exception e) {
            LOG.error(e, "保存登录业务日志异常!");
        }
    }

    public IIpOrAreaResolver getIpOrAreaResolver() {
        return ipOrAreaResolver;
    }

    public void setIpOrAreaResolver(IIpOrAreaResolver ipOrAreaResolver) {
        this.ipOrAreaResolver = ipOrAreaResolver;
    }
}
