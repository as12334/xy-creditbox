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
 * 站点初始化开奖结果
 */
public class LotteryResultInitTask extends CommonTask<LotteryResultNumberVo> {

    public static final Log LOG = LogFactory.getLog(LotteryResultInitTask.class);

    @Autowired
    private ILotteryResultNumberService lotteryResultNumberService;

    private LotteryResultNumberVo numberVo;

    public void setNumberVo(LotteryResultNumberVo numberVo) {
        this.numberVo = numberVo;
    }


    @Override
    public LotteryResultNumberVo call() {
        if(this.numberVo == null || this.numberVo._getSiteId() == null ||
                this.numberVo.getSearch().getCodes() == null || this.numberVo.getSearch().getInitDate() == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少参数");
            LOG.error("商户初始化开奖结果失败,原因:{0}",this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.numberVo._getSiteId());
        if(dataSource == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少商户数据源");
            LOG.error("商户初始化开奖结果失败,siteId:{0},原因:{1}",this.numberVo._getSiteId(),this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DataContext.setDataSource(dataSource);
        lotteryResultNumberService.excuteInitLotteryResult(this.numberVo);
        return this.numberVo;
    }


//    //修改初始化方式,保留原有方法 2018-09-10
//    @Override
//    public LotteryResultNumberVo call() {
//        if(this.numberVo == null || this.numberVo._getSiteId() == null || CollectionTool.isEmpty(this.numberVo.getEntities())){
//            this.numberVo.setSuccess(false);
//            this.numberVo.setErrMsg("缺少参数");
//            LOG.error("商户初始化开奖结果失败,原因:{0}",this.numberVo.getErrMsg());
//            return this.numberVo;
//        }
//        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.numberVo._getSiteId());
//        if(dataSource == null){
//            this.numberVo.setSuccess(false);
//            this.numberVo.setErrMsg("缺少商户数据源");
//            LOG.error("商户初始化开奖结果失败,siteId:{0},原因:{1}",this.numberVo._getSiteId(),this.numberVo.getErrMsg());
//            return this.numberVo;
//        }
//        DataContext.setDataSource(dataSource);
//        lotteryResultNumberService.batchInsertNotExist(this.numberVo);
//        return this.numberVo;
//    }
}