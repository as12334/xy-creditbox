package so.wwb.creditbox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.sys.po.SysSiteGroup;
import so.wwb.creditbox.model.manager.sys.so.SysSiteGroupSo;


/**
 * 站点分组表值对象
 *
 * @author steady
 * @time 2018-9-10 16:24:29
 */
public class SysSiteGroupVo extends BaseObjectVo<SysSiteGroup, SysSiteGroupSo, SysSiteGroupVo.SysSiteGroupQuery> {

    private static final long serialVersionUID = -6217521678024384329L;

    /**
     *  站点分组表查询逻辑
     */
    public static class SysSiteGroupQuery extends AbstractQuery<SysSiteGroupSo> {

        private static final long serialVersionUID = 7487114002396040173L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(SysSiteGroup.PROP_CODE, Operator.EQ, searchObject.getCode());
            return criteria;
        }
    }
}