package so.wwb.creditbox.model.manager.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.user.po.VUserManager;
import so.wwb.creditbox.model.manager.user.so.VUserManagerSo;


/**
 * 用户管理/详细视图 - Fei  jeremy列表页值对象
 *
 * @author block
 * @time 2019-10-16 18:58:21
 */
//region your codes 1
public class VUserManagerListVo extends BaseListVo<VUserManager, VUserManagerSo, VUserManagerListVo.VUserManagerQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 3110605444957648178L;
    //endregion your codes 5

    /**
     *  用户管理/详细视图 - Fei  jeremy列表查询逻辑
     */
    public static class VUserManagerQuery extends AbstractQuery<VUserManagerSo> {

        //region your codes 6
        private static final long serialVersionUID = -1374211898141443198L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}