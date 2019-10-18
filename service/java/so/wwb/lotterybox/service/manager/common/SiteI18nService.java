package so.wwb.lotterybox.service.manager.common;


import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Order;
import org.soul.data.mapper.sys.SysParamMapper;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.lotterybox.data.manager.common.SiteI18nMapper;
import so.wwb.lotterybox.iservice.manager.common.ISiteI18nService;
import so.wwb.lotterybox.model.constants.cache.CacheKey;
import so.wwb.lotterybox.model.manager.site.po.SiteI18n;
import so.wwb.lotterybox.model.manager.site.vo.SiteI18nListVo;
import so.wwb.lotterybox.model.manager.site.vo.SiteI18nVo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 站点动态国际化服务
 *
 * @author tony
 * @time 2015-11-13 14:24:42
 */
//region your codes 1
public class SiteI18nService extends BaseService<SiteI18nMapper, SiteI18nListVo, SiteI18nVo, SiteI18n, Integer> implements ISiteI18nService {
//endregion your codes 1

    //region your codes 2
    @Autowired
    private SysParamMapper sysParamMapper;

    @Override
    public Map<String, Map<String, SiteI18n>> load(SiteI18nVo siteI18nVo) {
        Integer siteId=siteI18nVo.getSearch().getSiteId();
        if(siteId==null){
            siteId=siteI18nVo._getSiteId();
        }
        String module = siteI18nVo.getSearch().getModule();
        String type = siteI18nVo.getSearch().getType();
        List<SiteI18n> list = null;
        Map<String, Map<String, SiteI18n>> cacheMap = new LinkedHashMap<>();
        Order[] orders = new Order[]{
                new Order(SiteI18n.PROP_MODULE, Direction.ASC),
                new Order(SiteI18n.PROP_TYPE, Direction.ASC),
                new Order(SiteI18n.PROP_KEY, Direction.ASC),
                new Order(SiteI18n.PROP_LOCALE, Direction.ASC),
        };
        if (StringTool.isNotBlank(module) && StringTool.isNotBlank(type)) {
            list = this.mapper.search(
                    Criteria.and(
                            Criteria.add(SiteI18n.PROP_SITE_ID, Operator.EQ, siteId),
                            Criteria.add(SiteI18n.PROP_MODULE, Operator.EQ, module),
                            Criteria.add(SiteI18n.PROP_TYPE, Operator.EQ, type)
                    ), orders
            );
            Map<String, SiteI18n> beCached = (LinkedHashMap) CollectionTool.toEntityMap(list, SiteI18n.PROP_CACHE_KEY_LOCALE);
            String cacheKey = CacheKey.getCacheKey(siteId.toString(), module, type);
            cacheMap.put(cacheKey, beCached);
        } else {
            list = this.mapper.search(Criteria.add(SiteI18n.PROP_SITE_ID, Operator.EQ, siteId), orders);
            List<SiteI18n> cacheVos = CacheKey.toCacheVo(list, SiteI18n.class);
            Map<String, List<SiteI18n>> groupByed = CollectionTool.groupByProperty(cacheVos, SiteI18n.PROP_CACHE_KEY, String.class);
            for (String key : groupByed.keySet()) {
                LinkedHashMap<String, SiteI18n> beCached = (LinkedHashMap) CollectionTool.toEntityMap(groupByed.get(key), SiteI18n.PROP_CACHE_KEY_LOCALE);
                String realCacheKey = CacheKey.getCacheKey(key);
                cacheMap.put(realCacheKey, beCached);
            }
        }
            return cacheMap;
    }

    @Override
    public int hideInsertI18n(SiteI18nListVo listVo) {
        return this.mapper.hideInsertI18n(listVo);
    }

    @Override
    @Transactional
    public SiteI18nListVo saveClassification(SiteI18nListVo listVo) {
        List<SiteI18n> siteI18nList = new ArrayList<>();//记录新增的活动分类
        List<SiteI18n> updtaeSiteI18ns = new ArrayList<>();//记录更新的活动分类
        boolean success = false;
        //更新修改的操作
        if (CollectionTool.isNotEmpty(updtaeSiteI18ns)) {
            success = this.mapper.batchUpdateOnly(updtaeSiteI18ns, SiteI18n.PROP_VALUE) >= 0;
        }
        //新增活动分类
        if (CollectionTool.isNotEmpty(siteI18nList)) {
            success = this.mapper.batchInsert(siteI18nList) >= 0;
        }
        listVo.setSuccess(success);
        return listVo;
    }
    //endregion your codes 2

}