package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.site.po.VSiteUserAccount;
import so.wwb.lotterybox.model.manager.site.so.VSiteUserAccountSo;


/**
 * 站点管理查询子账户值对象
 *
 * @author wzw
 * @time 2017-5-3 17:49:34
 */
//region your codes 1
public class VSiteUserAccountVo extends BaseObjectVo<VSiteUserAccount, VSiteUserAccountSo, VSiteUserAccountVo.VSiteUserAccountQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -5600798336612913991L;
    //endregion your codes 5

    /**
     *  站点管理查询子账户查询逻辑
     */
    public static class VSiteUserAccountQuery extends AbstractQuery<VSiteUserAccountSo> {

        //region your codes 6
        private static final long serialVersionUID = -5170671066019903156L;
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