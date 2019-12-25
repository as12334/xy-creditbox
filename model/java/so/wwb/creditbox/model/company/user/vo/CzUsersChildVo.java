package so.wwb.creditbox.model.company.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.user.po.CzUsersChild;
import so.wwb.creditbox.model.company.user.so.CzUsersChildSo;


/**
 * 值对象
 *
 * @author block
 * @time 2019-12-24 23:36:50
 */
//region your codes 1
public class CzUsersChildVo extends BaseObjectVo<CzUsersChild, CzUsersChildSo, CzUsersChildVo.CzUsersChildQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 3885762595308485292L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class CzUsersChildQuery extends AbstractQuery<CzUsersChildSo> {

        //region your codes 6
        private static final long serialVersionUID = -2265637067960585031L;
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