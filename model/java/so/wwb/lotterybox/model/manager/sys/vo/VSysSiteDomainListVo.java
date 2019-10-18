package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.enums.sys.ResolveStatusEnum;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.lotterybox.model.manager.sys.so.VSysSiteDomainSo;


/**
 * 列表页值对象
 *
 * @author Administrator
 * @time 2017-4-12 11:22:59
 */
//region your codes 1
public class VSysSiteDomainListVo extends BaseListVo<VSysSiteDomain, VSysSiteDomainSo, VSysSiteDomainListVo.VSysSiteDomainQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -6343311506577653806L;
    //endregion your codes 5
    //查询类型
    private String searchType;
    /**
     *  列表查询逻辑
     */
    public static class VSysSiteDomainQuery extends AbstractQuery<VSysSiteDomainSo> {

        //region your codes 6
        private static final long serialVersionUID = -5114495108780303693L;

        @Override
        public Sort getDefaultSort() {
            Sort sort = new Sort(Order.desc(VSysSiteDomain.PROP_CREATE_TIME));
            return sort;
        }

        /**
         * 条件被引用,修改时小心
         * @return
         */
        @Override
        public Criteria getCriteria() {
            return Criteria.and(
                    Criteria.add(VSysSiteDomain.PROP_IS_DELETED, Operator.EQ, false),
                    Criteria.add(VSysSiteDomain.PROP_DOM_NAME,Operator.LIKE,searchObject.getDomName()),
                    Criteria.add(VSysSiteDomain.PROP_DOMAIN,Operator.LIKE,searchObject.getDomain()),
                    Criteria.add(VSysSiteDomain.PROP_SITE_ID,Operator.EQ,searchObject.getSiteId()),
                    Criteria.add(VSysSiteDomain.PROP_SITE_USER_ID, Operator.EQ, searchObject.getSiteUserId()),
                    Criteria.add(VSysSiteDomain.PROP_DOMAIN_SUBSYS_CODE, Operator.EQ, searchObject.getDomainSubsysCode()),
                    Criteria.add(VSysSiteDomain.PROP_RESOLVE_STATUS, Operator.EQ, searchObject.getResolveStatus()));
            //endregion your codes 2
        }
        public Criteria getSiteCriteria() {
            //region your codes 2
            return Criteria.and(
                    Criteria.add(VSysSiteDomain.PROP_IS_ENABLE, Operator.EQ,true),
                    Criteria.add(VSysSiteDomain.PROP_RESOLVE_STATUS, Operator.IN, new String[]{ResolveStatusEnum.SUCCESS.getCode(),ResolveStatusEnum.BOUNDED.getCode(),ResolveStatusEnum.TOBETIEDUP.getCode()}),
                    Criteria.add(VSysSiteDomain.PROP_IS_DELETED, Operator.EQ, false),
                    Criteria.add(VSysSiteDomain.PROP_SITE_ID, Operator.GT, 0)
            );
            //endregion your codes 2
        }
        public Criteria getLoadDomainCriteria() {
            //region your codes 2
            return Criteria.and(
                    Criteria.add(VSysSiteDomain.PROP_IS_ENABLE, Operator.EQ,true),
                    Criteria.add(VSysSiteDomain.PROP_RESOLVE_STATUS, Operator.IN, new String[]{ResolveStatusEnum.SUCCESS.getCode(),ResolveStatusEnum.BOUNDED.getCode(),ResolveStatusEnum.TOBETIEDUP.getCode()}),
                    Criteria.add(VSysSiteDomain.PROP_IS_DELETED, Operator.EQ, false)
            );
            //endregion your codes 2
        }

        public Criteria getBySiteIdCriteria() {
            return Criteria.and(
                    Criteria.add(VSysSiteDomain.PROP_IS_ENABLE, Operator.EQ,true),
                    Criteria.add(VSysSiteDomain.PROP_RESOLVE_STATUS, Operator.IN, new String[]{ResolveStatusEnum.SUCCESS.getCode(),ResolveStatusEnum.BOUNDED.getCode(),ResolveStatusEnum.TOBETIEDUP.getCode()}),
                    Criteria.add(VSysSiteDomain.PROP_IS_DELETED, Operator.EQ, false),
                    Criteria.add(VSysSiteDomain.PROP_SITE_ID, Operator.EQ, searchObject.getSiteId())
            );
        }
    }

    //region your codes 4
    public String getSearchType() {
        return searchType;
    }
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
    //endregion your codes 4

}