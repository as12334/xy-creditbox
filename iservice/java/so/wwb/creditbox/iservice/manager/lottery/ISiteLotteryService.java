package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryVo;


/**
 * 站点彩票服务接口
 *
 * @author block
 * @time 2019-10-20 23:13:50
 */
//region your codes 1
public interface ISiteLotteryService extends IBaseService<SiteLotteryListVo, SiteLotteryVo, SiteLottery, Integer> {
    void takeOff(SiteLotteryListVo siteLotteryListVo);

    void saveSiteLotteryOrder(SiteLotteryVo siteLotteryVo);

    void takeOffAllByCode(SiteLotteryListVo siteLotteryListVo);

    void sync(SiteLotteryListVo siteLotteryListVo);
//endregion your codes 1

    //region your codes 2

    //endregion your codes 2

}