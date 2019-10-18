package so.wwb.lotterybox.web.defense.core.handle;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.net.ServletTool;
import org.soul.web.session.SessionManagerBase;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.iservice.manager.common.IDefenseRecordService;
import so.wwb.lotterybox.model.company.setting.po.DefenseRecord;
import so.wwb.lotterybox.model.company.setting.vo.DefenseRecordVo;
import so.wwb.lotterybox.web.defense.biz.enums.Dispose;
import so.wwb.lotterybox.web.defense.biz.interceptor.IDefense;
import so.wwb.lotterybox.web.defense.core.DefenseRs;
import so.wwb.lotterybox.web.defense.core.IDefenseRs;
import so.wwb.lotterybox.web.defense.core.IDefenseRuleEngine;
import so.wwb.lotterybox.web.defense.core.interceptor.IDefenseRecordPadding;
import so.wwb.lotterybox.web.defense.core.model.DefenseClientId;
import so.wwb.lotterybox.web.defense.core.model.DefenseContext;
import so.wwb.lotterybox.web.defense.core.model.ResetColumns;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by longer on 2/3/16.
 */
public class DefenseHandler implements IDefenseHandler {

    private static final Log LOG = LogFactory.getLog(DefenseHandler.class);

    /**
     * 防御规则引擎
     */
    private IDefenseRuleEngine defenseRuleEngine;

    /**
     * 防御记录填充器
     */
    private IDefenseRecordPadding defenseRecordPadding;


    @Override
    public void beforeHandle(HttpServletRequest request, IDefense defense) {
        try {
            DefenseClientId defenseClientId = buildDefenseEntity(request);
            DefenseRecord defenseRecord = queryDefenseRecord(defense,defenseClientId);
            IDefenseRs defenseRs;
            if (defenseRecord != null){
                //验证是否已达到防御规则限制
                LOG.info("【防御】，已存在记录：{0},开始进行规则判断。",defenseRecord);
                DefenseContext defenseContext = new DefenseContext();
                defenseContext.setDefense(defense);
                defenseContext.setDefenseRecord(defenseRecord);
                defenseRs = defenseRuleEngine.validRule(defenseContext);
            }else{
                defenseRecord = initRecord(defense.action(),defenseClientId);
                defenseRs = initDefenseRs(defenseRecord);
            }
            LOG.info("【防御】，本次防御结果：{0}",defenseRs);
            request.setAttribute(IDefenseRs.R_DEFENSE_RS,defenseRs);
            request.setAttribute(IDefenseRs.R_DEFENSE_REC,defenseRecord);
            request.setAttribute(IDefenseRs.R_DEFENSE_CLI,defenseClientId);
        } catch (Exception e){
            LOG.error(e,"【防御】:action前拦截异常!");
        }
    }

    /**
     * 创建防御实体
     * @return
     */
    private DefenseClientId buildDefenseEntity(HttpServletRequest request) {
        Integer sysUserId = SessionManagerBase.getUserId();
        DefenseClientId clientId = new DefenseClientId();
        if (sysUserId!=null){
            clientId.setSysUserId(sysUserId);
        }
        clientId.setIp(ServletTool.getIpAddr(request));
        clientId.setLocale(SessionManagerBase.getLocale());
        clientId.setTimeZone(SessionManagerBase.getTimeZone());
        return clientId;
    }


    /**
     * 查询当前是否已经存在防御记录
     * @param defense
     * @param defenseClientId ip或者userid
     * @return
     */
    private DefenseRecord queryDefenseRecord(IDefense defense, DefenseClientId defenseClientId) {
        String clientId = defenseClientId.getId();
        DefenseRecordVo vo = new DefenseRecordVo();
        vo.getSearch().setClientId(clientId);
        vo.getSearch().setActionCode(defense.action());
        vo = defenseRecordService().search(vo);
        return vo.getResult();
    }

    /**
     * 初始化一个防御记录
     * @return
     * @param rule
     * @param
     */
    private DefenseRecord initRecord(String rule, DefenseClientId defenseClientId) {
        Date now = new Date();
        DefenseRecord defenseRecord = new DefenseRecord();
        defenseRecord.setActionCode(rule);
        defenseRecord.setClientId(defenseClientId.getId());
        defenseRecord.setOperateIp(IpTool.ipv4StringToLong(defenseClientId.getIp()));
        defenseRecord.setOperateStartTime(now);
        defenseRecord.setSuccessTimes(0);
        defenseRecord.setErrorTimes(0);
        if (defenseClientId.getSysUserId()!=null){
            defenseRecord.setSysUserId(defenseClientId.getSysUserId());
        }
        return defenseRecord;
    }

    /**
     * 初始化防御结果
     * @param defenseRecord
     * @return
     */
    private IDefenseRs initDefenseRs(final DefenseRecord defenseRecord) {
        DefenseRs defenseRs = new DefenseRs();
        defenseRs.setIsAvaiable(true);
        defenseRs.setDispose(Dispose.enumOf(defenseRecord.getDisposeCode()));
        defenseRs.setMessage(defenseRecord.getDescription());
        return defenseRs;
    }

    @Override
    public void afterHandle(HttpServletRequest request, IDefense defense) {
        try{
            //warning: this value setting by concrete biz code
            Boolean actionRs = (Boolean)request.getAttribute(IDefenseRs.R_ACTION_RS);
            DefenseRecord defenseRecord = (DefenseRecord) request.getAttribute(IDefenseRs.R_DEFENSE_REC);
            IDefenseRs defenseRs = (IDefenseRs) request.getAttribute(IDefenseRs.R_DEFENSE_RS);
            if (defenseRecord.isNeedReset()) {
                defenseRecord.setResetColumns(defenseRs.getDefenseRs().getResetColumns());
                ResetColumns.reset(defenseRecord);
                LOG.info("【防御】，本次防御记录重置：{0}",defenseRecord);
                DefenseRecordVo vo = new DefenseRecordVo();
                vo.setResult(defenseRecord);
                defenseRecordService().reset(vo);
            }

            if (actionRs == null) {//无效操作，不进行防御记录更新
                return;
            }

            defenseRecord.setIsActionSuccess(actionRs);
            buildRecordByRs(defenseRecord, defenseRs);
            DefenseRecordVo defenseRecordVo = new DefenseRecordVo();
            defenseRecordVo.setResult(defenseRecord);
            if (defenseRecord.getId() == null) {
                increTimes(defenseRecord,actionRs);
                LOG.info("【防御】，新增防御记录：{0}",defenseRecord);
                defenseRecordService().insert(defenseRecordVo);
            } else {
                LOG.info("【防御】，更新防御记录：{0}",defenseRecord);
                defenseRecordService().updateRecord(defenseRecordVo);
            }
        } catch (Exception e){
            LOG.error(e,"【防御】:action后拦截异常!");
        }
    }

    /**
     * 从防御结果里构建防御记录
     * @param defenseRecord
     * @param defenseRs
     */
    private void buildRecordByRs(DefenseRecord defenseRecord, IDefenseRs defenseRs){
        defenseRecord.setOperateEndTime(new Date());
        defenseRecord.setDisposeCode(defenseRs.getDefenseRs().getDispose().getCode());
        if (defenseRecord.getDisposeEndTime() == null){//处置过期时间为空时，更新为最新的过期时间
            defenseRecord.setDisposeEndTime(defenseRs.getDefenseRs().getDisposeEndTime());
        }
        defenseRecord.setResetColumns(defenseRs.getDefenseRs().getResetColumns());
    }

    /**
     * 增加次数(保存时)
     * @param defenseRecord
     * @param actionRs
     */
    private void increTimes(DefenseRecord defenseRecord, Boolean actionRs) {
        if (actionRs) {
            defenseRecord.setSuccessTimes(defenseRecord.getSuccessTimes() + 1);
        } else {
            defenseRecord.setErrorTimes(defenseRecord.getErrorTimes() + 1);
        }
    }

    private IDefenseRecordService defenseRecordService() {
        return ServiceTool.defenseRecordService();
    }


    public void setDefenseRuleEngine(IDefenseRuleEngine defenseRuleEngine) {
        this.defenseRuleEngine = defenseRuleEngine;
    }

    public void setDefenseRecordPadding(IDefenseRecordPadding defenseRecordPadding) {
        this.defenseRecordPadding = defenseRecordPadding;
    }

}
