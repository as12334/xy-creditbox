package so.wwb.creditbox.model.company.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.user.po.CzUsers;
import so.wwb.creditbox.model.company.user.so.CzUsersSo;


/**
 * 值对象
 *
 * @author block
 * @time 2019-12-19 23:19:54
 */
//region your codes 1
public class CzUsersVo extends BaseObjectVo<CzUsers, CzUsersSo, CzUsersVo.CzUsersQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 5207952723519560027L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class CzUsersQuery extends AbstractQuery<CzUsersSo> {

        //region your codes 6
        private static final long serialVersionUID = -4949272579354239580L;
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