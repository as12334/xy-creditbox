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
 * @author admin
 * @time 2017-4-14 13:54:42
 */
//region your codes 1
public interface ILotteryGatherConfService extends IBaseService<LotteryGatherConfListVo, LotteryGatherConfVo, LotteryGatherConf, Integer> {
//endregion your codes 1

    //region your codes 2
    Map<String,Map<String,List<LotteryGatherConf>>> load(LotteryGatherConfListVo lotteryGatherConfListVo);
    //endregion your codes 2

}