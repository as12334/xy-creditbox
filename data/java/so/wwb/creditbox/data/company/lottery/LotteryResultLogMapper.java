package so.wwb.creditbox.data.company.lottery;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultLog;

/**
 * 商户自主彩开奖记录
 *
 * @author rambo
 * @time 2018-9-9 14:13:23
 */
//region your codes 1
public interface LotteryResultLogMapper extends IBaseMapper<LotteryResultLog, Integer> {
//endregion your codes 1

    //region your codes 2
    void insertResultLog (LotteryResultLog resultLog);

    //endregion your codes 2

}