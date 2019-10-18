package so.wwb.lotterybox.data.company.lottery;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.company.lottery.po.BetOrderWin;
import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.lotterybox.model.company.lottery.so.LotteryBetOrderSo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryBetOrderVo;

import java.util.List;
import java.util.Map;


/**
 * 投注记录表数据访问对象
 *
 * @author fei
 * @time 2017-4-8 14:33:26
 */

public interface LotteryBetOrderMapper extends IBaseMapper<LotteryBetOrder, Integer> {


    /**
     * 根据玩法、下注选项获取累加下注金额
     *
     * @param so (expect, userId, code, playCodes, betCodes)
     * @return BetOrders
     */
    List<LotteryBetOrder> sumBetAmountQuota(LotteryBetOrderSo so);

    //region 待删

    /**
     * 投注下单（增加投注记录，增加交易记录，增加玩家投注订单，修改玩家API余额）
     */
    Integer executeBetting(Map<String, Object> params);

    Map queryBetOrderProfit(Map<String, Object> params);

    /**
     * 账户合计（）
     *
     * @param params
     * @return
     */
    String queryBetOrderAccountTotal(Map<String, Object> params);

    /**
     * 获取玩家投注的单项总额
     *
     * @param search
     * @return
     */
    Double getNumQuota(LotteryBetOrderSo search);

    /**
     * 获取玩家投注的单类别单项限额
     *
     * @param search
     * @return
     */
    Double getPlayQuota(LotteryBetOrderSo search);

    int updatePlayerApiBalance(LotteryBetOrder lotteryBetOrder);

    List<Map> lotteryBetOrderReportPaging(Map<String, Object> map);

    long lotteryBetOrderReportCount(Map<String, Object> map);

    List<Integer> queryAllYear();

    Map getReportTotal(Map<String, Object> map);

    List<LotteryBetOrder> billChangeListByOwnerCode(LotteryBetOrderSo so);

    Map<String, Double> distributorBetOrderTotal(LotteryBetOrderSo so);

    int distributorBetOrderCount(LotteryBetOrderSo so);


    /**
     * 查询API注单
     *
     * @param recordParam recordParam
     * @return List<LotteryBetOrder>
     */
//    List<LotteryBetOrder> queryBetOrders(RecordParam recordParam);

    List<LotteryBetOrder> queryBetOrderToUserId(LotteryBetOrderVo vo);

    /**
     * 统计金额
     *
     * @param so
     * @return
     */
    Map<String, String> sumAmount(LotteryBetOrderSo so);

    /**
     * 根据时间段获取注单记录
     *
     * @param map
     * @return
     */
    List<Map> queryLotteryBetOrderByTime(Map<String, Object> map);


    List<LotteryBetOrder> getBetOrderByParentIds(LotteryBetOrderSo so);

    long getBetOrderByParentIdsCount(LotteryBetOrderSo search);

    Map queryBetOrderProfitByParntId(LotteryBetOrderSo search);

    Map<String, Object> queryTotalByStatus(Map<String, Object> map);

    List<Map<String, Object>> getRecentProfit(LotteryBetOrderSo so);

    List<String> getUserNameByExpect(LotteryBetOrderSo so);

    List<Map> getBetAmountByBetNum(LotteryBetOrderSo so);

    List<Map> getProfitByExpects(LotteryBetOrderSo so);

    Double getProfitByExpectsAndUsername(LotteryBetOrderSo so);

    List<BetOrderWin> getAvaliableWinOrder(LotteryBetOrderSo so);

    List<LotteryBetOrder> queryBetOrderByApi(LotteryBetOrderSo so);

    List<Map<String, Object>> findTeamMemberBetOrdersByPayoutTime(LotteryBetOrderSo search);

    List<Map<String, Object>> findTeamMemberBetOrdersTotalByPayoutTime(LotteryBetOrderSo search);

    List<Map<String, Object>> findTeamMemberBetOrdersByPayoutTimeTotalCount(LotteryBetOrderSo search);

    Map<String, Double> queryEffectiveAmount(LotteryBetOrderSo search);

    Map<String, Object> findTeamByPayoutTimeTotal(LotteryBetOrderSo search);

    List<LotteryBetOrder> queryAllStatus(LotteryBetOrderSo search);

    List<LotteryBetOrder> queryAllStatusCount(LotteryBetOrderSo search);

    /**
     * 玩家分析列表
     * 彩种分析列表
     * 按派彩时间查询当前的分析列表
     *
     * @param so {
     *           pageType 页面类型必须指定
     *           queryStartDate not null
     *           queryEndDate not null
     *           }
     * @return List
     */
    List<Map> analysisList(LotteryBetOrderSo so);

    /**
     * 今日注单总计数据
     * @param so{
     *  queryStartDate not null
     *  queryEndDate not null
     * }
     * @return {
     * bet_num_total: 总投注笔数
     * player_num_total: 总投注人数
     * bet_amount_total: 总投注金额
     * rebate_total: 总返点金额
     * effective_trade_amount_total: 总有效投注金额
     * payout_total: 总派彩金额
     * profit_total: 总盈亏
     * }
     */
    Map betOrderTodaySum(LotteryBetOrderSo so);

    /**
     * 分析列表分页
     */
    int analysisListCount(LotteryBetOrderSo so);

    List<LotteryBetOrder> searchPayoutApiOrder(LotteryBetOrderSo so);


    /**
     * 投注记录
     * @param so
     * @return
     */
    List<LotteryBetOrder> queryButorBetOrder(LotteryBetOrderSo so);

    /**
     * 投注记录
     * @param so
     * @return
     */
    int queryButorBetOrderCount(LotteryBetOrderSo so);


    //endregion
}