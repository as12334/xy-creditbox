package so.wwb.creditbox.schedule.service.manager.task;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.common.task.CommonTask;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryGatherHandle;
import so.wwb.creditbox.iservice.company.lottery.ILotteryResultNumberService;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultNumberVo;
import so.wwb.creditbox.service.manager.lottery.gather.LotteryGatherHandleFactory;

import java.util.Date;

/**
 * 彩票自主彩任务(采集-派彩)
 * @author: marz
 * @time 2018-3-14 20:35:57
 */
public class LotteryResultOwnTask extends CommonTask<LotteryResultNumberVo> {
    public static final Log LOG = LogFactory.getLog(LotteryResultOwnTask.class);

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
        this.numberVo = gather();
        if(!this.numberVo.isSuccess()){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg(numberVo.getErrMsg());
            LOG.error("LotteryResultOwnTask:彩票采集派彩失败,siteId:{0},原因:{1}",this.numberVo._getSiteId(),this.numberVo.getErrMsg());
            return this.numberVo;
        }
        this.numberVo = lotteryResultNumberService.updateLotteryResult(this.numberVo);
        if(!this.numberVo.isSuccess()){
            // 更新开奖结果 避免多线程同时更新开奖结果 直接返回操作成功true
            if(StringTool.isNotBlank(this.numberVo.getOkMsg())){
                this.numberVo.setSuccess(true);
                return this.numberVo;
            }else{
                this.numberVo.setSuccess(false);
                this.numberVo.setErrMsg(this.numberVo.getErrMsg());
                LOG.error("LotteryResultOwnTask:彩票采集派彩失败,原因:{0}",this.numberVo.getErrMsg());
                return this.numberVo;
            }
        }
        return lotteryResultNumberService.payout(numberVo);
    }

    private LotteryResultNumberVo gather(){
        LotteryGatherConf lotteryGatherConf = gatherParam.getLotteryGatherConf();
        ILotteryGatherHandle lotteryHandle = LotteryGatherHandleFactory.getInstance().getLotteryHandle(lotteryGatherConf.getAbbrName());
        Integer siteId = this.numberVo._getSiteId();
        Date lotteryTime = gatherParam.getLotteryTime();
        String expect = gatherParam.getExpect();
        String code = gatherParam.getCode();
        Date closeTime = gatherParam.getCloseTime();
        LOG.info("LotteryResultOwnTask:开始采集开奖号码:siteId:{0},code:{1},expect:{2},封盘时间:{3},当前时间:{4},开奖时间:{5}", siteId, code, expect,
                DateTool.formatDate(closeTime,DateTool.yyyy_MM_dd_HH_mm_ss), DateTool.formatDate(new Date(), DateTool.yyyy_MM_dd_HH_mm_ss), DateTool.formatDate(lotteryTime, DateTool.yyyy_MM_dd_HH_mm_ss));
        try {
            Object object = lotteryHandle.doGather(gatherParam);
            if(object instanceof LotteryResultNumberVo){
                LotteryResultNumberVo vo = (LotteryResultNumberVo)object;
                LotteryResultNumber number = vo.getResult();
                if(vo.isSuccess() && number != null){
                    this.numberVo.getResult().setGatherTime(number.getGatherTime());
                    this.numberVo.getResult().setGather(number.getGather());
                    this.numberVo.getResult().setGatherOrigin(number.getGatherOrigin());
                    this.numberVo.getResult().setOpenCode(number.getOpenCode());
                    this.numberVo.getResult().setOpenCodeMemo(number.getOpenCodeMemo());
                    LOG.info("LotteryResultOwnTask:采集开奖号码成功,siteId:{0},code:{1},expect:{2},openCode:{3}", siteId,code, expect,number.getOpenCode());
                }else{
                    this.numberVo.setSuccess(false);
                    this.numberVo.setErrMsg(vo.getErrMsg());
                    LOG.error("LotteryResultOwnTask:采集开奖号码失败,siteId:{0},code:{1},expect:{2},原因:{3}", siteId,code, expect,vo.getErrMsg());
                }
            }else{
                this.numberVo.setSuccess(false);
                this.numberVo.setErrMsg("返回采集类型错误");
                LOG.error("LotteryResultOwnTask:采集开奖号码失败,siteId:{0},code:{1},expect:{2},原因:{3}", siteId,code, expect,this.numberVo.getErrMsg());
            }
        } catch (Exception e) {
            LOG.error(e, "LotteryResultOwnTask:采集任务异常,siteId:{0},code:{1},expect:{2}",siteId, code, expect);
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("采集任务异常");
        }
        return this.numberVo;
    }

}