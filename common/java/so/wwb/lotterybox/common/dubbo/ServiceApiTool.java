package so.wwb.lotterybox.common.dubbo;

import org.soul.commons.dubbo.DubboTool;
import so.wwb.lotterybox.iservice.api.IApiBetOrderService;
import so.wwb.lotterybox.iservice.api.IApiBillService;
import so.wwb.lotterybox.iservice.api.IUserExtendService;
import so.wwb.lotterybox.iservice.api.IUserTokenService;

public class ServiceApiTool {
    private static String dubboApplicationName;
    protected static <T> T getService(Class<T> interfaceClazz) {
        return DubboTool.getServiceByAppName(interfaceClazz, dubboApplicationName);
    }
    public  void setDubboApplicationName(String appName){
        dubboApplicationName=appName;
    }
    public static String getDubboApplicationName(){
        return dubboApplicationName;
    }

    /** API相关接口 */
    public static IUserExtendService userExtendService() {
        return getService(IUserExtendService.class);
    }
    public static IApiBillService billService() {
        return getService(IApiBillService.class);
    }

    public static IApiBetOrderService apiBetOrderService() {
        return getService(IApiBetOrderService.class);
    }

    public static IUserTokenService userTokenService() {
        return getService(IUserTokenService.class);
    }

}
