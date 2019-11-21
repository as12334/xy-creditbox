package so.wwb.creditbox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;

import java.util.Map;


/**
 * 服务接口
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public interface ISiteLotteryOddsService extends IBaseService<SiteLotteryOddsListVo, SiteLotteryOddsVo, SiteLotteryOdds, Integer> {

//endregion your codes 1

    Map<String, Map<String, SiteLotteryOdds>> load(SiteLotteryOddsListVo siteLotteryOddListVo);

    //region your codes 2
    SiteLotteryOddsVo initOddsData(SiteLotteryOddsVo vo);

    SiteLotteryOddsVo saveSiteLotteryOdds(SiteLotteryOddsVo siteLotteryOddsVo);
    //endregion your codes 2

}