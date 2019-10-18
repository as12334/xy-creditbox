package so.wwb.creditbox.manager.common.site.controller;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.net.ServletTool;
import org.soul.commons.support._Module;
import org.soul.web.controller.NoMappingCrudController;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.sys.IVSysSiteUserService;
import so.wwb.creditbox.manager.boss.site.form.VSysSiteUserForm;
import so.wwb.creditbox.manager.boss.site.form.VSysSiteUserSearchForm;
import so.wwb.creditbox.model.enums.sys.SysSiteStatusEnum;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteUser;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.AuditAddLogTool;
import so.wwb.creditbox.web.tools.token.TokenHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by ronnie
 * on 17-12-5
 */
public class BaseVSysSiteUserController extends NoMappingCrudController<IVSysSiteUserService, VSysSiteUserListVo, VSysSiteUserVo,VSysSiteUserSearchForm, VSysSiteUserForm, VSysSiteUser, Integer> {

    private static final org.soul.commons.log.Log LOG = org.soul.commons.log.LogFactory.getLog(BaseVSysSiteUserController.class);
    protected static final String SYS_SITE_LOGOPATH = "Logo/1/1459172297237.png";
    protected static final String SITE_BOSS_UPDATE = "site.boss.update";
    protected static final String SITE_BOSS_STATUS = "site.boss.status";

    protected static final String SITE_UPDATE = "site.update";

    protected static final String SITE_SH_UPDATE = "site.sh.update";
    protected static final String SITE_SH_STATUS = "site.sh.status";

    protected static final String SITE_ME_UPDATE = "site.me.update";
    protected static final String SITE_ME_STATUS = "site.me.status";


    @Override
    protected String getViewBasePath() {
        return null;
    }


    protected String searchVSysSiteUserListVo(VSysSiteUserListVo listVo, VSysSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request){
        VSysSiteUserListVo cmd = super.doList(listVo, form, result, model);
        model.addAttribute("command", cmd);
        if (ServletTool.isAjaxSoulRequest(request)) {
            return getViewBasePath() + "IndexPartial";
        } else {
            return getViewBasePath() + "Index";
        }
    }

    protected String edit(SysSiteVo sysSiteVo, Model model){
        model.addAttribute("validateRule", JsRuleCreator.create(VSysSiteUserForm.class));
        sysSiteVo = ServiceTool.sysSiteService().get(sysSiteVo);
        if(SYS_SITE_LOGOPATH.equals(sysSiteVo.getResult().getLogoPath())){
            sysSiteVo.getResult().setLogoPath("");//默认的图片不显示
        }
        model.addAttribute("command", sysSiteVo);
        return getViewBasePath() + "Edit";
    }

    protected Map updateStatus(SysSiteVo siteVo, HttpServletRequest request, String str){
        Map<String, Object> map = new HashMap<>(4);
        if(siteVo.getResult()==null){
            map.put(TokenHandler.TOKEN_VALUE,TokenHandler.generateGUID());
            map.put("msg", "更新失败");
            map.put("state", false);
            return map;
        }
        siteVo = updateSiteStatus(siteVo);
        Cache.refreshSysSite();
        Cache.refreshSiteDomain();
        if (siteVo.isSuccess()){
            addAuditLog(siteVo,request,str);
        }
        map.put("state",true);
        map.put("message","更新成功");
        return map;
    }

    protected Map update(SysSiteVo sysSiteVo, HttpServletRequest request, String str){
        HashMap map = new HashMap(4);
        if (sysSiteVo.getResult() == null) {
            map.put(TokenHandler.TOKEN_VALUE,TokenHandler.generateGUID());
            map.put("msg", "保存失败");
            map.put("state", false);
        }else{
            sysSiteVo = updateSite(sysSiteVo);
            addAuditLog(sysSiteVo, request,str);
            map.put("msg", "保存成功");
            map.put("state", true);
        }
        Cache.refreshSysSite();
        Cache.refreshSiteDomain();
        return map;
    }



    public SysSiteVo updateSite(SysSiteVo sysSiteVo){
        if(sysSiteVo.getResult()!=null) {
            String webSite = sysSiteVo.getResult().getWebSite();
            if (StringTool.indexOf(webSite, "http://") != -1) {
                webSite = webSite.substring("http://".length(), webSite.length());
                sysSiteVo.getResult().setWebSite(webSite);
            }
            sysSiteVo.setProperties(SysSite.PROP_REMARK, SysSite.PROP_WEB_SITE, SysSite.PROP_TEMPLATE_CODE);
            ServiceTool.sysSiteService().updateOnly(sysSiteVo);
            if (sysSiteVo.isSuccess()) {
                sysSiteVo.setOkMsg(LocaleTool.tranMessage(_Module.COMMON, "save.success"));
            } else {
                sysSiteVo.setErrMsg(LocaleTool.tranMessage(_Module.COMMON, "save.failed"));
            }
        }
        return sysSiteVo;
    }

    protected SysSiteVo updateSiteStatus(SysSiteVo siteVo){
        Map<String, Object> map = new HashMap<>(1);
        siteVo.getSearch().setId(siteVo.getResult().getId());
        SysSiteVo sysSiteVo = ServiceTool.sysSiteService().get(siteVo);
        String status=  sysSiteVo.getResult().getStatus();
        if (SysSiteStatusEnum.NORMAL.getCode().equals(status)){
            sysSiteVo.getResult().setStatus(SysSiteStatusEnum.STOP.getCode());
        }else if(SysSiteStatusEnum.STOP.getCode().equals(status)){
            sysSiteVo.getResult().setStatus(SysSiteStatusEnum.NORMAL.getCode());
        }
        sysSiteVo.setProperties(SysSite.PROP_STATUS);
        ServiceTool.sysSiteService().updateOnly(sysSiteVo);
        Cache.refreshSysSite();
        Cache.refreshSiteDomain();
        map.put("state", sysSiteVo.isSuccess());
        return sysSiteVo;
    }

    protected void addAuditLog(SysSiteVo sysSiteVo, HttpServletRequest request, String msgKey) {
        try {
            List<String> params = new ArrayList<>();
            params.add(sysSiteVo.getResult().getId().toString());
            if (StringTool.equals(SITE_BOSS_UPDATE,msgKey)||StringTool.equals(SITE_SH_UPDATE,msgKey)||StringTool.equals(SITE_ME_UPDATE,msgKey)){
                params.add(sysSiteVo.getResult().getRemark());
                AuditAddLogTool.addLog(request,msgKey,params);
                return;
            }
            params.add(sysSiteVo.getResult().getName());
            String status = sysSiteVo.getResult().getStatus();
            for (SysSiteStatusEnum statusEnum : SysSiteStatusEnum.values()){
                if (StringTool.equals(statusEnum.getCode(),status)){
                    status = statusEnum.getTrans();
                }
            }
            params.add(status);
            AuditAddLogTool.addLog(request,msgKey,params);
        }catch (Exception e){
            LOG.error("保存审计日志出错{0}",e.getMessage());
        }
    }
}
