package so.wwb.lotterybox.service.manager.lottery.task;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.common.task.CommonTask;
import so.wwb.lotterybox.iservice.company.lottery.ILotteryResultNumberService;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultNumberVo;

/**
 * 站点删除开奖结果
 *
 * @author steady
 * @time 2018-07-09
 */
public class LotteryResultDeleteTask extends CommonTask<LotteryResultNumberVo> {

    public static final Log LOG = LogFactory.getLog(LotteryResultDeleteTask.class);

    @Autowired
    private ILotteryResultNumberService lotteryResultNumberService;

    private LotteryResultNumberVo numberVo;

    public void setNumberVo(LotteryResultNumberVo numberVo) {
        this.numberVo = numberVo;
    }

    @Override
    public Object call() throws Exception {
        if(this.numberVo == null || this.numberVo._getSiteId() == null || this.numberVo.getResult() == null
                || this.numberVo.getResult().getCode() == null || this.numberVo.getResult().getExpect() == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少参数");
            LOG.error("商户开奖结果删除失败,原因:{0}",this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.numberVo._getSiteId());
        if(dataSource == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少商户数据源");
            LOG.error("商户开奖结果删除失败,siteId:{0},原因:{1}",this.numberVo._getSiteId(),this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DataContext.setDataSource(dataSource);
        this.numberVo = lotteryResultNumberService.doDelete(this.numberVo);
        if(!this.numberVo.isSuccess()){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg(this.numberVo.getErrMsg());
            LOG.error("商户开奖结果删除失败,原因:{0}",this.numberVo.getErrMsg());
            return this.numberVo;
        }
        return this.numberVo;
    }
}
