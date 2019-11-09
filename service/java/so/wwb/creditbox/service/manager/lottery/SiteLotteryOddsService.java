package so.wwb.creditbox.service.manager.lottery;

import com.sun.javafx.collections.MappingChange;
import org.apache.commons.collections.map.LinkedMap;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.data.manager.lottery.SiteLotteryMapper;
import so.wwb.creditbox.data.manager.lottery.SiteLotteryOddsMapper;
import so.wwb.creditbox.iservice.manager.lottery.ISiteLotteryOddsService;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryStatusEnum;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotteryOddsSo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsVo;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * 服务
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public class SiteLotteryOddsService extends BaseService<SiteLotteryOddsMapper, SiteLotteryOddsListVo, SiteLotteryOddsVo, SiteLotteryOdds, Integer> implements ISiteLotteryOddsService {

//endregion your codes 1

    //region your codes 2

    @Autowired
    private SiteLotteryMapper siteLotteryMapper;

    @Override
    public SiteLotteryOddsVo initData(SiteLotteryOddsVo vo) {
        SiteLotteryOddsSo so = vo.getSearch();
        List<SiteLottery> search = siteLotteryMapper.search(Criteria.add(SiteLottery.PROP_SITE_ID, Operator.EQ, so.getSiteId())
                .addAnd(SiteLottery.PROP_STATUS, Operator.EQ, LotteryStatusEnum.NORMAL.getCode()));
        vo.setSiteLotteryList(search);

        Map hashMap = new LinkedHashMap<String,SiteLotteryOdds>();
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class, so.getCode());
        switch (lotteryEnum){
            case CQSSC:
                hashMap.put("1-5單碼",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),1_1));
                hashMap.put("1-5大小",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),2_11));
                hashMap.put("1-5單雙",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),3_13));
                hashMap.put("總和大小",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),16_71));
                hashMap.put("總和單雙",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),17_73));
                hashMap.put("龍虎",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),18_75));
                hashMap.put("和",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),18_77));
                hashMap.put("豹子",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),19_78));
                hashMap.put("順子",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),19_79));
                hashMap.put("對子",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),19_80));
                hashMap.put("半順",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),19_81));
                hashMap.put("雜六",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),19_82));
                break;
            case BJPK10:
            case XYFT:
                hashMap.put("1-10單碼",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),1_1));
                hashMap.put("1-10大小",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),2_11));
                hashMap.put("1-10單雙",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),3_13));
                hashMap.put("1-5龍虎",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),4_15));
                hashMap.put("冠亞大",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),37_168));
                hashMap.put("冠亞小",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),37_169));
                hashMap.put("冠亞單",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),38_170));
                hashMap.put("冠亞雙",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),38_171));
                break;
            case GDKL10:
                hashMap.put("1-8單碼",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),81_1));
                hashMap.put("1-8大小",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),82_21));
                hashMap.put("1-8單雙",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),83_23));
                hashMap.put("1-8方位",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),121_251));
                hashMap.put("1-8尾大小",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),84_27));
                hashMap.put("1-8合單雙",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),85_25));
                hashMap.put("1-8中發白-中發",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),122_283));
                hashMap.put("1-8中發白-白",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),122_285));



                hashMap.put("總和大小",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),11_245));
                hashMap.put("總和單雙",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),12_247));
                hashMap.put("總和尾大小",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),13_249));
                hashMap.put("總和龍虎",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),80_307));


                hashMap.put("任選二",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),72_1));
                hashMap.put("選二連組",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),74_1));
                hashMap.put("任選三",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),75_1));
                hashMap.put("選三前組",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),77_1));
                hashMap.put("任選四",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),78_1));
                hashMap.put("任選五",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),79_1));

//                hashMap.put("選二連直",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),80_307));
//                hashMap.put("選三前直",mapper.getBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),80_307));
        }

        vo.setOddsMap(hashMap);
        return vo;
    }
    //endregion your codes 2

}