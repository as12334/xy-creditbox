package so.wwb.creditbox.data.manager.lottery;

import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.SiteLottery;
import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotterySo;

import java.util.List;


/**
 * 站点彩票数据访问对象
 *
 * @author block
 * @time 2019-10-20 23:13:50
 */
//region your codes 1
public interface SiteLotteryMapper extends IBaseMapper<SiteLottery, Integer> {
//endregion your codes 1

    //region your codes 2
    void takeOffAllByCode(SiteLotterySo siteLotterySo);


    void takeOff(SiteLotterySo siteLotterySo);


    void sync(SiteLotterySo siteLotterySo);

    void changeAllSiteGenre(Lottery lottery);


    void updateAllSiteOrderNum(List<SiteLottery> list);

    //endregion your codes 2

}