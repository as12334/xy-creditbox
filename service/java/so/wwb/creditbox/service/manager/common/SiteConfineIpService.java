package so.wwb.creditbox.service.manager.common;


import org.soul.commons.collections.CollectionTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.common.SiteConfineIpMapper;
import so.wwb.creditbox.iservice.manager.common.ISiteConfineIpService;
import so.wwb.creditbox.model.manager.site.po.SiteConfineIp;
import so.wwb.creditbox.model.manager.site.po.SiteOperateArea;
import so.wwb.creditbox.model.manager.site.vo.SiteConfineIpListVo;
import so.wwb.creditbox.model.manager.site.vo.SiteConfineIpVo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 限制/允许访问站点/管理中心的IP表服务
 *
 * @author tony
 * @time 2015-11-13 16:25:18
 */
public class SiteConfineIpService extends BaseService<SiteConfineIpMapper, SiteConfineIpListVo, SiteConfineIpVo, SiteConfineIp, Integer> implements ISiteConfineIpService {

    @Override
    public Map<String, Map<String, SiteConfineIp>> load(SiteConfineIpVo siteConfineIpVo) {
        Integer siteId=siteConfineIpVo.getSearch().getSiteId();
        if(siteId==null){
            siteId=siteConfineIpVo._getSiteId();
        }
        Map<String, Map<String, SiteConfineIp>> cacheMap = new HashMap<>();
        List<SiteConfineIp> list = mapper.search(Criteria.add(SiteOperateArea.PROP_SITE_ID, Operator.EQ, siteId), Order.asc(SiteConfineIp.PROP_ID));
        if(list.size()>0) {
            cacheMap = new LinkedHashMap<>();
            cacheMap.put(siteId.toString(), CollectionTool.toEntityMap(list, SiteConfineIp.PROP_ID, String.class));
        }
        return cacheMap;
    }

    @Override
    public int ipContains(SiteConfineIpVo objectVo) {
        return mapper.ipContains(objectVo);
    }

}