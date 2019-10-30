package so.wwb.creditbox.model.company.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.company.user.so.VSiteUserSo;


/**
 * 列表页值对象
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
//region your codes 1
public class VSiteUserListVo extends BaseListVo<VSiteUser, VSiteUserSo, VSiteUserListVo.VSiteUserQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 1126250913807854495L;
    //endregion your codes 5

    /**
     *  列表查询逻辑
     */
    public static class VSiteUserQuery extends AbstractQuery<VSiteUserSo> {

        //region your codes 6
        private static final long serialVersionUID = -7807821076448937251L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return Criteria.add(VSiteUser.PROP_USER_TYPE, Operator.EQ,searchObject.getUserType())
                    .addAnd(VSiteUser.PROP_USERNAME, Operator.LIKE_S,searchObject.getUsername())
                    .addAnd(VSiteUser.PROP_STATUS, Operator.EQ,searchObject.getStatus());
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}