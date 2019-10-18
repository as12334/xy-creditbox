package so.wwb.lotterybox.iservice.manager.lottery;
import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryErrorLog;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryErrorLogListVo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryErrorLogVo;

/**
 * 彩票失败日志服务接口
 *
 * @author steady
 * @time 2018-5-24 14:52:46
 */
public interface ILotteryErrorLogService extends IBaseService<LotteryErrorLogListVo, LotteryErrorLogVo, LotteryErrorLog, Integer> {

}