package so.wwb.creditbox.manager.controller;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.tree.TreeNode;
import org.soul.model.security.privilege.po.VSysUserResource;
import org.soul.model.security.privilege.vo.SysResourceVo;
import org.soul.model.sys.po.SysParam;
import org.soul.model.sys.vo.SysParamVo;
import org.soul.web.controller.BaseIndexController;
import org.soul.web.security.privilege.controller.SysResourceController;
import org.soul.web.session.SessionManagerBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.manager.init.ConfigManager;
import so.wwb.creditbox.manager.session.SessionManager;
import so.wwb.creditbox.model.base.ParamTool;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.SiteParamEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteManage;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageListVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.web.cache.Cache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class IndexController extends BaseIndexController {
    private static final String INDEX_URI = "index";
    private static final String INDEX_CONTENT_URI = "index.include/content";

    @Override
    protected String content(Integer parentId, HttpServletRequest request, HttpServletResponse response, Model model) {
        SysUserExtend sysUserExtend = SessionManager.getSysUserExtend();
        if (sysUserExtend == null) {
            return "";
        }
        SysResourceVo o = new SysResourceVo();
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, sysUserExtend.getUserType());
        switch (userTypeEnum) {
            case BOSS_SUB:
            case COMPANIES:
                o.getSearch().setUserId(SessionManager.getUserId());
            default:
                break;
        }

        o.getSearch().setSubsysCode(ConfigManager.get().getSubsysCode());
        o.getSearch().setParentId(parentId);
        List<TreeNode<VSysUserResource>> menuNodeList = ServiceTool.sysResourceService().getSubMenus(o);
        SysResourceController.loadLocal(menuNodeList);
        model.addAttribute("command", menuNodeList);
        return INDEX_CONTENT_URI;

    }

    @RequestMapping(value = "index")
    protected String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        return INDEX_URI;
    }

    /**
     * 用户所在时区时间
     */
    @RequestMapping(value = "/index/getUserTimeZoneDate")
    @ResponseBody
    public String getUserTimeZoneDate(HttpServletRequest request) {
        SysSiteVo sysSiteVo = new SysSiteVo();
        sysSiteVo.getSearch().setId(SessionManager.getSiteId());
        sysSiteVo = ServiceTool.sysSiteService().get(sysSiteVo);
        TimeZone timeZone = TimeZone.getTimeZone(sysSiteVo.getResult().getTimezone());
        Map<String, Object> map = new HashMap<>(2);
        map.put("dateTimeFromat", CommonContext.getDateFormat().getDAY_SECOND());
        map.put("dateTime", DateTool.formatDate(new Date(), SessionManagerBase.getLocale(), timeZone, CommonContext.getDateFormat().getDAY_SECOND()));
        map.put("time", String.valueOf(System.currentTimeMillis()));
        map.put("timeZone", timeZone.getID());
        return JsonTool.toJson(map);
    }

    @RequestMapping(value = "/siteInfo")
    protected String siteInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<VSysSiteManage> list = ServiceTool.vSysSiteManageService().allSearch(new VSysSiteManageListVo());
        for (VSysSiteManage sysSite : list) {
            sysSite.setName(Cache.getSiteNameBySiteId(sysSite.getId()));
        }
        //list = CollectionTool.groupByProperty(list,VSysSiteManage.PROP_IDC,String.class).get(ConfigManager.get().getIdc());
        model.addAttribute("sites", list);
        return "siteInfo";
    }


    /**
     * 查询boss设置声音
     *
     * @author faker
     * @date 7/24/17
     */
    @RequestMapping("/index/queryTones")
    @ResponseBody
    public Collection<SysParam> queryTones() {
        Collection<SysParam> sysParams = ParamTool.getSysParams(SiteParamEnum.WARMING_TONE_GATHER);
        for (SysParam param : sysParams) {
            //如果参数设置不启用，则不启用
            if (!param.getActive()) {
                continue;
            }
            if (SiteParamEnum.WARMING_TONE_GATHER.getCode().equals(param.getParamCode()) && SessionManager.getGatherVoiceNotice() != null) {
                param.setActive(SessionManager.getGatherVoiceNotice());
            }
//            if (SiteParamEnum.WARMING_TONE_BILL.getCode().equals(param.getParamCode()) && SessionManager.getBillVoiceNotice() != null) {
//                param.setActive(SessionManager.getBillVoiceNotice());
//            }
//
//            //存取款
//            if (SiteParamEnum.WARMING_TONE_DEPOSIT.getCode().equals(param.getParamCode()) && SessionManager.getCompanyVoiceNotice() != null) {
//                param.setActive(SessionManager.getCompanyVoiceNotice());
//            }
//            if (SiteParamEnum.WARMING_TONE_ONLINEPAY.getCode().equals(param.getParamCode()) && SessionManager.getOnlineVoiceNotice() != null) {
//                param.setActive(SessionManager.getOnlineVoiceNotice());
//            }
//            if (SiteParamEnum.WARMING_TONE_SYSDEPOSIT.getCode().equals(param.getParamCode()) && SessionManager.getSysdepositVoiceNotice() != null) {
//                param.setActive(SessionManager.getSysdepositVoiceNotice());
//            }
//            if (SiteParamEnum.WARMING_TONE_DRAW.getCode().equals(param.getParamCode()) && SessionManager.getDrawVoiceNotice() != null) {
//                param.setActive(SessionManager.getDrawVoiceNotice());
//            }
//            if (SiteParamEnum.WARMING_TONE_SYSDRAW.getCode().equals(param.getParamCode()) && SessionManager.getSysdrawVoiceNotice() != null) {
//                param.setActive(SessionManager.getSysdrawVoiceNotice());
//            }
        }
        return sysParams;
    }

    @RequestMapping("/index/showPop")
    @ResponseBody
    public Map showPop() {
        Map result = new HashMap();
        SysParamVo sysParamVo = getSysParamVo();
        if (sysParamVo.getResult() == null) {
            insertPersonParam(sysParamVo);
            result.put("isShow", "true");
        } else {
            result.put("isShow", sysParamVo.getResult().getParamValue());
        }

        return result;
    }

    @RequestMapping("/index/savePersonShowpop")
    @ResponseBody
    public Map savePersonShowpop(String isShow) {
        Map result = new HashMap();
        try {
            SysParamVo sysParamVo = getSysParamVo();
            if (sysParamVo.getResult() == null) {
                sysParamVo.getSearch().setParamValue(isShow);
                insertPersonParam(sysParamVo);
            } else {
                sysParamVo.getResult().setParamValue(isShow);
                sysParamVo.setProperties(SysParam.PROP_PARAM_VALUE);
                ServiceTool.siteSysParamService().updateOnly(sysParamVo);
            }
            result.put("state", true);
        } catch (Exception ex) {
            result.put("state", false);
        }

        return result;
    }


    private SysParamVo getSysParamVo() {
        SysParamVo sysParamVo = new SysParamVo();
        sysParamVo.getSearch().setModule(Module.MASTER_SETTING.getCode());
//        sysParamVo.getSearch().setParamType(SiteParamEnum.SETTING_SHOWPOP.getType());
        sysParamVo.getSearch().setParamCode(SessionManager.getUserId().toString());
        sysParamVo = ServiceTool.siteSysParamService().searchByModuleTypeCode(sysParamVo);
        return sysParamVo;
    }

    private void insertPersonParam(SysParamVo sysParamVo) {
        SysParam sysParam = new SysParam();
        sysParam.setModule(Module.MASTER_SETTING.getCode());
//        sysParam.setParamType(SiteParamEnum.SETTING_SHOWPOP.getType());
        sysParam.setParamCode(SessionManager.getUserId().toString());
        if (StringTool.isBlank(sysParamVo.getSearch().getParamValue())) {
            sysParam.setParamValue("true");
        } else {
            sysParam.setParamValue(sysParamVo.getSearch().getParamValue());
        }

        sysParam.setDefaultValue("true");
        sysParam.setActive(true);
        sysParam.setRemark("是否弹窗提醒");
        sysParamVo.setResult(sysParam);
        ServiceTool.siteSysParamService().insert(sysParamVo);
    }
}
