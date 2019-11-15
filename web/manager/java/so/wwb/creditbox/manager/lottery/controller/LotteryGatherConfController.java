package so.wwb.creditbox.manager.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryGatherConfService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryGatherConfListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryGatherConfVo;
import so.wwb.creditbox.manager.lottery.form.LotteryGatherConfSearchForm;
import so.wwb.creditbox.manager.lottery.form.LotteryGatherConfForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 彩票采集接口配置表控制器
 *
 * @author block
 * @time 2019-11-15 10:46:13
 */
@Controller
//region your codes 1
@RequestMapping("/lotteryGatherConf")
public class LotteryGatherConfController extends BaseCrudController<ILotteryGatherConfService, LotteryGatherConfListVo, LotteryGatherConfVo, LotteryGatherConfSearchForm, LotteryGatherConfForm, LotteryGatherConf, Integer> {
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