package so.wwb.creditbox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryRebatesListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryRebatesVo;


/**
 * 服务接口
 *
 * @author block
 * @time 2019-11-12 0:36:34
 */
//region your codes 1
public interface ISiteLotteryRebatesService extends IBaseService<SiteLotteryRebatesListVo, SiteLotteryRebatesVo, SiteLotteryRebates, Integer> {

//endregion your codes 1

    //region your codes 2
    SiteLotteryRebatesVo initRebatesData(SiteLotteryRebatesVo vo);

    SiteLotteryRebatesVo saveSiteLotteryOdds(SiteLotteryRebatesVo siteLotteryRebatesVo);
    //endregion your codes 2

}