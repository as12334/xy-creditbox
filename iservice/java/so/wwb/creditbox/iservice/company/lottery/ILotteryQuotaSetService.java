package so.wwb.creditbox.iservice.company.lottery;

import so.wwb.creditbox.model.company.lottery.po.LotteryQuotaSet;
import so.wwb.creditbox.model.company.lottery.vo.LotteryQuotaSetListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryQuotaSetVo;

import java.util.Map;

/**
 * 彩票限额设置表服务接口
 *
 * @author diego
 * @time 2018-02-11
 */
public interface ILotteryQuotaSetService {

    /**
     * 缓存赔率设置
     */
    Map<String, Map<String, LotteryQuotaSet>> load(LotteryQuotaSetVo vo);

    LotteryQuotaSetListVo search(LotteryQuotaSetListVo listVo);

    int batchUpdateOnly(LotteryQuotaSetVo vo);

}