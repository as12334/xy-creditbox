package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryWinningRecordService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.service.company.handler.LotteryResultHandleFactory;
import so.wwb.creditbox.service.company.handler.WinningRecordHandleVo;

import java.util.List;


/**
 * 中奖记录表服务
 *
 * @author shook
 * @time 2017-4-9 9:27:40
 */
//region your codes 1
public class LotteryWinningRecordService implements ILotteryWinningRecordService {
//endregion your codes 1

    //region your codes 2
    private static final Log LOG = LogFactory.getLog(LotteryWinningRecordService.class);

    @Override
    public List<LotteryWinningRecord> handleWinningRecords(LotteryResult lotteryResult) {
        LOG.info("开始生成中奖记录,参数:{0}", lotteryResult);
        IWinningRecordHandle winningRecordHandle = LotteryResultHandleFactory.createHandle(lotteryResult.getCode());
        WinningRecordHandleVo winningRecordHandleVo = winningRecordHandle.handle(lotteryResult);
        return winningRecordHandleVo.getLotteryWinningRecordList();
    }
    //endregion your codes 2

}
