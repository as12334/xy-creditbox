package so.wwb.creditbox.manager.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryOddsService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdds;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOddsListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOddsVo;
import so.wwb.creditbox.manager.lottery.form.LotteryOddsSearchForm;
import so.wwb.creditbox.manager.lottery.form.LotteryOddsForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 控制器
 *
 * @author block
 * @time 2019-11-8 0:50:59
 */
@Controller
//region your codes 1
@RequestMapping("/lotteryOdds")
public class LotteryOddsController extends BaseCrudController<ILotteryOddsService, LotteryOddsListVo, LotteryOddsVo, LotteryOddsSearchForm, LotteryOddsForm, LotteryOdds, Integer> {
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