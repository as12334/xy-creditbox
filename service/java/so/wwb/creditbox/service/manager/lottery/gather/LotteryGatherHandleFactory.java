package so.wwb.creditbox.service.manager.lottery.gather;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryGatherHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryGatherConfEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LotteryGatherHandleFactory {
    public static final Log log = LogFactory.getLog(LotteryGatherHandleFactory.class);
    private static LotteryGatherHandleFactory instance = null;
    private static final Map<String, ILotteryGatherHandle> handler = new ConcurrentHashMap<>();
    private final Lock lock = new ReentrantLock();

    public static LotteryGatherHandleFactory getInstance() {
        if (instance == null) {
            synchronized (LotteryGatherHandleFactory.class) {
                if (instance == null) {
                    instance = new LotteryGatherHandleFactory();
                }
            }
        }
        return instance;
    }

    public ILotteryGatherHandle getLotteryHandle(String key) {
        ILotteryGatherHandle handle = handler.get(key);
        if (handle == null) {
            handle = LotteryGatherHandleFactory.createHandle(key);
            if (handle != null) handler.put(key, handle);
        }
        return handle;
    }

    private static ILotteryGatherHandle createHandle(String key) {
        LotteryGatherConfEnum lotteryGatherConfEnum = EnumTool.enumOf(LotteryGatherConfEnum.class, key);
        if (null == lotteryGatherConfEnum) {
            log.error("gather conf type:{0},not open, please contact administrator", key);
            return null;
        }

        switch (lotteryGatherConfEnum) {
            case opencai:
                return new OpenCaiGatherHandle();
            case kai:
                return new Kai168CaiGatherHandle();
            case auto:
                return new AutomaticHandle();
            default:
                return null;
        }
    }

    /**
     * @param key
     * @return
     */
    public ILotteryGatherHandle getLotterHandle(String key) {
        ILotteryGatherHandle handle = handler.get(key);
        if (handle == null) {
            lock.lock();
            try {
                handle = handler.get(key);
                if (handle != null)
                    return handle;
                handle = createHandle(key);
                handler.put(key, handle);
            } finally {
                lock.unlock();
            }
        }
        return handle;
    }
}
