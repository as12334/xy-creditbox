package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotterySo;

import java.util.ArrayList;


/**
 * 站点彩票列表页值对象
 *
 * @author block
 * @time 2019-10-20 23:13:50
 */
//region your codes 1
public class SiteLotteryListVo extends BaseListVo<SiteLottery, SiteLotterySo, SiteLotteryListVo.SiteLotteryQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 5424524994667954221L;
    //endregion your codes 5

    /**
     *  站点彩票列表查询逻辑
     */
    public static class SiteLotteryQuery extends AbstractQuery<SiteLotterySo> {

        //region your codes 6
        private static final long serialVersionUID = 7241070365988061538L;
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

    private ArrayList<Integer> siteLottery;

    public ArrayList getSiteLottery() {
        return siteLottery;
    }

    public void setSiteLottery(ArrayList siteLottery) {
        this.siteLottery = siteLottery;
    }
    //endregion your codes 4

}