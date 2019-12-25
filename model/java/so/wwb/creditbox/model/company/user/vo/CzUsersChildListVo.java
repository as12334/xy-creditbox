package so.wwb.creditbox.model.company.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.user.po.CzUsersChild;
import so.wwb.creditbox.model.company.user.so.CzUsersChildSo;


/**
 * 列表页值对象
 *
 * @author block
 * @time 2019-12-24 23:36:50
 */
//region your codes 1
public class CzUsersChildListVo extends BaseListVo<CzUsersChild, CzUsersChildSo, CzUsersChildListVo.CzUsersChildQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 1509191371520687108L;
    //endregion your codes 5

    /**
     *  列表查询逻辑
     */
    public static class CzUsersChildQuery extends AbstractQuery<CzUsersChildSo> {

        //region your codes 6
        private static final long serialVersionUID = -8250814138586847176L;
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