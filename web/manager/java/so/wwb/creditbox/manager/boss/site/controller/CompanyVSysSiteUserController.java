package so.wwb.creditbox.manager.boss.site.controller;

import org.soul.commons.enums.YesNot;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.support._Module;
import org.soul.model.log.audit.enums.OpType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.manager.boss.site.form.VSysSiteUserSearchForm;
import so.wwb.creditbox.manager.common.site.controller.BaseVSysSiteUserController;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.base.ParamTool;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.enums.base.SiteParamEnum;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserListVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.token.Token;
import so.wwb.creditbox.web.tools.token.TokenHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 商户站点控制器
 *
 * Dick 2018-6-26
 */
@Controller
@RequestMapping("/site/siteCompany")
public class CompanyVSysSiteUserController extends BaseVSysSiteUserController {
    @Override
    protected String getViewBasePath() {
        return "/boss/site/company/";
    }

    @RequestMapping("/list")
    public String queryVSysSiteUser(VSysSiteUserListVo listVo, VSysSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request){
        model.addAttribute("sysParam", ParamTool.getSysParam(SiteParamEnum.SETTING_SYSTEM_SETTINGS_VERIFICATION));
        List<String> list = new ArrayList<>();
        list.add(SubSysCodeEnum.COMPANY.getCode());
        listVo.getSearch().setSubSysCodes(list);
        return searchVSysSiteUserListVo(listVo, form, result, model, request);
    }

    @RequestMapping("/siteEdit")
    @Token(generate = true)
    public String editSysSite(SysSiteVo sysSiteVo, Model model) {
        return edit(sysSiteVo,model);
    }

    /**
     *站点修改
     */
    @RequestMapping("/updateSiteMerChant")
    @ResponseBody
    @Token(valid = true)
    @Audit(module = Module.DOMAIN,moduleType = ModuleType.SITE_COMPANY_UPDATE,opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map updateSiteMerChant(SysSiteVo sysSiteVo,HttpServletRequest request) {
        HashMap map = new HashMap(4);
        if (sysSiteVo.getResult() == null) {
            map.put(TokenHandler.TOKEN_VALUE,TokenHandler.generateGUID());
            map.put("msg", "保存失败");
            map.put("state", false);
            return map;
        }
        //如果logo为空，就给默认值
        if(StringTool.isEmpty(sysSiteVo.getResult().getLogoPath())){
            sysSiteVo.getResult().setLogoPath(SYS_SITE_LOGOPATH);
        }
        sysSiteVo.getResult().setTheme("".equals(sysSiteVo.getResult().getTheme())?"default":sysSiteVo.getResult().getTheme());
        sysSiteVo.getResult().setTemplateCode("".equals(sysSiteVo.getResult().getTemplateCode())?"default":sysSiteVo.getResult().getTemplateCode());
        sysSiteVo.setProperties(
                SysSite.PROP_REMARK,
                SysSite.PROP_WEB_SITE,
                SysSite.PROP_TEMPLATE_CODE,
                SysSite.PROP_LOGO_PATH,
                SysSite.PROP_THEME,
                SysSite.PROP_TITLE,
                SysSite.PROP_NAME
        );
        sysSiteVo = ServiceTool.sysSiteService().updateOnly(sysSiteVo);
        Cache.refreshSysSite();
        Cache.refreshSiteDomain();
        if (sysSiteVo.isSuccess()) {
            sysSiteVo.setOkMsg(LocaleTool.tranMessage(_Module.COMMON, "save.success"));
        } else {
            sysSiteVo.setErrMsg(LocaleTool.tranMessage(_Module.COMMON, "save.failed"));
        }
        addAuditLog(sysSiteVo, request,SITE_COMPANY_UPDATE);
        map.put("msg", "保存成功");
        map.put("state", true);
        return map;
    }



    @RequestMapping("/updateMhSiteStatus")
    @ResponseBody
    @Audit(module = Module.DOMAIN,moduleType = ModuleType.SITE_COMPANY_STATUS,opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map updateMhSiteStatus(SysSiteVo siteVo, HttpServletRequest request) {
        return updateStatus(siteVo,request,SITE_COMPANYE_STATUS);
    }

}
