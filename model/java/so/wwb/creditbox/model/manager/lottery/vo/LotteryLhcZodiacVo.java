package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryLhcZodiac;
import so.wwb.creditbox.model.manager.lottery.so.LotteryLhcZodiacSo;

/**
 * 六合彩生肖表值对象
 *
 * @author zain
 * @time 2017-8-8 19:35:52
 */
//region your codes 1
public class LotteryLhcZodiacVo extends BaseObjectVo<LotteryLhcZodiac, LotteryLhcZodiacSo, LotteryLhcZodiacVo.LotteryLhcZodiacQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -2921811086064679294L;
    //endregion your codes 5

    /**
     *  六合彩生肖表查询逻辑
     */
    public static class LotteryLhcZodiacQuery extends AbstractQuery<LotteryLhcZodiacSo> {

        //region your codes 6
        private static final long serialVersionUID = 7313836831920885006L;
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