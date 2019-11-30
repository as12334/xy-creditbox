package so.wwb.creditbox.web.log.controller;

import org.soul.commons.bean.Pair;
import org.soul.commons.dict.DictTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.model.log.audit.enums.OpType;
import org.soul.model.sys.po.SysAuditLog;
import org.soul.model.sys.po.SysDict;
import org.soul.model.sys.vo.SysAuditLogListVo;
import org.soul.model.sys.vo.SysAuditLogVo;
import org.soul.web.controller.NoMappingCrudController;
import org.soul.web.session.SessionManagerBase;
import org.springframework.ui.Model;
import so.wwb.creditbox.iservice.manager.common.IAuditLogService;
import so.wwb.creditbox.model.enums.base.*;
import so.wwb.creditbox.model.enums.common.AuditLogPageTypeEnum;
import so.wwb.creditbox.model.enums.sys.SysUserTypeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.web.log.form.SysAuditLogForm;
import so.wwb.creditbox.web.log.form.SysAuditLogSearchForm;
import so.wwb.creditbox.web.tools.KeyTool;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.SysParamTool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 系统日志基类
 * Created by jeremy on 18-11-23.
 */
public class BaseAuditLogController extends NoMappingCrudController<IAuditLogService, SysAuditLogListVo, SysAuditLogVo,
        SysAuditLogSearchForm, SysAuditLogForm, SysAuditLog, String> {

    private static List<Pair<String, String>> keys;

    static {
        keys = new ArrayList<>();
        keys.add(new Pair<>("search.operator", "角色账号"));
        keys.add(new Pair<>("search.ip", "IP 地址"));
    }

    protected Log LOG = LogFactory.getLog(BaseAuditLogController.class);

    @Override
    protected String getViewBasePath() {
        return null;
    }

    /**
     * 首页框架搭建
     */
    protected String baseLogIndex(SysAuditLogListVo listVo, Model model, Class<? extends BaseAuditLogController> subClass, HttpServletRequest request) {
        setLinkSearch(listVo, model, request);
        model.addAttribute(KeyTool.COMMAND, listVo);
//        model.addAttribute(KeyTool.TOP_MENU, SysParamTool.setTopMenu(AuditLogPageTypeEnum.class, subClass));
        return "Index";
    }

    /**
     * 执行查询日志列表
     */
    protected String executeQueryLogList(SysAuditLogListVo listVo, Model model, HttpServletRequest request) {
        setQuery(listVo, request);
        listVo = this.getService().queryLogs(listVo);
        setModel(listVo, model, request);
        return "IndexPartial";
    }

    /**
     * 审计日志详细
     *
     * @param logVo search.id not null
     */
    protected String baseDescDetail(SysAuditLogVo logVo, Model model, HttpServletRequest request) {
        model.addAttribute(KeyTool.RESULT, this.getService().get(logVo).getResult());
        return "Detail";
    }

    /**
     * 查询参数预装
     */
    private void setQuery(SysAuditLogListVo logListVo, HttpServletRequest request) {
        String roleType = logListVo.getSearch().getRoleType();
        String subsysCode = SessionManagerCommon.getSysUserExtend().getSubsysCode();
        defaultDataSource(logListVo, roleType);
        //除了总控后台， 其他站点查询日志必须传入站点ID
        if (logListVo.getSearch().getSiteId() == null && !StringTool.equals(SubSysCodeEnum.BOSS.getCode(), subsysCode)) {
            logListVo.getSearch().setSiteId(SessionManagerCommon.getSiteId());
        }
        if (StringTool.isBlank(roleType)) {
            logListVo.getSearch().setRoleType(SessionManagerBase.getUser().getSubsysCode());
        }
        if (!ServletTool.isAjaxSoulRequest(request)) {
            if (logListVo.getSearch().getOperatorBegin() == null) {
                logListVo.getSearch().setOperatorBegin(SessionManagerCommon.getDate().addDays(-7));
            }
            if (logListVo.getSearch().getOperatorEnd() == null) {
                logListVo.getSearch().setOperatorEnd(DateTool.addSeconds(SessionManagerCommon.getDate().getTomorrow(), -1));
            }
        }
        if (StringTool.isNotBlank(logListVo.getSearch().getOperator())) {
            if (!StringTool.equals("player", roleType)) {
                String operator = logListVo.getSearch().getOperator() + "@" + SysParamTool.getSiteCode(logListVo._getDataSourceId());
                logListVo.getSearch().setOperator(operator);
            }
        }
        //链接页参数预装(roleType在首页加载时指定)
        String linkSearchOperator = request.getParameter("linkSearchOperator");
        String linkSearchModuleType = request.getParameter("linkSearchModuleType");
        String linkSearchIp = request.getParameter("linkSearchIp");
        if (StringTool.isNotBlank(linkSearchOperator)) {
            logListVo.getSearch().setOperator(linkSearchOperator);
        }
        if (StringTool.isNotBlank(linkSearchModuleType)) {
            logListVo.getSearch().setModuleType(linkSearchModuleType);
        }
        if (StringTool.isNotBlank(linkSearchIp)) {
            logListVo.getSearch().setIp(linkSearchIp);
        }
    }

    /**
     * 页面模型数据预装
     */
    private void setModel(SysAuditLogListVo logListVo, Model model, HttpServletRequest request) {
        String roleType = logListVo.getSearch().getRoleType();
        String subsysCode = SessionManagerCommon.getSysUserExtend().getSubsysCode();
        String operator = logListVo.getSearch().getOperator();
        //ip、账号名搜索类型
        model.addAttribute("keys", keys);
        String searchKey = request.getParameter("keys");
        String linkSearchKeys = request.getParameter("linkSearchKeys");
        if (StringTool.isNotBlank(linkSearchKeys)) {
            model.addAttribute("searchKey", linkSearchKeys);
        } else if (StringTool.isNotBlank(searchKey)) {
            model.addAttribute("searchKey", searchKey);
        } else {
            model.addAttribute("searchKey", "search.operator");
        }
        //填充角色账号的类型、日志类型
        List<Pair<String, String>> roleKeys = new ArrayList<>();
        if (StringTool.equals(SubSysCodeEnum.BOSS.getCode(), roleType)) {
            model.addAttribute("bossModuleType", EnumTool.getEnumList(BoModuleType.class));
            roleKeys.add(new Pair<>(UserTypeEnum.BOSS.getCode(), "总控"));
            roleKeys.add(new Pair<>(UserTypeEnum.BOSS_SUB.getCode(), "总控-子账号"));

        }  else if (StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), roleType)
                || StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), roleType)) {
            if (StringTool.equals(SubSysCodeEnum.BOSS.getCode(), subsysCode)) {
                roleKeys.add(new Pair<>(UserTypeEnum.COMPANY.getCode(), "商户"));
                roleKeys.add(new Pair<>(UserTypeEnum.COMPANY_SUB.getCode(), "商户-子账号"));
            } else if (StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)
                    || StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)) {
                //商户暂时没有單独的总代日志
                roleKeys.add(new Pair<>(UserTypeEnum.COMPANY.getCode(), "商户"));
                roleKeys.add(new Pair<>(UserTypeEnum.COMPANY_SUB.getCode(), "商户-子账号"));
                roleKeys.add(new Pair<>(UserTypeEnum.DISTRIBUTOR.getCode(), "总代"));
                roleKeys.add(new Pair<>(UserTypeEnum.DISTRIBUTOR_SUB.getCode(), "总代-子账号"));
            }
//            if (StringTool.equals(SubSysCodeEnum.BOSS.getCode(), subsysCode)
//                    || StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)) {
//                model.addAttribute("merchantModuleType", EnumTool.getEnumList(MeModuleType.class));
//            } else if (StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)) {
//                model.addAttribute("merchantModuleType", EnumTool.getEnumList(ApiMeModuleType.class));
//            }
        } else if (StringTool.equals(SubSysCodeEnum.DISTRIBUTOR.getCode(), roleType)) {
//            model.addAttribute("distributorModuleType", EnumTool.getEnumList(DiModuleType.class));
            roleKeys.add(new Pair<>(UserTypeEnum.DISTRIBUTOR.getCode(), "总代"));
            roleKeys.add(new Pair<>(UserTypeEnum.DISTRIBUTOR_SUB.getCode(), "总代-子账号"));

        } else if (StringTool.equals("player", roleType)) {
//            if (StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)
//                    || StringTool.equals(SubSysCodeEnum.DISTRIBUTOR.getCode(), subsysCode)) {
//                List<PlModuleType> list = new ArrayList<>();
//                list.add(PlModuleType.PASSPORT_LOGIN);
//                list.add(PlModuleType.PASSPORT_LOGOUT);
//                list.add(PlModuleType.PASSPORT_LOGIN_FAIL);
//                model.addAttribute("playerModuleType", list);
//            } else {
//                model.addAttribute("playerModuleType", EnumTool.getEnumList(PlModuleType.class));
//            }
        }
        if (StringTool.isNotBlank(operator)
                && !StringTool.equals("player", roleType)
                && operator.contains("@")) {
            logListVo.getSearch().setOperator(operator.split("@")[0]);
        }
        model.addAttribute("roleKeys", roleKeys);
        model.addAttribute("opType", getSysDictMap(roleType)); //操作类型
        model.addAttribute(KeyTool.COMMAND, logListVo);
    }

    /**
     * 其他页面链接传递的参数格式
     */
    private void setLinkSearch(SysAuditLogListVo logListVo, Model model, HttpServletRequest request) {
        model.addAttribute("hasReturn", request.getParameter("hasReturn"));
        model.addAttribute("linkSearchRoleType", logListVo.getSearch().getRoleType());
        model.addAttribute("linkSearchOperator", logListVo.getSearch().getOperator());
        model.addAttribute("linkSearchModuleType", logListVo.getSearch().getModuleType());
        model.addAttribute("linkSearchIp", logListVo.getSearch().getIp());
        model.addAttribute("linkSearchKeys", request.getParameter("keys"));
    }

    /**
     * 获取操作类型
     */
    private Map<String, SysDict> getSysDictMap(String roleType) {
        Map<String, SysDict> map = DictTool.get(DictEnum.Log_OpType);
        //过滤掉查看
        map.remove(OpType.QUERY.getTrans());
        if (roleType.equals(SysUserTypeEnum.PLAYER.getCode())) {
            //只留登录，登出，新增，修改
            map.remove(OpType.OTHER.getTrans());
            map.remove(OpType.DELETE.getTrans());
            map.remove(OpType.AUDIT.getTrans());
            map.remove(OpType.RECHARGE.getTrans());
            map.remove(OpType.WITHDRAW.getTrans());
        }
        return map;
    }

    /**
     * 玩家日志走商户库，其他走boss
     */
    private void defaultDataSource(SysAuditLogListVo logListVo, String roleType) {
        Integer sourceId = logListVo._getDataSourceId();
        Integer currentId = SessionManagerCommon.getSiteId();
        if (StringTool.equals("player", roleType)) {
            logListVo._setDataSourceId(sourceId != null ? sourceId : currentId);
            LOG.info("查询[{0}]审计日志切换至站点数据源：{1}", roleType, logListVo._getDataSourceId());
        } else {
            logListVo._setDataSourceId(null);
            LOG.info("查询[{0}]审计日志访问BOSS数据原", roleType);
        }
    }
}
