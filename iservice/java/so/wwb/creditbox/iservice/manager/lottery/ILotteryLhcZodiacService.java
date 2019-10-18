package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryLhcZodiac;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryLhcZodiacListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryLhcZodiacVo;

import java.util.Map;

/**
 * 六合彩生肖表服务接口
 *
 * @author zain
 * @time 2017-8-8 19:35:52
 */
//region your codes 1
public interface ILotteryLhcZodiacService extends IBaseService<LotteryLhcZodiacListVo, LotteryLhcZodiacVo, LotteryLhcZodiac, Integer> {
//endregion your codes 1

    //region your codes 2
    Map<String, LotteryLhcZodiac> load(LotteryLhcZodiacListVo lotteryLhcZodiacListVo);
    //endregion your codes 2

}