package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.sys.po.VSysRole;
import so.wwb.lotterybox.model.manager.sys.so.VSysRoleSo;


/**
 * @author: tom
 * @date: 15-7-10
 */
public class VSysRoleVo extends BaseObjectVo<VSysRole, VSysRoleSo, VSysRoleVo.VSysRoleQuery> {

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