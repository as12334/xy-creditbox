package so.wwb.creditbox.data.manager.lottery;

import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import org.soul.data.rdb.mybatis.IBaseMapper;


/**
 * 数据访问对象
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public interface SiteLotteryOddsMapper extends IBaseMapper<SiteLotteryOdds, Integer> {

//endregion your codes 1

    //region your codes 2
    SiteLotteryOdds getBetSortLine(String code ,Integer siteId,String hid,Integer betSort);
    //endregion your codes 2

}