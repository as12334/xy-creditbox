package so.wwb.creditbox.model.company.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.company.user.so.VSiteUserSo;


/**
 * 值对象
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
//region your codes 1
public class VSiteUserVo extends BaseObjectVo<VSiteUser, VSiteUserSo, VSiteUserVo.VSiteUserQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 6694474193966734089L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class VSiteUserQuery extends AbstractQuery<VSiteUserSo> {

        //region your codes 6
        private static final long serialVersionUID = 164756431342350909L;
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