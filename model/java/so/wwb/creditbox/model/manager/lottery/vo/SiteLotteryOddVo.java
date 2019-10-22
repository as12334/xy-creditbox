package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdd;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotteryOddSo;


/**
 * 赔率设置表值对象
 *
 * @author block
 * @time 2019-10-21 22:52:08
 */
//region your codes 1
public class SiteLotteryOddVo extends BaseObjectVo<SiteLotteryOdd, SiteLotteryOddSo, SiteLotteryOddVo.SiteLotteryOddQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7433855148467286858L;

    //下注json
    private String lotteryOddJson;
    //endregion your codes 5

    /**
     *  赔率设置表查询逻辑
     */
    public static class SiteLotteryOddQuery extends AbstractQuery<SiteLotteryOddSo> {

        //region your codes 6
        private static final long serialVersionUID = 7000083046367992847L;
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

    public String getLotteryOddJson() {
        return lotteryOddJson;
    }

    public void setLotteryOddJson(String lotteryOddJson) {
        this.lotteryOddJson = lotteryOddJson;
    }

    //endregion your codes 4

}