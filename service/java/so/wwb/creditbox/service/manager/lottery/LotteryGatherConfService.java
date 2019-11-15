package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Order;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.lottery.LotteryGatherConfMapper;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryGatherConfService;
import so.wwb.creditbox.model.enums.lottery.LotteryGatherConfStatusEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryGatherConfListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryGatherConfVo;

import java.util.List;
import java.util.Map;


/**
 * 彩票采集接口配置表服务
 *
 * @author block
 * @time 2019-11-15 10:46:12
 */
//region your codes 1
public class LotteryGatherConfService extends BaseService<LotteryGatherConfMapper, LotteryGatherConfListVo, LotteryGatherConfVo, LotteryGatherConf, Integer> implements ILotteryGatherConfService {
//endregion your codes 1

    //region your codes 2
    @Override
    public Map<String, List<LotteryGatherConf>> load(LotteryGatherConfListVo lotteryGatherConfListVo) {
        Criteria criteria = Criteria.add(LotteryGatherConf.PROP_STATUS, Operator.EQ, LotteryGatherConfStatusEnum.NORMAL.getCode());
        criteria = criteria.addAnd(LotteryGatherConf.PROP_CODE, Operator.EQ, lotteryGatherConfListVo.getSearch().getCode());
        List<LotteryGatherConf> gatherConfs = this.mapper.search(criteria,new Order(LotteryGatherConf.PROP_ID, Direction.DESC));
        Map<String, List<LotteryGatherConf>> codeMaps = CollectionTool.groupByProperty(gatherConfs, LotteryGatherConf.PROP_CODE, String.class);
        return codeMaps;
    }

    //endregion your codes 2

}