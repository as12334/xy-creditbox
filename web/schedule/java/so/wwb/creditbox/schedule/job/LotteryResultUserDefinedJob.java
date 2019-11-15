package so.wwb.creditbox.schedule.job;

import org.soul.commons.cache.jedis.proxy.JedisClientProxy;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.data.support.DataContext;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.vo.TaskScheduleVo;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.creditbox.iservice.manager.taskschedule.ITaskScheduleServiceExS;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultSo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.service.tool.DatasourceUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by marz on 18-5-31.
 * 自定义开奖结果主任务
 */
public class LotteryResultUserDefinedJob {

    private static final Log LOG = LogFactory.getLog(LotteryResultUserDefinedJob.class);

    private static JedisClientProxy jedisTemplate = ServiceTool.jedisTemplate();

    private static final String JOB_CODE = "lotteryResultSubJob";

    public void execute(String[] codes) {
        LOG.info("LotteryResultUserDefinedJob:开奖彩种的列表:{0}", JsonTool.toJson(codes));
        List<LotteryResult> curLotteryResult = getCurLotteryResult(Arrays.asList(codes));
        if (CollectionTool.isEmpty(curLotteryResult)) {
            LOG.info("LotteryResultUserDefinedJob:该时间区没有需要采集数据");
            return;
        }
        runTaskSchedule(curLotteryResult);
    }

    private List<LotteryResult> getCurLotteryResult(List<String> codes) {
        DataContext.setDataSource(DatasourceUtil.getBossDatasource());
        ILotteryResultService service = ServiceTool.lotteryResultService();
        LotteryResultVo resultVo = new LotteryResultVo();
        resultVo.setSearch(new LotteryResultSo());
        resultVo.getSearch().setCodes(codes);
        List<LotteryResult> lotteryResults = service.searchCurLotteryResult(resultVo);
        return lotteryResults;
    }

    private void runTaskSchedule(List<LotteryResult> curLotteryResult) {
        LOG.info("LotteryResultUserDefinedJob:需采集的彩种：{0}", JsonTool.toJson(curLotteryResult));
        DataContext.setDataSource(DatasourceUtil.getBossDatasource());
        ITaskScheduleServiceExS taskScheduleService = ServiceTool.taskScheduleServiceExS();
        TaskScheduleVo scheduleVo = new TaskScheduleVo();
        scheduleVo.getSearch().setJobCode(JOB_CODE);
        TaskScheduleVo schedule = taskScheduleService.search(scheduleVo);
        for (LotteryResult lotteryResult : curLotteryResult) {
            String key = lotteryResult.getCode() + "@" + lotteryResult.getExpect();
            TaskSchedule result = schedule.getResult();
            result.setJobMethodArg(lotteryResult.getCode());
            scheduleVo.setResult(result);
            String value = jedisTemplate.get(key);
            if (StringTool.isBlank(value)) {
                jedisTemplate.setex(key, 6 * 60, key);
//                taskScheduleService.runOnceTask(scheduleVo, lotteryResult.getCode());
                LotteryResultSubJob lotteryResultSubJob = (LotteryResultSubJob) SpringTool.getBean("lotteryResultSubJob");
                lotteryResultSubJob.execute(lotteryResult.getCode());
            }
        }
    }
}
