package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.LotteryType;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryVo;

import java.util.List;
import java.util.Map;

/**
 * 彩种表服务接口
 */
public interface ILotteryService extends IBaseService<LotteryListVo, LotteryVo, Lottery, Integer> {


    //region your codes 2
    @Transactional
    void changeLotteryGenre(LotteryVo lotteryVo);

    @Transactional
    void saveLotteryOrder(LotteryVo lotteryVo);


    //endregion your codes 2

}