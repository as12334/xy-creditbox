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
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultNumberVo;

/**
 * 站点派彩任务
 *
 * @author marz
 * @time 2018-3-9 10:27:40
 */
public class LotteryResultPayoutTask extends CommonTask<LotteryResultNumberVo> {

    public static final Log LOG = LogFactory.getLog(LotteryResultPayoutTask.class);

    @Autowired
    private ILotteryResultNumberService lotteryResultNumberService;

    private LotteryResultNumberVo numberVo;

    public void setNumberVo(LotteryResultNumberVo numberVo) {
        this.numberVo = numberVo;
    }

    @Override
    public LotteryResultNumberVo call() {
        if(this.numberVo == null || this.numberVo._getSiteId() == null || this.numberVo.getResult() == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("派彩失败,缺少派彩参数");
            LOG.error("LotteryResultPayoutTask:彩票派彩失败,缺少派彩参数");
            return this.numberVo;
        }
        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.numberVo._getSiteId());
        if(dataSource == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少商户数据源");
            LOG.error("LotteryResultPayoutTask:站点:{0},彩票采集失败,原因:{1}",this.numberVo._getSiteId(),this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DataContext.setDataSource(dataSource);
        CommonContext.set(new ContextParam());
        CommonContext.get().setSiteId(this.numberVo._getSiteId());
        this.numberVo = lotteryResultNumberService.saveOrUpdateByLotteryResult(this.numberVo);
        if(!this.numberVo.isSuccess()){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg(this.numberVo.getErrMsg());
            LOG.error("LotteryResultPayoutTask:站点:{0},彩票派彩失败,原因:{1}",this.numberVo._getSiteId(),this.numberVo.getErrMsg());
            return this.numberVo;
        }
        return lotteryResultNumberService.payout(this.numberVo);
    }
}