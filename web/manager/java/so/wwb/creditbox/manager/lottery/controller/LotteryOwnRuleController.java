package so.wwb.creditbox.manager.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryOwnRuleService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOwnRule;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOwnRuleListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOwnRuleVo;
import so.wwb.creditbox.manager.lottery.form.LotteryOwnRuleSearchForm;
import so.wwb.creditbox.manager.lottery.form.LotteryOwnRuleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 自主开号规则表控制器
 *
 * @author block
 * @time 2019-11-15 15:39:42
 */
@Controller
//region your codes 1
@RequestMapping("/lotteryOwnRule")
public class LotteryOwnRuleController extends BaseCrudController<ILotteryOwnRuleService, LotteryOwnRuleListVo, LotteryOwnRuleVo, LotteryOwnRuleSearchForm, LotteryOwnRuleForm, LotteryOwnRule, Integer> {
//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/lottery/";
        //endregion your codes 2
    }

    //region your codes 3

    //endregion your codes 3

}