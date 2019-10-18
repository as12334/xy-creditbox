package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryQuotaSet;
import so.wwb.creditbox.model.company.lottery.so.LotteryQuotaSetSo;

import java.util.List;

/**
 * 彩票限额设置表值对象
 *
 * @author diego
 * @time 2018-02-11
 */

public class LotteryQuotaSetVo extends BaseObjectVo<LotteryQuotaSet, LotteryQuotaSetSo, LotteryQuotaSetVo.LotteryQuotaSetQuery> {


    private static final long serialVersionUID = -6334734578824593405L;

    private List<LotteryQuotaSet> quotaSetList;
    private String lotteryQuotaSetJson;


    public List<LotteryQuotaSet> getQuotaSetList() {
        return quotaSetList;
    }

    public void setQuotaSetList(List<LotteryQuotaSet> quotaSetList) {
        this.quotaSetList = quotaSetList;
    }

    public String getLotteryQuotaSetJson() {
        return lotteryQuotaSetJson;
    }

    public void setLotteryQuotaSetJson(String lotteryQuotaSetJson) {
        this.lotteryQuotaSetJson = lotteryQuotaSetJson;
    }

    /**
     *  彩票限额设置表查询逻辑
     */
    public static class LotteryQuotaSetQuery extends AbstractQuery<LotteryQuotaSetSo> {


        private static final long serialVersionUID = -1502646873271799318L;

        @Override
        public Criteria getCriteria() {
            return null;
        }


    }


}