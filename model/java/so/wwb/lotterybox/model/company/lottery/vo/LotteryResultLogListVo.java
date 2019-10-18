package so.wwb.lotterybox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultLog;
import so.wwb.lotterybox.model.company.lottery.so.LotteryResultLogSo;

/**
 * 彩票杀率设置列表页值对象
 *
 * @author rambo
 * @time 2017-9-9 19:13:23
 */
//region your codes 1
public class LotteryResultLogListVo extends BaseListVo<LotteryResultLog, LotteryResultLogSo, LotteryResultLogListVo.LotteryResultLogQuery> {

//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 5149439395760677490L;
    //endregion your codes 5

    /**
     *  彩票杀率设置列表查询逻辑
     */
    public static class LotteryResultLogQuery extends AbstractQuery<LotteryResultLogSo> {


        //region your codes 6
        private static final long serialVersionUID = 4292657760776380362L;
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