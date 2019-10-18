package so.wwb.creditbox.model.manager.sys.vo;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.sys.po.SysRole;
import so.wwb.creditbox.model.manager.sys.so.SysRoleSo;


/**
 * @author: tom
 * @date: 15-7-10
 */
public class SysRoleVo extends BaseObjectVo<SysRole, SysRoleSo, SysRoleVo.SysRoleQuery> {

    private static final long serialVersionUID = -1189684886568722263L;

    public SysRoleVo() {
    }

    protected static class SysRoleQuery extends AbstractQuery<SysRoleSo> {
        private static final long serialVersionUID = -3218615596114712080L;

        protected SysRoleQuery() {
        }

        public Criteria getCriteria() {
            Criteria criteria = new Criteria();
            if (StringTool.isNotEmpty(this.searchObject.getName())) {
                criteria.addAnd(new Criterion("name", Operator.ILIKE, this.searchObject.getName()));
            }
            return criteria.addAnd(new Criterion("builtIn", Operator.EQ,"f"));
        }
    }
}