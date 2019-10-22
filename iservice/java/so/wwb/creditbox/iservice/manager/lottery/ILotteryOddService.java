package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdd;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOddListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOddVo;

import java.util.List;
import java.util.Map;


/**
 * 赔率设置表服务接口
 *
 * @author block
 * @time 2019-10-21 21:46:34
 */
//region your codes 1
public interface ILotteryOddService extends IBaseService<LotteryOddListVo, LotteryOddVo, LotteryOdd, Integer> {
    //region your codes 2
    Map<String, List<LotteryOdd>> load(LotteryOddListVo lotteryBetOddListVo);
//endregion your codes 1

    //region your codes 2

    //endregion your codes 2

}