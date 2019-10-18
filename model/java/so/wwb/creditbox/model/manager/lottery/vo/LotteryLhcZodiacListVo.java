package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryLhcZodiac;
import so.wwb.creditbox.model.manager.lottery.so.LotteryLhcZodiacSo;

/**
 * 六合彩生肖表列表页值对象
 *
 * @author zain
 * @time 2017-8-8 19:35:52
 */
//region your codes 1
public class LotteryLhcZodiacListVo extends BaseListVo<LotteryLhcZodiac, LotteryLhcZodiacSo, LotteryLhcZodiacListVo.LotteryLhcZodiacQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8841714868036986917L;
    //endregion your codes 5

    /**
     *  六合彩生肖表列表查询逻辑
     */
    public static class LotteryLhcZodiacQuery extends AbstractQuery<LotteryLhcZodiacSo> {

        //region your codes 6
        private static final long serialVersionUID = -3031968937394263272L;
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