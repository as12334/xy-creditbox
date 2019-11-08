package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.manager.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotteryOddsSo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 值对象
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public class SiteLotteryOddsVo extends BaseObjectVo<SiteLotteryOdds, SiteLotteryOddsSo, SiteLotteryOddsVo.SiteLotteryOddsQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 1512323731168965695L;

    private  List<SiteLottery> siteLotteryList;

    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class SiteLotteryOddsQuery extends AbstractQuery<SiteLotteryOddsSo> {

        //region your codes 6
        private static final long serialVersionUID = -8595652773641667966L;
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

    public List<SiteLottery> getSiteLotteryList() {
        return siteLotteryList;
    }

    public void setSiteLotteryList(List<SiteLottery> siteLotteryList) {
        this.siteLotteryList = siteLotteryList;
    }

    //endregion your codes 4

}