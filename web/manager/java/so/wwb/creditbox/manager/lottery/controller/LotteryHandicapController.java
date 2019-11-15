package so.wwb.creditbox.manager.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryHandicapService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryHandicap;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryHandicapListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryHandicapVo;
import so.wwb.creditbox.manager.lottery.form.LotteryHandicapSearchForm;
import so.wwb.creditbox.manager.lottery.form.LotteryHandicapForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 彩种盘口控制器
 *
 * @author block
 * @time 2019-11-15 9:31:35
 */
@Controller
//region your codes 1
@RequestMapping("/lotteryHandicap")
public class LotteryHandicapController extends BaseCrudController<ILotteryHandicapService, LotteryHandicapListVo, LotteryHandicapVo, LotteryHandicapSearchForm, LotteryHandicapForm, LotteryHandicap, Integer> {
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