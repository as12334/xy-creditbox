package so.wwb.lotterybox.data.manager.lottery;
import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryErrorLog;

/**
 * 彩票失败日志数据访问对象
 *
 * @author steady
 * @time 2018-5-24 14:52:46
 */
public interface LotteryErrorLogMapper extends IBaseMapper<LotteryErrorLog, Integer> {}