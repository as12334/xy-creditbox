package so.wwb.creditbox.service.manager.sys;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.Paging;
import org.soul.commons.query.enums.Operator;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.sys.VSysSiteDomainMapper;
import so.wwb.creditbox.iservice.manager.sys.IVSysSiteDomainService;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteDomainListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteDomainVo;

import java.util.List;
import java.util.Map;

//region your codes 1
public class VSysSiteDomainService extends BaseService<VSysSiteDomainMapper, VSysSiteDomainListVo, VSysSiteDomainVo, VSysSiteDomain, Integer> implements IVSysSiteDomainService {
//endregion your codes 1

    //region your codes 2
    private final VSysSiteDomainListVo list_vo = new VSysSiteDomainListVo();

    @Override
    public List<VSysSiteDomain> availables(VSysSiteDomainListVo listVo) {
        return this.mapper.search(listVo.getQuery().getCriteria());
    }

    @Override
    public Map<String, VSysSiteDomain> load(VSysSiteDomainVo sysSiteDomainVo) {
        List<VSysSiteDomain> list = mapper.search(list_vo.getQuery().getLoadDomainCriteria());
        return CollectionTool.toEntityMap(list, VSysSiteDomain.PROP_LOWER_DOMAIN, String.class);
    }

    @Override
    public Map<String, Integer> loadDomain(VSysSiteDomainVo sysSiteDomainVo) {
        List<VSysSiteDomain> list = mapper.search(list_vo.getQuery().getSiteCriteria());
        return CollectionTool.extractToMap(list, VSysSiteDomain.PROP_LOWER_DOMAIN, VSysSiteDomain.PROP_SITE_ID);
    }

    @Override
    public List<VSysSiteDomain> getSiteDomainByDomain(VSysSiteDomainVo sysSiteDomainVo) {

        return this.mapper.search(sysSiteDomainVo.getQuery().getCriteria());
    }

    @Override
    public VSysSiteDomainListVo queryMerchantDomain(VSysSiteDomainListVo listVo) {
        Criteria criteria = Criteria.add(VSysSiteDomain.PROP_SITE_ID, Operator.EQ, listVo.getSearch().getSiteId())
                .addAnd(VSysSiteDomain.PROP_DOMAIN_SUBSYS_CODE, Operator.NE, "agent")
                .addAnd(VSysSiteDomain.PROP_DOM_NAME, Operator.LIKE, listVo.getSearch().getDomName())
                .addAnd(VSysSiteDomain.PROP_DOMAIN, Operator.LIKE, listVo.getSearch().getDomain())
                .addAnd(VSysSiteDomain.PROP_RESOLVE_STATUS, Operator.EQ, listVo.getSearch().getResolveStatus());
        Paging paging = listVo.getPaging();
        long count = mapper.count(criteria);
        paging.setTotalCount(count);
        paging.cal();
        int pageNo = paging.getPageNumber();
        int pageSize = paging.getPageSize();
        listVo.setResult(mapper.pagingSearch(criteria, pageNo, pageSize));
        return listVo;
    }

    @Override
    public List<VSysSiteDomain> querySiteDomainUserId(Integer siteId) {
        Criteria criteria = Criteria.add(VSysSiteDomain.PROP_SITE_ID, Operator.EQ, siteId);
        return mapper.search(criteria);
    }

    @Override
    public List<VSysSiteDomain> loadSiteDomain(VSysSiteDomainListVo sysSiteDomainVo) {
        return mapper.search(sysSiteDomainVo.getQuery().getBySiteIdCriteria());
    }

    //endregion your codes 2
}