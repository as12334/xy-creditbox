package so.wwb.creditbox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.lottery.po.LotteryOddSet;
import so.wwb.creditbox.model.company.lottery.vo.LotteryOddSetListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryOddSetVo;

import java.util.Map;

/**
 * 彩票赔率设置表服务接口
 *
 * @author diego
 * @time 2018-02-11
 */
public interface ILotteryOddSetService extends IBaseService<LotteryOddSetListVo,LotteryOddSetVo,LotteryOddSet,Integer>{

    /**
     * 缓存赔率设置
     */
    Map<String, Map<String, LotteryOddSet>> load(LotteryOddSetVo vo);

    LotteryOddSetListVo search(LotteryOddSetListVo listVo);

    void initLotteryOddSet (LotteryOddSetVo lotteryOddSetVo);

    Integer deleteLotteryOddSetByProject(LotteryOddSet lotteryOddSet);

}