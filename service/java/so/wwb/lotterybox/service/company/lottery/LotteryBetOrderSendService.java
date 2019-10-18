package so.wwb.lotterybox.service.company.lottery;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.service.support.BaseService;
import so.wwb.lotterybox.data.company.lottery.LotteryBetOrderSendMapper;
import so.wwb.lotterybox.iservice.company.lottery.ILotteryBetOrderSendService;
import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrderSend;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryBetOrderSendListVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryBetOrderSendVo;

/**
 * 下注推送注单失败记录服务接口
 *
 * @author diego
 * @time 2018-11-20 19:11:05
 */
public class LotteryBetOrderSendService extends BaseService<LotteryBetOrderSendMapper, LotteryBetOrderSendListVo, LotteryBetOrderSendVo, LotteryBetOrderSend, Integer> implements ILotteryBetOrderSendService {

    private Log LOG = LogFactory.getLog(LotteryBetOrderSendService.class);


}