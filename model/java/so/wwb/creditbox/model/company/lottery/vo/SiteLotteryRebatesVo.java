package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.company.lottery.so.SiteLotteryRebatesSo;

import java.util.List;
import java.util.Map;


/**
 * 值对象
 *
 * @author block
 * @time 2019-11-12 0:36:34
 */
//region your codes 1
public class SiteLotteryRebatesVo extends BaseObjectVo<SiteLotteryRebates, SiteLotteryRebatesSo, SiteLotteryRebatesVo.SiteLotteryRebatesQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8832445994781301201L;

    private Map rebatesMap;

    private String lotteryRebatesJson;

    private List<String> betSorts;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class SiteLotteryRebatesQuery extends AbstractQuery<SiteLotteryRebatesSo> {

        //region your codes 6
        private static final long serialVersionUID = 5189710429723578908L;
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

    public Map getRebatesMap() {
        return rebatesMap;
    }

    public void setRebatesMap(Map rebatesMap) {
        this.rebatesMap = rebatesMap;
    }

    public String getLotteryRebatesJson() {
        return lotteryRebatesJson;
    }

    public void setLotteryRebatesJson(String lotteryRebatesJson) {
        this.lotteryRebatesJson = lotteryRebatesJson;
    }

    public List<String> getBetSorts() {
        return betSorts;
    }

    public void setBetSorts(List<String> betSorts) {
        this.betSorts = betSorts;
    }

    //endregion your codes 4

}