package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.LotteryType;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryVo;

import java.util.List;
import java.util.Map;

/**
 * 彩种表服务接口
 */
public interface ILotteryService extends IBaseService<LotteryListVo, LotteryVo, Lottery, Integer> {

    /**
     * 按站点的彩种缓存
     * @param vo LotteryVo
     * @return Map<String, Map<String, Lottery>>
     */
//    Map<String, List<Lottery>> load(LotteryVo vo);
    Map<String, Map<String, Lottery>> load(LotteryVo vo);

    /**
     * 保存排序
     * @param lotteryVo
     */
    LotteryVo saveLotteryOrder(LotteryVo lotteryVo);

    /**
     * 更改彩种玩法形式
     * @param lotteryVo
     */
    LotteryVo changeLotteryGenre(LotteryVo lotteryVo);

    List<Lottery> queryLotteryCode(String typeCode);
    /**
     * 保存彩种
     * @param objectVo
     */
    LotteryVo saveLottery(LotteryVo objectVo);
    /**
     * 更改彩种状态
     * @param lotteryVo
     */
    LotteryVo updateLotteryStatus(LotteryVo lotteryVo);
    /**
     * 彩种同步
     * @param lotteryListVo
     */
    LotteryVo saveSync(LotteryListVo lotteryListVo, Map map);
    /**
     * 下架彩种
     * @param lotteryListVo
     */
    LotteryVo saveTakeOff(LotteryListVo lotteryListVo, Map map);

    /**
     * 获取站点开放彩种的类型
     * @param vo
     *  search.siteId not null
     *  search.model 排除玩法模式
     * @return
     */
    List<LotteryType> queryLotteryTypeBySiteId(LotteryVo vo);

    /**仅查询自主彩的彩种数*/
    List<LotteryType> queryOwnLotteryTypeBySiteId(LotteryListVo listVo);

    /**
     * 根据站点和彩种类型获取对应的彩种
     * @param siteId
     * @param code
     * @return
     */
    List<Lottery> queryLotteryBySiteIdType(Integer siteId, String code);

    List<Lottery> queryLotteryBySiteId(Integer siteId);

}