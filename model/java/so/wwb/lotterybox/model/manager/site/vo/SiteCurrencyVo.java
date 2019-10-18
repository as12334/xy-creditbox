package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.site.po.SiteCurrency;
import so.wwb.lotterybox.model.manager.site.so.SiteCurrencySo;


/**
 * 币种表值对象
 *
 * @author jerry
 * @time 2017-4-7 10:02:33
 */
//region your codes 1
public class SiteCurrencyVo extends BaseObjectVo<SiteCurrency, SiteCurrencySo, SiteCurrencyVo.SiteCurrencyQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 600026283057043782L;
    //endregion your codes 5

    /**
     *  币种表查询逻辑
     */
    public static class SiteCurrencyQuery extends AbstractQuery<SiteCurrencySo> {

        //region your codes 6
        private static final long serialVersionUID = 6359335824818574457L;
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