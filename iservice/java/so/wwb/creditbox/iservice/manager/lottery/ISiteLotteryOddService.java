package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdd;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddVo;

import java.util.Map;


/**
 * 赔率设置表服务接口
 *
 * @author block
 * @time 2019-10-21 22:52:07
 */
//region your codes 1
public interface ISiteLotteryOddService extends IBaseService<SiteLotteryOddListVo, SiteLotteryOddVo, SiteLotteryOdd, Integer> {

//endregion your codes 1


    //region your codes 2
    Map<String, Map<String, SiteLotteryOdd>> load(SiteLotteryOddListVo siteLotteryOddListVo);
    Integer getOddBySiteId(SiteLotteryOdd listVo);
    //endregion your codes 2

}