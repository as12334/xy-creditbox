package so.wwb.creditbox.schedule.service.utility;

import org.soul.commons.spring.utils.SpringTool;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryService;
import so.wwb.creditbox.iservice.manager.sys.ISysSiteService;
import so.wwb.creditbox.iservice.manager.taskschedule.ITaskRunRecordService;
import so.wwb.creditbox.iservice.manager.taskschedule.ITaskScheduleServiceEx;
import so.wwb.creditbox.schedule.init.ConfigManager;
import so.wwb.creditbox.service.manager.lottery.LotteryService;

public class ServiceManager {

    public static ITaskRunRecordService getTaskRunRecordService() {
        return SpringTool.getBean(ITaskRunRecordService.class);
    }

    public static ITaskScheduleServiceEx getTaskScheduleServiceEx() {
        return SpringTool.getBean(ITaskScheduleServiceEx.class);
    }

    public static ISysSiteService getSysSiteService() {
        return SpringTool.getBean(ISysSiteService.class);
    }



    public static ILotteryService getLotteryService() {
        return (LotteryService) SpringTool.getBean("lotteryService");
    }


    public static ConfigManager getServiceConf() {
        return  SpringTool.getBean(ConfigManager.class);
    }

}
