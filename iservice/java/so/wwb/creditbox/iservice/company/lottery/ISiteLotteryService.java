package so.wwb.creditbox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryVo;

import java.util.Map;


/**
 * 站点彩票服务接口
 *
 * @author block
 * @time 2019-10-20 23:13:50
 */
//region your codes 1
public interface ISiteLotteryService extends IBaseService<SiteLotteryListVo, SiteLotteryVo, SiteLottery, Integer> {
    Map<String, Map<String, SiteLottery>> load(SiteLotteryVo vo);

    void takeOff(SiteLotteryListVo siteLotteryListVo);

    void saveSiteLotteryOrder(SiteLotteryVo siteLotteryVo);

    void takeOffAllByCode(SiteLotteryListVo siteLotteryListVo);

    void sync(SiteLotteryListVo siteLotteryListVo);
//endregion your codes 1

    //region your codes 2

    //endregion your codes 2

}