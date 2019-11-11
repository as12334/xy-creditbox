package so.wwb.creditbox.company.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import so.wwb.creditbox.company.lottery.form.SiteLotteryOddsForm;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.iservice.company.lottery.ISiteLotteryRebatesService;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryRebatesListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryRebatesVo;
import so.wwb.creditbox.company.lottery.form.SiteLotteryRebatesSearchForm;
import so.wwb.creditbox.company.lottery.form.SiteLotteryRebatesForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        vo.getSearch().setSiteId(SessionManagerBase.getSiteId());
        vo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        vo = this.getService().initRebatesData(vo);
        vo.setValidateRule(JsRuleCreator.create(SiteLotteryRebatesForm.class));
        model.addAttribute("command",vo);
        return this.getViewBasePath()+"EditRebates";
    }
    //endregion your codes 3

}