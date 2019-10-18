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
 * 站点批量撤单,撤销任务
 *
 * @author marz
 * @time 2018-4-13 08:52:40
 */
public class LotteryRevoTask extends CommonTask<LotteryResultNumberVo> {

    public static final Log LOG = LogFactory.getLog(LotteryRevoTask.class);

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
            this.numberVo.setErrMsg("缺少派彩参数");
            LOG.error("彩票批量撤单，撤销失败,原因:{0}",this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.numberVo._getSiteId());
        if(dataSource == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少商户数据源");
            LOG.error("彩票批量{0}失败,原因:{1}",this.numberVo.getRevoItemText(), this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DataContext.setDataSource(dataSource);
        CommonContext.set(new ContextParam());
        CommonContext.get().setSiteId(this.numberVo._getSiteId());
        return lotteryResultNumberService.batchRevo(this.numberVo);
    }
}