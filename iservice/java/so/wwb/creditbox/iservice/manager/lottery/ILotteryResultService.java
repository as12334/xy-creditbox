package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import org.soul.model.security.privilege.vo.SysResourceListVo;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 开奖结果主表服务接口
 *
 * @author block
 * @time 2019-11-15 9:31:52
 */
//region your codes 1
public interface ILotteryResultService extends IBaseService<LotteryResultListVo, LotteryResultVo, LotteryResult, Integer> {
    //region your codes 2
//endregion your codes 1

    Map<String, Map<String, LotteryResult>> load(LotteryResultVo vo);

    //region your codes 2
    Boolean doInitLotteryJob(Date initDate);

    List<LotteryResult> searchCurLotteryResult(LotteryResultVo resultVo);

    void saveLotterResult(LotteryResultVo lotterResultVo);

    LotteryResultVo openLotteryResult(LotteryResultVo resultVo);

    @Transactional
    LotteryResultVo buildLotteryResult(LotteryResultVo resultVo);

    List<Integer> queryBossIds(SysResourceListVo listVo);

    LotteryResult searchByCurTime(LotteryResultVo resultVo);

    boolean validLotteryResult(LotteryResultVo resultVo);

    LotteryResultVo saveUpdateLotteryResult(LotteryResultVo resultVo);

    /**
     * 查询所有彩种的最近一期开奖结果
     */
    List<LotteryResult> queryRecentResult(LotteryResultVo vo);

    List<LotteryResult> queryRecentOpenResult(LotteryResultListVo lotteryResultListVo);

    /**
     * 查询最近5期已开奖
     * @param lotteryResultVo
     * @return
     */
    List<LotteryResult> queryFiveRecentOpenResult(LotteryResultVo lotteryResultVo);

    //endregion your codes 2

}