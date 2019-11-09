package so.wwb.creditbox.company.lottery.controller;

import org.soul.commons.init.context.Const;
import org.soul.web.controller.BaseCrudController;
import org.soul.web.session.SessionManagerBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.lottery.form.SiteLotteryOddsForm;
import so.wwb.creditbox.company.lottery.form.SiteLotteryOddsSearchForm;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.iservice.manager.lottery.ISiteLotteryOddsService;
import so.wwb.creditbox.model.company.user.vo.VSiteUserVo;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.web.tools.token.Token;

import java.security.SecureRandom;


/**
 * 控制器
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
@Controller
//region your codes 1
@RequestMapping("/siteLotteryOdds")
public class SiteLotteryOddsController extends BaseCrudController<ISiteLotteryOddsService, SiteLotteryOddsListVo, SiteLotteryOddsVo, SiteLotteryOddsSearchForm, SiteLotteryOddsForm, SiteLotteryOdds, Integer> {
//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/lottery/";
        //endregion your codes 2
    }

    //region your codes 3
    @RequestMapping("/set/{code}")
    @Token(generate = true)
    public String createUser4(@PathVariable("code") String code,SiteLotteryOddsVo vo, Model model) {
        vo.getSearch().setCode(code);
        vo.getSearch().setSiteId(SessionManagerBase.getSiteId());
        vo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        vo = this.getService().initData(vo);
        model.addAttribute("command",vo);
        return this.getViewBasePath()+code;
    }
    //endregion your codes 3

}