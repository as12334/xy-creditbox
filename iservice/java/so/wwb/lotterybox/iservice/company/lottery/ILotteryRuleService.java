package so.wwb.lotterybox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.company.lottery.po.LotteryRule;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryRuleListVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryRuleVo;

import java.util.Map;


/**
 * 商户彩票杀率设置服务接口
 *
 * @author marz
 * @time 2018-3-12 14:13:23
 */
public interface ILotteryRuleService extends IBaseService<LotteryRuleListVo, LotteryRuleVo, LotteryRule, Integer> {

    Map<String,Map<String, LotteryRule>> load(LotteryRuleListVo LotteryKillRateListVo);

    LotteryRuleVo updateLotteryRuleModel(LotteryRuleVo ruleVo);
}