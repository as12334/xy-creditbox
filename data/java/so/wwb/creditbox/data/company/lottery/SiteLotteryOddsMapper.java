package so.wwb.creditbox.data.company.lottery;

import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.company.lottery.so.SiteLotteryOddsSo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;

import java.util.List;


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
    SiteLotteryOdds getOddBetSortLine(String code ,Integer siteId,String hid,String betSort);

    Integer saveSiteLotteryOdds(SiteLotteryOddsVo search);

    List<SiteLotteryOdds> getBranchOdds(SiteLotteryOddsSo search);

    //endregion your codes 2

}