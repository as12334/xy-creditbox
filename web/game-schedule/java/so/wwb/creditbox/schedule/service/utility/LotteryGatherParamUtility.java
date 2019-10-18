package so.wwb.creditbox.schedule.service.utility;

import org.soul.commons.enums.EnumTool;
import so.wwb.creditbox.model.constants.common.Const;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.company.lottery.po.LotteryRule;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.utility.LotteryResultNumberUtility;

/**
 * Created by marz on 18-3-8.
 */
public class LotteryGatherParamUtility {

    /**
     * 初始采集参数
     *
     * @param killRate
     * @param result
     * @param conf
     * @return
     */
    public static LotteryGatherParam initGatherParam(LotteryResult result, LotteryGatherConf conf,LotteryRule killRate) {
        if(result != null && conf != null){
            return initGatherParam(LotteryResultNumberUtility.createByLotteryResult(result),conf,killRate);
        }
        return null;
    }

    /**
     * 初始采集参数
     *
     * @param lotteryRule
     * @param result
     * @param conf
     * @return
     */
    public static LotteryGatherParam initGatherParam(LotteryResultNumber result, LotteryGatherConf conf, LotteryRule lotteryRule) {
        if(result != null && conf != null){
            LotteryGatherParam gatherParam = new LotteryGatherParam();
            gatherParam.setCode(result.getCode());
            LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class, result.getCode());
            gatherParam.setType(lotteryEnum.getType());
            gatherParam.setExpect(result.getExpect());
            gatherParam.setLotteryTime(result.getOpenTime());
            gatherParam.setCloseTime(result.getCloseTime());
            gatherParam.setUrl(conf.getUrl());
            gatherParam.setLotteryGatherConf(conf);
            gatherParam.setLotteryRule(lotteryRule);
            gatherParam.setGather(Const.SYSTEM_OPERATOR);
            return gatherParam;
        }
        return null;
    }

}
