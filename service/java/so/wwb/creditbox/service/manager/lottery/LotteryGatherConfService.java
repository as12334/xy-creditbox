package so.wwb.creditbox.service.manager.lottery;

import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.lottery.LotteryGatherConfMapper;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryGatherConfService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryGatherConfListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryGatherConfVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryGatherConfService extends BaseService<LotteryGatherConfMapper, LotteryGatherConfListVo, LotteryGatherConfVo, LotteryGatherConf, Integer> implements ILotteryGatherConfService {


    @Override
    public Map<String,Map<String,List<LotteryGatherConf>>> load(LotteryGatherConfListVo lotteryGatherConfListVo) {
        List<LotteryGatherConf> gatherConfs = allSearch(lotteryGatherConfListVo);
        Map<String,Map<String,List<LotteryGatherConf>>> result = new HashMap<>();
        for(LotteryGatherConf conf : gatherConfs){
            Map<String,List<LotteryGatherConf>> map = new HashMap<>();
            List<LotteryGatherConf> list = new ArrayList<>();
            if(result.containsKey(conf.getConfType())){
                map = result.get(conf.getConfType());
            }if(map.containsKey(conf.getCode())){
                list = map.get(conf.getCode());
            }
            list.add(conf);
            map.put(conf.getCode(),list);
            result.put(conf.getConfType(),map);
        }
        return result;
    }
}