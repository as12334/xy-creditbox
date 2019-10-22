package so.wwb.creditbox.data.manager.lottery;

import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdd;
import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotteryOddSo;

import java.util.List;


/**
 * 赔率设置表数据访问对象
 *
 * @author block
 * @time 2019-10-21 22:52:07
 */
//region your codes 1
public interface SiteLotteryOddMapper extends IBaseMapper<SiteLotteryOdd, Integer> {
//endregion your codes 1

    //region your codes 2

    /**
     * 查询站点支持彩种
     *
     * @param SiteLotteryOdd
     * @return
     */

    Integer getOddBySiteId(SiteLotteryOdd listVo);
    //endregion your codes 2

}