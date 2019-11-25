package so.wwb.creditbox.data.manager.lottery;

import org.soul.model.security.privilege.so.SysResourceSo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultSo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;

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

    /**
     * 根据归属时间获取开奖结果
     */
    List<LotteryResult> getCurLotteryResult(LotteryResultSo so);


    /**
     * 查询所有彩种的最近一期开奖结果
     *
     * @return
     */
    List<LotteryResult> queryRecentResult();

    List<LotteryResult> queryRecentOpenResult(LotteryResultListVo listVo);

    List<LotteryResult> queryFiveRecentOpenResult(LotteryResultSo search);

    //endregion your codes 2

}