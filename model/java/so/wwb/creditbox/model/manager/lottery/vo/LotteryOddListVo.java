package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdd;
import so.wwb.creditbox.model.manager.lottery.so.LotteryOddSo;


/**
 * 赔率设置表列表页值对象
 *
 * @author block
 * @time 2019-10-21 21:46:34
 */
//region your codes 1
public class LotteryOddListVo extends BaseListVo<LotteryOdd, LotteryOddSo, LotteryOddListVo.LotteryOddQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7204461919539879688L;
    //endregion your codes 5

    /**
     *  赔率设置表列表查询逻辑
     */
    public static class LotteryOddQuery extends AbstractQuery<LotteryOddSo> {

        //region your codes 6
        private static final long serialVersionUID = -939678255459053352L;
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