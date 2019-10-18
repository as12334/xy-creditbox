package so.wwb.lotterybox.schedule.service.manager.job;

import org.soul.commons.cache.jedis.proxy.JedisClientProxy;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.taskschedule.so.TaskScheduleSo;
import org.soul.model.taskschedule.vo.TaskScheduleVo;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.lotterybox.iservice.manager.taskschedule.ITaskScheduleServiceExGs;
import so.wwb.lotterybox.model.enums.lottery.LotteryClassifyEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryEnum;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryResultSo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultListVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 彩票开奖主任务
 * @author: marz
 * @time 2018-2-27 20:35:57
 * */
public class LotteryResultMainJob {

    private static final Log LOG = LogFactory.getLog(LotteryResultMainJob.class);

    @Autowired
    private ILotteryResultService lotteryResultService;
    @Autowired
    private ITaskScheduleServiceExGs taskScheduleServiceExGs;
    @Autowired
    private JedisClientProxy jedisTemplateData;

    private static final String UNIFY_JOB_CODE = "lotteryResultOfficeSubJob";

    private static final String OWN_JOB_CODE = "lotteryResultOwnSubJob";

    public LotteryResultMainJob() {
    }

    public void execute(String[] arr) {
        LotteryResultListVo resultListVo = null;
        if(arr != null) {
            LotteryResultSo so = new LotteryResultSo();
            so.setCodes(new ArrayList<String>());
            for(String code:arr) {
                if (StringTool.isNotBlank(code)) {
                    so.getCodes().add(code);
                }
            }
            resultListVo = lotteryResultService.curLotteryResultByCode(so);
        }
        if (resultListVo != null && CollectionTool.isEmpty(resultListVo.getResult())) {
            LOG.info("LotteryResultMainJob:该时间区没有需要采集数据");
            return;
        }
        runTaskSchedule(resultListVo.getResult());
    }

    private void runTaskSchedule(List<LotteryResult> list) {
        Map<String,String> map = new HashMap<>();
        list.forEach(e->map.put(e.getCode(),e.getExpect()));
        LOG.info("LotteryResultMainJob:需采集的彩种与期数：{0}", JsonTool.toJson(map));
        for (LotteryResult lotteryResult : list) {
            LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,lotteryResult.getCode());
            if(lotteryEnum == null){
                LOG.error("开奖前校验未通过,不开奖,code:{0},原因:{1}",lotteryResult.getCode(),"无当前彩种");
                continue;
            }
            String key = lotteryResult.getCode() + "@" + lotteryResult.getExpect();
            String value = jedisTemplateData.get(key);
            if(StringTool.isNotBlank(value)){
                LOG.warn("开奖前校验未通过,不开奖,code:{0},expect:{1},原因:{2}",lotteryResult.getCode(),lotteryResult.getExpect(),"当期彩种已经开奖");
                continue;
            }
            if (StringTool.isBlank(value)) {
                jedisTemplateData.setex(key, 6 * 60, key);
                TaskScheduleVo unifyScheduleVo = new TaskScheduleVo();
                unifyScheduleVo.setSearch(new TaskScheduleSo());
                unifyScheduleVo.getSearch().setJobCode(UNIFY_JOB_CODE);
                //自主彩调用另一个任务
                if(LotteryClassifyEnum.OWN.getCode().equals(lotteryEnum.getClassify())){
                    unifyScheduleVo.getSearch().setJobCode(OWN_JOB_CODE);
                }
                taskScheduleServiceExGs.runOnceTask(unifyScheduleVo, lotteryResult.getCode(),lotteryResult.getExpect());
            }
        }
    }

}
