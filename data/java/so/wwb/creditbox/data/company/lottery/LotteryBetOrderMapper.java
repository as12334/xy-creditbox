package so.wwb.creditbox.data.company.lottery;

import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.so.LotteryBetOrderSo;

import java.util.List;


/**
 * 投注记录表数据访问对象
 *
 * @author block
 * @time 2019-11-27 21:11:28
 */
//region your codes 1
public interface LotteryBetOrderMapper extends IBaseMapper<LotteryBetOrder, Integer> {

//endregion your codes 1

    //region your codes 2
    List<LotteryBetOrder> sumBetCode(LotteryBetOrderSo search);

    List<SiteLotteryOdds> searchOddsInfo(LotteryBetOrderSo search);
    //endregion your codes 2

}