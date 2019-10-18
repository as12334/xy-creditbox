package so.wwb.creditbox.service.manager.lottery.winning;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LotteryResultHandleFactory {

    //region log
    private static final Log log = LogFactory.getLog(LotteryResultHandleFactory.class);
    //endregion

    //region ctor
    private static LotteryResultHandleFactory instance = null;
    private static Map<String, IWinningRecordHandle> handler = new ConcurrentHashMap<>();
    public static LotteryResultHandleFactory getInstance() {
        if (instance == null) {
            synchronized (LotteryResultHandleFactory.class) {
                if (instance == null) {
                    instance = new LotteryResultHandleFactory();
                }
            }
        }
        return instance;
    }
    //endregion

    //region function: get winning record handle
    public IWinningRecordHandle getWinningRecordHandle(String lotteryType) {
        IWinningRecordHandle handle = null;
        handle = handler.get(lotteryType);
        if (handle == null) {
            handle = LotteryResultHandleFactory.createHandle(lotteryType);
            if(handle!=null) handler.put(lotteryType, handle);
        }
        return handle;
    }

    public static IWinningRecordHandle createHandle(String lottery){
       /* LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,lottery);
        if (lotteryEnum == null) {
            log.error("彩种:{0},暂未开放，请联系管理员.", lottery);
            return new WinningRecordHandle();
        }*/
        LotteryTypeEnum lotteryTypeEnum = EnumTool.enumOf(LotteryTypeEnum.class,lottery);
        if (lotteryTypeEnum == null) {
            log.error("彩种类型:{0},暂未开放，请联系管理员.", LotteryTypeEnum.class);
            return new WinningRecordHandle();
        }
        IWinningRecordHandle winningRecordHandle = handler.get(lotteryTypeEnum.getCode());
        log.info("handler的大小：{0}",handler.size());
        if (winningRecordHandle == null){
            switch (lotteryTypeEnum){
                case SSC:
                    winningRecordHandle = new SscWinningRecordHandle();
                    break;
                case PK10:
                    winningRecordHandle = new Pk10WinningRecordHandle();
                    break;
                case K3:
                    winningRecordHandle = new K3WinningRecordHandle();
                    break;
                case LHC:
                    winningRecordHandle = new LhcWinningRecordHandle();
                    break;
                case SFC:
                    winningRecordHandle = new SfcWinningRecordHandle();
                    break;
                case KENO:
                    winningRecordHandle = new KenoWinningRecordHandle();
                    break;
                case XY28:
                    winningRecordHandle = new Xy28WinningRecordHandle();
                    break;
                case PL3:
                    winningRecordHandle = new Pl3WinningRecordHandle();
                    break;
                case SYX5:
                    winningRecordHandle = new Syx5WinningRecordHandle();
                    break;
                case NN:
                    winningRecordHandle = new NnWinningRecordHandle();
                    break;
                case BJL:
                    winningRecordHandle = new BjlWinningRecordHandle();
                    break;
                default:
                    winningRecordHandle = new WinningRecordHandle();
                    break;
            }
            if (winningRecordHandle instanceof WinningRecordHandle)
                return winningRecordHandle;
            handler.put(lottery,winningRecordHandle);
        }
        return winningRecordHandle;
    }

    //endregion
}
