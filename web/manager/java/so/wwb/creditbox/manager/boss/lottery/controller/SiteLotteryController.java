package so.wwb.creditbox.manager.boss.lottery.controller;

import org.soul.commons.cache.locale.LocaleTool;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.support._Module;
import org.soul.web.controller.BaseCrudController;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.company.lottery.ISiteLotteryService;
import so.wwb.creditbox.manager.lottery.form.SiteLotteryForm;
import so.wwb.creditbox.manager.lottery.form.SiteLotterySearchForm;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryGenreEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryVo;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.web.cache.Cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 控制器
 *
 * @author River
 * @time 2015-11-4 15:19:03
 */
@Controller
//region your codes 1
@RequestMapping("/siteLottery")
public class SiteLotteryController extends BaseCrudController<ISiteLotteryService, SiteLotteryListVo, SiteLotteryVo, SiteLotterySearchForm, SiteLotteryForm, SiteLottery, Integer> {

    private static final Log LOG = LogFactory.getLog(SiteLotteryController.class);

    private final static String ORDER_URL = "/lottery/manage/OrderLottery";
//endregion your codes 1


    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/lottery/siteLottery/";
        //endregion your codes 2
    }

    @Override
    protected SiteLotteryListVo doList(SiteLotteryListVo listVo, SiteLotterySearchForm form, BindingResult result, Model model) {
        model.addAttribute("validateRule", JsRuleCreator.create(SiteLotteryForm.class));
        if (listVo.getSearch() != null && listVo.getSearch().getSiteId() != null) {
            listVo.getQuery().addOrder(SiteLottery.PROP_ORDER_NUM, Direction.ASC);
            listVo = super.doList(listVo, form, result, model);
        }
        Map<String, SysSite> sysSite = Cache.getSysSite();
        model.addAttribute("sysSite", sysSite);
        return listVo;
    }

    @RequestMapping(value = "/queryLotteryList")
    protected String queryLotteryList(SiteLotteryListVo listVo, SiteLotterySearchForm form, BindingResult result, Model model) {
        model.addAttribute("validateRule", JsRuleCreator.create(SiteLotteryForm.class));
        Map<String, String> lotteryGenre = EnumTool.getCodeMap(LotteryGenreEnum.class);
        model.addAttribute("lotteryGenre", lotteryGenre);
        if (listVo.getSearch() != null && listVo.getSearch().getSiteId() != null) {
            listVo.getQuery().addOrder(SiteLottery.PROP_ORDER_NUM, Direction.ASC);
            listVo = super.doList(listVo, form, result, model);
            if (Cache.getSysSite().get(listVo.getSearch().getSiteId().toString()) != null) {
                String siteCode = Cache.getSysSite().get(listVo.getSearch().getSiteId().toString()).getCode();
                model.addAttribute("siteCode", siteCode);
            }
            model.addAttribute("command", listVo);
            return "/lottery/siteLottery/IndexPartial";
        }
        LotteryListVo lotteryListVo = new LotteryListVo();
        lotteryListVo.setPaging(listVo.getPaging());
        if (StringTool.isNotBlank(listVo.getSearch().getCode())) {
            lotteryListVo.getSearch().setCode(listVo.getSearch().getCode());
        }
        if (StringTool.isNotBlank(listVo.getSearch().getType())) {
            lotteryListVo.getSearch().setType(listVo.getSearch().getType());
        }
        lotteryListVo.getQuery().addOrder(Lottery.PROP_ORDER_NUM, Direction.ASC);
        LotteryListVo search = ServiceTool.lotteryService().search(lotteryListVo);
        Map<String, LotteryTypeEnum> lotteryTypeMap = EnumTool.getEnumMap(LotteryTypeEnum.class);
        model.addAttribute("lotteryType", lotteryTypeMap);
        model.addAttribute("command", search);
        return "/lottery/manage/IndexPartial";
    }

    @RequestMapping("/takeOff")
    public String takeOffLottery(SiteLotteryListVo listVo, SiteLotterySearchForm form, BindingResult result, Model model) {
        if (null != listVo.getSearch().getSiteId()) {
            model.addAttribute("siteId", listVo.getSearch().getSiteId());
            listVo.setPaging(null);
            listVo.getQuery().addOrder(SiteLottery.PROP_ORDER_NUM, Direction.ASC);
            listVo = super.doList(listVo, form, result, model);
            model.addAttribute("command", listVo);
        } else {
            LotteryListVo lotteryListVo = new LotteryListVo();
            lotteryListVo.setPaging(null);
            lotteryListVo.getQuery().addOrder(Lottery.PROP_ORDER_NUM, Direction.ASC);
            model.addAttribute("command", ServiceTool.lotteryService().search(lotteryListVo));
        }
        model.addAttribute("lotteryEnums", EnumTool.getCodeMap(LotteryEnum.class));
        model.addAttribute("status", listVo.getSearch().getStatus());
        return getViewBasePath() + "TakeOff";
    }

    @RequestMapping("/saveTakeOff")
    @ResponseBody
    public Map saveTakeOff(SiteLotteryListVo siteLotteryListVo) {
        Map<String, Object> map = new HashMap<>(2, 1f);
        ArrayList siteLottery = siteLotteryListVo.getSiteLottery();
        if (siteLottery == null) {
            map.put("state", false);
            map.put("msg", LocaleTool.tranMessage(_Module.COMMON, "no.data.takeOff"));
            return map;
        }
        if (null != siteLotteryListVo.getSearch().getSiteId()) {
            int siteId = siteLotteryListVo.getSearch().getSiteId();
            for (int i = 0; i < siteLottery.size(); i++) {//下架单个站点
                int siteLotteryId = Integer.parseInt(siteLottery.get(i).toString());
                SiteLotteryListVo listVo = new SiteLotteryListVo();
                listVo.getSearch().setSiteId(siteId);
                listVo.getSearch().setId(siteLotteryId);
                ServiceTool.siteLotteryService().takeOff(listVo);
                Cache.refreshSiteLottery(siteId);
            }
        } else {//下架全部站点
            for (int i = 0; i < siteLottery.size(); i++) {
                LotteryVo lotteryVo = new LotteryVo();
                lotteryVo.getSearch().setId(Integer.parseInt(siteLottery.get(i).toString()));
                lotteryVo = ServiceTool.lotteryService().search(lotteryVo);
                String code = lotteryVo.getResult().getCode();
                SiteLotteryListVo listVo = new SiteLotteryListVo();
                listVo.getSearch().setCode(code);
                ServiceTool.siteLotteryService().takeOffAllByCode(listVo);
            }
        }
        Map<String, SysSite> sysSites = Cache.getSysSite();
        for (SysSite sysSite : sysSites.values()) {
            int siteId = sysSite.getId();
            if (siteId > 0) {
                Cache.refreshSiteLottery(siteId);
            }
        }


        map.put("state", true);
        map.put("msg", LocaleTool.tranMessage(_Module.COMMON, "takeOff.successful"));
        return map;
    }

    @RequestMapping("/sync")
    public String syncLottery(SiteLotteryListVo listVo, Model model) {

        LotteryListVo lotteryListVo = new LotteryListVo();
        lotteryListVo.setPaging(null);
        lotteryListVo = ServiceTool.lotteryService().search(lotteryListVo);
        lotteryListVo.setPaging(null);
        listVo = ServiceTool.siteLotteryService().search(listVo);
        Map<Object, SiteLottery> siteLotteryMap = CollectionTool.toEntityMap(listVo.getResult(), SiteLottery.PROP_CODE);
        if (null != listVo.getSearch().getSiteId()) {
            model.addAttribute("siteId", listVo.getSearch().getSiteId());
            model.addAttribute("siteLotteryMap", siteLotteryMap);
        }
        model.addAttribute("lotteryEnums", EnumTool.getCodeMap(LotteryEnum.class));
        model.addAttribute("lottery", lotteryListVo);
        return getViewBasePath() + "Sync";
    }

    @RequestMapping("/saveSync")
    @ResponseBody
    public Map saveSync(SiteLotteryListVo siteLotteryListVo) {
        Map<String, Object> map = new HashMap<>(2, 1f);
        ArrayList siteLottery = siteLotteryListVo.getSiteLottery();
        siteLotteryListVo.setPaging(null);
        siteLotteryListVo = ServiceTool.siteLotteryService().search(siteLotteryListVo);
        Map<Object, SiteLottery> siteLotteryMap = CollectionTool.toEntityMap(siteLotteryListVo.getResult(), SiteLottery.PROP_CODE);
        if (siteLottery == null) {
            map.put("state", false);
            map.put("msg", LocaleTool.tranMessage(_Module.COMMON, "no.data.sync"));
            return map;
        }
        for (int i = 0; i < siteLottery.size(); i++) {
            int lotteryId = Integer.parseInt(siteLottery.get(i) == null ? "" : siteLottery.get(i).toString());
            LotteryVo lottery = new LotteryVo();
            lottery.getSearch().setId(lotteryId);
            LotteryVo lotteryVo = ServiceTool.lotteryService().search(lottery);
            SiteLotteryListVo listVo = new SiteLotteryListVo();
            listVo.getSearch().setCode(lotteryVo.getResult().getCode());
            if (null != siteLotteryListVo.getSearch().getSiteId()) {//同步单个站点
                listVo.getSearch().setSiteId(siteLotteryListVo.getSearch().getSiteId());
                ServiceTool.siteLotteryService().sync(listVo);
                Cache.refreshSiteLottery(siteLotteryListVo.getSearch().getSiteId());
            } else {//同步所有彩票站点
                Map<String, SysSite> sysSites = Cache.getSysSite();
                for (SysSite sysSite : sysSites.values()) {
                    int siteId = sysSite.getId();
                    if (siteId > 0) {
                        listVo.getSearch().setSiteId(siteId);
                        listVo.getSearch().setCode(lotteryVo.getResult().getCode());
                        ServiceTool.siteLotteryService().sync(listVo);
                        Cache.refreshSiteLottery(siteId);
                    }
                }

            }

        }

        map.put("state", true);
        map.put("msg", LocaleTool.tranMessage(_Module.COMMON, "sync.successful"));
        return map;
    }

    @RequestMapping(value = "/siteLotteryManage")
    public String lotteryManage(SiteLotteryVo siteLotteryVo, Model model) {
        if (siteLotteryVo.getSearch().getId() == null) {

        }
        siteLotteryVo = getService().get(siteLotteryVo);
        model.addAttribute("command", siteLotteryVo);
        return getViewBasePath() + "Edit";
    }

    @RequestMapping(value = "/changeLotteryStatus")
    @ResponseBody
    public Map changeLotteryStatus(SiteLotteryVo siteLotteryVo) {
        if (siteLotteryVo.getResult() == null || siteLotteryVo.getResult().getId() == null
                || StringTool.isBlank(siteLotteryVo.getResult().getStatus())) {
            siteLotteryVo.setSuccess(false);
            siteLotteryVo.setErrMsg("彩种信息不全");
            return getVoMessage(siteLotteryVo);
        }
        siteLotteryVo.setProperties(Lottery.PROP_STATUS);
        siteLotteryVo = getService().updateOnly(siteLotteryVo);
        Cache.refreshSiteLottery(siteLotteryVo.getResult().getSiteId());
        return getVoMessage(siteLotteryVo);
    }

    @RequestMapping(value = "/changeLotteryGenre")
    @ResponseBody
    public Map changeLotteryGenre(SiteLotteryVo siteLotteryVo) {
        if (siteLotteryVo.getResult() == null || siteLotteryVo.getResult().getId() == null
                || siteLotteryVo.getResult().getGenre() == null) {
            siteLotteryVo.setSuccess(false);
            siteLotteryVo.setErrMsg("彩种信息不全");
            return getVoMessage(siteLotteryVo);
        }
        siteLotteryVo.setProperties(Lottery.PROP_GENRE);
        siteLotteryVo = getService().updateOnly(siteLotteryVo);
        Cache.refreshSiteLottery(siteLotteryVo.getResult().getSiteId());
        return getVoMessage(siteLotteryVo);
    }
    //endregion your codes 3

    @RequestMapping("/orderLottery")
    public String orderLottery(SiteLotteryListVo listVo, SiteLotterySearchForm form, BindingResult result, Integer siteId, Model model) {
        listVo.getQuery().addOrder(Lottery.PROP_ORDER_NUM, Direction.ASC);
        listVo.getSearch().setSiteId(siteId);
        listVo.setPaging(null);
        SiteLotteryListVo siteLotteryListVo = super.doList(listVo, form, result, model);
        model.addAttribute("command", siteLotteryListVo);
        model.addAttribute("siteId", siteId);
        return ORDER_URL;
    }

    @RequestMapping(value = "/saveSiteLotteryOrder", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public boolean saveSiteApiOrder(@RequestBody SiteLotteryVo siteLotteryVo, Integer siteId, Model model) {
        this.getService().saveSiteLotteryOrder(siteLotteryVo);
        Cache.refreshSiteLottery(siteId);
        return true;
    }
}
