package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.sys.po.SysParam;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.sys.ResolveStatusEnum;
import so.wwb.lotterybox.model.manager.sys.po.SysDomain;
import so.wwb.lotterybox.model.manager.sys.so.SysDomainSo;

import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * 站长域名表-修改完会替换 sys_domain列表页值对象
 *
 * @author jeff
 * @time 2015-8-20 14:14:39
 */
//region your codes 1
public class SysDomainListVo extends BaseListVo<SysDomain, SysDomainSo, SysDomainListVo.SysDomainQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 5517585906356136950L;
    private String mainDomain;//主域名
    private Collection<SysParam> domainTypes;
    private List<Integer> ids;
    private List<Map<String, Object>> someDomain;
    private List<Map<String, Object>> rankCount;
    private Long rankTotal;

    /*前端展示设置*/
    private List<SysDomain> domains;
    private List<Integer> changeStatusFalse;

    public Map<Integer, SysUser> userAgentMap;

    //查询类型
    private String searchType;
    private String isPart;
    private static final String DOMAIN_TYPE_ADMIN = "admin";
    /**
     * 系统参数 前台是否显示备用网址页面
     */
    private SysParam sysParam;
    //endregion your codes 5

    /**
     * 站长域名表-修改完会替换 sys_domain列表查询逻辑
     */
    public static class SysDomainQuery extends AbstractQuery<SysDomainSo> {

        //region your codes 6
        private static final long serialVersionUID = 5679344158349712634L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(SysDomain.PROP_SITE_ID, Operator.EQ, searchObject.getSiteId());
            criteria.addAnd(SysDomain.PROP_RESOLVE_STATUS, Operator.EQ, searchObject.getResolveStatus());
            criteria.addAnd(SysDomain.PROP_PAGE_URL, Operator.EQ, searchObject.getPageUrl());
            criteria.addAnd(SysDomain.PROP_NAME, Operator.LIKE, searchObject.getName());
            criteria.addAnd(SysDomain.PROP_DOMAIN, Operator.LIKE, searchObject.getDomain());
            criteria.addAnd(SysDomain.PROP_IS_DELETED, Operator.EQ, false);
            criteria.addAnd(SysDomain.PROP_IS_ENABLE, Operator.EQ, searchObject.getIsEnable());
            criteria.addAnd(SysDomain.PROP_SUBSYS_CODE, Operator.EQ, searchObject.getSubsysCode());
            //列表页过滤掉总代，代理域名
            criteria.addAnd(SysDomain.PROP_SUBSYS_CODE, Operator.NE, SubSysCodeEnum.DISTRIBUTOR.getCode());
            return criteria;
        }


        //region your codes 3
        public Criteria checkDomain() {
            Criteria criteria = Criteria.add(SysDomain.PROP_DOMAIN, Operator.EQ, searchObject.getDomain())
                    .addAnd(SysDomain.PROP_IS_DELETED, Operator.EQ, false)
                    .addAnd(SysDomain.PROP_RESOLVE_STATUS, Operator.NE, ResolveStatusEnum.FAIL.getCode());
            if (searchObject.getId() != null) {
                criteria.addAnd(SysDomain.PROP_ID, Operator.NE, searchObject.getId());
            }
            return criteria;
        }

        @Override
        public Sort getDefaultSort() {
            return Sort.add(SysDomain.PROP_IS_DEFAULT, Direction.DESC).add(SysDomain.PROP_CREATE_TIME, Direction.DESC);
        }

        public Criteria getDomainForOutestTengineCriteria() {
            Criteria isDelete = Criteria.add(SysDomain.PROP_IS_DELETED, Operator.EQ, searchObject.getIsDeleted());
            Criteria isEnable = Criteria.add(SysDomain.PROP_IS_ENABLE, Operator.EQ, searchObject.getIsEnable());
            Criteria resolveStatus = Criteria.add(SysDomain.PROP_RESOLVE_STATUS, Operator.EQ, searchObject.getResolveStatus());
            return Criteria.and(isEnable, isDelete, resolveStatus);
        }
        //endregion your codes 3
    }

    //region your codes 4

    public String getMainDomain() {
        return mainDomain;
    }

    public void setMainDomain(String mainDomain) {
        this.mainDomain = mainDomain;
    }

    public Collection<SysParam> getDomainTypes() {
        return domainTypes;
    }

    public void setDomainTypes(Collection<SysParam> domainTypes) {
        this.domainTypes = domainTypes;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public SysParam getSysParam() {
        return sysParam;
    }

    public void setSysParam(SysParam sysParam) {
        this.sysParam = sysParam;
    }

    public List<Map<String, Object>> getSomeDomain() {
        return someDomain;
    }

    public void setSomeDomain(List<Map<String, Object>> someDomain) {
        this.someDomain = someDomain;
    }

    public List<SysDomain> getDomains() {
        return domains;
    }

    public void setDomains(List<SysDomain> domains) {
        this.domains = domains;
    }

    public List<Integer> getChangeStatusFalse() {
        return changeStatusFalse;
    }

    public void setChangeStatusFalse(List<Integer> changeStatusFalse) {
        this.changeStatusFalse = changeStatusFalse;
    }

    public List<Map<String, Object>> getRankCount() {
        return rankCount;
    }

    public void setRankCount(List<Map<String, Object>> rankCount) {
        this.rankCount = rankCount;
    }

    public Map<Integer, SysUser> getUserAgentMap() {
        return userAgentMap;
    }

    public void setUserAgentMap(Map<Integer, SysUser> userAgentMap) {
        this.userAgentMap = userAgentMap;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Long getRankTotal() {
        return rankTotal;
    }

    public void setRankTotal(Long rankTotal) {
        this.rankTotal = rankTotal;
    }

    public String getIsPart() {
        return isPart;
    }

    public void setIsPart(String isPart) {
        this.isPart = isPart;
    }
    //endregion your codes 4

}