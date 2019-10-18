package so.wwb.lotterybox.common.dubbo;

import org.soul.commons.dubbo.DubboTool;
import org.soul.iservice.taskschedule.ITaskScheduleService;

public class ServiceScheduleTool {
    private static String dubboApplicationName;
    protected static <T> T getService(Class<T> interfaceClazz) {
        return DubboTool.getServiceByAppName(interfaceClazz,dubboApplicationName);
    }
    public  void setDubboApplicationName(String appName){
        dubboApplicationName=appName;
    }
    public static String getDubboApplicationName(){
        return dubboApplicationName;
    }
    public static ITaskScheduleService getTaskScheduleService() {

        return getService(ITaskScheduleService.class);
    }
}
