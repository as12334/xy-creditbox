package so.wwb.creditbox.manager.boss.site.controller;

import org.soul.commons.net.ServletTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.manager.common.site.controller.BaseDetailController;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.manager.sys.vo.VSysDomainListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Ronnie
 * @date: 17-11-6
 */
@Controller
@RequestMapping("/site/companiesSiteDetail")
public class CompaniesSiteDetailController extends BaseDetailController {

    protected String getViewBasePath() {

        return "boss/site/companies/detail/";
    }

    @RequestMapping("/viewSiteCompanies")
    public String viewSiteCompanies(VSysSiteUserVo vSysSiteUserVo, Model model) {
        return getVSysSiteUserVo(vSysSiteUserVo,model);
    }

    @RequestMapping("/viewDomainCompanies")
    public String viewDomainCompanies(VSysDomainListVo vSysDomainListVo, Model model, HttpServletRequest request) {
        model.addAttribute("domainResolvestatus", getResolveStatusEnums());
        vSysDomainListVo.getSearch().setSubsysCode(SubSysCodeEnum.COMPANIES.getCode());
        vSysDomainListVo = ServiceTool.vSysDomainService().search(vSysDomainListVo);//查询股东域名
        model.addAttribute("getSiteId", vSysDomainListVo.getSearch().getSiteId());
        model.addAttribute("command", vSysDomainListVo);
        if (ServletTool.isAjaxSoulRequest(request)) {
            return getViewBasePath() + "PartialDomain";
        } else {
            return getViewBasePath() + "ViewDomain";
        }
    }
}
