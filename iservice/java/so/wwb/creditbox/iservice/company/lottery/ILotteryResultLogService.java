package so.wwb.creditbox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultLog;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultLogListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultLogVo;


/**
 * 商户彩票杀率设置服务接口
 *
 * @author marz
 * @time 2018-3-12 14:13:23
 */
//region your codes 1
public interface ILotteryResultLogService extends IBaseService<LotteryResultLogListVo, LotteryResultLogVo, LotteryResultLog, Integer> {
//endregion your codes 1

    //region your codes 2
    void insertResultLog (LotteryResultLogVo logVo);
    //endregion your codes 2

}