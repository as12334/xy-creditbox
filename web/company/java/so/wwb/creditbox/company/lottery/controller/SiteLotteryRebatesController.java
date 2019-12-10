package so.wwb.creditbox.company.lottery.controller;

import org.soul.model.log.audit.enums.OpType;
import org.soul.web.controller.BaseCrudController;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.iservice.company.lottery.ISiteLotteryRebatesService;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryRebatesListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryRebatesVo;
import so.wwb.creditbox.company.lottery.form.SiteLotteryRebatesSearchForm;
import so.wwb.creditbox.company.lottery.form.SiteLotteryRebatesForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * 控制器
 *
 * @author block
 * @time 2019-11-12 0:36:34
 */
@Controller
//region your codes 1
@RequestMapping("/siteLotteryRebates")
public class SiteLotteryRebatesController extends BaseCrudController<ISiteLotteryRebatesService, SiteLotteryRebatesListVo, SiteLotteryRebatesVo, SiteLotteryRebatesSearchForm, SiteLotteryRebatesForm, SiteLotteryRebates, Integer> {
//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/lottery/rebate/";
        //endregion your codes 2
    }

    //region your codes 3
    @RequestMapping("/editRebates")
    @Token(generate = true)
    public String editRebates(SiteLotteryRebatesVo vo, Model model , HttpServletRequest request, HttpServletResponse response) {
        vo._setDataSourceId(SessionManagerBase.getSiteId());
        vo.getSearch().setSiteId(SessionManagerBase.getSiteId());
//        vo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        vo = this.getService().initRebatesData(vo);
        vo.setValidateRule(JsRuleCreator.create(SiteLotteryRebatesForm.class));
        model.addAttribute("command",vo);
        return this.getViewBasePath()+"EditRebates";
    }

    @Audit(module = Module.LOTTERY, moduleType = ModuleType.LOTTERY_ODD, opType = OpType.UPDATE)
    @RequestMapping(value = "/saveSiteLotteryRebates", method = RequestMethod.POST)
    @ResponseBody
    public Map saveSiteLotteryRebates(HttpServletRequest request, SiteLotteryRebatesVo siteLotteryRebatesVo) {

        siteLotteryRebatesVo._setDataSourceId(SessionManagerBase.getSiteId());
        siteLotteryRebatesVo.getSearch().setSiteId(LotteryCommonContext.get().getSiteId());
        siteLotteryRebatesVo.getSearch().setHid(LotteryCommonContext.get().getDomainUserHid());
        siteLotteryRebatesVo = this.getService().saveSiteLotteryOdds(siteLotteryRebatesVo);
        return getVoMessage(siteLotteryRebatesVo);

    }
        //endregion your codes 3

}