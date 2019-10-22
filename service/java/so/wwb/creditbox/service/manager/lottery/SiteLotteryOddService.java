package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.lottery.SiteLotteryOddMapper;
import so.wwb.creditbox.iservice.manager.lottery.ISiteLotteryOddService;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdd;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 赔率设置表服务
 *
 * @author block
 * @time 2019-10-21 22:52:08
 */
//region your codes 1
public class SiteLotteryOddService extends BaseService<SiteLotteryOddMapper, SiteLotteryOddListVo, SiteLotteryOddVo, SiteLotteryOdd, Integer> implements ISiteLotteryOddService {
//endregion your codes 1

    //region your codes 2

    @Override
    public Map<String, Map<String, SiteLotteryOdd>> load(SiteLotteryOddListVo siteLotteryOddListVo) {
        Integer siteId = siteLotteryOddListVo.getSearch().getSiteId();
        if (siteId == null) {
            siteId = siteLotteryOddListVo._getSiteId();
        }
        Criteria criteria = Criteria.add(SiteLotteryOdd.PROP_SITE_ID, Operator.EQ, siteId);
        Map<String, Map<String, SiteLotteryOdd>> cacheMap = new HashMap<>();
        List<SiteLotteryOdd> list = this.mapper.search(criteria);
        String cacheKey;
        String valueKey;
        for (SiteLotteryOdd siteLotteryOdd : list) {
            cacheKey = CacheKey.getCacheKey(siteId.toString(), siteLotteryOdd.getCode());
            if (cacheMap.get(cacheKey) == null) {
                cacheMap.put(cacheKey, new HashMap<String, SiteLotteryOdd>());
            }
            valueKey = CacheKey.getCacheKey(siteLotteryOdd.getBetCode(), siteLotteryOdd.getBetNum());
            cacheMap.get(cacheKey).put(valueKey, siteLotteryOdd);
        }
        return cacheMap;
    }

    @Override
    public Integer getOddBySiteId(SiteLotteryOdd listVo) {
        return mapper.getOddBySiteId(listVo);
    }

    //endregion your codes 2

}