package so.wwb.creditbox.manager.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryRebatesService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryRebates;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryRebatesListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryRebatesVo;
import so.wwb.creditbox.manager.lottery.form.LotteryRebatesSearchForm;
import so.wwb.creditbox.manager.lottery.form.LotteryRebatesForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 控制器
 *
 * @author block
 * @time 2019-11-11 23:05:37
 */
@Controller
//region your codes 1
@RequestMapping("/lotteryRebates")
public class LotteryRebatesController extends BaseCrudController<ILotteryRebatesService, LotteryRebatesListVo, LotteryRebatesVo, LotteryRebatesSearchForm, LotteryRebatesForm, LotteryRebates, Integer> {
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