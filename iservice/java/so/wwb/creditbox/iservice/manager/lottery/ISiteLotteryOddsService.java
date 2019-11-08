package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsVo;


/**
 * 服务接口
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public interface ISiteLotteryOddsService extends IBaseService<SiteLotteryOddsListVo, SiteLotteryOddsVo, SiteLotteryOdds, Integer> {

//endregion your codes 1

    //region your codes 2
    SiteLotteryOddsVo initData(SiteLotteryOddsVo vo);
    //endregion your codes 2

}