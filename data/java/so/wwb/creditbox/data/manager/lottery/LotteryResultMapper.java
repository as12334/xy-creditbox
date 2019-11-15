package so.wwb.creditbox.data.manager.lottery;

import org.soul.model.security.privilege.so.SysResourceSo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultSo;

import java.util.List;


/**
 * 开奖结果主表数据访问对象
 *
 * @author block
 * @time 2019-11-15 9:31:52
 */
//region your codes 1
public interface LotteryResultMapper extends IBaseMapper<LotteryResult, Integer> {
//endregion your codes 1

    //region your codes 2
    List<LotteryResult> searchCurLotteryResult(LotteryResultSo search);

    LotteryResult searchByCurTime(LotteryResultSo search);

    List<Integer> queryBossIds(SysResourceSo so);

    //endregion your codes 2

}