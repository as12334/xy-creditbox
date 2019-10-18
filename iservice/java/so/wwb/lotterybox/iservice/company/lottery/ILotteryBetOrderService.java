package so.wwb.lotterybox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.bean.AssetsBean;
import so.wwb.lotterybox.model.company.lottery.po.BetOrderWin;
import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryBetOrderVo;

import java.util.List;
import java.util.Map;

/**
 * 投注记录表服务接口
 *
 * @author fei
 * @time 2017-4-8 14:33:26
 */
public interface ILotteryBetOrderService extends IBaseService<LotteryBetOrderListVo, LotteryBetOrderVo, LotteryBetOrder, Integer> {

    /**
     * 按彩种-期数投注记录缓存
     *
     * @param listVo LotteryBetOrderListVo
     */
    Map<String, Map<String, List<LotteryBetOrder>>> load(LotteryBetOrderListVo listVo);
//
//    /**
//     * @param listVo
//     * @return
//     */
//    List<LotteryBetOrder> billChangeListByOwnerCode(LotteryBetOrderListVo listVo);
//
//    Map<String, Double> distributorBetOrderTotal(LotteryBetOrderListVo listVo);
//
//    int distributorBetOrderCount(LotteryBetOrderListVo listVo);
//
//    /**
//     * 撤销,撤单投注记录
//     *
//     * @param betOrderVo
//     * @return
//     */
//    LotteryBetOrderVo revoOrder(LotteryBetOrderVo betOrderVo);
//
//    Map queryBetOrderProfit(LotteryBetOrderListVo listVo);
//
//    /**
//     * 根据时间(派彩时间) 查询资产
//     *
//     * @param listVo
//     * @return
//     */
//    AssetsBean queryBetOrderAccountTotal(LotteryBetOrderListVo listVo);
//
//    /**
//     * API查询注单记录
//     *
//     * @param recordParam recordParam
//     * @return Response
//     */
//    WebJson fetchBetOrders(RecordParam recordParam);
//
//    /**
//     * 获取统计金额
//     *
//     * @param listVo
//     * @return
//     */
//    Map<String, String> sumAmount(LotteryBetOrderListVo listVo);
//
//    /**
//     * 根据时间段获取注单记录
//     * 根据code分组
//     *
//     * @param vo
//     * @return
//     */
//    List<Map> queryLotteryBetOrderByTime(LotteryBetOrderListVo vo, String order, String property);
//
//    Map queryBetOrderProfitByParntId(LotteryBetOrderListVo listVo);
//
//    /**
//     * 根据时间统计(派彩时间) 注单状态
//     *
//     * @param listVo
//     * @return
//     */
//    Map<String, Object> queryTotalByStatus(LotteryBetOrderListVo listVo);
//
//    List<Map<String, Object>> getRecentProfit(LotteryBetOrderListVo listVo);
//
//    // -----------------------------------------------
//
//    /**
//     * 新增投注订单
//     *
//     * @param vo （Order, OrderBean, Terminal）
//     * @return vo (需包含注单ID集合和返点金额)
//     * @author Fei
//     */
//    LotteryBetOrderVo addBetOrder(LotteryBetOrderVo vo);
//
//    List<LotteryBetOrder> sumBetAmountQuota(LotteryBetOrderListVo listVo);
//
//    /**
//     * 根据订单号查询注单
//     *
//     * @param listVo billNo:订单号
//     * @return LotteryBetOrder
//     */
//    List<LotteryBetOrder> getBetOrdersByBillNo(LotteryBetOrderListVo listVo);
//
//    List<Map> lotteryBetOrderReportPaging(LotteryBetOrderListVo listVo);
//
//    long lotteryBetOrderReportCount(LotteryBetOrderListVo listVo);
//
//    Map getReportTotal(LotteryBetOrderListVo listVo);
//
//    /**
//     * 更具ids查询投注记录
//     *
//     * @param listVo ids:投注ids
//     */
//    LotteryBetOrderListVo queryLotteryBetOrderByIds(LotteryBetOrderListVo listVo);
//
//    WebJson fetchHistoryBetOrders(RecordParam historyRecordParam);
//
//    /**
//     * 获取当期下注用户名列表
//     */
//    List<String> getUserNameByExpect(LotteryBetOrderVo vo);
//
//    /**
//     * 获取当期每个号码下注金额
//     */
//    List<Map> getBetAmountByBetNum(LotteryBetOrderVo vo);
//
//    /**
//     * 获取本期玩家盈利前十名
//     */
//    List<Map> getProfitByExpects(LotteryBetOrderVo vo);
//
//    /**
//     * 获取本期玩家盈利前十名
//     */
//    Double getProfitByExpectsAndUsername(LotteryBetOrderVo vo);
//
//    /**
//     * 投注记录列表导出
//     *
//     * @return
//     */
//    LotteryBetOrderListVo queryLotteryBetOrderForExport(LotteryBetOrderListVo lotteryBetOrderListVo);
//
//    /**
//     *
//     */
//    List<BetOrderWin> getAvaliableWinOrder(LotteryBetOrderListVo listVo);
//
//    /**
//     * Api 即时注单  历史注单
//     */
//    List<LotteryBetOrder> queryBetOrderByApi(LotteryBetOrderListVo lotteryBetOrderListVo);
//
//    List<Map<String, Object>> findTeamMemberBetOrdersByPayoutTime(LotteryBetOrderListVo listVo);
//
//    List<Map<String, Object>> findTeamMemberBetOrdersTotalByPayoutTime(LotteryBetOrderListVo listVo);
//
//    Map<String, Double> queryEffectiveAmount(LotteryBetOrderVo lotteryBetOrderVo);
//
//    List<Map<String, Object>> findTeamMemberBetOrdersByPayoutTimeTotalCount(LotteryBetOrderListVo listVo);
//
//    Map<String, Object> findTeamByPayoutTimeTotal(LotteryBetOrderListVo listVo);
//
//    List<LotteryBetOrder> queryAllStatus(LotteryBetOrderListVo listVo);
//
//    List<LotteryBetOrder> queryAllStatusCount(LotteryBetOrderListVo listVo);
//
//
//
//
//    /**
//     * 玩家分析列表
//     * 彩种分析列表
//     * 按派彩时间查询当前的分析列表
//     *
//     * @param listVo search {
//     *               pageType 页面类型必须指定
//     *               queryStartDate not null
//     *               queryEndDate not null
//     *               }
//     * @return List
//     */
//    Map analysisList(LotteryBetOrderListVo listVo);
//
//    /**
//     * 今日注单总计数据
//     *
//     * @param listVo search{
//     *               queryStartDate not null
//     *               queryEndDate not null
//     *               }
//     * @return {
//     * bet_num_total: 总投注笔数
//     * player_num_total: 总投注人数
//     * bet_amount_total: 总投注金额
//     * rebate_total: 总返点金额
//     * effective_trade_amount_total: 总有效投注金额
//     * payout_total: 总派彩金额
//     * profit_total: 总盈亏
//     * }
//     */
//    Map betOrderTodaySum(LotteryBetOrderListVo listVo);
//
//
//    /**
//     * 派彩 注单推送查询
//     * @param listVo search{
//     *                    code not null
//     *                    expect not null
//     *                    siteId not null
//     *                    status  彩种状态
//     *                    payout  派彩金额
//     *                    }
//     */
//    List<LotteryBetOrder> searchPayoutApiOrder(LotteryBetOrderListVo listVo);
//    /**
//     * 投注记录分页
//     * @param lotteryBetOrderListVo
//     * @return
//     */
//    LotteryBetOrderListVo queryButorLotteryBetOrderListVo(LotteryBetOrderListVo lotteryBetOrderListVo);


}