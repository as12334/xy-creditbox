package so.wwb.creditbox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.site.po.VSiteUserAccount;
import so.wwb.creditbox.model.manager.site.so.VSiteUserAccountSo;


/**
 * 站点管理查询子账户列表页值对象
 *
 * @author wzw
 * @time 2017-5-3 17:49:34
 */
//region your codes 1
public class VSiteUserAccountListVo extends BaseListVo<VSiteUserAccount, VSiteUserAccountSo, VSiteUserAccountListVo.VSiteUserAccountQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -837949584884922450L;
    //endregion your codes 5

    /**
     *  站点管理查询子账户列表查询逻辑
     */
    public static class VSiteUserAccountQuery extends AbstractQuery<VSiteUserAccountSo> {

        //region your codes 6
        private static final long serialVersionUID = -6548615269272518329L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = new Criteria();
            criteria.addAnd(VSiteUserAccount.PROP_SITE_ID, Operator.EQ,searchObject.getSiteId());
            criteria.addAnd(VSiteUserAccount.PROP_OWNER_ID, Operator.EQ,searchObject.getOwnerId());
            criteria.addAnd(VSiteUserAccount.PROP_USER_TYPE, Operator.EQ,searchObject.getUserType());
            return criteria;
            //endregion your codes 2
        }

        @Override
        public Order[] getOrders() {
            return new Order[]{Order.asc(VSiteUserAccount.PROP_ID)};
        }
        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}