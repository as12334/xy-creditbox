package so.wwb.creditbox.manager.common.site.controller;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.dict.DictTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.net.ServletTool;
import org.soul.web.controller.NoMappingCrudController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.sys.IVSysSiteUserService;
import so.wwb.creditbox.manager.boss.site.form.VSysSiteUserForm;
import so.wwb.creditbox.manager.boss.site.form.VSysSiteUserSearchForm;
import so.wwb.creditbox.model.enums.base.DictEnum;
import so.wwb.creditbox.model.enums.sys.ResolveStatusEnum;
import so.wwb.creditbox.model.manager.site.vo.SiteConfineIpListVo;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.po.VSysDomain;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteUser;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysDomainListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserVo;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: Ronnie
 * @date: 17/11/6
 */
public class BaseDetailController extends NoMappingCrudController<IVSysSiteUserService, VSysSiteUserListVo, VSysSiteUserVo,VSysSiteUserSearchForm, VSysSiteUserForm, VSysSiteUser, Integer> {

    protected String getViewBasePath() {
        return "";
    }

    protected List getDomainTypeEnum(){
        List list = new ArrayList();
//        for(DomainTypeEnum typeEnum :DomainTypeEnum.values()){
//            if(!typeEnum.getCode().equals(DomainTypeEnum.COMPANY.getCode())){
//                list.add(typeEnum);
//            }
//        }
        return list;
    }

    /**
     * 站点信息
     */
    protected String getVSysSiteUserVo(VSysSiteUserVo vSysSiteUserVo, Model model) {
        model.addAttribute("getSiteId", vSysSiteUserVo.getSearch().getId());
        model.addAttribute("mode", DictTool.get(DictEnum.ACCOUNT_MODE));
        VSysSiteUserVo vo = ServiceTool.vSysSiteUserService().search(vSysSiteUserVo);
        //得到每个站点的昨天 商户详情跑函数用
        if(vo.getResult() != null){
            // 开站月份差
            Date openingTime = vo.getResult().getOpeningTime();
            if (openingTime != null) {
                timeDifference(model, openingTime);
            }
            String time = DateTool.formatDate(new Date(), TimeZone.getTimeZone(vo.getResult().getTimezone()),DateTool.yyyy_MM_dd);
            Date date = DateTool.parseDate(time,DateTool.yyyy_MM_dd);
            model.addAttribute("date", DateTool.addDays(date,-1));
        }
        model.addAttribute("command", vo);
        return getViewBasePath() + "View";
    }

    /**
     * 获取开站时间差
     * @param model
     * @param openingTime
     */
    private void timeDifference(Model model, Date openingTime) {
        Date date = new Date();
        SimpleDateFormat simpley=new SimpleDateFormat("yyyy");
        SimpleDateFormat simpleM=new SimpleDateFormat("MM");
        SimpleDateFormat simpled=new SimpleDateFormat("dd");
        Integer datey = Integer.valueOf(simpley.format(date));
        Integer dateM = Integer.valueOf(simpleM.format(date));
        Integer dated = Integer.valueOf(simpled.format(date));
        Integer openingTimey = Integer.valueOf(simpley.format(openingTime));
        Integer openingTimeM = Integer.valueOf(simpleM.format(openingTime));
        Integer openingTimed = Integer.valueOf(simpled.format(openingTime));
        Integer year=datey-openingTimey;
        Integer month=dateM-openingTimeM;
        if(dateM<openingTimeM){
            year-=1;
            month+=12;
        }
        if(dated<openingTimed){
            month-=1;
            if(month<0){
                year-=1;
                month=11;
            }
        }
        model.addAttribute("years", year);
        model.addAttribute("months", month);
    }

    protected List getResolveStatusEnums(){
        List list = new ArrayList();
        for(ResolveStatusEnum statusEnum :EnumTool.getEnumList(ResolveStatusEnum.class)){
            if(!ResolveStatusEnum.BOUNDED.getCode().equals(statusEnum.getCode())){
                list.add(statusEnum);
            }
        }
        return list;
    }

    /**
     * 域名网址
     */
    public void viewDomain(VSysDomainListVo vSysDomainListVo, Model model) {
        model.addAttribute("domainResolvestatus", getResolveStatusEnums());
        vSysDomainListVo = ServiceTool.vSysDomainService().search(vSysDomainListVo);
        if(CollectionTool.isNotEmpty(vSysDomainListVo.getResult())){
            for(VSysDomain site:vSysDomainListVo.getResult()){
//                if (site.getIsTemp() != null && site.getIsTemp()) {
//                    if (DateTool.addDays(site.getCreateTime(), Const.Domain_Temp_Can_Use_Days).before(new Date())) {
//                        site.setTimeOut("true");
//                    }
//                }
            }
        }
        model.addAttribute("command", vSysDomainListVo);
        model.addAttribute("getSiteId", vSysDomainListVo.getSearch().getSiteId());
    }

    /**
     * 登录白名單
     */
    @RequestMapping("/viewWhiteList")
    public String viewWhiteList(SiteConfineIpListVo listVo, Model model, HttpServletRequest request) {
        Map<String, Serializable> map = DictTool.get(DictEnum.SETTING_SITE_CONFINE_STATUS);
        map.remove("wait");
        model.addAttribute("stateMap", map);
        listVo.getSearch().setSiteId(listVo.getSearch().getId());
        listVo.getSearch().setType("1");
        listVo = ServiceTool.siteConfineIpService().search(listVo);
        model.addAttribute("command", listVo);
        // 共同的
        model.addAttribute("getSiteId", listVo.getSearch().getId());
        if (ServletTool.isAjaxSoulRequest(request)) {
            return getViewBasePath() + "PartialWhiteList";
        } else {
            return getViewBasePath() + "ViewWhiteList";
        }

    }

    /**
     * 修改站点模式
     */
    public SysSiteVo updateModes(SysSiteVo syssiteVo) {
        SysSite sysSite = syssiteVo.getResult();
//        if (StringTool.isBlank(sysSite.getMode())) {
//            sysSite.setMode(ModeEnum.LIVE.getCode());
//        }
        syssiteVo.setProperties(SysSite.PROP_MODE);
        syssiteVo = ServiceTool.sysSiteService().updateOnly(syssiteVo);
        return syssiteVo;
    }
}
