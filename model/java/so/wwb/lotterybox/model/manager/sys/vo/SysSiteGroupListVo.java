package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.sys.po.SysSiteGroup;
import so.wwb.lotterybox.model.manager.sys.so.SysSiteGroupSo;


/**
 * 站点分组表列表页值对象
 *
 * @author steady
 * @time 2018-9-10 16:24:29
 */
public class SysSiteGroupListVo extends BaseListVo<SysSiteGroup, SysSiteGroupSo, SysSiteGroupListVo.SysSiteGroupQuery> {
    private static final long serialVersionUID = -5042137175457495817L;
    /**
     *  站点分组表列表查询逻辑
     */
    public static class SysSiteGroupQuery extends AbstractQuery<SysSiteGroupSo> {

        private static final long serialVersionUID = -1795114154296008871L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(SysSiteGroup.PROP_TYPE, Operator.EQ, searchObject.getType());
            criteria.addAnd(SysSiteGroup.PROP_CODE, Operator.EQ, searchObject.getCode());
            return criteria;
        }

        @Override
        public Order[] getOrders() {
            return new Order[]{ Order.asc(SysSiteGroup.PROP_TYPE),Order.desc(SysSiteGroup.PROP_UPDATE_TIME) };
        }
    }
}