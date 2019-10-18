package so.wwb.lotterybox.schedule.service.manager.task;


import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.common.task.CommonTask;
import so.wwb.lotterybox.iservice.company.lottery.ILotteryResultLogService;
import so.wwb.lotterybox.iservice.company.lottery.ILotteryResultNumberService;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.constants.common.Const;
import so.wwb.lotterybox.model.enums.lottery.LotteryEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryGatherOriginEnum;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultLogVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultNumberVo;
import so.wwb.lotterybox.schedule.service.manager.job.LotterySystemJob;

import java.util.Date;
import java.util.List;

/**
 * 彩票自主彩任务(采集-派彩)
 * @author: marz
 * @time 2018-3-14 20:35:57
 */
public class SystemPayoutTask extends CommonTask<LotteryResultNumberVo> {
    public static final Log LOG = LogFactory.getLog(LotteryResultOwnTask.class);

    @Autowired
    private ILotteryResultNumberService lotteryResultNumberService;

    @Autowired
    private ILotteryResultLogService lotteryResultLogService;

    private LotteryResultNumberVo numberVo;

    public void setNumberVo(LotteryResultNumberVo numberVo) {
        this.numberVo = numberVo;
    }

    @Override
    public LotteryResultNumberVo call() {
        DruidDataSource dataSource = DatasourceTool.getDruidDatasource(this.numberVo._getSiteId());
        if(dataSource == null){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少商户数据源");
            LOG.error("SystemPayoutTask:彩票派彩失败,原因:{0}",this.numberVo.getErrMsg());
            return this.numberVo;
        }
        DataContext.setDataSource(dataSource);
        CommonContext.set(new ContextParam());
        CommonContext.get().setSiteId(this.numberVo._getSiteId());
        this.numberVo = beforePayoutChech ();
        if(!this.numberVo.isSuccess()){
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg(numberVo.getErrMsg());
            LOG.error("SystemPayoutTask:彩票派彩失败,siteId:{0},原因:{1}",this.numberVo._getSiteId(),this.numberVo.getErrMsg());
            return this.numberVo;
        }
        return lotteryResultNumberService.payout(this.numberVo);
    }
    private LotteryResultNumberVo beforePayoutChech () {
        this.numberVo._setDataSourceId(this.numberVo._getSiteId());
        this.numberVo = lotteryResultNumberService.search(this.numberVo);
        LotteryResultNumber resultNumber = this.numberVo.getResult();
        if(resultNumber == null){
            LOG.error("自主彩派彩前校验未通过,code:{0},expect:{1},原因{2}",this.numberVo.getSearch().getCode(),this.numberVo.getSearch().getExpect(),"缺少的开奖结果数据");
            this.numberVo.setSuccess(false);
            this.numberVo.setErrMsg("缺少的开奖结果数据");
            return this.numberVo;
        }

        if(resultNumber != null && resultNumber.getOpenCode() == null){
            LotteryResultLogVo logVo = new LotteryResultLogVo();
            logVo.getSearch().setExpect(this.numberVo.getSearch().getExpect());
            logVo.getSearch().setCode(this.numberVo.getSearch().getCode());
            logVo._setDataSourceId(this.numberVo._getSiteId());
            logVo = lotteryResultLogService.search(logVo);

            if (logVo.getResult() != null && logVo.getResult().getResultNum() != null) {
                this.numberVo.getResult().setOpenCode(logVo.getResult().getResultNum());
            } else {
                this.numberVo.getResult().setOpenCode(StringTool.join(",", LotterySystemJob.randomOpenCodes(this.numberVo.getSearch().getCode()).toArray()));
            }
            initLotteryResultNum ();
            int result = lotteryResultNumberService.updateOpenResultNum(this.numberVo);
            if (result == 1) {
                this.numberVo.setSuccess(true);
            } else {
                this.numberVo.setSuccess(false);
                this.numberVo.setErrMsg("开奖结果已存在");
            }
        }
        return this.numberVo;
    }

    private void initLotteryResultNum () {
        this.numberVo.getResult().setGatherTime(new Date());
        this.numberVo.getResult().setGather(Const.SYSTEM_OPERATOR);
        this.numberVo.getResult().setGatherOrigin(LotteryGatherOriginEnum.AUTO.getCode());
        this.numberVo.getResult().setOpenCodeMemo(getOpenCodeMemo (this.numberVo.getSearch().getCode(),this.numberVo.getResult().getOpenCode()));
    }

    /**
     * 根据开奖号码获取开奖号码备注，暂时保存六合彩生肖
     * @return
     */
    private String getOpenCodeMemo(String code,String openCode){
        String result = null;
        if(StringTool.isNotEmpty(code) && StringTool.isNotEmpty(openCode)){
            if(LotteryEnum.JSLHC.getCode().equals(code)){
                List<String> zodicList = CacheBase.getLotteryLhcZodiacList(StringTool.split(openCode,","));
                result = StringTool.join(zodicList,",");
            }
        }
        return result;
    }
}
