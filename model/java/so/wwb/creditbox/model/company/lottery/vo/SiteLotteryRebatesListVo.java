package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.company.lottery.so.SiteLotteryRebatesSo;


/**
 * 列表页值对象
 *
 * @author block
 * @time 2019-11-12 0:36:34
 */
//region your codes 1
public class SiteLotteryRebatesListVo extends BaseListVo<SiteLotteryRebates, SiteLotteryRebatesSo, SiteLotteryRebatesListVo.SiteLotteryRebatesQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -5453819095464887055L;
    //endregion your codes 5

    /**
     *  列表查询逻辑
     */
    public static class SiteLotteryRebatesQuery extends AbstractQuery<SiteLotteryRebatesSo> {

        //region your codes 6
        private static final long serialVersionUID = -6552804385768026901L;
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