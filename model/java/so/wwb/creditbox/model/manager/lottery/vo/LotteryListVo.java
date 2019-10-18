package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.so.LotterySo;

import java.util.ArrayList;

/**
 * 彩种表列表页值对象
 *
 * @author shook
 * @time 2017-4-7 19:50:21
 */
//region your codes 1
public class LotteryListVo extends BaseListVo<Lottery, LotterySo, LotteryListVo.LotteryQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -508088222246187250L;
    //endregion your codes 5

    /**
     *  彩种表列表查询逻辑
     */
    public static class LotteryQuery extends AbstractQuery<LotterySo> {

        //region your codes 6
        private static final long serialVersionUID = 188501406299265130L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(Lottery.PROP_TYPE, Operator.LIKE,searchObject.getType());
            criteria.addAnd(Lottery.PROP_ID,Operator.EQ,searchObject.getId());
            criteria.addAnd(Lottery.PROP_CODE,Operator.LIKE,searchObject.getCode());
            criteria.addAnd(Lottery.PROP_CODE,Operator.NOT_IN,searchObject.getNoIncludeCodeList());
            criteria.addAnd(Lottery.PROP_STATUS,Operator.EQ,searchObject.getStatus());
            criteria.addAnd(Lottery.PROP_SITE_ID,Operator.EQ,searchObject.getSiteId());
            criteria.addAnd(Lottery.PROP_NAME,Operator.LIKE,searchObject.getName());
            criteria.addAnd(Lottery.PROP_CLASSIFY,Operator.EQ,searchObject.getClassify());
            criteria.addAnd(Lottery.PROP_MODEL,Operator.EQ,searchObject.getModel());
            if (CollectionTool.isNotEmpty(searchObject.getOwnCodes())){
                criteria.addAnd(Lottery.PROP_CODE,Operator.IN,searchObject.getOwnCodes());
            }
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4
    private ArrayList<Integer> lottery;

    public ArrayList getLottery() {
        return lottery;
    }

    public void setLottery(ArrayList lottery) {
        this.lottery = lottery;
    }
    //endregion your codes 4

}