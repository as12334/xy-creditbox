package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Order;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.sys.po.VSysDomain;
import so.wwb.lotterybox.model.manager.sys.so.VSysDomainSo;


/**
 * 域名视图列表页值对象
 *
 * @author cherry
 * @time 2017-4-3 15:11:07
 */
//region your codes 1
public class VSysDomainListVo extends BaseListVo<VSysDomain, VSysDomainSo, VSysDomainListVo.VSysDomainQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 1586529376606586422L;
    //endregion your codes 5

    /**
     * 域名视图列表查询逻辑
     */
    public static class VSysDomainQuery extends AbstractQuery<VSysDomainSo> {

        //region your codes 6
        private static final long serialVersionUID = -1682213007229701171L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(VSysDomain.PROP_SITE_ID, Operator.EQ, searchObject.getSiteId())
                    .addAnd(VSysDomain.PROP_RESOLVE_STATUS, Operator.EQ, searchObject.getResolveStatus())
                    .addAnd(VSysDomain.PROP_PAGE_URL, Operator.EQ, searchObject.getPageUrl())
                    .addAnd(VSysDomain.PROP_NAME, Operator.LIKE, searchObject.getName())
                    .addAnd(VSysDomain.PROP_DOMAIN, Operator.LIKE, searchObject.getDomain())
                    .addAnd(VSysDomain.PROP_SUBSYS_CODE, Operator.EQ, searchObject.getSubsysCode())
                    .addAnd(VSysDomain.PROP_IS_DELETED, Operator.EQ, false)
                    .addAnd(VSysDomain.PROP_SUBSYS_CODE, Operator.IN, searchObject.getSubSysCodes());

            Criteria orCriteria = Criteria.or(Criteria.add(VSysDomain.PROP_SITE_ID, Operator.EQ, searchObject.getOrSiteId()),
                    Criteria.add(VSysDomain.PROP_PARENT_ID, Operator.EQ, searchObject.getOrParentId()));
            criteria.addAnd(orCriteria);
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3

        @Override
        public Sort getDefaultSort() {
            return Sort.add(VSysDomain.PROP_ID, Direction.DESC);
        }

        @Override
        public Order[] getOrders() {
            return new Order[]{Order.asc(VSysDomain.PROP_RESOLVE_STATUS),Order.desc(VSysDomain.PROP_CREATE_TIME)};
        }

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}