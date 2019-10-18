package so.wwb.lotterybox.manager.common.privilege.controller;

import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.DateQuickPicker;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.support._Module;
import org.soul.commons.validation.form.PasswordRule;
import org.soul.model.common.BaseVo;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.model.session.SessionKey;
import org.soul.model.sys.po.SysParam;
import org.soul.model.sys.vo.SysParamVo;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.validation.form.annotation.FormModel;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.common.utility.security.AuthTool;
import so.wwb.lotterybox.manager.common.account.form.UpdatePrivilegesPasswordWithoutRemoteForm;
import so.wwb.lotterybox.manager.common.privilege.form.PrivilegeForm;
import so.wwb.lotterybox.manager.session.SessionManager;
import so.wwb.lotterybox.model.base.ParamTool;
import so.wwb.lotterybox.model.constants.common.MessageI18nConst;
import so.wwb.lotterybox.model.enums.base.Module;
import so.wwb.lotterybox.model.enums.base.PrivilegeStatusEnum;
import so.wwb.lotterybox.model.enums.base.SiteParamEnum;
import so.wwb.lotterybox.model.manager.user.po.SysUserExtend;
import so.wwb.lotterybox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.lotterybox.web.passport.captcha.CaptchaUrlEnum;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限密码验证控制器
 */
@Controller
@RequestMapping("/common/privilege")
public class PrivilegeController {

    private static final Log LOG = LogFactory.getLog(PrivilegeController.class);
    private static final String VALIDATE_RULE = "validateRule";
    private static final String STATE = "state";
    private static final String MSG = "msg";
    private static final String STATE_CODE = "stateCode";
    private static final String CHECK_PRIVILEGE_URI = "/common/privilege/PrivilegeCheck";
    private static final String LOCK_PRIVILEGE_URI = "/common/privilege/PrivilegeLock";
    private static final String SET_PRIVILEGE_URI = "/common/privilege/SetPrivilegePassword";
    public final static int TRY_TIMES = 5;


    /**
     * 安全密码页面
     *
     * @return
     */
    @RequestMapping("/showCheckPrivilege")
    public String showCheckPrivilege(Model modal) {
        Integer leftTimes = TRY_TIMES;
        int errTimes = getErrorTimes();
        leftTimes = leftTimes - errTimes;
        modal.addAttribute("leftTimes", leftTimes);
        modal.addAttribute(VALIDATE_RULE, JsRuleCreator.create(PrivilegeForm.class));
        return CHECK_PRIVILEGE_URI;
    }

    /**
     * 显示安全密码锁定页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/showLockPrivilege")
    public String showLockPrivilege(Model model) {
        SysUser curUser = SessionManager.getSysUserExtend();

        SysParamVo paramVo = new SysParamVo();
//        paramVo.getSearch().setModule(SiteParamEnum.SETTING_PC_CUSTOMER.getModule().getCode());
//        paramVo.getSearch().setParamType(SiteParamEnum.SETTING_PC_CUSTOMER.getType());
//        paramVo.getSearch().setParamCode(SiteParamEnum.SETTING_PC_CUSTOMER.getCode());
        paramVo = getSystemParams(paramVo);
        String customerServiceUrl = "";
        if (paramVo.getResult() != null) {
            customerServiceUrl = paramVo.getResult().getParamValue() == null ? paramVo.getResult().getDefaultValue() : paramVo.getResult().getParamValue();
        }
        if (StringTool.isBlank(customerServiceUrl)) {
            customerServiceUrl = "";
        }
        String customerService = LocaleTool.tranMessage(Module.COMPANY_SETTING, MessageI18nConst.NOTICE_PARAM_CUSTOMER);
        model.addAttribute("customerService", customerService);
        model.addAttribute("customerServiceUrl", customerServiceUrl);
        model.addAttribute("curUser", curUser);
        setLockTime(curUser, model);
        return LOCK_PRIVILEGE_URI;
    }

    private SysParamVo getSystemParams(SysParamVo paramVo) {
        paramVo._setDataSourceId(SessionManager.getSiteId());
        paramVo.getQuery().setCriterions(new Criterion[]{
                new Criterion(SysParam.PROP_MODULE, Operator.EQ, paramVo.getSearch().getModule()),
                new Criterion(SysParam.PROP_PARAM_TYPE, Operator.EQ, paramVo.getSearch().getParamType()),
                new Criterion(SysParam.PROP_PARAM_CODE, Operator.EQ, paramVo.getSearch().getParamCode())
        });
        paramVo = ServiceTool.sysParamService().search(paramVo);
        return paramVo;
    }

    /**
     * 验证输入的安全密码
     *
     * @param request
     * @param code
     * @return
     */
    @RequestMapping("/validatePrivilege")
    @ResponseBody
    public Map validatePrivilege(HttpServletRequest request, @FormModel() @Valid PrivilegeForm form, String code, String valiCode, BindingResult result) {
        Map<String, Object> resultMap = new HashMap<>(4);
        if (result.hasErrors()) {
            resultMap.put(STATE, false);
            resultMap.put(MSG, LocaleTool.tranMessage("setting", "myAccount.updatePassword.failed"));
            return resultMap;
        }
        try {
            String inputCode = AuthTool.md5SysUserPermission(code, SessionManager.getUserName());
            if (inputCode.equals(SessionManager.getPrivilegeCode())) {
                inputCorrect(request, valiCode, resultMap);
            } else {
                inputFaultCount(resultMap);
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        return resultMap;
    }

    /**
     * 输入安全密码正确
     *
     * @param request
     * @param validateCode
     * @param resultMap
     */
    private void inputCorrect(HttpServletRequest request, String validateCode, Map<String, Object> resultMap) {
        Date now = DateQuickPicker.getInstance().getNow();
        int errTimes = getErrorTimes();
        //第二次以上重试时，判断图片验证码
        if (!isLock() && errTimes >= TRY_TIMES) {
            errTimes = 0;
        }
        if (errTimes >= 2) {
            validateCheckCode(request, validateCode, resultMap);
        }

        Map<String, Object> privilegeUsers = new HashMap<>();
        privilegeUsers.put(STATE, PrivilegeStatusEnum.STATUS_OK.getCode());
        privilegeUsers.put("time", new Date());
        SessionManager.setPrivilegeStatus(privilegeUsers);

        updateUserErrorTimes(0, now, null);
        resultMap.put(STATE, true);
        resultMap.put(MSG, PrivilegeStatusEnum.CODE_100.getTrans());
        resultMap.put(STATE_CODE, PrivilegeStatusEnum.CODE_100.getCode());
    }

    /**
     * 输入安全密码错误次数检查
     *
     * @param resultMap
     */
    private void inputFaultCount(Map<String, Object> resultMap) {
        Date now = DateQuickPicker.getInstance().getNow();
        Map<String, Object> privilegeUsers = new HashMap<>();
        int errTimes = getErrorTimes();//之前输错安全密码的次数
        String message;//错误信息
        String stateCode;//错误代码
        int updateTimes;//更新安全密码次数
        Date freezeStartTime;//安全密码冻结开始时间
        Date freezeEndTime;//安全密码冻结结束时间
        if (errTimes == 0) {
            //第一次输入错误
            privilegeUsers.put(STATE, PrivilegeStatusEnum.STATUS_ERROR.getCode());
            privilegeUsers.put("times", 1);
            message = LocaleTool.tranMessage("privilege", "input.wrong");
            stateCode = PrivilegeStatusEnum.CODE_98.getCode();
            updateTimes = 1;
            freezeStartTime = now;
            freezeEndTime = null;
            resultMap.put("leftTimes", TRY_TIMES - 1);
        } else {
            if (errTimes == -1) {
                errTimes = 0;
            }
            int newTimes = errTimes;
            newTimes++;
            //超过最大允许输入错误的次数
            if (newTimes >= TRY_TIMES) {
                privilegeUsers.put(STATE, PrivilegeStatusEnum.STATUS_LOCK.getCode());
                privilegeUsers.put("time", new Date());
                message = LocaleTool.tranMessage("privilege", "input.freeze");
                stateCode = PrivilegeStatusEnum.CODE_99.getCode();
                updateTimes = TRY_TIMES;
                freezeStartTime = now;
                freezeEndTime = DateTool.addHours(now, 3);
            } else {
                //多次错误但没有达到最大值
                privilegeUsers.put(STATE, PrivilegeStatusEnum.STATUS_ERROR.getCode());
                privilegeUsers.put("times", newTimes);
                message = LocaleTool.tranMessage("privilege", "input.wrong");
                stateCode = PrivilegeStatusEnum.CODE_98.getCode();
                resultMap.put("retry", true);
                resultMap.put("leftTimes", TRY_TIMES - newTimes);
                updateTimes = newTimes;
                freezeStartTime = null;
                freezeEndTime = null;
            }
        }
        SessionManager.setPrivilegeStatus(privilegeUsers);
        updateUserErrorTimes(updateTimes, freezeStartTime, freezeEndTime);
        resultMap.put(STATE, false);
        resultMap.put(MSG, message);
        resultMap.put(STATE_CODE, stateCode);
    }

    /**
     *  更新安全密码参数
     * @param times 次数
     * @param startTime 开始时间
     * @param endTime 结束数据
     */
    private void updateUserErrorTimes(int times, Date startTime, Date endTime) {
        try {
            SysUserExtend user = SessionManager.getSysUserExtend();
            SysUserExtendVo sysUserVo = new SysUserExtendVo();
            sysUserVo.setProperties(SysUser.PROP_SECPWD_FREEZE_START_TIME, SysUser.PROP_SECPWD_FREEZE_END_TIME, SysUser.PROP_SECPWD_ERROR_TIMES);
            user.setSecpwdFreezeStartTime(startTime);
            user.setSecpwdFreezeEndTime(endTime);
            user.setSecpwdErrorTimes(times);
            sysUserVo.setResult(user);
            LOG.info("更新安全密码用户：{0},更新次数：{1},更新开始时间：{2}，更新结束时间：{3}", user.getUsername(), user.getSecpwdErrorTimes(), user.getSecpwdFreezeStartTime(), user.getSecpwdFreezeEndTime());
            ServiceTool.sysUserExtendService().updateOnly(sysUserVo);
            //更新用户次数后更新session中的用户
            sysUserVo.getSearch().setId(user.getId());
            sysUserVo = ServiceTool.sysUserExtendService().get(sysUserVo);
            SessionManager.setUser(sysUserVo.getResult());
        } catch (Exception e) {
            LOG.error(e, "更新用户安全密码错误次数失败");
        }
    }




    /**
     * 是否锁住
     *
     * @return
     */
    private boolean isLock() {
        boolean isLock = true;
        SysUser curUser = SessionManager.getSysUserExtend();
        Date now = DateQuickPicker.getInstance().getNow();
        if (curUser != null && curUser.getSecpwdFreezeEndTime() != null) {
            isLock = now.before(curUser.getSecpwdFreezeEndTime());
        }else if (curUser != null && curUser.getSecpwdFreezeEndTime() == null){
            isLock = false;
        }
        return isLock;
    }

    /**
     * 检查验证码参数
     *
     * @param request
     * @param validateCode
     * @param resultMap
     */
    private void validateCheckCode(HttpServletRequest request, String validateCode, Map<String, Object> resultMap) {
        String message = "";
        String stateCode;
        boolean state;
        if (StringTool.isBlank(validateCode)) {
            message = LocaleTool.tranMessage("privilege", "captcha.input");
            stateCode = PrivilegeStatusEnum.CODE_98.getCode();
            state = false;
        } else {
            if (!checkValidateCode(validateCode, request)) {
                message = LocaleTool.tranMessage("privilege", "captcha.wrong");
                stateCode = PrivilegeStatusEnum.CODE_97.getCode();
                state = false;
            } else {
                stateCode = PrivilegeStatusEnum.CODE_100.getCode();
                state = true;
            }
        }
        if (StringTool.isNotBlank(message)) resultMap.put(MSG, message);
        resultMap.put(STATE_CODE, stateCode);
        resultMap.put(STATE, state);
    }


    /**
     * 检查权限密码状态
     *
     * @return
     */
    @RequestMapping("/checkPrivilege")
    @ResponseBody
    public Map checkPrivilege() {
        final HashMap<Object, Object> map = new HashMap<>(2);
        if (StringTool.isBlank(SessionManager.getSysUserExtend().getPermissionPwd())) {
            //未设置权限密码
            LOG.info("未设置安全密码");
            map.put(STATE, PrivilegeStatusEnum.CODE_96.getCode());
            return map;
        }
        int errTimes = getErrorTimes();
        boolean isLock = isLock();
        LOG.info("是否被锁定了：{0},密码错误次数：{1}", isLock, errTimes);
        if (isLock) {
            map.put(STATE, PrivilegeStatusEnum.CODE_99.getCode());
        } else {
            SysUser curUser = SessionManager.getSysUserExtend();
            if (errTimes == 0) {
                //上次密码正常
                successLastTime(map, curUser);
            } else if (errTimes > 0 || errTimes == -1) {
                //上次密码不正确
                if (errTimes == -1) {
                    errTimes = 1;
                }
                failLastTime(map, errTimes);

            } else {
                SessionManager.clearPrivilegeStatus();
                map.put(STATE, PrivilegeStatusEnum.CODE_0.getCode());
            }
        }
        map.put("title", LocaleTool.tranView("common", "securityPassword"));
        return map;
    }

    private void failLastTime(HashMap<Object, Object> map, int errTimes) {
        if (errTimes >= TRY_TIMES) {
            map.put("times", 0);
            map.put(STATE, PrivilegeStatusEnum.CODE_0.getCode());
            updateUserErrorTimes(0, null, null);
        } else {
            final Integer times = errTimes;//(Integer) privilegeUsers.get("times");
            map.put(STATE, PrivilegeStatusEnum.CODE_98.getCode());
            map.put("times", TRY_TIMES - times);
        }
    }

    private void successLastTime(HashMap<Object, Object> map, SysUser curUser) {
        Date now = DateQuickPicker.getInstance().getNow();
        Date start = DateTool.addDays(now, -1);
        final Date lastTime = curUser.getSecpwdFreezeStartTime() == null ? start : curUser.getSecpwdFreezeStartTime();
        long minutesBetween = DateTool.minutesBetween(now, lastTime);
        String paramValue = "5";
        if (ParamTool.getSysParam(SiteParamEnum.SETTING_PRIVILAGE_PASS_TIME) != null) {
            ParamTool.getSysParam(SiteParamEnum.SETTING_PRIVILAGE_PASS_TIME).getParamValue();
        }
        Integer privilegeTime = 0;
        if (StringTool.isNotBlank(paramValue)) {
            privilegeTime = Integer.parseInt(paramValue);
        }
        if (minutesBetween < privilegeTime) {
            //还在允许的时间范围内
            map.put(STATE, PrivilegeStatusEnum.CODE_100.getCode());
        } else {
            //已超时，重新验证
            SessionManager.clearPrivilegeStatus();
            map.put(STATE, PrivilegeStatusEnum.CODE_0.getCode());
        }
    }


    /**
     * 安全码错误次数
     * 判断不出来默认需要权限
     *
     * @return
     */
    private int getErrorTimes() {
        int errorTimes = 1;
        SysUser curUser = SessionManager.getSysUserExtend();
        if (curUser != null) {
            errorTimes =  curUser.getSecpwdErrorTimes() == null ? -1 : curUser.getSecpwdErrorTimes();
        }
        return errorTimes;
    }

    private void setLockTime(SysUser curUser, Model model) {
        if (isLock()) {
            final Date lastTime = curUser.getSecpwdFreezeStartTime();
            long seconds = DateTool.secondsBetween(new Date(), lastTime);
            long hour = DateTool.hoursBetween(new Date(), lastTime);
            long min = DateTool.minutesBetween(new Date(), lastTime);
            model.addAttribute("hour", (3 - hour - 1));
            model.addAttribute("min", (60 - min - 1));
            model.addAttribute("sec", (60 - (seconds - min * 60) - 1));
        }
    }


    @RequestMapping(value = "setPrivilegePassword", method = RequestMethod.GET)
    public String setPrivilegePassword(Model model, SysUserVo sysUserVo) {
        sysUserVo.setValidateRule(JsRuleCreator.create(UpdatePrivilegesPasswordWithoutRemoteForm.class, "result"));
        model.addAttribute("command", sysUserVo);
        return SET_PRIVILEGE_URI;
    }

    @RequestMapping(value = "setPrivilegePassword", method = RequestMethod.POST)
    @ResponseBody
    public Map setPrivilegePassword(SysUserVo sysUserVo, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        String password = AuthTool.md5SysUserPassword(sysUserVo.getResult().getPassword(), SessionManager.getSysUserExtend().getUsername());
        if (password.equals(SessionManager.getSysUserExtend().getPassword())) {
            sysUserVo = updateUserPermissionPwd(sysUserVo);
        } else {
            sysUserVo.setSuccess(false);
            sysUserVo.setErrMsg("登录密码错误");
        }
        Map privilegeUsers = new HashMap();
        privilegeUsers.put(STATE, PrivilegeStatusEnum.STATUS_OK.getCode());
        privilegeUsers.put("time", new Date());
        SessionManager.setPrivilegeStatus(privilegeUsers);
        return getVoMessage(sysUserVo);
    }

    private SysUserVo updateUserPermissionPwd(SysUserVo sysUserVo) {
        //设置id
        sysUserVo.getResult().setId(SessionManager.getSysUserExtend().getId());
        sysUserVo.setProperties(SysUser.PROP_PERMISSION_PWD, SysUser.PROP_SECPWD_ERROR_TIMES, SysUser.PROP_SECPWD_FREEZE_END_TIME, SysUser.PROP_SECPWD_FREEZE_START_TIME);
        //密码加密
        String md5Pwd = AuthTool.md5SysUserPermission(sysUserVo.getResult().getPermissionPwd(), SessionManager.getSysUserExtend().getUsername());
        sysUserVo.getResult().setPermissionPwd(md5Pwd);
        sysUserVo.getResult().setSecpwdErrorTimes(0);
        sysUserVo.getResult().setSecpwdFreezeEndTime(new Date());
        sysUserVo.getResult().setSecpwdFreezeStartTime(new Date());
        sysUserVo = ServiceTool.sysUserService().updateOnly(sysUserVo);
        if (SessionManager.isCurrentSiteMaster()) {
            sysUserVo._setDataSourceId(SessionManager.getSiteParentId());
            sysUserVo.getResult().setId(SessionManager.getSiteUserId());
            sysUserVo = ServiceTool.sysUserService().updateOnly(sysUserVo);
        }
        //改变session中user的权限密码
        if (sysUserVo.isSuccess()) {
            SysUserExtend sysUser = SessionManager.getSysUserExtend();
            sysUser.setPermissionPwd(sysUserVo.getResult().getPermissionPwd());
            sysUser.setSecpwdErrorTimes(0);
            sysUser.setSecpwdFreezeStartTime(sysUserVo.getResult().getSecpwdFreezeStartTime());
            sysUser.setSecpwdFreezeEndTime(sysUserVo.getResult().getSecpwdFreezeEndTime());
            SessionManagerBase.setUser(sysUser);
        }
        return sysUserVo;
    }

    protected Map getVoMessage(BaseVo baseVo) {
        Map<String, Object> map = new HashMap<>(2);
        if (baseVo.isSuccess() && StringTool.isBlank(baseVo.getOkMsg())) {
            baseVo.setOkMsg(LocaleTool.tranMessage(_Module.COMMON, "save.success"));

        } else if (!baseVo.isSuccess() && StringTool.isBlank(baseVo.getErrMsg())) {
            baseVo.setErrMsg(LocaleTool.tranMessage(_Module.COMMON, "save.failed"));
        }
        map.put(MSG, StringTool.isNotBlank(baseVo.getOkMsg()) ? baseVo.getOkMsg() : baseVo.getErrMsg());
        map.put(STATE, baseVo.isSuccess());
        return map;
    }

    /**
     * 验证吗remote验证
     *
     * @param validateCode
     * @param request
     * @return
     */
    @RequestMapping("/checkValidateCode")
    @ResponseBody
    public boolean checkValidateCode(@RequestParam("validateCode") String validateCode, HttpServletRequest request) {
        String requiedValiCode=(String)request.getAttribute("requiedValiCode");
        if (StringTool.isNotBlank(requiedValiCode) && StringTool.isEmpty(validateCode)) {
            return false;
        }
        if (StringTool.isNotBlank(requiedValiCode)) {
            return validateCode.equalsIgnoreCase((String) SessionManagerCommon.getAttribute(SessionKey.S_CAPTCHA_PREFIX + CaptchaUrlEnum.CODE_PRIVILEGE.getSuffix()));
        }else{
            return true;
        }
    }

    @RequestMapping(value = "/checkPrivilegePwd")
    @ResponseBody
    public String checkPrivilegePwd(@RequestParam("result.permissionPwd") String password) {
        // 弱密码过滤
        if (PasswordRule.isWeak(password)) {
            return "false";
        }
        return "true";
    }

}
