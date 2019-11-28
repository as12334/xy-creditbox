package so.wwb.creditbox.company.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.company.lottery.ILotteryBetOrderService;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderVo;
import so.wwb.creditbox.company.lottery.form.LotteryBetOrderSearchForm;
import so.wwb.creditbox.company.lottery.form.LotteryBetOrderForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 投注记录表控制器
 *
 * @author block
 * @time 2019-11-27 21:11:29
 */
@Controller
//region your codes 1
@RequestMapping("/lotteryBetOrder")
public class LotteryBetOrderController extends BaseCrudController<ILotteryBetOrderService, LotteryBetOrderListVo, LotteryBetOrderVo, LotteryBetOrderSearchForm, LotteryBetOrderForm, LotteryBetOrder, Integer> {
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