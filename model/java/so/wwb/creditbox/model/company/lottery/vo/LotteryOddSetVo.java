package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryOddSet;
import so.wwb.creditbox.model.company.lottery.so.LotteryOddSetSo;

/**
 * 彩票赔率设置表值对象
 *
 * @author diego
 * @time 2018-02-11
 */

public class LotteryOddSetVo extends BaseObjectVo<LotteryOddSet, LotteryOddSetSo, LotteryOddSetVo.LotteryOddSetQuery> {


    private static final long serialVersionUID = -3796279123161423878L;

    //下注json
    private String lotteryOddSetJson;

    public String getLotteryOddSetJson() {
        return lotteryOddSetJson;
    }

    public void setLotteryOddSetJson(String lotteryOddSetJson) {
        this.lotteryOddSetJson = lotteryOddSetJson;
    }

    /**
     *  彩票赔率设置表查询逻辑
     */
    public static class LotteryOddSetQuery extends AbstractQuery<LotteryOddSetSo> {


        private static final long serialVersionUID = -7615126202072163880L;

        @Override
        public Criteria getCriteria() {
            return null;
        }


    }


}