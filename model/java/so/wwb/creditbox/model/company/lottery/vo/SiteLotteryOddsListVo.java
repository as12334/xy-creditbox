package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.so.SiteLotteryOddsSo;


/**
 * 列表页值对象
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public class SiteLotteryOddsListVo extends BaseListVo<SiteLotteryOdds, SiteLotteryOddsSo, SiteLotteryOddsListVo.SiteLotteryOddsQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8037799286391377037L;
    //endregion your codes 5

    /**
     *  列表查询逻辑
     */
    public static class SiteLotteryOddsQuery extends AbstractQuery<SiteLotteryOddsSo> {

        //region your codes 6
        private static final long serialVersionUID = 8699937773628779735L;
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