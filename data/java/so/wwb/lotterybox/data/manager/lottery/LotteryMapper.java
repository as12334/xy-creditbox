package so.wwb.lotterybox.data.manager.lottery;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.manager.lottery.po.Lottery;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryType;
import so.wwb.lotterybox.model.manager.lottery.so.LotterySo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryListVo;

import java.util.List;

/**
 * 彩种表数据访问对象
 *
 * @author shook
 * @time 2017-4-7 19:50:21
 */
//region your codes 1
public interface LotteryMapper extends IBaseMapper<Lottery, Integer> {
    List<Lottery> queryLotteryCode(String lotteryCode);
//endregion your codes 1

    List<Lottery> queryListBySiteId(Integer siteId);
    Lottery queryLottery(String code);

    /**
     * 通过站点id获取站点开放的彩种类型和对应的彩种数
     * @param so siteId not null
     * @return lotteryTYpe
     */
    List<LotteryType> queryLotteryTypeBySiteId(LotterySo so);

    /**仅查询自主彩的彩种数*/
    List<LotteryType> queryOwnLotteryTypeBySiteId(LotteryListVo listVo);

    /**
     * 根据站点id和彩种类型获取彩种
     * @param lottery
     * @return
     */
    List<Lottery> queryLotteryBysiteIdType(Lottery lottery);

}