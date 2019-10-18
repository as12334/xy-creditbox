package so.wwb.lotterybox.model.manager.lottery.vo;
import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryErrorLog;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryErrorLogSo;

/**
 * 彩票失败日志值对象
 *
 * @author steady
 * @time 2018-5-24 14:52:46
 */
public class LotteryErrorLogVo extends BaseObjectVo<LotteryErrorLog, LotteryErrorLogSo, LotteryErrorLogVo.LotteryErrorLogQuery> {
    private static final long serialVersionUID = 2849571759976974928L;

    private String showType;

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    /**
     *  彩票失败日志查询逻辑
     */
    public static class LotteryErrorLogQuery extends AbstractQuery<LotteryErrorLogSo> {
        private static final long serialVersionUID = 5742351563347451068L;
        @Override
        public Criteria getCriteria() {
            return null;
        }
     }
}