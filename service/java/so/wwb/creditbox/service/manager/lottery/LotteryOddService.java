package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.collections.CollectionTool;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.lottery.LotteryOddMapper;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryOddService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdd;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOddListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOddVo;

import java.util.List;
import java.util.Map;


/**
 * 赔率设置表服务
 *
 * @author block
 * @time 2019-10-21 21:46:34
 */
//region your codes 1
public class LotteryOddService extends BaseService<LotteryOddMapper, LotteryOddListVo, LotteryOddVo, LotteryOdd, Integer> implements ILotteryOddService {
//endregion your codes 1

    //region your codes 2
    @Override
    public Map<String, List<LotteryOdd>> load(LotteryOddListVo lotteryBetOddListVo) {
        List<LotteryOdd> lotteryList = allSearch(lotteryBetOddListVo);
        return CollectionTool.groupByProperty(lotteryList, LotteryOdd.PROP_CODE, String.class);
    }
    //endregion your codes 2

}