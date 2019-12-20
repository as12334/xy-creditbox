package so.wwb.creditbox.model.company.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.user.po.CzRateKc;
import so.wwb.creditbox.model.company.user.so.CzRateKcSo;


/**
 * 值对象
 *
 * @author block
 * @time 2019-12-19 23:20:50
 */
//region your codes 1
public class CzRateKcVo extends BaseObjectVo<CzRateKc, CzRateKcSo, CzRateKcVo.CzRateKcQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 8395060447469699712L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class CzRateKcQuery extends AbstractQuery<CzRateKcSo> {

        //region your codes 6
        private static final long serialVersionUID = -2334185270301537746L;
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