package so.wwb.lotterybox.data.manager.lottery;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryResultSo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;

import java.util.List;
import java.util.Map;

/**
 * 开奖结果表数据访问对象
 *
 * @author shook
 * @time 2017-4-9 9:47:30
 */
public interface LotteryResultMapper extends IBaseMapper<LotteryResult, Integer> {

    /**
     * 批量更新开奖号码
     */
    int batchUpdateOpenCode(List<LotteryResult> list);

    /** 查询当前要开奖记录 */
    List<LotteryResult> searchCurLotteryResult();

    /** 根據code查询当前要开奖记录 */
    List<LotteryResult> searchCurLotteryResultByCode(LotteryResultSo lotteryResultSo);

    /**
     * 查询所有彩种的最近一期开奖结果
     */
    List<LotteryResult> queryRecentResult();

    /**
     * 查询未开奖
     */
    List<LotteryResult> queryNoresult(LotteryResultSo search);

    /**
     * 查询最近已开奖的彩票结果
     */
    List<LotteryResult> queryRecentOpenResult(LotteryResultListVo listVo);

    /**
     * 查询当前时间所有彩种盘口
     */
    List<LotteryResult> queryCurHandicap();

    /**
     * 根据归属时间获取开奖结果
     */
    List<LotteryResult> findRecentLotteryResult(LotteryResultSo so);

    boolean batchUpdateAdjust(LotteryResultSo so);

    /**
     * 查询最近一条记录
     */
    LotteryResult queryRecentOneResult(String code);

    LotteryResult searchByCurTime(LotteryResultSo search);

    String queryRecentExpect(LotteryResultSo search);

    /**
     * 查询所有彩种未开奖数据
     */
    List<LotteryResult> queryOpeningData();

    /***
     * 查询已开奖的彩票结果
     */
    List<LotteryResult> queryOpenLottery(List<LotteryResult> list);

    /**
     * 查询当前盘口
     */
    LotteryResult queryHandicapByCurrentTime(LotteryResultSo so);

    /**
     * 查询彩种某一期的开奖号码
     */
    String searchOpenCode(LotteryResult lotteryResult);

    List<LotteryResult> queryAllHandicapByCurrentTime(LotteryResultSo so);

    LotteryResult queryLastOpenCodeByCode(String code);

    List<LotteryResult> queryHklhcResult(LotteryResultSo so);

    /**
     * 根据彩种(codes)查询已开奖的开奖结果,用于同步开奖结果
     * @param so 查询条件LotteryResultSo(codes)
     * @return 返回结果为LotteryResult表中数据,使用LotteryResultNumber接收
     */
    List<LotteryResultNumber> querySyncLotteryResult(LotteryResultSo so);

    /**
     * 初始化开奖结果
     * @param map initDate:初始化日期 codesStr: 初始化彩种code（eg:cqssc,xyft）
     * @return resultValue 执行结果
     */
    String doInitLotteryResult(Map map);

}