package so.wwb.lotterybox.schedule.service.manager.job;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.enums.lottery.LotteryConfTypeEnum;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.lotterybox.schedule.service.manager.task.LotteryValidTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * 开奖结果校验
 * Created by marz on 18-7-16.
 */
public class LotteryResultValidJob {

    private static final Log LOG = LogFactory.getLog(LotteryResultValidJob.class);

    @Autowired
    private ExecutorService validExecutor;

    private final static int GMT = 8 ;


    public LotteryResultValidJob() {
    }

    public void execute(String[] codes) {
        if(codes != null && codes.length != 0){
            Map<String,List<LotteryGatherConf>> lotteryGatherConfMap = CacheBase.getLotteryGatherConf(LotteryConfTypeEnum.VALID.getCode());
            List<String> validCodes = new ArrayList<>();
            List<LotteryGatherConf> confs = new ArrayList<>(codes.length);
            for(int i=0; i < codes.length; i++){
                if(lotteryGatherConfMap.containsKey(codes[i]) && CollectionTool.isNotEmpty(lotteryGatherConfMap.get(codes[i]))){
                    validCodes.add(codes[i]);
                    confs.addAll(lotteryGatherConfMap.get(codes[i]));
                }
            }
            if(CollectionTool.isNotEmpty(confs)){
                LOG.info("开始彩票开奖结果验证任务,验证彩种列表:{0}", StringTool.join(validCodes,","));
                String date = DateTool.formatDate(DateTool.addHours(new Date(),GMT),DateTool.yyyy_MM_dd);
                for (LotteryGatherConf gatherConf : confs) {
                    LotteryValidTask task = SpringTool.getBean(LotteryValidTask.class);
                    task.setConf(gatherConf);
                    task.setDate(date);
                    validExecutor.submit(task);
                }

            }
        }
    }
}
