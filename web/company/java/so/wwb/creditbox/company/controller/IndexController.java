package so.wwb.creditbox.company.controller;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.tree.TreeNode;
import org.soul.model.security.privilege.po.VSysUserResource;
import org.soul.model.security.privilege.vo.SysResourceVo;
import org.soul.model.sys.po.SysParam;
import org.soul.model.sys.vo.SysParamVo;
import org.soul.web.controller.BaseIndexController;
import org.soul.web.security.privilege.controller.SysResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.init.ConfigManager;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteManage;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageListVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class IndexController extends BaseIndexController {
    private static final String INDEX_URI = "Home";
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
            case SHAREHOLDER_SUB:
            case COMPANY_SUB:
            case DISTRIBUTOR_SUB:
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
        SiteLotteryListVo siteLotteryListVo = new SiteLotteryListVo();
        siteLotteryListVo.getSearch().setSiteId(SessionManager.getSiteId());
        siteLotteryListVo._setDataSourceId(SessionManager.getSiteId());
        siteLotteryListVo = ServiceTool.siteLotteryService().search(siteLotteryListVo);
        model.addAttribute("lotterys",siteLotteryListVo.getResult());



        SysResourceVo o = new SysResourceVo();
        SysUserExtend user = SessionManagerCommon.getSysUserExtend();

        if(!StringTool.equals(user.getUserType(),UserTypeEnum.COMPANY.getCode())){
            o.getSearch().setUserId(SessionManagerCommon.getUserId());
        }
        o.getSearch().setSubsysCode(user.getSubsysCode());
        List<TreeNode<VSysUserResource>> menuNodeList = ServiceTool.sysResourceService().getAllMenus(o);

        return INDEX_URI;
    }

    @RequestMapping(value = "/{code}/noopen")
    protected String noopen(@PathVariable String code, HttpServletRequest request, HttpServletResponse response, Model model) {
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class, code);
        LotteryResult lotteryResult = getHandicapOpen(lotteryEnum.getCode());
        lotteryResult.setOpeningTime(DateTool.addMinutes(lotteryResult.getCloseTime(),-20));
        lotteryResult.setCloseTime(new Date());


        model.addAttribute("command",lotteryResult);
        return "Noopen";
    }
    /**
     * 获取所有菜單
     * @return
     */
    @RequestMapping("/fetchAllMenus")
    @ResponseBody
    public String fetchAllMenus() {
        SysResourceVo o = new SysResourceVo();
        SysUserExtend user = SessionManagerCommon.getSysUserExtend();

        if(!StringTool.equals(user.getUserType(),UserTypeEnum.COMPANY.getCode())){
            o.getSearch().setUserId(SessionManagerCommon.getUserId());
        }

        o.getSearch().setSubsysCode(user.getSubsysCode());
        List<TreeNode<VSysUserResource>> menuNodeList = ServiceTool.sysResourceService().getAllMenus(o);
        return JsonTool.toJson(menuNodeList);
    }
    /**
     * 获取彩票当前盘口信息(开奖)
     */
    public LotteryResult getHandicapOpen(String code) {
        List<LotteryResult> lotteryResultList = CacheBase.getLotteryResult(code);
        Date curDate = new Date();
        for (LotteryResult lotteryResult : lotteryResultList) {
            if (curDate.getTime() <= lotteryResult.getOpenTime().getTime()) {
                Long leftTime = DateTool.secondsBetween(lotteryResult.getCloseTime(), curDate);
                lotteryResult.setLeftTime(leftTime);
                lotteryResult.setLeftOpenTime(DateTool.secondsBetween(lotteryResult.getOpeningTime(), curDate));
                return lotteryResult;
            }
        }
        return null;
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
//        Collection<SysParam> sysParams = ParamTool.getSysParams(SiteParamEnum.WARMING_TONE_BILL);
//        for (SysParam param : sysParams) {
//            //如果参数设置不启用，则不启用
//            if (!param.getActive()) {
//                continue;
//            }
//            if (SiteParamEnum.WARMING_TONE_GATHER.getCode().equals(param.getParamCode()) && SessionManager.getGatherVoiceNotice() != null) {
//                param.setActive(SessionManager.getGatherVoiceNotice());
//            }
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
        return null;
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
