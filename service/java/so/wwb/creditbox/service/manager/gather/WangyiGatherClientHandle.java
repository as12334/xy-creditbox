package so.wwb.creditbox.service.manager.gather;

import org.soul.commons.data.xml.JaxbTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.gameapi.result.GameApiResult;
import org.soul.model.gameapi.result.ResultStatus;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.GatherRecord;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

import java.util.Date;
import java.util.Map;

/**
 * Created by admin on 17-4-14.
 * 网易彩票
 * http://caipiao.163.com/
 */
public class WangyiGatherClientHandle implements ILotteryGatherHandle {
    private static final String CATEGORY = "category";
    private static final String TYPE = "type";

    private static final Log LOG = LogFactory.getLog(WangyiGatherClientHandle.class);

    @Override
    public LotteryResultVo doGather(LotteryGatherParam gatherParam) {
        return null;
    }

    @Override
    public LotteryResultListVo doCollection(LotteryGatherParam gatherParam) {
        return null;
    }

    @Override
    public void doValid(LotteryGatherConf gatherConf) {

    }

    public LotteryResultVo handleLotteryResultVo(LotteryGatherParam gatherParam, GameApiResult gameApiResult) {
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        Map<String, Object> additionalResult = (Map<String, Object>) gameApiResult.getAdditionalResult();

        if (!ResultStatus.SUCCESS.equals(gameApiResult.getStatus())) {
            lotteryResultVo.setResult(new LotteryResult());
            return lotteryResultVo;
        }
        LotteryResult lotteryResult = new LotteryResult();
        for (String key : additionalResult.keySet()) {
            String data = (String) additionalResult.get(key);
            if (StringTool.isNotBlank(data)) {
                GatherRecord wyRecord = JaxbTool.fromXml(data, GatherRecord.class);
                LotteryEnum lottery = LotteryEnum.CQSSC;
                if (wyRecord != null && StringTool.isNotBlank(wyRecord.getExpect()) && lottery.getTrans().equals(wyRecord.getCode())) {
                    String expect = wyRecord.getExpect().substring(0, 9);
                    lotteryResult.setCode(lottery.getCode());
                    lotteryResult.setType(lottery.getType());
                    lotteryResult.setExpect(expect);
                    lotteryResult.setOpenTime(new Date());
                }
            }
        }
        lotteryResultVo.setResult(lotteryResult);
        return lotteryResultVo;
    }


}
