package so.wwb.lotterybox.service.manager.lottery.task;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.common.task.CommonTask;
import so.wwb.lotterybox.iservice.company.lottery.ILotteryResultNumberService;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultNumberVo;

/**
 * 补采同步站点开奖结果
 *
 * @author steady
 * @time 2018-07-20
 */
public class LotteryMakeUpTask extends CommonTask<LotteryResultNumberVo> {

    public static final Log LOG = LogFactory.getLog(LotteryMakeUpTask.class);

    @Autowired
    private ILotteryResultNumberService lotteryResultNumberService;

    private LotteryResultNumberVo numberVo;

    public void setNumberVo(LotteryResultNumberVo numberVo) {
        this.numberVo = numberVo;
    }

    @Override
    public Object call() throws Exception {
        if(this.numberVo == null || this.numberVo._getSiteId() == null || CollectionTool.isEmpty(this.numberVo.getEntities())){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("商户补采失败,缺少参数");
            LOG.error("商户补采失败,原因:{0}",this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.numberVo._getSiteId());
        if(dataSource == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少商户数据源");
            LOG.error("商户补采失败,原因:{0}",this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DataContext.setDataSource(dataSource);
        lotteryResultNumberService.batchUpdateExist(this.numberVo);
        return this.numberVo;
    }
}
