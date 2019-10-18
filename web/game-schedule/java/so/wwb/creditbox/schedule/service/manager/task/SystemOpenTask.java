package so.wwb.creditbox.schedule.service.manager.task;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.common.task.CommonTask;
import so.wwb.creditbox.iservice.company.lottery.ILotteryBetOrderService;
import so.wwb.creditbox.iservice.company.lottery.ILotteryResultLogService;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.lottery.LotteryRuleModelEnum;
import so.wwb.creditbox.model.company.lottery.po.*;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultLogVo;
import so.wwb.creditbox.schedule.service.manager.job.LotterySystemJob;
import so.wwb.creditbox.utility.LotteryOwnWinKeyUtility;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 彩票自主彩任务(采集)
 * @author: rambo
 * @time 2018-9-9 20:35:57
 */
public class SystemOpenTask extends CommonTask<LotteryResultLogVo> {
    public static final Log LOG = LogFactory.getLog(SystemOpenTask.class);


    @Autowired
    private ILotteryResultLogService lotteryResultLogService;

    @Autowired
    private ILotteryBetOrderService lotteryBetOrderService;


    //开奖记录
    private LotteryResultLogVo resultLogVo;

    public void setResultLogVo(LotteryResultLogVo resultLogVo) {
        this.resultLogVo = resultLogVo;
    }

    @Override
    public LotteryResultLogVo call() {
        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.resultLogVo._getSiteId());
        if(dataSource == null){
            this.resultLogVo.setSuccess(false);
            this.resultLogVo.setErrMsg("缺少商户数据源");
            LOG.error("SystemOpenTask:彩票开号失败，缺少商户数据源");
            return this.resultLogVo;
        }
        DataContext.setDataSource(dataSource);
        CommonContext.set(new ContextParam());
        CommonContext.get().setSiteId(this.resultLogVo._getSiteId());
        this.resultLogVo = openCode();
        if (this.resultLogVo.getResult() != null && this.resultLogVo.getResult().getResultNum() != null) {
            lotteryResultLogService.insertResultLog(this.resultLogVo);
        }
        if (this.resultLogVo.isSuccess()) {
            LOG.info("SystemOpenTask:彩票开号成功,彩种:{0},期数:{1}",this.resultLogVo.getSearch().getCode(),this.resultLogVo.getSearch().getExpect());
        } else {
           LOG.error("SystemOpenTask:彩票开号失败,原因:{0}",this.resultLogVo.getErrMsg());
        }
        return this.resultLogVo;
    }

    private LotteryResultLogVo openCode(){

        LOG.info("SystemOpenTask:开号:siteId:{0},code:{1},expect:{2}", this.resultLogVo._getSiteId(), this.resultLogVo.getSearch().getCode(), this.resultLogVo.getSearch().getExpect());
        try {
            LotteryRule lotteryRule = CacheBase.getLotteryRule(Integer.toString(this.resultLogVo._getSiteId()),this.resultLogVo.getSearch().getCode());
            if (lotteryRule != null && LotteryRuleModelEnum.BEST.getCode().equals(lotteryRule.getModel()) && lotteryRule.getCountLimit() != null) {
                this.resultLogVo = getBasetResult (lotteryRule);
            }
        } catch (Exception e) {
            LOG.error(e, "SystemOpenTask:彩票开号任务异常,siteId:{0},code:{1},expect:{2}",this.resultLogVo._getSiteId(), this.resultLogVo.getSearch().getCode(), this.resultLogVo.getSearch().getExpect());
            this.resultLogVo.setSuccess(false);
            this.resultLogVo.setErrMsg("彩票开号任务");
        }
        return this.resultLogVo;
    }


    private LotteryResultLogVo getBasetResult (LotteryRule lotteryRule) {
        List<BetOrderWin> list = fetchBetOrder(lotteryRule);
        if (CollectionTool.isEmpty(list)) {
            return this.resultLogVo;
        }
        LOG.info("统计注单数:期数:{0},彩种:{1},注单数量:{2},",this.resultLogVo.getSearch().getExpect(),this.resultLogVo.getSearch().getCode(),list.size());
        Map<String, BetOrderWin> map = list.stream().collect(Collectors.toMap(k->k.getBetCode() + "_" + k.getBetNum(), Function.identity()));
        Double betAmount = list.stream().mapToDouble(BetOrderWin::getBetAmount).sum();
        Map<String,Double> link = new LinkedHashMap<>();
        for (int i = 0; i < lotteryRule.getCountLimit(); i++) {
            List<String> resultList = LotterySystemJob.randomOpenCodes (this.resultLogVo.getSearch().getCode());
            List<String> winList = LotteryOwnWinKeyUtility.handleWinKeyRecords(this.resultLogVo.getSearch().getCode(),resultList);
            Double canWin = computeCanWin (map,winList);
            String openNum = StringTool.join(",", resultList.toArray());
            link.put(openNum,canWin);
        }
        List<Map.Entry<String,Double>> linkList = new ArrayList<>(link.entrySet());
        Collections.sort(linkList, new Comparator<Map.Entry<String,Double>>() {
            public int compare(Map.Entry<String,Double> x, Map.Entry<String,Double> y) {
                return x.getValue().compareTo(y.getValue());
            }
        });
        if (CollectionTool.isNotEmpty(linkList)) {
            initResultLog(linkList);
        }
        return this.resultLogVo;
    }

    private void initResultLog (List<Map.Entry<String,Double>> linkList) {
        LotteryResultLog resultLog = new LotteryResultLog();
        resultLog.setResultNum(linkList.get(0).getKey());
        resultLog.setExpect(this.resultLogVo.getSearch().getExpect());
        resultLog.setCode(this.resultLogVo.getSearch().getCode());
        resultLog.setCreateTime(new Date());
        this.resultLogVo.setResult(resultLog);
        this.resultLogVo._setDataSourceId(this.resultLogVo._getSiteId());
    }

    private List<BetOrderWin> fetchBetOrder(LotteryRule lotteryRule) {
        LotteryBetOrderListVo vo = new LotteryBetOrderListVo();
        vo.getSearch().setCode(this.resultLogVo.getSearch().getCode());
        vo.getSearch().setExpect(this.resultLogVo.getSearch().getExpect());
        vo._setDataSourceId(this.resultLogVo._getSiteId());
        if (StringTool.isNotEmpty(lotteryRule.getUsername())) {
            String[] useNames = lotteryRule.getUsername().split(",");
            List<String> users = Arrays.asList(useNames);
            if (CollectionTool.isNotEmpty(users)) {
                vo.getSearch().setNameList(users);
            }
        }
        if (lotteryRule.getAmountLimit() != null && lotteryRule.getAmountLimit() > 0) {
            vo.getSearch().setBetAmount(lotteryRule.getAmountLimit());
        }
//        List<BetOrderWin> list = lotteryBetOrderService.getAvaliableWinOrder (vo);
        return null;
    }

    private Double computeCanWin (Map<String, BetOrderWin> map, List<String> winList) {
        BigDecimal winMoney = BigDecimal.ZERO;
        for (String key : winList) {
            if (map.get(key) != null) {
                BigDecimal bd2 = new BigDecimal(Double.toString(map.get(key).getCanWinMoney()));
                winMoney = winMoney.add(bd2);
            }
        }
        return winMoney.doubleValue();
    }
}