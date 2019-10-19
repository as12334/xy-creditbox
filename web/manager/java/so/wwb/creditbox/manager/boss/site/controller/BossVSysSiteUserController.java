package so.wwb.creditbox.manager.boss.site.controller;

import org.soul.commons.enums.YesNot;
import org.soul.model.log.audit.enums.OpType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.manager.boss.site.form.VSysSiteUserSearchForm;
import so.wwb.creditbox.manager.common.site.controller.BaseVSysSiteUserController;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * 站长管理视图控制器
 *
 * Dick 2018-6-27
 */
@Controller
@RequestMapping("/site/siteBoss")
public class BossVSysSiteUserController extends BaseVSysSiteUserController {

    @Override
    protected String getViewBasePath() {
        return "/boss/site/boss/";
    }

    /**
     * 平台站点管理
     * 根据当前boss账号,管理boss站点信息
     */
    @RequestMapping("/list")
    public String queryVSysSiteUser(VSysSiteUserListVo listVo, VSysSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request){
        listVo.getSearch().setSubsysCode(SubSysCodeEnum.BOSS.getCode());//boss
        return searchVSysSiteUserListVo(listVo, form, result, model, request);
    }

    @RequestMapping("/siteEdit")
    public String loadSysSite(SysSiteVo sysSiteVo, Model model) {
        return edit(sysSiteVo,model);
    }

    @RequestMapping("/updateSiteBoss")
    @ResponseBody
    @Audit(module = Module.DOMAIN,moduleType = ModuleType.SITE_BOSS_UPDATE,opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map updateSiteBoss(SysSiteVo sysSiteVo, HttpServletRequest request) {
        return update(sysSiteVo,request,SITE_BOSS_UPDATE);
    }

}
