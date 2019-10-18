package so.wwb.lotterybox.schedule.init;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.vo.TaskScheduleVo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import so.wwb.lotterybox.model.enums.schedule.TaskSchedulerEnum;
import so.wwb.lotterybox.schedule.service.utility.ServiceManager;
import so.wwb.lotterybox.utility.CommonTool;
import so.wwb.lotterybox.utility.ScheduleTool;

import java.util.List;

/**
 * Created by longer on 8/20/15.
 * Spring上下文加载成功后
 */
@Component
public class SchedulerContextRefreshListener implements ApplicationListener<ContextRefreshedEvent>,Ordered {
    public int getOrder() {
        return 90;
    }
    private static final Log LOG = LogFactory.getLog(SchedulerContextStopListener.class);
    //
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            if (startScheduleService(TaskSchedulerEnum.DEFAULT.getCode())) {
                ServiceCtxLoaderListener.managerScheduleStart = true;
            }
            if (startScheduleService(TaskSchedulerEnum.MERCHANT.getCode())) {
                ServiceCtxLoaderListener.merchantScheduleStart = true;
            }
            LOG.info("关闭顺序:"+getOrder()+",停止--Scheduler--服务成功！");
        } catch (Exception e) {
            LOG.error("关闭顺序:"+getOrder()+",停止--Scheduler--服务失败！");
        }
    }
    private boolean startScheduleService(String scheduleKey) {
        boolean result = true;
        try {
            CommonTool.BindDataSource(0);
            TaskScheduleVo taskScheduleVo = new TaskScheduleVo();
            String belongIDC = ServiceManager.getServiceConf().getIdc();
            taskScheduleVo.setIdc(belongIDC);
            ScheduleTool.initTaskSchedules(getTaskScheduleList(taskScheduleVo));
            LOG.info("schedule:{0},初始化成功",scheduleKey);
        } catch (Exception e) {
            LOG.error(e,"schedule:{0},初始化异常:{1}",scheduleKey,e.getMessage());
            result = false;
        }
        return result;
    }

    /**
     * 获取需要初始化的调度任务列表
     * @param taskScheduleVo
     * @return
     */
    private List getTaskScheduleList(TaskScheduleVo taskScheduleVo){
        return ServiceManager.getTaskScheduleServiceEx().search(
                Criteria.add(TaskSchedule.PROP_STATUS, Operator.EQ, TaskSchedule.STATUS_ENABLE)
                        .addAnd(TaskSchedule.PROP_IDC, Operator.EQ, taskScheduleVo.getIdc())
                        .addAnd(TaskSchedule.PROP_SCHEDULER, Operator.IN,new Object[]{TaskSchedulerEnum.DEFAULT.getCode(),TaskSchedulerEnum.MERCHANT.getCode()}));
    }

}
