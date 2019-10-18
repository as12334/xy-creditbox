package so.wwb.lotterybox.service.company.lottery;

import org.soul.service.support.BaseService;
import so.wwb.lotterybox.data.company.lottery.LotteryResultLogMapper;
import so.wwb.lotterybox.iservice.company.lottery.ILotteryResultLogService;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultLog;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultLogListVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultLogVo;

/**
 * 彩票杀率设置服务
 *
 * @author marz
 * @time 2018-3-12 14:13:23
 */
//region your codes 1
public class LotteryResultLogService extends BaseService<LotteryResultLogMapper, LotteryResultLogListVo, LotteryResultLogVo, LotteryResultLog, Integer> implements ILotteryResultLogService {
//endregion your codes 1

    //region your codes 2
    @Override
    public void insertResultLog(LotteryResultLogVo logVo) {
        this.mapper.insertResultLog (logVo.getResult());
    }
    //endregion your codes 2

}