package so.wwb.creditbox.manager.common.account.controller;

import org.apache.commons.collections.map.HashedMap;
import org.soul.commons.bean.Pair;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.dict.DictTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.net.ServletTool;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.model.log.audit.enums.OpMode;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.po.SysUserRole;
import org.soul.model.security.privilege.po.SysUserStatus;
import org.soul.model.security.privilege.vo.SysRoleListVo;
import org.soul.model.security.privilege.vo.SysUserRoleListVo;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.web.controller.NoMappingCrudController;
import org.soul.web.validation.form.annotation.FormModel;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.iservice.manager.user.ISysUserExtendService;
import so.wwb.creditbox.manager.common.account.form.SysUserExtendEditForm;
import so.wwb.creditbox.manager.common.account.form.SysUserExtendForm;
import so.wwb.creditbox.manager.common.account.form.SysUserExtendSearchForm;
import so.wwb.creditbox.manager.common.account.form.SysUserExtendUpdateForm;
import so.wwb.creditbox.manager.session.SessionManager;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.common.AuditLogEnum;
import so.wwb.creditbox.model.enums.base.DictEnum;
import so.wwb.creditbox.model.enums.base.FreezeTypeEnum;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.sys.po.SysRole;
import so.wwb.creditbox.model.manager.sys.po.VSysRole;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendListVo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountVo;
import so.wwb.creditbox.utility.DesTool;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.membercenter.form.ResetPwdForm;
import so.wwb.creditbox.web.passport.captcha.GoogleAuthenticator;
import so.wwb.creditbox.web.shiro.common.filter.KickoutFilter;
import so.wwb.creditbox.web.tools.AuditAddLogTool;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.SysParamTool;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by Ronnie 17/11/1
 */

public class BaseAccountController extends NoMappingCrudController<ISysUserExtendService, SysUserExtendListVo, SysUserExtendVo,
        SysUserExtendSearchForm, SysUserExtendForm, SysUserExtend, Integer> {
    private static final Log LOG = LogFactory.getLog(BaseAccountController.class);

    private final static String SUCCESS = "success";
    private final static String FALSE = "false";


    private static final Map<String, String[]> userTypesMap = new HashMap<>(6);

    static {
        userTypesMap.put(UserTypeEnum.BOSS.getCode(), new String[]{
                UserTypeEnum.BOSS_SUB.getCode(),
        });
        userTypesMap.put(UserTypeEnum.SHAREHOLDER.getCode(), new String[]{
                UserTypeEnum.SHAREHOLDER_SUB.getCode(),
        });
        userTypesMap.put(UserTypeEnum.COMPANY.getCode(), new String[]{
                UserTypeEnum.COMPANY_SUB.getCode(),
        });
        userTypesMap.put(UserTypeEnum.DISTRIBUTOR.getCode(), new String[]{
                UserTypeEnum.DISTRIBUTOR_SUB.getCode()
        });
    }

    /**
     * 上级关系分隔符
     */
    private static final String PARENT_SPILT = ",";

    @Override
    protected String getViewBasePath() {
        return null;
    }


    @Override
    protected SysUserExtendListVo doList(SysUserExtendListVo listVo, SysUserExtendSearchForm form, BindingResult result, Model model) {
        //设置多账号查询
        splitUsername(listVo, SessionManager.getSiteId());
        listVo = super.doList(listVo, form, result, model);
        setListModel(listVo, model);
        return listVo;
    }

    @Override
    protected SysUserExtendVo doView(SysUserExtendVo objectVo, Model model) {
        objectVo = queryView(objectVo, model);
        model.addAttribute("userStatus", DictTool.get(DictEnum.COMMON_USER_STATUS));
        return objectVo;
    }

    @Override
    protected SysUserExtendVo doCreate(SysUserExtendVo objectVo, Model model) {
        SysUserExtend operator = SessionManager.getSysUserExtend();
        model.addAttribute(SysUserExtend.PROP_SUBSYS_CODE, operator.getSubsysCode());
        if (objectVo.getResult() != null) {
            model.addAttribute(SysUserExtend.PROP_OWNER_ID, objectVo.getResult().getOwnerId());
        }
        if (!isAllowCreate()) {
            return objectVo;
        }
        String[] userTypes = getEditUserTypes();
        model.addAttribute("userTypes", userTypes);
        getRoles(model);
        model.addAttribute("sex", DictTool.get(DictEnum.COMMON_SEX));
        return super.doCreate(objectVo, model);
    }

    /**
     * 设置页面数据
     *
     * @param listVo
     * @param model
     */
    private void setListModel(SysUserExtendListVo listVo, Model model) {
        String searchUserType = listVo.getSearch().getUserType();
        if (StringTool.equals(UserTypeEnum.COMPANY.getCode(), searchUserType)) {
            List<String> list =new ArrayList<>();
            list.add(SubSysCodeEnum.DISTRIBUTOR.getCode());
            list.add(SubSysCodeEnum.DISTRIBUTOR.getCode());
            //所有商户下对应的总代人数
            model.addAttribute("ownerIds", querySubCount(listVo, list));
        }
    }

    /**
     * 根据账号类型查询账号列表
     *
     * @param listVo
     * @param userType 账号类型
     * @return
     */
    protected SysUserExtendListVo queryAccountListByType(SysUserExtendListVo listVo, String userType) {
        splitUsername(listVo, SessionManager.getSiteId());
        listVo.getSearch().setUserType(userType);
        return this.getService().search(listVo);
    }

    /**
     * 根据账号类型查询所有存在站点的账号列表
     *
     * @param listVo
     * @param userType
     * @return
     */
    protected SysUserExtendListVo queryAccountListAsSiteByType(SysUserExtendListVo listVo, String userType) {
        listVo.setPaging(null);
        listVo.getQuery().setCriterions(new Criterion[]{
                new Criterion(SysUserExtend.PROP_SITE_ID, Operator.IS_NOT_NULL, null),
                new Criterion(SysUserExtend.PROP_USER_TYPE, Operator.EQ, userType)
        });
        return this.getService().search(listVo);
    }


    protected Map merchantPersist(SysUserExtendVo objectVo, SysUserExtendForm form, BindingResult result) {
        Map<String, Object> map = new HashMap<>(1);
        SysUserExtend sysUserExtend = SessionManager.getSysUserExtend();
        if (sysUserExtend == null) {
            return null;
        }
        if (sysUserExtend.getSubsysCode().equals(SubSysCodeEnum.BOSS.getCode())) {
            objectVo.getResult().setOwnerId(objectVo.getResult().getOwnerId());
        }
       /* else{
            objectVo.getResult().setOwnerId(sysUserExtend.getId());
        }*/
        objectVo.getResult().setUserType(UserTypeEnum.COMPANY.getCode());
        if (!SysParamTool.checkManageUsername(objectVo)) {
            map.put("msg", "该账号有重复");
            return map;
        }
        return super.persist(objectVo, form, result);
    }

    protected Map merchantPersistAccount(SysUserExtendVo objectVo, BindingResult result, HttpServletRequest request) {
        if (!result.hasErrors()) {
            objectVo = getService().updateSysUser(objectVo, SessionManager.getSysUserExtend());
        } else {
            objectVo.setSuccess(false);
        }
        addAuditLog(objectVo, request, AuditLogEnum.UPDATE_MANAGE_ACCOUNT_INFO);
        Map resMap = getVoMessage(objectVo);
        resMap.put("auditResult", objectVo.isSuccess() ? SUCCESS : FALSE);
        return resMap;
    }

    protected Map subAccountPersist(SysUserExtendVo objectVo, SysUserExtendForm form, BindingResult result) {
        Map<String, Object> map = new HashMap<>(1);
        SysUserExtend sysUserExtend = SessionManager.getSysUserExtend();
        if (sysUserExtend == null) {
            return null;
        }
        String userType = sysUserExtend.getUserType();
        String[] userTypes = userTypesMap.get(userType);
        String type = null;
        for (String s : userTypes) {
            type = s;
        }
        objectVo.getResult().setUserType(type);
        if (!SysParamTool.checkManageUsername(objectVo)) {
            map.put("msg", "该账号有重复");
            return map;
        }
        return super.persist(objectVo, form, result);
    }

    /**
     * 编辑跳转
     */
    protected SysUserExtendVo editAccount(Model model, Integer id) {
        if (id == null) {
            return null;
        }
        SysUserExtendVo objectVo = new SysUserExtendVo();
        objectVo.getSearch().setId(id);
        objectVo = getService().editAccount(objectVo);
        objectVo.setValidateRule(JsRuleCreator.create(SysUserExtendEditForm.class, "result"));
        model.addAttribute("command", objectVo);
        getUserRoles(objectVo, model);
        model.addAttribute("sex", DictTool.get(DictEnum.COMMON_SEX));
//        model.addAttribute("email", objectVo.getNoticeContactWay().getContactValue());
        return objectVo;
    }

    /**
     * 重置登录密码跳转
     * resetPwd
     */
    protected SysUserExtendVo resetPassword(Model model, Integer id) {
        if (id == null) {
            return null;
        }
        SysUserExtendVo objectVo = new SysUserExtendVo();
        objectVo.getSearch().setId(id);
        objectVo = getService().editAccount(objectVo);
        objectVo.setValidateRule(JsRuleCreator.create(ResetPwdForm.class, "result"));
        model.addAttribute("command", objectVo);
        return objectVo;
    }


    /**
     * 重置密码保存
     * updatePwd
     */
    public SysUserExtendVo updatePwd(SysUserExtendVo userExtendVo, @FormModel @Valid ResetPwdForm form, BindingResult result, HttpServletRequest request) {
        userExtendVo.setSuccess(false);
        if (result.hasErrors() || userExtendVo.getSearch().getId() == null) {
            userExtendVo.setErrMsg("参数错误,保存失败");
            return userExtendVo;
        }
        userExtendVo = this.getService().get(userExtendVo);
        if (userExtendVo.getResult() == null) {
            userExtendVo.setErrMsg("用户不存在，保存失败");
            LOG.error("更新账号密码，用户查询结果为空");
            return userExtendVo;
        }
        String md5Pwd = AuthTool.md5SysUserPassword(form.get$pwd(), userExtendVo.getResult().getUsername());
        if (StringTool.equals(md5Pwd, userExtendVo.getResult().getPassword())) {
            userExtendVo.setErrMsg("新登录密码不能与原登录密码相同");
            return userExtendVo;
        } else {
            userExtendVo.getResult().setPassword(md5Pwd);
        }
        userExtendVo.setProperties(SysUserExtend.PROP_PASSWORD);
        userExtendVo = this.getService().updateOnly(userExtendVo);
        if (userExtendVo.isSuccess()) {
            addAuditLog(userExtendVo, request, AuditLogEnum.UPDATE_MANAGE_ACCOUNT_PASSWORD);
            loginKickout(userExtendVo.getResult().getId(), "登录密码被重置");
            Cache.refreshSysUserExtend();
        }
        return userExtendVo;
    }

    private void loginKickout(Integer userId, String kickOutMsg) {

//        Session session=SessionManagerCommon.getSession(false);
//        if(session!=null && !session.getId().toString().startsWith("-1,")){
//            SessionManagerCommon.clearSession();
//        }
//
        String operateUser = SessionManager.getUser().getUsername() + "(" + SessionManager.getUser().getId() + ")";
        Integer siteId = null;
        KickoutFilter.loginKickoutAll(userId, siteId, OpMode.MANUAL, kickOutMsg, operateUser);
    }


    /**
     * 更新状态
     * 根据ID  更新启用和停用状态
     */
    public SysUserExtendVo baseDisabledStatus(HttpServletRequest request, SysUserExtendVo userExtendVo) {
        Integer userId = userExtendVo.getResult().getId();
        if (userId != null) {
            userExtendVo.getSearch().setId(userId);
            userExtendVo = this.getService().get(userExtendVo);
            if (userExtendVo.getResult() != null) {
                String status = userExtendVo.getResult().getStatus();
                if (SysUserStatus.NORMAL.getCode().equals(status)) {
                    userExtendVo.getResult().setStatus(SysUserStatus.DISABLED.getCode());
                }
                if (SysUserStatus.DISABLED.getCode().equals(status)) {
                    userExtendVo.getResult().setStatus(SysUserStatus.NORMAL.getCode());
                }
                userExtendVo.setProperties(SysUserExtend.PROP_STATUS);
                userExtendVo = this.getService().updateOnly(userExtendVo);
                if (userExtendVo.isSuccess()) {
                    addAuditLog(userExtendVo, request, AuditLogEnum.UPDATE_MANAGE_ACCOUNT_STATUS);
                    if (userExtendVo.getResult().getStatus().equals(SysUserStatus.DISABLED.getCode())) {
                        loginKickout(userId, "账号被停用");
                    }
                    Cache.refreshSysUserExtend();
                }
            }
        }
        return userExtendVo;
    }

    /**
     * 更新状态
     * 根据ID  更新冻结和解冻
     */
    public SysUserExtendVo baseFreezeStatus(SysUserExtendVo userExtendVo, HttpServletRequest request) {
        userExtendVo.setSuccess(false);
        Integer userId = userExtendVo.getResult().getId();
        if (userId == null) {
            userExtendVo.setErrMsg("参数错误,保存失败");
            return userExtendVo;
        }
        userExtendVo.getSearch().setId(userId);
        SysUserExtendVo sysUserExtendVo = this.getService().get(userExtendVo);
        if (sysUserExtendVo.getResult() == null) {
            userExtendVo.setErrMsg("用户不存在，保存失败");
            return userExtendVo;
        }
        String status = sysUserExtendVo.getResult().getStatus();
        if (SysUserStatus.DISABLED.getCode().equals(status)) {
            userExtendVo.setErrMsg("该账号已经停用啦!冻结失败");
            return userExtendVo;
        }
        if (SysUserStatus.LOCKED.getCode().equals(status)) {
            sysUserExtendVo.getResult().setStatus(SysUserStatus.NORMAL.getCode());
            sysUserExtendVo.getResult().setFreezeType(null);
            sysUserExtendVo.getResult().setFreezeEndTime(null);
            sysUserExtendVo.getResult().setFreezeStartTime(null);
            sysUserExtendVo.getResult().setFreezeCode(null);
            sysUserExtendVo.getResult().setFreezeContent(null);
            sysUserExtendVo.getResult().setFreezeUser(null);
            sysUserExtendVo.getResult().setLoginErrorTimes(0);//登录密码输错次数清零
        } else if (SysUserStatus.NORMAL.getCode().equals(status)) {
            sysUserExtendVo.getResult().setStatus(SysUserStatus.LOCKED.getCode());
            sysUserExtendVo.getResult().setFreezeType(FreezeTypeEnum.MANUAL.getCode());
            sysUserExtendVo.getResult().setFreezeEndTime(null);
            sysUserExtendVo.getResult().setFreezeStartTime(new Date());
            sysUserExtendVo.getResult().setFreezeCode(null);
            sysUserExtendVo.getResult().setFreezeContent("手动冻结该账号");
            sysUserExtendVo.getResult().setFreezeUser(SessionManager.getUserId());
        }
        sysUserExtendVo.setProperties(SysUserExtend.PROP_STATUS, SysUserExtend.PROP_FREEZE_CODE,
                SysUserExtend.PROP_FREEZE_END_TIME, SysUserExtend.PROP_FREEZE_TYPE, SysUserExtend.PROP_FREEZE_START_TIME,
                SysUserExtend.PROP_FREEZE_USER, SysUserExtend.PROP_FREEZE_CONTENT, SysUserExtend.PROP_LOGIN_ERROR_TIMES);
        sysUserExtendVo = this.getService().updateOnly(sysUserExtendVo);
        if (sysUserExtendVo.isSuccess()) {
            userExtendVo.setSuccess(true);
            userExtendVo.setOkMsg("保存成功");
            if (SysUserStatus.LOCKED.getCode().equals(sysUserExtendVo.getResult().getStatus())) {
                loginKickout(sysUserExtendVo.getResult().getId(), "账号被冻结");
            }
            addAuditLog(userExtendVo, request, AuditLogEnum.UPDATE_MANAGE_ACCOUNT_STATUS);
            Cache.refreshSysUserExtend();
        }
        return userExtendVo;
    }


    /**
     * 删除
     *
     * @param objectVo
     * @param id
     * @return
     */
    @Override
    public Map delete(SysUserExtendVo objectVo, Integer id) {
        Map<String, Object> map = new HashMap<>(6);
        if (id == null || StringTool.isBlank(id.toString())) {
            map.put("state", false);
            map.put("msg", "加载实体时id参数必须指定！");
            return map;
        }
        objectVo.getSearch().setId(id);
        objectVo = this.getService().deleteSysUser(objectVo);
        Cache.refreshSysUserExtend();
        if (objectVo.isSuccess()) {
            map.put("state", true);
            map.put("msg", "删除成功");
        } else {
            map.put("state", false);
            map.put("msg", "删除失败");
        }
        return map;
    }

    /**
     * 查询详细
     *
     * @param objectVo
     * @return
     */
    public SysUserExtendVo queryView(SysUserExtendVo objectVo, Model model) {
        SysUserExtend sysUserExtend = SessionManager.getSysUserExtend();
        if (sysUserExtend == null) {
            return objectVo;
        }
        objectVo.setLoginUserId(SessionManager.getUserId());
        objectVo.getSearch().setUserType(sysUserExtend.getUserType());
        if (UserTypeEnum.COMPANY.getCode().equals(SessionManager.getUser().getUserType())) {
            objectVo.getSearch().setOwnerId(SessionManager.getUserId());
        } else if (UserTypeEnum.COMPANY_SUB.getCode().equals(SessionManager.getUser().getUserType())) {
            objectVo.getSearch().setOwnerId(SessionManager.getUser().getOwnerId());
        }
        objectVo = this.getService().viewSysUser(objectVo);
        return objectVo;
    }

    protected SysUserExtendVo baseAddAccount(SysUserExtendVo objectVo, @FormModel @Valid SysUserExtendForm form, BindingResult result, HttpServletRequest request) {
        if (checkAccountParams(objectVo, form, result, request)) {
            initAccount(objectVo, request);
            objectVo = doPersist(objectVo);
            if (objectVo.isSuccess()) {
                addAuditLog(objectVo, request, AuditLogEnum.INSERT_MANAGE_ACCOUNT);
                CacheBase.refreshSysUserExtend();
            }
        }
        return objectVo;
    }

    protected SysUserExtendVo baseUpdateAccount(SysUserExtendVo userExtendVo, @FormModel @Valid SysUserExtendUpdateForm form, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            userExtendVo.setSuccess(false);
            userExtendVo.setErrMsg("参数错误，保存失败");
        } else {
            userExtendVo = this.getService().updateSysUser(userExtendVo, SessionManager.getSysUserExtend());
            addAuditLog(userExtendVo, request, AuditLogEnum.UPDATE_MANAGE_ACCOUNT_INFO);
        }
        return userExtendVo;
    }

    private boolean checkAccountParams(SysUserExtendVo objectVo, @FormModel @Valid SysUserExtendForm form, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            objectVo.setSuccess(false);
            objectVo.setErrMsg("参数错误，保存失败");
            LOG.error("参数错误，保存失败");
            return objectVo.isSuccess();
        }

        SysUserExtendVo ownerVo = new SysUserExtendVo();
        ownerVo.getSearch().setId(objectVo.getResult().getOwnerId());
        if (objectVo.getResult().getOwnerId() == null || ServiceTool.sysUserExtendService().get(ownerVo).getResult() == null) {
            objectVo.setSuccess(false);
            objectVo.setErrMsg("缺少上级数据，保存失败");
            LOG.error("缺少上级数据，ownerId=[{0}]，保存失败", objectVo.getResult().getOwnerId());
            return objectVo.isSuccess();
        }

        if (!SysParamTool.checkManageUsername(objectVo)) {
            objectVo.setSuccess(false);
            objectVo.setErrMsg("该账号有重复,保存失败");
            LOG.error("[" + SysParamTool.addManageUsernameSuffix(objectVo) + "]账号名已存在,保存失败");
        }
        return objectVo.isSuccess();
    }

    /**
     * 初始化注册参数
     * PS: userType、subsysCode、ownerId、createUser 数据请在入口进行处理
     */
    private void initAccount(SysUserExtendVo objectVo, HttpServletRequest request) {
        String createUserType = objectVo.getResult().getUserType();

        SysUserExtendVo ownerVo = new SysUserExtendVo();
        ownerVo.getSearch().setId(objectVo.getResult().getOwnerId());
        SysUserExtend owner = ServiceTool.sysUserExtendService().get(ownerVo).getResult();

//        objectVo.getResult().setOwnerName(owner.getUsername());
//        objectVo.getResult().setOwnerCode(owner.getCode());

        objectVo.getResult().setHid(ServiceTool.vSiteUserService().getHid(owner.getHid()));
        //创建股东和商户主账号时，没有站点ID, 其他账户取上级站点ID
        if (!StringTool.equals(UserTypeEnum.COMPANIES.getCode(), createUserType)
                && !StringTool.equals(UserTypeEnum.COMPANY.getCode(), createUserType)) {
            objectVo.getResult().setSiteId(owner.getSiteId());
        }
        objectVo.getResult().setParentName(owner.getUsername());
        objectVo.getResult().setDefaultCurrency(owner.getDefaultCurrency());
        objectVo.getResult().setDefaultTimezone(owner.getDefaultTimezone());
        objectVo.getResult().setDefaultLocale(owner.getDefaultLocale());
        boolean boss = StringTool.equals(UserTypeEnum.BOSS.getCode(), owner.getUserType());
//        objectVo.getResult().setParentIds(boss ?
//                owner.getId().toString() : owner.getId() + "," + owner.getParentIds());
//        objectVo.getResult().setParentNames(boss ?
//                owner.getUsername() : owner.getUsername() + "," + owner.getParentNames());
        //TODO by jeremy 给名字加上对应后缀(临时后缀，在该账号建立站点时，会将站点code同步到相应账号名下，总代除外)
        String splitName = owner.getUsername();
        if (splitName.contains("@")) {
            splitName = splitName.substring(splitName.indexOf("@"));
            objectVo.getResult().setUsername(objectVo.getResult().getUsername() + splitName);
        }
        if (!UserTypeEnum.PLAYER.getCode().equals(createUserType)) {
            //对身份验证码进行DES加密处理
            String str = GoogleAuthenticator.generateSecretKey();
            String key = objectVo.getResult().getUsername();
            String secret = DesTool.encrypt(str, key);
            objectVo.getResult().setAuthenticationKey(secret);
        }
        objectVo.getResult().setRegisterIp(IpTool.ipv4StringToLong(ServletTool.getIpAddr(request)));
        objectVo.getResult().setRegisterIpDictCode(SessionManagerCommon.getIpDictCode());
        objectVo.getResult().setStatus(SysUserStatus.NORMAL.getCode());
        objectVo.getResult().setBuiltIn(false);
    }

    @Override
    protected SysUserExtendVo doSave(SysUserExtendVo objectVo) {
        return getService().saveSysUser(objectVo);
    }

    //    @Override
//    protected SysUserExtendVo doSave(SysUserExtendVo objectVo) {
//        SysUserExtend operatorUser = SessionManager.getSysUserExtend();//操作人
//        String createUserType = objectVo.getResult().getUserType();//创建账户的类型
//        if (SubSysCodeEnum.COMPANY.getCode().equals(operatorUser.getSubsysCode())) {//api商户创建子账号
//            if (UserTypeEnum.DISTRIBUTOR.getCode().equals(objectVo.getResult().getUserType())) {//商户创建总代账号
//                objectVo.getResult().setSubsysCode(SubSysCodeEnum.DISTRIBUTOR.getCode());
//            } else {
//                objectVo.getResult().setSubsysCode(operatorUser.getSubsysCode());
//            }
//        } else if ("false".equals(objectVo.getSearch().getCode())) {
//            objectVo.getResult().setSubsysCode(SubSysCodeEnum.COMPANY.getCode());
//        } else if (checkAPI(objectVo)
//                &&
//                (UserTypeEnum.DISTRIBUTOR.getCode().equals(objectVo.getResult().getUserType()) || UserTypeEnum.DISTRIBUTOR_SUB.getCode().equals(objectVo.getResult().getUserType()))) {//判断生成api总代账号
//            objectVo.getResult().setSubsysCode(SubSysCodeEnum.DISTRIBUTOR.getCode());
//        } else {
//            objectVo.getResult().setSubsysCode(getSubSysCode(createUserType));
//        }
//
//
//        objectVo.getResult().setCreateUser(operatorUser.getId());
//        objectVo.getResult().setStatus(SysUserStatus.NORMAL.getCode());
//        objectVo.getResult().setDefaultCurrency(operatorUser.getDefaultCurrency());
//        objectVo.getResult().setDefaultTimezone(operatorUser.getDefaultTimezone());
//        objectVo.getResult().setDefaultLocale(operatorUser.getDefaultLocale());
//
//        if (objectVo.getResult().getOwnerId() != null) {
//            SysUserExtendVo sysUserExtendVo = new SysUserExtendVo();
//            sysUserExtendVo.getSearch().setId(objectVo.getResult().getOwnerId());
//            SysUserExtendVo ownerUser = this.getService().get(sysUserExtendVo);
//            objectVo.getResult().setOwnerName(ownerUser.getResult().getUsername());
//            objectVo.getResult().setOwnerCode(ownerUser.getResult().getCode());
//
//            //创建股东和商户主账号时，没有站点ID, 其他账户取上级站点ID
//            if (!StringTool.equals(UserTypeEnum.SHAREHOLDER.getCode(), createUserType)
//                    && !StringTool.equals(UserTypeEnum.COMPANY.getCode(), createUserType)
//                    ) {
//                objectVo.getResult().setSiteId(ownerUser.getResult().getSiteId());
//            }
//            //TODO by jeremy 给名字加上对应后缀(临时后缀，在该账号建立站点时，会将站点code同步到相应账号名下，总代除外)
//            String splitName = ownerUser.getResult().getUsername();
//            if (splitName.contains("@")) {
//                splitName = splitName.substring(splitName.indexOf("@"));
//                objectVo.getResult().setUsername(objectVo.getResult().getUsername() + splitName);
//            }
//
//            //设置身份验证码
//            if (!UserTypeEnum.PLAYER.getCode().equals(createUserType)) {
//                //对身份验证码进行DES加密处理
//                String str = GoogleAuthenticator.generateSecretKey();
//                String key = objectVo.getResult().getUsername();
//                String secret = DesTool.encrypt(str, key);
//                objectVo.getResult().setAuthenticationKey(secret);
//            }
//
//            if (ownerUser.getResult().getId() == 0) {
//                objectVo.getResult().setParentIds(ownerUser.getResult().getId().toString());
//                objectVo.getResult().setParentNames(ownerUser.getResult().getUsername());
//            } else {
//                objectVo.getResult().setParentIds(ownerUser.getResult().getId() + "," + ownerUser.getResult().getParentIds());
//                objectVo.getResult().setParentNames(ownerUser.getResult().getUsername() + "," + ownerUser.getResult().getParentNames());
//            }
//        } else {
//            //设置用户上下级关系
//            setOwnerRelation(objectVo);
//        }
//        objectVo = getService().saveSysUser(objectVo);
//        if (objectVo.isSuccess()) {
//            CacheBase.refreshSysUserExtend();
//        }
//        return objectVo;
//    }

    //判断上级是不是api
    public boolean checkAPI(SysUserExtendVo userExtendVo) {
        userExtendVo.getSearch().setId(userExtendVo.getResult().getOwnerId());
        userExtendVo = this.getService().get(userExtendVo);
        if (userExtendVo.getResult() != null) {
            return SubSysCodeEnum.COMPANY.getCode().equals(userExtendVo.getResult().getSubsysCode()) || SubSysCodeEnum.DISTRIBUTOR.getCode().equals(userExtendVo.getResult().getSubsysCode());
        }
        return false;
    }

    /**
     * 更新用户某一选项
     */
    public Map updateOnly(SysUserExtendVo sysUserExtendVo, String property) {
        if (sysUserExtendVo.getResult() == null || sysUserExtendVo.getResult().getId() == null) {
            sysUserExtendVo.setSuccess(false);
            return getVoMessage(sysUserExtendVo);
        }
        sysUserExtendVo.setProperties(property);
        sysUserExtendVo = getService().updateOnly(sysUserExtendVo);
        return getVoMessage(sysUserExtendVo);
    }

    /**
     * 获取编辑账户的角色
     */
    private void getUserRoles(SysUserExtendVo objectVo, Model model) {
        SysUserExtend user = objectVo.getResult();
        if (user == null) return;
        String optionUserType = SessionManager.getSysUserExtend().getUserType();
        boolean isNeedRole = isNeedRoles(user.getUserType(), optionUserType);
        model.addAttribute("isNeedRole", isNeedRole);
        if (isNeedRole) {
            model.addAttribute("roles", getRoles(user.getSubsysCode()));
            model.addAttribute("userRoles", getUserRoles(user.getId()));
        }
    }

    /**
     * 编辑账号时判断是否需要角色
     * 被操作的用户是子账号，并且操作者是boss、股东、商户、总代才显示分配角色功能
     *
     * @param userType       被操作的用户类型
     * @param optionUserType 操作用户类型
     */
    private boolean isNeedRoles(String userType, String optionUserType) {
        boolean isNeedRole = false;

        if (UserTypeEnum.BOSS_SUB.getCode().equals(userType) && UserTypeEnum.BOSS.getCode().equals(optionUserType)) {
            isNeedRole = true;
        } else if (UserTypeEnum.SHAREHOLDER_SUB.getCode().equals(userType) && UserTypeEnum.SHAREHOLDER.getCode().equals(optionUserType)) {
            isNeedRole = true;
        } else if (UserTypeEnum.COMPANY_SUB.getCode().equals(userType) && UserTypeEnum.COMPANY.getCode().equals(optionUserType)) {
            isNeedRole = true;
        } else if (UserTypeEnum.DISTRIBUTOR_SUB.getCode().equals(userType) && UserTypeEnum.DISTRIBUTOR.getCode().equals(optionUserType)) {
            isNeedRole = true;
        }

        return isNeedRole;
    }

    /**
     * 获取新增用户的角色
     */
    public void getRoles(Model model) {
        SysUserExtend sysUserExtend = SessionManager.getSysUserExtend();
        String userType = sysUserExtend.getUserType();
        String code = sysUserExtend.getSubsysCode();//用于api去角色
        boolean isNeedRole = false;
        String subSysCode = null;
        if (UserTypeEnum.BOSS.getCode().equals(userType) || UserTypeEnum.BOSS_SUB.getCode().equals(userType)) {
            isNeedRole = true;
        } else if (UserTypeEnum.SHAREHOLDER.getCode().equals(userType)) {
            isNeedRole = true;
            subSysCode = SubSysCodeEnum.SHAREHOLDER.getCode();
        } else if (UserTypeEnum.COMPANY.getCode().equals(userType)) {
            isNeedRole = true;
            subSysCode = code;
        } else if (UserTypeEnum.DISTRIBUTOR.getCode().equals(userType)) {
            isNeedRole = true;
            subSysCode = code;
        }
        if (isNeedRole) {
            if (UserTypeEnum.BOSS_SUB.getCode().equals(userType)) {
                model.addAttribute("roles", bossSubGetRoles());
            } else {
                model.addAttribute("roles", getRoles(subSysCode));
            }
        }
        model.addAttribute("isNeedRole", isNeedRole);
    }

    private List<Map<String, Object>> bossSubGetRoles() {
        so.wwb.creditbox.model.manager.sys.vo.SysRoleListVo sysRoleListVo = new so.wwb.creditbox.model.manager.sys.vo.SysRoleListVo();
        SysUserRoleListVo sysUserRoleListVo = new SysUserRoleListVo();
        sysUserRoleListVo.setProperties(SysUserRole.PROP_ROLE_ID);
        sysUserRoleListVo.setConditions(new Pair<>(SysUserRole.PROP_USER_ID, SessionManagerCommon.getUserId()));
        sysRoleListVo.setReadOnly(true);
        sysRoleListVo.setRoleIdList(ServiceTool.sysUserRoleService().oneSearchProperty(sysUserRoleListVo));
        List<VSysRole> vSysRoles = ServiceTool.vSubAccountService().getUserRoleList(sysRoleListVo);
        List<Map<String, Object>> list = new ArrayList<>();
        for (VSysRole role : vSysRoles) {
            Map<String, Object> map = new HashedMap();
            map.put("id", role.getId());
            map.put("name", role.getName());
            list.add(map);
        }
        return list;
    }

    /**
     * 根据subSysCode获取角色
     */
    public List<Map<String, Object>> getRoles(String subSysCode) {
        SysRoleListVo roleListVo = new SysRoleListVo();
        roleListVo.setProperties(SysRole.PROP_ID, SysRole.PROP_NAME);
        roleListVo.getQuery().setCriterions(new Criterion[]{new Criterion(SysRole.PROP_SUBSYS_CODE, Operator.EQ, subSysCode),
                new Criterion(SysRole.PROP_SITE_ID, Operator.EQ, LotteryCommonContext.get().getVirtualSiteId() == null ? SessionManager.getUser().getSiteId() : LotteryCommonContext.get().getVirtualSiteId())});
        return ServiceTool.sysRoleService().searchProperties(roleListVo);
    }

    /**
     * 根据user获取用户角色关系
     */
    private List getUserRoles(Integer userId) {
        SysUserRoleListVo userRoleListVo = new SysUserRoleListVo();
        userRoleListVo.setProperties(SysUserRole.PROP_ROLE_ID);
        userRoleListVo.getQuery().setCriterions(new Criterion[]{new Criterion(SysUserRole.PROP_USER_ID, Operator.EQ, userId)});
        return ServiceTool.sysUserRoleService().searchProperty(userRoleListVo);
    }


    /**
     * 获取用户系统编号
     */
    private String getSubSysCode(String userType) {
        String subSysCode;
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, userType);
        switch (userTypeEnum) {
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
                subSysCode = SessionManager.getSysUserExtend().getSubsysCode();
                break;
        }
        return subSysCode;
    }

    /**
     * 是否有新增权限
     */
    public boolean isAllowCreate() {
        return !UserTypeEnum.DISTRIBUTOR_SUB.getCode().equals(SessionManager.getSysUserExtend().getUserType());
    }

    public String[] getEditUserTypes() {
        String userType = SessionManager.getSysUserExtend().getUserType();
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, userType);
        String[] userTypes = null;
        switch (userTypeEnum) {
            case BOSS:
                userTypes = new String[]{UserTypeEnum.BOSS_SUB.getCode(), UserTypeEnum.SHAREHOLDER.getCode()};
                break;
            case BOSS_SUB:
                userTypes = new String[]{UserTypeEnum.SHAREHOLDER.getCode()};
                break;
            case SHAREHOLDER:
                userTypes = new String[]{UserTypeEnum.SHAREHOLDER_SUB.getCode(), UserTypeEnum.COMPANY.getCode()};
                break;
            case SHAREHOLDER_SUB:
                userTypes = new String[]{UserTypeEnum.COMPANY.getCode()};
                break;
            case COMPANY:
                userTypes = new String[]{UserTypeEnum.COMPANY_SUB.getCode(), UserTypeEnum.DISTRIBUTOR.getCode()};
                break;
            case COMPANY_SUB:
                userTypes = new String[]{UserTypeEnum.DISTRIBUTOR.getCode()};
                break;
            case DISTRIBUTOR:
                userTypes = new String[]{UserTypeEnum.DISTRIBUTOR_SUB.getCode()};
                break;
        }
        return userTypes;
    }

    /**
     * 设置用户上级关系
     */
    private void setOwnerRelation(SysUserExtendVo objectVo) {
        SysUserExtend operator = SessionManager.getSysUserExtend();
        String userType = operator.getUserType();
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, userType);
        Integer ownerId;
        String ownerName;
        String ownerCode;
        String parentIds;
        String parentNames;
        switch (userTypeEnum) {
            case BOSS_SUB:
            case SHAREHOLDER_SUB:
            case COMPANY_SUB:
                ownerId = operator.getOwnerId();
//                ownerName = operator.getOwnerName();
//                parentIds = operator.getParentIds();
//                parentNames = operator.getParentNames();
//                ownerCode = operator.getOwnerCode();
                break;
            default:
                ownerId = operator.getId();
                ownerName = operator.getUsername();
//                ownerCode = operator.getCode();
                StringBuffer parentIdBuffer = new StringBuffer();
                StringBuffer parentNameBuffer = new StringBuffer();
                parentIdBuffer.append(ownerId);
//                if (StringTool.isNotBlank(operator.getParentIds())) {
//                    parentIdBuffer.append(PARENT_SPILT).append(operator.getParentIds());
//                }
                parentIds = parentIdBuffer.toString();
                parentNameBuffer.append(ownerName);
//                if (StringTool.isNotBlank(operator.getParentNames())) {
//                    parentNameBuffer.append(PARENT_SPILT).append(operator.getParentNames());
//                }
                parentNames = parentNameBuffer.toString();
                break;
        }
        //给名字加上对应后缀
        String splitName = operator.getUsername();
        if (splitName.contains("@")) {
            splitName = splitName.substring(splitName.indexOf("@"));
            objectVo.getResult().setUsername(objectVo.getResult().getUsername() + splitName);
        }
        objectVo.getResult().setOwnerId(ownerId);
//        objectVo.getResult().setOwnerName(ownerName);
//        objectVo.getResult().setParentIds(parentIds);
//        objectVo.getResult().setParentNames(parentNames);
//        objectVo.getResult().setOwnerCode(ownerCode);
        if (!UserTypeEnum.COMPANY.getCode().equals(objectVo.getResult().getUserType())
                && !UserTypeEnum.SHAREHOLDER.getCode().equals(objectVo.getResult().getUserType())
                ) {
            objectVo.getResult().setSiteId(SessionManager.getSiteId());
        }
    }

    /**
     * 根据当前的登录的用户信息,找到旗下的子账号
     */
    public List<Map<String, Object>> querySubCount(SysUserExtendListVo list,List<String> subsysCodes) {
        List<Map<String, Object>> map = null;
        if (list.getResult().size() > 0) {
            List<Integer> idList = new ArrayList<>();
            List<SysUserExtend> listVo1 = list.getResult();
            for (SysUserExtend sysUser : listVo1) {
                idList.add(sysUser.getId());
            }
            Integer[] array = new Integer[idList.size()];
            for (int i = 0; i < idList.size(); i++) {
                array[i] = idList.get(i);
            }
            map = this.getService().queryOwnerIdList(array, subsysCodes);
        }
        return map;
    }

    /**
     * 添加审计日志
     *
     * @param userExtendVo
     * @param request
     * @param logEnum
     */
    public void addAuditLog(SysUserExtendVo userExtendVo, HttpServletRequest request, AuditLogEnum logEnum) {
        try {
            if (userExtendVo.isSuccess()) {
                if (AuditLogEnum.UPDATE_MANAGE_ACCOUNT_STATUS == logEnum) {
                    if (userExtendVo.getSearch().getId() != null) {
                        userExtendVo = this.getService().get(userExtendVo);
                    }
                }
                List<String> params = new ArrayList<>();
                params.add(SessionManager.getSiteId().toString());
                params.add(userExtendVo.getResult().getUsername());
                params.add(AuditAddLogTool.installEnumMsg(UserTypeEnum.class, userExtendVo.getResult().getUserType()));
//                params.add(userExtendVo.getResult().getOwnerName());
                if (AuditLogEnum.UPDATE_MANAGE_ACCOUNT_STATUS == logEnum
                        || AuditLogEnum.UPDATE_MANAGE_ACCOUNT_INFO == logEnum
                        || AuditLogEnum.UPDATE_MANAGE_ACCOUNT_PASSWORD == logEnum) {
                    params.add(AuditAddLogTool.installEnumMsg(SysUserStatus.class, userExtendVo.getResult().getStatus()));
                }
                AuditAddLogTool.addLog(request, logEnum, params);
            }
        } catch (Exception e) {
            LOG.error("保存审计日志失败{0}", e.getMessage());
        }
    }

    /**
     * 多账号查询添加后缀
     * 商户、总代、boss子账号、股东总账号可多账号查询
     *
     * @param listVo
     * @param siteId
     * @return
     */
    protected void splitUsername(SysUserExtendListVo listVo, Integer siteId) {
        String subsysCode = SessionManagerCommon.getSysUserExtend().getSubsysCode();
        if (StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)
                || StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)
                || StringTool.equals(SubSysCodeEnum.DISTRIBUTOR.getCode(), subsysCode)
                || StringTool.equals(SubSysCodeEnum.DISTRIBUTOR.getCode(), subsysCode)
                || StringTool.equals(UserTypeEnum.BOSS_SUB.getCode(), listVo.getSearch().getUserType())
                || StringTool.equals(UserTypeEnum.SHAREHOLDER_SUB.getCode(), listVo.getSearch().getUserType())) {
            List<String> nameList = SysParamTool.executeSplitUsername(SessionManager.getSiteId(), listVo.getSearch().getUsername());
            if (CollectionTool.isNotEmpty(nameList)) {
                listVo.getSearch().setNameList(nameList);
                listVo.getSearch().setUsername(null);
            }
        }
    }

    /**
     * 重置身份验证码
     *
     * @param objectVo
     * @param request
     * @return
     */
    protected Map<String, Object> baseResetAuthenticationKey(VSubAccountVo objectVo, HttpServletRequest request) {
        objectVo.getSearch().setId(objectVo.getResult().getId());
        objectVo.getSearch().setSiteId(objectVo.getResult().getSiteId());
        Map<String, Object> result = new HashMap<>();
        result.put("state", false);
        try {
            String str = GoogleAuthenticator.generateSecretKey();
            LOG.info("Secret key is " + str);
            SysUserVo sysUserVo = new SysUserVo();
            sysUserVo.getSearch().setId(objectVo.getSearch().getId());
            sysUserVo = ServiceTool.sysUserService().get(sysUserVo);
            if (sysUserVo.getResult() != null) {
                //对身份验证码进行DES加密处理
                String key = sysUserVo.getResult().getUsername();
                String secret = DesTool.encrypt(str, key);
                String host = sysUserVo.getResult().getSiteId() + "-" + sysUserVo.getResult().getSubsysCode();
                String url = GoogleAuthenticator.getQRBarcodeURL(sysUserVo.getResult().getUsername(), host, str);
                LOG.info("Please register " + url);
                sysUserVo.getResult().setAuthenticationKey(secret);
                sysUserVo.setProperties(SysUser.PROP_AUTHENTICATION_KEY);
                sysUserVo = ServiceTool.sysUserService().updateOnly(sysUserVo);
                result.put("state", sysUserVo.isSuccess());
                result.put("username", sysUserVo.getResult().getUsername());
                result.put("host", host);
                result.put("secret", str);
                result.put("url", url);
                if (sysUserVo.isSuccess()) {
                    List<String> params = new ArrayList<>();
                    params.add(SessionManager.getSiteId().toString());
                    params.add(sysUserVo.getResult().getUsername());
                    params.add(AuditAddLogTool.installEnumMsg(SubSysCodeEnum.class, sysUserVo.getResult().getSubsysCode()));
                    params.add(sysUserVo.getResult().getOwnerId().toString());
                    params.add(url);
                    AuditAddLogTool.addLog(request, AuditLogEnum.UPDATE_MANAGE_ACCOUNT_AUTHENTICATION_KEY, params);
                }
            }
        } catch (Exception ex) {
            LOG.error(ex, "生产验证码出错");
        }
        return result;
    }

}