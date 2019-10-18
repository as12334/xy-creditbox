package so.wwb.creditbox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.sys.po.SysCurrency;
import so.wwb.creditbox.model.manager.sys.so.SysCurrencySo;


/**
 * 币种表值对象
 *
 * @author catban
 * @time 2015-12-17 15:27:35
 */
//region your codes 1
public class SysCurrencyVo extends BaseObjectVo<SysCurrency, SysCurrencySo, SysCurrencyVo.SysCurrencyQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -906952714834579381L;
    //endregion your codes 5

    /**
     *  币种表查询逻辑
     */
    public static class SysCurrencyQuery extends AbstractQuery<SysCurrencySo> {

        //region your codes 6
        private static final long serialVersionUID = 1883763216338661061L;
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