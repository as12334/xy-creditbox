package so.wwb.creditbox.service.company.lottery;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.soul.commons.collections.ListTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.HidTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.data.company.lottery.SiteLotteryMapper;
import so.wwb.creditbox.data.company.lottery.SiteLotteryOddsMapper;
import so.wwb.creditbox.iservice.company.lottery.ISiteLotteryOddsService;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryStatusEnum;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.so.SiteLotteryOddsSo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    private static final Log LOG = LogFactory.getLog(SiteLotteryOddsService.class);

//endregion your codes 1

    //region your codes 2

    @Autowired
    private SiteLotteryMapper siteLotteryMapper;


    @Override
    public Map<String, Map<String, SiteLotteryOdds>> load(SiteLotteryOddsListVo siteLotteryOddListVo) {
        SiteLotteryOddsSo search = siteLotteryOddListVo.getSearch();
        Integer siteId = search.getSiteId();
        if (siteId == null) {
            siteId = siteLotteryOddListVo._getSiteId();
        }
        Map<String, Map<String, SiteLotteryOdds>> cacheMap = new HashMap<>();
        String cacheKey;
        String valueKey;
        List<SiteLotteryOdds> list = mapper.getBranchOdds(search);
        for (SiteLotteryOdds siteLotteryOdd : list) {
            cacheKey = CacheKey.getCacheKey(siteId.toString(), search.getHid(),siteLotteryOdd.getCode());
            if (cacheMap.get(cacheKey) == null) {
                cacheMap.put(cacheKey, new HashMap<String, SiteLotteryOdds>());
            }
            valueKey = CacheKey.getCacheKey(siteLotteryOdd.getBetSort());
            cacheMap.get(cacheKey).put(valueKey, siteLotteryOdd);
        }
        return cacheMap;
    }



    @Override
    public SiteLotteryOddsVo initOddsData(SiteLotteryOddsVo vo) {
        SiteLotteryOddsSo so = vo.getSearch();
        List<SiteLottery> search = siteLotteryMapper.search(Criteria.add(SiteLottery.PROP_SITE_ID, Operator.EQ, so.getSiteId())
                .addAnd(SiteLottery.PROP_STATUS, Operator.EQ, LotteryStatusEnum.NORMAL.getCode()));
        vo.setSiteLotteryList(search);

        Map hashMap = new LinkedHashMap<String,SiteLotteryOdds>();
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class, so.getCode());
        switch (lotteryEnum){
            case CQSSC:
                hashMap.put("1-5單碼",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"1_1"));
                hashMap.put("1-5大小",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"2_11"));
                hashMap.put("1-5單雙",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"3_13"));
                hashMap.put("總和大小",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"16_71"));
                hashMap.put("總和單雙",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"17_73"));
                hashMap.put("龍虎",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"18_75"));
                hashMap.put("和",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"18_77"));
                hashMap.put("豹子",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"19_78"));
                hashMap.put("順子",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"19_79"));
                hashMap.put("對子",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"19_80"));
                hashMap.put("半順",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"19_81"));
                hashMap.put("雜六",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"19_82"));
                break;
            case BJPK10:
            case XYFT:
                hashMap.put("1-10單碼",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"1_1"));
                hashMap.put("1-10大小",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"2_11"));
                hashMap.put("1-10單雙",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"3_13"));
                hashMap.put("1-5龍虎",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"4_15"));
                hashMap.put("冠亞大",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"37_168"));
                hashMap.put("冠亞小",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"37_169"));
                hashMap.put("冠亞單",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"38_170"));
                hashMap.put("冠亞双",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"38_171"));

                hashMap.put("冠亞和-3,4,18,19",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"36_151"));
                hashMap.put("冠亞和-5,6,16,17",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"36_153"));
                hashMap.put("冠亞和-7,8,14,15",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"36_155"));
                hashMap.put("冠亞和-9,10,12,13",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"36_157"));
                hashMap.put("冠亞和-11",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"36_159"));
                break;
            case GDKL10:
                hashMap.put("1-8單碼",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"81_1"));
                hashMap.put("1-8大小",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"82_21"));
                hashMap.put("1-8單雙",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"83_23"));
                hashMap.put("1-8方位",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"121_251"));
                hashMap.put("1-8尾大小",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"84_27"));
                hashMap.put("1-8合單雙",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"85_25"));
                hashMap.put("1-8中發白-中發",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"122_283"));
                hashMap.put("1-8中發白-白",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"122_285"));



                hashMap.put("總和大小",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"11_245"));
                hashMap.put("總和單雙",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"12_247"));
                hashMap.put("總和尾大小",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"13_249"));
                hashMap.put("總和龍虎",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"80_307"));


                hashMap.put("任選二",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"72_1"));
                hashMap.put("選二連組",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"74_1"));
                hashMap.put("任選三",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"75_1"));
                hashMap.put("選三前組",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"77_1"));
                hashMap.put("任選四",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"78_1"));
                hashMap.put("任選五",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"79_1"));

//                hashMap.put("選二連直",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"80_307"));
//                hashMap.put("選三前直",mapper.getOddBetSortLine(so.getCode(),so.getSiteId(),so.getHid(),"80_307"));
        }

        vo.setOddsMap(hashMap);
        return vo;
    }

    @Override
    public SiteLotteryOddsVo saveSiteLotteryOdds(SiteLotteryOddsVo siteLotteryOddsVo) {
        JSONArray arr = null;
        try {
            arr = JSONObject.parseArray(siteLotteryOddsVo.getLotteryOddsJson());
        } catch (Exception e) {
            LOG.error("提交赔率格式有问题，转换出错！{0}", siteLotteryOddsVo.getLotteryOddsJson());
            siteLotteryOddsVo.setSuccess(false);
            return siteLotteryOddsVo;
        }
        SiteLotteryOddsSo search = siteLotteryOddsVo.getSearch();
        Integer count = 0;
        for (int i = 0; i < arr.size(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            if (obj != null) {
                String  betSort = obj.getString("betSort");
                String  code = obj.getString("code");
                Double  oddA = obj.getDouble("oddA");
                Double  oddB = obj.getDouble("oddB");
                Double  oddC = obj.getDouble("oddC");
                Double  maxOdd = obj.getDouble("maxOdd");
                Map<String, String> map = SiteLotteryOddsVo.betSortMap.get(code);
                String s = map.get(betSort);
                String[] split = s.split(",");
                siteLotteryOddsVo.setBetSorts(ListTool.newArrayList(split));
                search.setCode(code);
                search.setOddA(oddA);
                search.setOddB(oddB);
                search.setOddC(oddC);
                search.setMaxOdd(maxOdd);
                count += mapper.saveSiteLotteryOdds(siteLotteryOddsVo);
            }
        }
        if(count == 0){
            siteLotteryOddsVo.setSuccess(false);
        }
        return siteLotteryOddsVo;
    }
    //endregion your codes 2

}