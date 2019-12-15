package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.data.manager.lottery.LotteryResultExtendMapper;
import so.wwb.creditbox.iservice.company.lottery.ILotteryPayoutLogService;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultPayoutService;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.company.lottery.po.LotteryPayoutLog;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.company.lottery.vo.LotteryPayoutLogVo;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryStatusEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.enums.site.SiteStatusEnum;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResultExtend;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteUser;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by block on 2019/11/30.
 */
public class LotteryResultPayoutService implements ILotteryResultPayoutService {
    private Log LOG = LogFactory.getLog(this.getClass());

    //新重结函数
    private static final String CALL_HEAVY_PAYOUT = "{call lottery_payout_heavy(?,?,?,?,?)}";

    //新派彩函数
    private static final String CALL_LOTTERY_PAYOUT = "{call lottery_payout(?,?,?,?,?)}";

    @Autowired
    private ExecutorService payoutExecutor;

    @Autowired
    ILotteryPayoutLogService lotteryPayoutLogService;

    @Autowired
    LotteryWinningRecordService lotteryWinningRecordService;

    @Autowired
    LotteryResultExtendMapper lotteryResultExtendMapper;

    @Override
    public boolean payoutForAll(LotteryResultVo resultVo) {
        if (isErrorResult(resultVo)) {
            LOG.error("平台自动派彩出错，请检查开奖数据是否正常!");
            return false;
        }
        resultVo.setPayoutSource(1);
        generatePayoutTaskForAll(resultVo);
        return true;
    }

    @Override
    public boolean payoutForOne(LotteryResultVo resultVo) {
        return false;
    }

    @Override
    public boolean heavyForAll(LotteryResultVo resultVo) {
        return false;
    }

    @Override
    public boolean heavyForOne(LotteryResultVo resultVo) {
        return false;
    }
    private void generatePayoutTaskForAll(LotteryResultVo resultVo) {
        Map<String, VSysSiteUser> sysSiteUserMap = CacheBase.getSysSiteUser();
        if (sysSiteUserMap == null || sysSiteUserMap.size() == 0) {
            LOG.error("派彩任务生成失败,需要派彩的站点为空!");
        }
        //再次生成一次中奖结果json字符串
        String winRecordJson = getWinRecordListJson(resultVo.getResult());
        if (StringTool.isEmpty(winRecordJson)) {
            LOG.error("彩票派彩,未存在中奖记录，彩种为{0},期号为{1},开奖结果:{2}", resultVo.getResult().getCode(), resultVo.getResult().getExpect(), resultVo.getResult().getOpenCode());
            return;
        }
        resultVo.setWinRecordJson(winRecordJson);
        LOG.info("自动派彩,彩种为{0},期号为{1},开奖结果:{2}", resultVo.getResult().getCode(), resultVo.getResult().getExpect(), resultVo.getResult().getOpenCode());
        Map<Integer, Future<Integer>> futureMap = new HashMap<>();
        for (Map.Entry<String, VSysSiteUser> entry : sysSiteUserMap.entrySet()) {
            if(entry.getValue().getSubsysCode().equals(SubSysCodeEnum.COMPANY.getCode())){
                Future<Integer> future = submitPayoutTask(resultVo, entry.getValue());
                if (future != null) {
                    futureMap.put(entry.getValue().getId(), future);
                }
            }
        }
        if (MapTool.isNotEmpty(futureMap)) {
            for (Map.Entry<Integer, Future<Integer>> entry : futureMap.entrySet()) {
                try {
                    entry.getValue().get();
                } catch (Exception e) {
                    LOG.error(e, "派彩任务调用异常,siteId:{0},code:{1},expect:{2}", entry.getKey(), resultVo.getResult().getCode(), resultVo.getResult().getExpect());
                }
            }
        }
    }
    /**
     * 开奖数据是否有误
     *
     * @param resultVo
     * @return true:非法结果，false:合法数据
     */
    private boolean isErrorResult(LotteryResultVo resultVo) {
        return resultVo.getResult() == null || StringTool.isBlank(resultVo.getResult().getCode())
                || StringTool.isBlank(resultVo.getResult().getExpect()) || StringTool.isBlank(resultVo.getResult().getOpenCode());
    }
    /**
     * 获取中奖记录列表json字符串
     *
     * @param lotteryResult
     * @return
     */
    private String getWinRecordListJson(LotteryResult lotteryResult) {
        List<Map<String, Object>> list = winRecordListChange(lotteryWinningRecordService.handleWinningRecords(lotteryResult));
        return CollectionTool.isNotEmpty(list) ? JsonTool.toJson(list) : null;
    }
    /**
     * 数据类型切换  符合数据库字段
     *
     * @param list
     * @return
     */
    private List<Map<String, Object>> winRecordListChange(List<LotteryWinningRecord> list) {


        ArrayList<LotteryResultExtend> lotteryResultExtends = new ArrayList<>();


        List<Map<String, Object>> result = new ArrayList<>();
        if (CollectionTool.isNotEmpty(list)) {
            for (LotteryWinningRecord record : list) {
                if (record != null) {
                    Map<String, Object> map = new HashMap<>(5, 1f);
                    //符合数据库查询字段
                    map.put("expect", record.getExpect());
                    map.put("code", record.getCode());
                    map.put("play_code", record.getPlayCode());
                    map.put("bet_code", record.getBetCode());
                    map.put("winning_num", record.getWinningNum());
                    result.add(map);

                    if(record.getType().equals(LotteryTypeEnum.SFC.getCode())){
                        if(record.getBetCode() == LotteryBettingEnum.SUM.getCode()){
                            lotteryResultExtends.add(insert(record));
                        }
                    }
                    else if(record.getType().equals(LotteryTypeEnum.PK10.getCode())){
                        if(record.getBetCode().equals(LotteryBettingEnum.RANK_ONE_TWO_SUM.getCode())
                                || record.getPlayCode().equals(LotteryPlayEnum.DRAGON_TIGER_TIE.getCode())){
                            lotteryResultExtends.add(insert(record));
                        }
                    }
                    else if(record.getType().equals(LotteryTypeEnum.SSC.getCode())){
                        if(record.getBetCode().equals(LotteryBettingEnum.ONE_COMBINATION.getCode())
                                ||record.getBetCode().equals(LotteryBettingEnum.SUM_DRAGON_TIGER_TIE.getCode())){
                            lotteryResultExtends.add(insert(record));
                        }
                    }

                }
            }
        }
        lotteryResultExtendMapper.batchInsert(lotteryResultExtends);
        return result;
    }
    private LotteryResultExtend insert(LotteryWinningRecord record) {
        LotteryResultExtend lotteryResultExtend = new LotteryResultExtend();
        lotteryResultExtend.setResultId(record.getId());
        lotteryResultExtend.setCode(record.getCode());
        lotteryResultExtend.setExpect(record.getExpect());
        lotteryResultExtend.setBetCode(record.getBetCode());
        lotteryResultExtend.setPlayCode(record.getPlayCode());
        lotteryResultExtend.setBetNum(record.getWinningNum());
        return lotteryResultExtend;
    }

    /**
     * 提交派彩任务
     *
     * @param resultVo
     * @param site
     */
    private Future<Integer> submitPayoutTask(LotteryResultVo resultVo, VSysSiteUser site) {
        if (checkPayoutAuto(resultVo, site)) {
            LotteryResultVo vo = new LotteryResultVo();
            vo.setResult(resultVo.getResult());
            vo.setPayoutSource(resultVo.getPayoutSource());
            vo.setSiteId(site.getId());
            vo.setWinRecordJson(resultVo.getWinRecordJson());
            PayoutTask payoutTask = new PayoutTask(vo);
            LOG.info("提交任务前参数:{0},{1},{2}", vo.getSiteId(), vo.getResult().getCode(), vo.getResult().getExpect());
            return payoutExecutor.submit(payoutTask);
        }
        return null;
    }
    /**
     * 判断是否可以自动派彩
     *
     * @param resultVo
     * @param site
     * @return true 可以 false 不行
     */
    private boolean checkPayoutAuto(LotteryResultVo resultVo, VSysSiteUser site) {
        Lottery lottery = CacheBase.getLotteryByCode(resultVo.getResult().getCode());
        SiteLottery siteLottery = CacheBase.getSiteLotteryByCode(String.valueOf(site.getId()), resultVo.getResult().getCode());
        String includeIdc = resultVo.getIncludeIdc();
        boolean flag = (site == null || site.getId() <= 0 || SiteStatusEnum.DISABLED.getCode().equals(site.getStatus()) || SiteStatusEnum.UN_BUILD.getCode().equals(site.getStatus())) ||
                (StringTool.isNotBlank(includeIdc)) ||
                (lottery == null || siteLottery == null || isCantDo (resultVo,lottery,siteLottery));
        LOG.info("彩票派彩,判断是否可以派彩flag:{0},siteId:{1},includeIdc:{2},lotteryStatus:{3},siteLotteryStatus:{4},code:{5},expect:{6}",
                !flag, site == null ? "null" : site.getId(), StringTool.isEmpty(includeIdc) ? "null" : includeIdc, lottery == null ? "null" : lottery.getStatus(),
                siteLottery == null ? "null" : siteLottery.getStatus(), lottery == null ? "null" : lottery.getCode(), resultVo.getResult().getExpect());
        return !flag;
    }
    private boolean isCantDo (LotteryResultVo resultVo, Lottery lottery, SiteLottery siteLottery) {
        if (StringTool.isNotEmpty(resultVo.getPayType()) && "active".equals(resultVo.getPayType())) {
            return false;
        }
        return !LotteryStatusEnum.NORMAL.getCode().equals(lottery.getStatus()) || !LotteryStatusEnum.NORMAL.getCode().equals(siteLottery.getStatus());
    }

    private class PayoutTask implements Callable<Integer> {
        private LotteryResultVo resultVo;

        public PayoutTask(LotteryResultVo resultVo) {
            this.resultVo = resultVo;
        }

        @Override
        public Integer call() throws Exception {
            LOG.info("执行派彩函数的参数：{0}",JsonTool.toJson(resultVo));
            LotteryResult lotteryResult = resultVo.getResult();
            Integer siteId = resultVo.getSiteId();
            CallableStatement cs = null;
            ResultSet rs = null;
            Connection conn = null;
            try {
                LOG.info("派彩入口,参数:{0},{1},{2}", siteId, lotteryResult.getCode(), lotteryResult.getExpect());
                DataSource masterDataSource = DatasourceTool.getDruidDatasource(siteId);
                if (masterDataSource == null) {
                    LOG.error("彩票不派彩,无站点库【{0}】", siteId);
                    return -1;
                }
                DataContext.setDataSource(masterDataSource);
                boolean validRcord = insertPayoutLog(resultVo);
                if (!validRcord) {
                    return -1;
                }
                String lotteryExpect = resultVo.getResult().getExpect();
                String lotteryCode = resultVo.getResult().getCode();
                String lotteryType = resultVo.getResult().getType();

                conn = masterDataSource.getConnection();
                if (resultVo.getPayoutSource() != null && resultVo.getPayoutSource() == 2) {
                    cs = conn.prepareCall(CALL_HEAVY_PAYOUT);
                } else {
                    cs = conn.prepareCall(CALL_LOTTERY_PAYOUT);
                }
                cs.setString(1, lotteryExpect);
                cs.setString(2, lotteryType);
                cs.setString(3, lotteryCode);
                cs.setString(4, lotteryResult.getOpenCode());
                cs.setString(5, resultVo.getWinRecordJson());
                LOG.info("彩票派彩开始,站点ID:{0},code:{1},expect:{2},openCode:{3}",
                        String.valueOf(siteId), lotteryCode, lotteryExpect, lotteryResult.getOpenCode());
                boolean rtn = cs.execute();
                rs = cs.getResultSet();
                String reVal = null;
                if (rtn && rs != null && rs.next()) {
                    reVal = rs.getString(1);
                }
                LOG.info("彩票派彩结束,站点ID:{0},code:{1},expect:{2},openCode:{3},派彩执行结果:{4}", siteId, lotteryCode, lotteryExpect, resultVo.getResult().getOpenCode(), reVal);
            } catch (Exception ex) {
                LOG.error(ex, "彩票派彩异常,站点ID:{0},彩种{1},期号{2},开奖结果{3}.", siteId, lotteryResult.getCode(), lotteryResult.getExpect(), lotteryResult.getOpenCode());
                return -1;
            } finally {
                DatasourceTool.release(conn, cs, rs);
            }
            return 0;
        }

    }
    /**
     * 新增开奖记录
     *
     * @param resultVo
     * @param
     */
    private boolean insertPayoutLog(LotteryResultVo resultVo) {
        Integer siteId = resultVo.getSiteId();
        LotteryResult lotteryResult = resultVo.getResult();
        LotteryPayoutLogVo recordVo = new LotteryPayoutLogVo();
        recordVo.setSuccess(false);
        LotteryPayoutLog payoutLog = new LotteryPayoutLog();
        payoutLog.setCode(lotteryResult.getCode());
        payoutLog.setExpect(lotteryResult.getExpect());
        payoutLog.setOpenCode(lotteryResult.getOpenCode());
        payoutLog.setType(lotteryResult.getType());
        payoutLog.setCreateTime(new Date());
        payoutLog.setPayoutHash(getPayOutHash(siteId, payoutLog));
        recordVo.setResult(payoutLog);
        try {
            recordVo = lotteryPayoutLogService.insert(recordVo);
        } catch (Exception e) {
            LOG.error(e, "开奖太过频繁,参数:{0},{1},{2}", siteId, lotteryResult.getCode(), lotteryResult.getExpect());
        }
        return recordVo.isSuccess();
    }
    private String getPayOutHash(Integer siteId, LotteryPayoutLog payoutLog) {
        int ss = Integer.parseInt(DateTool.formatDate(payoutLog.getCreateTime(), "ss")) / 10;
        String payOutHash = MessageFormat.format("{0}_{1}_{2}_{3}_{4}_{5}", siteId, payoutLog.getType(),
                payoutLog.getCode(), payoutLog.getExpect(), DateTool.formatDate(payoutLog.getCreateTime(), "yyyy-MM-dd HH:mm"), ss);
        return payOutHash;
    }

}
