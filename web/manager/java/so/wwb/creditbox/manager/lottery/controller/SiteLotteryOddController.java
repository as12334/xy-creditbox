package so.wwb.creditbox.manager.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.manager.lottery.ISiteLotteryOddService;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdd;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddVo;
import so.wwb.creditbox.manager.lottery.form.SiteLotteryOddSearchForm;
import so.wwb.creditbox.manager.lottery.form.SiteLotteryOddForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 赔率设置表控制器
 *
 * @author block
 * @time 2019-10-21 22:52:08
 */
@Controller
//region your codes 1
@RequestMapping("/siteLotteryOdd")
public class SiteLotteryOddController extends BaseCrudController<ISiteLotteryOddService, SiteLotteryOddListVo, SiteLotteryOddVo, SiteLotteryOddSearchForm, SiteLotteryOddForm, SiteLotteryOdd, Integer> {
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