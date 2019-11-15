package so.wwb.creditbox.service.manager.handle;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.enums.lottery.LotteryGatherConfEnum;
import so.wwb.creditbox.service.manager.gather.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LotteryGatherHandleFactory {
    private final Log LOG = LogFactory.getLog(LotteryGatherHandleFactory.class);
    private static LotteryGatherHandleFactory instance = null;
    private final Map<String, ILotteryGatherHandle> handler = new ConcurrentHashMap<>();
    private final Lock lock = new ReentrantLock();

    private LotteryGatherHandleFactory() {
    }

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
                if (handle != null) {
                    return handle;
                }
                handle = createHandle(key);
                handler.put(key, handle);
            } finally {
                lock.unlock();
            }
        }
        return handle;
    }

    /**
     * @param code
     * @return
     */
    private static ILotteryGatherHandle createHandle(String code) {
        LotteryGatherConfEnum lotterTypeEnum = EnumTool.enumOf(LotteryGatherConfEnum.class, code);
        if (lotterTypeEnum == null) {
            return null;
        }
        switch (lotterTypeEnum) {
            case opencai:
                return new OpenCaiGatherHandle();
            case kai:
                return new Kai168CaiGatherHandle();
            case wangyi:
                return new WangyiGatherClientHandle();
            case lbw:
                return new LbwGatherHandle();
            case auto:
                return new AutomaticHandle();
            case fhlm:
                return new FhlmGatherHandle();
            case cpk:
                return new CpkGatherHandle();
            default:
                return null;
        }
    }

}
