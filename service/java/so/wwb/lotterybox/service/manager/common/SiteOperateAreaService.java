package so.wwb.lotterybox.service.manager.common;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.service.support.BaseService;
import so.wwb.lotterybox.data.manager.common.SiteOperateAreaMapper;
import so.wwb.lotterybox.iservice.manager.common.ISiteOperateAreaService;
import so.wwb.lotterybox.model.manager.site.po.SiteOperateArea;
import so.wwb.lotterybox.model.manager.site.vo.SiteOperateAreaListVo;
import so.wwb.lotterybox.model.manager.site.vo.SiteOperateAreaVo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 经营地区表服务
 *
 * @author tony
 * @time 2015-11-13 16:24:12
 */
public class SiteOperateAreaService extends BaseService<SiteOperateAreaMapper, SiteOperateAreaListVo, SiteOperateAreaVo, SiteOperateArea, Integer> implements ISiteOperateAreaService {

    @Override
    public Map<String, Map<String, SiteOperateArea>> load(SiteOperateAreaVo siteOperateAreaVo) {
        Integer siteId=siteOperateAreaVo.getSearch().getSiteId();
        if(siteId==null){
            siteId=siteOperateAreaVo._getSiteId();
        }
        Map<String, Map<String, SiteOperateArea>> cacheMap = new LinkedHashMap<>();
        List<SiteOperateArea> list = mapper.search(Criteria.add(SiteOperateArea.PROP_SITE_ID, Operator.EQ, siteId), Order.asc(SiteOperateArea.PROP_ID));
        if(list.size()>0) {
            cacheMap.put(siteId.toString(), CollectionTool.toEntityMap(list, SiteOperateArea.PROP_ID, String.class));
        }
        return cacheMap;
    }

}