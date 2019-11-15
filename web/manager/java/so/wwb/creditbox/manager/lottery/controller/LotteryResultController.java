package so.wwb.creditbox.manager.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.manager.lottery.form.LotteryResultSearchForm;
import so.wwb.creditbox.manager.lottery.form.LotteryResultForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 开奖结果主表控制器
 *
 * @author block
 * @time 2019-11-15 9:31:52
 */
@Controller
//region your codes 1
@RequestMapping("/lotteryResult")
public class LotteryResultController extends BaseCrudController<ILotteryResultService, LotteryResultListVo, LotteryResultVo, LotteryResultSearchForm, LotteryResultForm, LotteryResult, Integer> {
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