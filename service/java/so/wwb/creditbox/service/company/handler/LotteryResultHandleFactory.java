package so.wwb.creditbox.service.company.handler;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.service.manager.lottery.IWinningRecordHandle;
import so.wwb.creditbox.service.manager.lottery.Pk10WinningRecordHandle;
import so.wwb.creditbox.service.manager.lottery.SfcWinningRecordHandle;
import so.wwb.creditbox.service.manager.lottery.SscWinningRecordHandle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shook on 17-4-9.
 */
public class LotteryResultHandleFactory {

    private static final Log log = LogFactory.getLog(LotteryResultHandleFactory.class);

    private static final LotteryResultHandleFactory instance = new LotteryResultHandleFactory();

    /**
     * lotteryType(ssc,pk10,k3,lhc):处理器
     */
    private static final Map<String, IWinningRecordHandle> handler = new ConcurrentHashMap<>();

    public static LotteryResultHandleFactory getInstance() {
        return instance;
    }

    public static IWinningRecordHandle createHandle(String lottery) {
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class, lottery);
        if (lotteryEnum == null) {
            log.error("彩种:{0},暂未开放，请联系管理员.", lottery);
            return new WinningRecordHandle();
        }
        LotteryTypeEnum lotteryTypeEnum = EnumTool.enumOf(LotteryTypeEnum.class, lotteryEnum.getType());
        if (lotteryTypeEnum == null) {
            log.error("彩种类型:{0},暂未开放，请联系管理员.", lotteryEnum.getType());
            return new WinningRecordHandle();
        }
        IWinningRecordHandle winningRecordHandle = handler.get(lotteryTypeEnum.getCode());
        log.info("handler的大小：{0}", handler.size());
        if (winningRecordHandle == null) {
            switch (lotteryTypeEnum) {
                case SSC:
                    winningRecordHandle = new SscWinningRecordHandle();
                    break;
                case PK10:
                    winningRecordHandle = new Pk10WinningRecordHandle();
                    break;
//                case K3:
//                    winningRecordHandle = new K3WinningRecordHandle();
//                    break;
//                case LHC:
//                    winningRecordHandle = new LhcWinningRecordHandle();
//                    break;
                case SFC:
                    winningRecordHandle = new SfcWinningRecordHandle();
                    break;
//                case KENO:
//                    winningRecordHandle = new KenoWinningRecordHandle();
//                    break;
//                case XY28:
//                    winningRecordHandle = new Xy28WinningRecordHandle();
//                    break;
//                case PL3:
//                    winningRecordHandle = new Pl3WinningRecordHandle();
//                    break;
                default:
                    winningRecordHandle = new WinningRecordHandle();
                    break;
            }
            if (winningRecordHandle instanceof WinningRecordHandle) {
                return winningRecordHandle;
            }
            handler.put(lottery, winningRecordHandle);
        }
        return winningRecordHandle;
    }

}
