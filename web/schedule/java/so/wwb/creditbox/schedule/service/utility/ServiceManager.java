package so.wwb.creditbox.schedule.service.utility;

import org.soul.commons.spring.utils.SpringTool;
import so.wwb.creditbox.iservice.common.IMessageService;
//import so.wwb.lotterybox.iservice.manager.sys.ISysExportService;
import so.wwb.creditbox.iservice.manager.taskschedule.ITaskScheduleServiceEx;
import so.wwb.creditbox.schedule.init.ConfigManager;
import so.wwb.creditbox.service.manager.lottery.LotteryResultService;
import so.wwb.creditbox.service.manager.lottery.LotteryService;
import so.wwb.creditbox.service.manager.sys.SysSiteService;
import so.wwb.creditbox.service.manager.taskschedule.TaskRunRecordService;

public class ServiceManager {

//    public static ISysExportService getSysExportService() {
//        return SpringTool.getBean(ISysExportService.class);
//    }

    public static IMessageService getMessageService() {
        return SpringTool.getBean(IMessageService.class);
    }

    public static ITaskScheduleServiceEx getTaskScheduleServiceEx() {
        return SpringTool.getBean(ITaskScheduleServiceEx.class);
    }

    public static TaskRunRecordService getTaskRunRecordService() {
        return (TaskRunRecordService) SpringTool.getBean("taskRunRecordService");
    }

    public static SysSiteService getSysSiteService() {
        return (SysSiteService) SpringTool.getBean("sysSiteService");
    }

    public static LotteryResultService getLotteryResultService() {
        return (LotteryResultService) SpringTool.getBean("lotteryResultService");
    }

    public static LotteryService getLotteryService() {
        return (LotteryService) SpringTool.getBean("lotteryService");
    }


    public static ConfigManager getServiceConf() {
        return SpringTool.getBean(ConfigManager.class);
    }

}
