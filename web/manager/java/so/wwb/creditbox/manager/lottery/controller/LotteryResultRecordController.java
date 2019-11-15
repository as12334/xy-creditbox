package so.wwb.creditbox.manager.lottery.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultRecordService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResultRecord;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultRecordListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultRecordVo;
import so.wwb.creditbox.manager.lottery.form.LotteryResultRecordSearchForm;
import so.wwb.creditbox.manager.lottery.form.LotteryResultRecordForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 开奖结果记录表控制器
 *
 * @author block
 * @time 2019-11-15 14:17:34
 */
@Controller
//region your codes 1
@RequestMapping("/lotteryResultRecord")
public class LotteryResultRecordController extends BaseCrudController<ILotteryResultRecordService, LotteryResultRecordListVo, LotteryResultRecordVo, LotteryResultRecordSearchForm, LotteryResultRecordForm, LotteryResultRecord, Integer> {
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