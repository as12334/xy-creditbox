package so.wwb.creditbox.manager.boss.lottery.controller;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.net.ServletTool;
import org.soul.commons.query.sort.Direction;
import org.soul.web.controller.BaseCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryService;
import so.wwb.creditbox.manager.boss.lottery.form.LotteryForm;
import so.wwb.creditbox.manager.boss.lottery.form.LotterySearchForm;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryGenreEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryHandicapListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryVo;
import so.wwb.creditbox.web.cache.Cache;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * 彩种表控制器
 *
 * @author shook
 * @time 2017-4-7 19:50:21
 */
@Controller
//region your codes 1
@RequestMapping("/lottery/manage")
public class LotteryController extends BaseCrudController<ILotteryService, LotteryListVo, LotteryVo, LotterySearchForm, LotteryForm, Lottery, Integer> {
    //endregion your codes 1
    private final static String ORDER_URL = "/lottery/manage/OrderLottery";

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/lottery/manage/";
        //endregion your codes 2
    }
    //region your codes 3

    @Override
    protected LotteryListVo doList(LotteryListVo listVo, LotterySearchForm form, BindingResult result, Model model) {
        Map<String, LotteryTypeEnum> lotteryTypeMap = EnumTool.getEnumMap(LotteryTypeEnum.class);
        if (listVo.getSearch().getType() != null && !StringTool.equals(listVo.getSearch().getType(), "")) {
            String type = listVo.getSearch().getType();
            for (LotteryTypeEnum entry : lotteryTypeMap.values()) {
                if (entry.getTrans().equals(type)) {
                    listVo.getSearch().setType(entry.getCode());
                }
            }
        }
        if (listVo.getSearch().getCode() != null && !StringTool.equals(listVo.getSearch().getCode(), "")) {
            String code = listVo.getSearch().getCode();
            Map<String, LotteryEnum> map = EnumTool.getEnumMap(LotteryEnum.class);
            for (LotteryEnum entry : map.values()) {
                if (entry.getTrans().equals(code)) {
                    listVo.getSearch().setCode(entry.getCode());
                }
            }
        }
        Map<String, String> lotteryGenre = EnumTool.getCodeMap(LotteryGenreEnum.class);
        model.addAttribute("lotteryType", lotteryTypeMap);
        model.addAttribute("lotteryGenre", lotteryGenre);
        listVo.getQuery().addOrder(Lottery.PROP_ORDER_NUM, Direction.ASC);
        return super.doList(listVo, form, result, model);
    }

    @RequestMapping(value = "/queryLotteryHandicap")
    public String queryLotteryHandicap(LotteryHandicapListVo listVo, Model model, HttpServletRequest request) {
        listVo.setPaging(null);
        //listVo.getQuery().addOrder(LotteryHandicap.PROP_EXPECT, Direction.ASC);
        listVo = ServiceTool.lotteryHandicapService().search(listVo);
        model.addAttribute("command", listVo);
        if (ServletTool.isAjaxSoulRequest(request)) {
            return "/lottery/lotteryhandicap/IndexPartial";
        } else {
            return "/lottery/lotteryhandicap/Index";
        }
    }

    @RequestMapping(value = "/lotteryManage")
    public String lotteryManage(LotteryVo lotteryVo, Model model) {
        if (lotteryVo.getSearch().getId() == null) {

        }
        lotteryVo = getService().get(lotteryVo);
        model.addAttribute("command", lotteryVo);
        return getViewBasePath() + "Edit";
    }

    @RequestMapping(value = "/changeLotteryStatus")
    @ResponseBody
    public Map changeLotteryStatus(LotteryVo lotteryVo) {
        if (lotteryVo.getResult() == null || lotteryVo.getResult().getId() == null
                || StringTool.isBlank(lotteryVo.getResult().getStatus())) {
            lotteryVo.setSuccess(false);
            lotteryVo.setErrMsg("彩种信息不全");
            return getVoMessage(lotteryVo);
        }
        lotteryVo.setProperties(Lottery.PROP_STATUS);
        lotteryVo = getService().updateOnly(lotteryVo);
        Cache.refreshLottery();
        return getVoMessage(lotteryVo);
    }

    @RequestMapping("/orderLottery")
    public String orderLottery(LotteryListVo listVo, LotterySearchForm form, BindingResult result, Model model) {
        listVo.getQuery().addOrder(Lottery.PROP_ORDER_NUM, Direction.ASC);
        listVo.setPaging(null);
        LotteryListVo lotteryListVo = super.doList(listVo, form, result, model);
        model.addAttribute("command", lotteryListVo);
        return ORDER_URL;
    }

    @RequestMapping(value = "/saveLotteryOrder", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public boolean saveSiteApiOrder(@RequestBody LotteryVo lotteryVo, Model model) {
        this.getService().saveLotteryOrder(lotteryVo);
        Cache.refreshLottery();
        Cache.refreshAllSiteLottery();
        return true;
    }

    @RequestMapping(value = "/changeLotteryGenre")
    @ResponseBody
    public Map changeLotteryGenre(LotteryVo lotteryVo) {
        if (lotteryVo.getResult() == null || lotteryVo.getResult().getCode() == null
                || lotteryVo.getResult().getId() == null
                || lotteryVo.getResult().getGenre() == null) {
            lotteryVo.setSuccess(false);
            lotteryVo.setErrMsg("彩种信息不全");
            return getVoMessage(lotteryVo);
        }
        lotteryVo.setProperties(Lottery.PROP_GENRE);
        getService().changeLotteryGenre(lotteryVo);
        Cache.refreshLottery();
        Cache.refreshAllSiteLottery();
        return getVoMessage(lotteryVo);
    }
    //endregion your codes 3

}
