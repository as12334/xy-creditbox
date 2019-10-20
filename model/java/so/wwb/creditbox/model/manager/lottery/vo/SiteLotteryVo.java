package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotterySo;


/**
 * 站点彩票值对象
 *
 * @author block
 * @time 2019-10-20 23:13:51
 */
//region your codes 1
public class SiteLotteryVo extends BaseObjectVo<SiteLottery, SiteLotterySo, SiteLotteryVo.SiteLotteryQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -2044113065320494757L;
    //endregion your codes 5

    /**
     *  站点彩票查询逻辑
     */
    public static class SiteLotteryQuery extends AbstractQuery<SiteLotterySo> {

        //region your codes 6
        private static final long serialVersionUID = -9193145025584637753L;
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
    private GameManageOrderVo[] orderList;

    public GameManageOrderVo[] getOrderList() {
        return orderList;
    }

    public void setOrderList(GameManageOrderVo[] orderList) {
        this.orderList = orderList;
    }

    //endregion your codes 4

}