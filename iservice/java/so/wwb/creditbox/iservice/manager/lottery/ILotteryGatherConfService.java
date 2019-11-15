package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryGatherConfListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryGatherConfVo;

import java.util.List;
import java.util.Map;


/**
 * 彩票采集接口配置表服务接口
 *
 * @author block
 * @time 2019-11-15 10:46:12
 */
//region your codes 1
public interface ILotteryGatherConfService extends IBaseService<LotteryGatherConfListVo, LotteryGatherConfVo, LotteryGatherConf, Integer> {
    //region your codes 2
//endregion your codes 1

    //region your codes 2
    Map<String, List<LotteryGatherConf>> load(LotteryGatherConfListVo lotteryGatherConfListVo);
    //endregion your codes 2

}