package so.wwb.lotterybox.data.company.lottery;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.company.lottery.po.LotteryOddSet;
import so.wwb.lotterybox.model.company.lottery.so.LotteryOddSetSo;

import java.util.List;

/**
 * 彩票赔率设置表数据访问对象
 *
 * @author diego
 * @time 2018-02-11
 */

public interface LotteryOddSetMapper extends IBaseMapper<LotteryOddSet, Integer> {

    void initLotteryOddSet (LotteryOddSetSo lotteryOddSetSo);

    List<LotteryOddSet> searchAllOdds();

    Integer deleteLotteryOddSetByProject(LotteryOddSet lotteryOddSet);

}