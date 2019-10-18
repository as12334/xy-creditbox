package so.wwb.creditbox.service.manager.lottery.task;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.common.task.CommonTask;
import so.wwb.creditbox.iservice.company.lottery.ILotteryResultNumberService;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultNumberVo;

/**
 * 彩票自主彩任务(采集-派彩)
 * @author: marz
 * @time 2018-3-14 20:35:57
 */
public class LotteryResultOwnPayoutTask extends CommonTask<LotteryResultNumberVo> {
    public static final Log LOG = LogFactory.getLog(LotteryResultOwnPayoutTask.class);

    @Autowired
    private ILotteryResultNumberService lotteryResultNumberService;

    private LotteryGatherParam gatherParam;

    private LotteryResultNumberVo numberVo;

    public void setGatherParam(LotteryGatherParam gatherParam) {
        this.gatherParam = gatherParam;
    }

    public void setNumberVo(LotteryResultNumberVo numberVo) {
        this.numberVo = numberVo;
    }

    @Override
    public LotteryResultNumberVo call() {
        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.numberVo._getSiteId());
        if(dataSource == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少商户数据源");
            LOG.error("LotteryResultOwnTask:彩票采集派彩失败,原因:{0}",this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DataContext.setDataSource(dataSource);
        CommonContext.set(new ContextParam());
        CommonContext.get().setSiteId(this.numberVo._getSiteId());
        return lotteryResultNumberService.payout(numberVo);
    }
}
