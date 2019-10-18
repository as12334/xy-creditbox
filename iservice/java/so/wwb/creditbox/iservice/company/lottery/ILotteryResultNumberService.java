package so.wwb.creditbox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultNumberListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultNumberVo;

import java.util.List;
import java.util.Map;

/**
 * 彩票开奖结果表服务接口
 *
 * @author diego
 * @time 2018-02-11
 */

public interface ILotteryResultNumberService extends IBaseService<LotteryResultNumberListVo, LotteryResultNumberVo, LotteryResultNumber, Integer> {


    /**
     * 保存或更新LotteryResultNumber
     * @param numberVo
     * @return
     */
    LotteryResultNumberVo saveOrUpdateByLotteryResult(LotteryResultNumberVo numberVo);

    /**
     * 更新未开奖的LotteryResultNumber
     * @param numberVo
     * @return
     */
    LotteryResultNumberVo updateLotteryResult(LotteryResultNumberVo numberVo);

    /**
     * 批量添加商户开奖结果
     * @param numberVo
     * @return
     */
    int batchInsertNotExist(LotteryResultNumberVo numberVo);
    /**
     * 单站点派彩
     * @param numberVo
     * @return
     */
    LotteryResultNumberVo payout(LotteryResultNumberVo numberVo);
    /**
     * 单站点批量撤单,撤销
     * @param numberVo
     * @return
     */
    LotteryResultNumberVo batchRevo(LotteryResultNumberVo numberVo);

    /**
     * 单站点重结
     * @param numberVo
     * @return
     */
    LotteryResultNumberVo recalculate(LotteryResultNumberVo numberVo);

    /**
     * 最近的开彩记录(包含未开奖)
     */
    List<LotteryResultNumber> queryRecentRecords(LotteryResultNumberListVo listVo);

    /**
     * 最近的开彩记录（不包含未开奖）
     */
    List<LotteryResultNumber> queryRecentRecordsNoOpen(LotteryResultNumberListVo listVo);

    Map getCurLotteryResult(LotteryResultNumberVo vo);

    /**
     * 查询所有彩种最近一期已开奖结果
     * @param listVo listVo
     */
    List<LotteryResultNumber> queryAllLastOpened(LotteryResultNumberListVo listVo);

    /**
     * 删除
     */
    LotteryResultNumberVo doDelete(LotteryResultNumberVo numberVo);

    /**
     * 调盘
     */
    LotteryResultNumberVo doAdjust(LotteryResultNumberVo numberVo);

    /**
     * 调盘
     */
    LotteryResultNumberVo doBatchAdjust(LotteryResultNumberVo numberVo);

    /**
     * 批量更新商户开奖结果
     */
    int batchUpdateExist(LotteryResultNumberVo numberVo);

    LotteryResultNumberVo excuteInitLotteryResult(LotteryResultNumberVo numberVo);

    /**
     * 更新未开奖的LotteryResultNumber
     * @param numberVo
     * @return
     */
    int updateOpenResultNum(LotteryResultNumberVo numberVo);
}