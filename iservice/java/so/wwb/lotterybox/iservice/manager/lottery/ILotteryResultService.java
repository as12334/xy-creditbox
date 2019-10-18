package so.wwb.lotterybox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.lottery.po.Lottery;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryResultSo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultVo;

import java.util.List;
import java.util.Map;

public interface ILotteryResultService extends IBaseService<LotteryResultListVo, LotteryResultVo, LotteryResult, Integer> {

    /**
     * 按彩种-期数开奖结果缓存
     * @param vo LotteryVo
     * @return Map<String, List<LotteryResult>>
     */
    Map<String, Map<String, LotteryResult>> load(LotteryResultVo vo);

    /**
     * 根据彩种与期数列表获取开奖结果
     * @param resultListVo
     * @return
     */
    LotteryResultListVo searchByExpects(LotteryResultListVo resultListVo);
    /**
     * 查询当前需开奖的游戏结果
     */
    LotteryResultListVo curLotteryResult(LotteryResultListVo resultListVo);

    /**
     * 查询当前需开奖的游戏结果
     */
    LotteryResultListVo curLotteryResultByCode(LotteryResultSo lotteryResultSo);

    /**
     * 初始化开奖结果
     */
    LotteryResultVo initLotteryResult(LotteryResultVo resultVo);

    /**
     * 同步开奖结果
     */
    LotteryResultListVo doSync(LotteryResultListVo resultVo);

    /**
     * 返回当前时间之前已经开奖的所有彩种盘口
     */
    Map<String,LotteryResult> getCurOpenLotteryResultMap();

    /**
     * 根据彩种返回当前时间之前已经开奖的盘口
     */
    LotteryResult getCurOpenLotteryResult(String code);

    /**
     * 返回当前时间即将封盘的所有彩种盘口
     */
    Map<String,Map<String,Object>> getCurClosingLotteryResultMap(List<Lottery> lotteryList);

    /**
     * 根据彩种返回当前时间即将封盘的盘口
     */
    LotteryResult getCurClosingLotteryResult(String code);

    /**
     * 返回当前时间已经封盘的所有彩种盘口
     */
    Map<String,LotteryResult> getCurClosedLotteryResultMap();

    /**
     * 根据彩种返回当前时间已经封盘的盘口
     */
    LotteryResult getCurClosedLotteryResult(String code);

    /**
     * 返回当前时间即将开奖的所有彩种盘口
     */
    Map<String,LotteryResult> getCurLotteryResultMap();

    /**
     * 根据彩种返回当前时间即将开奖的彩种盘口
     */
    LotteryResult getCurLotteryResult(String code);


    /**
     * 官方彩派彩
     */
    LotteryResultVo officePayout(LotteryResultVo resultVo);

    /**
     * 自主彩彩派彩
     */
    LotteryResultVo ownPayout(LotteryResultVo resultVo);

    /**
     * 官方彩开号
     */
    LotteryResultVo doOpenNumber(LotteryResultVo resultVo);

    /**
     * 弹出开号窗口前的检查
     */
    LotteryResultVo checkOpenNumber(LotteryResultVo resultVo);

    /**
     * 调盘
     */
    LotteryResultVo doAdjust(LotteryResultVo resultVo);

    /**
     * 批量调盘
     */
    LotteryResultVo doBatchAdjust(LotteryResultVo resultVo);

    /**
     * 批量撤单,撤销
     */
    LotteryResultVo doBatchRevo(LotteryResultVo resultVo);

    /**
     * 补采
     */
    LotteryResultVo doMakeUp(LotteryResultVo resultVo);

    /**
     * 获取开奖结果
     */
    LotteryResultVo getOpenCode(LotteryResultVo resultVo);

    /**
     * 重结
     */
    LotteryResultVo doRecalculate(LotteryResultVo resultVo);

   //--------------分隔符---------------------


//    boolean validLotteryResult(LotteryResultVo resultVo);

//    LotteryResultVo saveUpdateLotteryResult(LotteryResultVo lotterResult);

    /**
     * 最近的开彩记录
     */
    List<LotteryResult> queryRecentRecords(LotteryResultListVo listVo);


//    LotteryResultVo openLotteryResult(LotteryResultVo resultVo);

    /**
     * 修改开奖结果时间
     */
    int batchUpdateProperties(LotteryResultVo resultVo);

//    LotteryResultVo buildLotteryResult(LotteryResultVo resultVo);

    /**
     * 查询所有彩种的最近一期开奖结果
     */
    Map<String, LotteryResult> queryRecentResult(LotteryResultVo vo);

    /**
     * 查询未开奖
     */
    List<LotteryResult> queryNoresult(LotteryResultListVo listVo);

    /**
     * 查询最近已开奖的彩票结果
     */
    List<LotteryResult> queryRecentOpenResult(LotteryResultListVo listVo);

    /**
     * 分页查询未开奖记录
     */
    LotteryResultListVo queryNotOpenResult(LotteryResultListVo listVo);


    /**
     * 查询当前时间所有彩种盘口
     */
    List<LotteryResult> queryCurHandicap(LotteryResultVo vo);


    /**
     * 分页查询已开奖记录
     *TODO BY SHOOK TO DEL
     */
    @Deprecated
    LotteryResultListVo queryHaveOpenResult(LotteryResultListVo listVo);


    /**
     * 查询开号结果
     */
    List<LotteryResult> searchLotteryResult(LotteryResultVo lotteryResultVo);

//    /**
//     * 手动派彩或者手动重结
//     * @param resultVo
//     * @return
//     */
//    LotteryResultVo payoutOrHeavyForHand(LotteryResultVo resultVo);

    /**
     * 初始化开奖结果
     */

    LotteryResultVo deleteLotteryResult(LotteryResultVo resultVo);

}