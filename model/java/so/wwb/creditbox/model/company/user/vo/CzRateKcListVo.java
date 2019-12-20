package so.wwb.creditbox.model.company.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.user.po.CzRateKc;
import so.wwb.creditbox.model.company.user.so.CzRateKcSo;


/**
 * 列表页值对象
 *
 * @author block
 * @time 2019-12-19 23:20:50
 */
//region your codes 1
public class CzRateKcListVo extends BaseListVo<CzRateKc, CzRateKcSo, CzRateKcListVo.CzRateKcQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 3311837982583808573L;
    //endregion your codes 5

    /**
     *  列表查询逻辑
     */
    public static class CzRateKcQuery extends AbstractQuery<CzRateKcSo> {

        //region your codes 6
        private static final long serialVersionUID = -4575264060227996196L;
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