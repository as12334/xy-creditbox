package so.wwb.creditbox.context;

import org.soul.commons.bean.BeanTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.ContextParam;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.session.UserSession;

public class LotteryCommonContext {
    private ThreadLocal<UserSession> userSession = new InheritableThreadLocal<>();
    private ThreadLocal<SysUserExtend> user = new InheritableThreadLocal<>();
    private static volatile LotteryCommonContext self = new LotteryCommonContext();

    public static void set(LotteryContextParam lotteryContextParam) {
        CommonContext.set(lotteryContextParam);
    }

    public static LotteryContextParam get() {
        if(CommonContext.get() instanceof ContextParam ){
            LotteryContextParam contextParam=new LotteryContextParam();
            BeanTool.copyPropertiesWithoutCast(CommonContext.get(),contextParam);
            CommonContext.set(contextParam);
        }
        return (LotteryContextParam)CommonContext.get();
    }

    public static ContextParam getContextParam() {
        return CommonContext.get();
    }

    public static <E> UserSession<E> getSession() {
        return self.userSession.get();
    }

    public static void setSession(UserSession userSession) {
        self.userSession.set(userSession);
    }

    public static SysUserExtend getUser() {
        return self.user.get();
    }

    public static void setUserExtend(SysUserExtend sysUserExtend) {
        self.user.set(sysUserExtend);
    }
}