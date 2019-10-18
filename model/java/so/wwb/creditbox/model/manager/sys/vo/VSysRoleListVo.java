package so.wwb.creditbox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.sys.po.VSysRole;
import so.wwb.creditbox.model.manager.sys.so.VSysRoleSo;


/**
 * @author: tom
 * @date: 15-7-10
 */
public class VSysRoleListVo extends BaseObjectVo<VSysRole, VSysRoleSo, VSysRoleListVo.VSysRoleQuery> {

    private static final long serialVersionUID = -1189684886568722263L;

    protected static class VSysRoleQuery extends AbstractQuery<VSysRoleSo> {
        private static final long serialVersionUID = -3218615596114712080L;

        protected VSysRoleQuery() {
        }

        public Criteria getCriteria() {
            return null;
        }
    }
}