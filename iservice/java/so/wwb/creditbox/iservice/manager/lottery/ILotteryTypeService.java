package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryType;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryTypeListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryTypeVo;

import java.util.Map;


/**
 * 服务接口
 *
 * @author ronnie
 * @time 2017-10-23 19:07:34
 */
//region your codes 1
public interface ILotteryTypeService extends IBaseService<LotteryTypeListVo, LotteryTypeVo, LotteryType, Integer> {
//endregion your codes 1

    //region your codes 2

    /**
     * 彩种类型缓存
     * @param lotteryTypeVo lotteryTypeVo
     * @return Map
     */
    Map<String, LotteryType> load(LotteryTypeVo lotteryTypeVo);

    LotteryTypeVo saveLotteryTypeOrder(LotteryTypeVo lotteryTypeVo);

    LotteryTypeListVo searchLotteryType(LotteryTypeListVo lotteryTypeVo);

    //endregion your codes 2

}