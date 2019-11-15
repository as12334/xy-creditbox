package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultSo;

import java.util.Date;


/**
 * 开奖结果主表值对象
 *
 * @author block
 * @time 2019-11-15 9:31:52
 */
//region your codes 1
public class LotteryResultVo extends BaseObjectVo<LotteryResult, LotteryResultSo, LotteryResultVo.LotteryResultQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8695863359077593101L;

    //下一期期号
    private String nextExpect;
    //下一期开奖时间
    private Date nextOpenTime;

//    private LotteryOrderSummaryListVo lotteryOrderSummaryListVo;

    private String updateUserName;
    //派彩来源1.派彩2.重结派彩
    private Integer payoutSource;

    //Specify the IDC
    private String includeIdc;

    //结果中心派彩来源1.站长中心2.总控中心
    private Integer ofPayout;

    private String winRecordJson;

    //自动派彩:auto ,手动派彩:active
    private String payType;
    //endregion your codes 5

    /**
     *  开奖结果主表查询逻辑
     */
    public static class LotteryResultQuery extends AbstractQuery<LotteryResultSo> {

        //region your codes 6
        private static final long serialVersionUID = 3217568169326680735L;
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

    public String getNextExpect() {
        return nextExpect;
    }

    public void setNextExpect(String nextExpect) {
        this.nextExpect = nextExpect;
    }

    public Date getNextOpenTime() {
        return nextOpenTime;
    }

    public void setNextOpenTime(Date nextOpenTime) {
        this.nextOpenTime = nextOpenTime;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Integer getPayoutSource() {
        return payoutSource;
    }

    public void setPayoutSource(Integer payoutSource) {
        this.payoutSource = payoutSource;
    }

    public String getIncludeIdc() {
        return includeIdc;
    }

    public void setIncludeIdc(String includeIdc) {
        this.includeIdc = includeIdc;
    }

    public Integer getOfPayout() {
        return ofPayout;
    }

    public void setOfPayout(Integer ofPayout) {
        this.ofPayout = ofPayout;
    }

    public String getWinRecordJson() {
        return winRecordJson;
    }

    public void setWinRecordJson(String winRecordJson) {
        this.winRecordJson = winRecordJson;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    //endregion your codes 4

}