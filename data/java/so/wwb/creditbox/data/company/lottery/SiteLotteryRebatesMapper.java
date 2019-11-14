package so.wwb.creditbox.data.company.lottery;

import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryRebatesVo;


/**
 * 数据访问对象
 *
 * @author block
 * @time 2019-11-12 0:36:34
 */
//region your codes 1
public interface SiteLotteryRebatesMapper extends IBaseMapper<SiteLotteryRebates, Integer> {
//endregion your codes 1

    //region your codes 2
    SiteLotteryRebates getRebateBetSortLine(String code, Integer siteId, String hid, String s);

    Integer saveSiteLotteryRebates(SiteLotteryRebatesVo siteLotteryRebatesVo);

    //endregion your codes 2

}