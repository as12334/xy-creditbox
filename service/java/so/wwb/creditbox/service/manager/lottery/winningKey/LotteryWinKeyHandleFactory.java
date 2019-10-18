package so.wwb.creditbox.service.manager.lottery.winningKey;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.iservice.manager.lottery.IWinRecordKeyHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LotteryWinKeyHandleFactory {

    //region log
    private static final Log log = LogFactory.getLog(LotteryWinKeyHandleFactory.class);
    //endregion

    //region ctor
    private static LotteryWinKeyHandleFactory instance = null;
    private static Map<String, IWinRecordKeyHandle> handler = new ConcurrentHashMap<>();
    public static LotteryWinKeyHandleFactory getInstance() {
        if (instance == null) {
            synchronized (LotteryWinKeyHandleFactory.class) {
                if (instance == null) {
                    instance = new LotteryWinKeyHandleFactory();
                }
            }
        }
        return instance;
    }
    //endregion


    public static IWinRecordKeyHandle createHandle(String code){
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,code);
        if (lotteryEnum == null) {
            log.error("彩种类型:{0},暂未开放，请联系管理员.", LotteryTypeEnum.class);
            return null;
        }
        IWinRecordKeyHandle winRecordKeyHandle = handler.get(lotteryEnum.getCode());
        log.info("handler的大小：{0}",handler.size());
        if (winRecordKeyHandle == null){
            switch (lotteryEnum){
                case JSPK10:
                    winRecordKeyHandle = new Jspk10WinKeyHandle();
                    break;
                case JISK3:
                    winRecordKeyHandle = new Jisk3WinKeyHandle();
                    break;
                case FFSSC:
                    winRecordKeyHandle = new FfsscWinKeyHandle();
                    break;
                case JSLHC:
                    winRecordKeyHandle = new JslhcWinKeyHandle();
                    break;
            }
            if (winRecordKeyHandle instanceof WinKeyHandle)
                return winRecordKeyHandle;
            handler.put(code,winRecordKeyHandle);
        }
        return winRecordKeyHandle;
    }

    //endregion
}
