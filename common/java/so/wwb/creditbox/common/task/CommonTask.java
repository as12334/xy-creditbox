package so.wwb.creditbox.common.task;

import org.soul.commons.init.context.CommonContext;

import java.util.concurrent.Callable;

/**
 * 公共任务 针对线程清除上下文中的二级缓存
 * Created by marz on 18-6-17.
 */
public abstract class CommonTask<T> implements Callable {

    public CommonTask() {
        //针对线程清除上下文中的二级缓存
        CommonContext.getCacheObject().clear();
    }
}
