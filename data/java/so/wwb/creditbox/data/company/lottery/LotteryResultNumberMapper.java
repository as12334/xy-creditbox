package so.wwb.creditbox.data.company.lottery;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.model.company.lottery.so.LotteryResultNumberSo;

import java.util.List;
import java.util.Map;

/**
 * 彩票开奖号码表数据访问对象
 *
 * @author diego
 * @time 2018-02-11
 */

public interface LotteryResultNumberMapper extends IBaseMapper<LotteryResultNumber, Integer> {


    int batchInsertNotExist(List<LotteryResultNumber> list);

    List<LotteryResultNumber> queryAllLastOpened();

    /**
     * 派彩
     * @param map code expect winrecordjson
     * @return resultValue 执行结果
     */
    String doPayout(Map map);

    /**
     * 重结
     * @param map code expect winrecordjson
     * @return resultValue 执行结果
     */
    String doRecalculate(Map map);

    /**
     * 批量撤单
     * @param resultNumber code expect
     * @return resultValue 执行结果
     */
    String doRevoke (LotteryResultNumber resultNumber);

    /**
     * 批量撤销
     * @param resultNumber code expect
     * @return resultValue 执行结果
     */
    String doRevocation (LotteryResultNumber resultNumber);

    /**
     * 批量调盘
     * @param so
     * @return
     */
    boolean batchUpdateAdjust(LotteryResultNumberSo so);

    /**
     * 批量更新开奖号码
     */
    int batchUpdateExist(List<LotteryResultNumber> list);

    /**
     * 初始化开奖结果
     * @param map initDate:初始化日期 codesStr: 初始化彩种code（eg:cqssc,xyft）
     * @return resultValue 执行结果
     */
    String doInitLotteryResultNumber(Map map);

    int updateOpenResultNum (LotteryResultNumber resultNumber);
}