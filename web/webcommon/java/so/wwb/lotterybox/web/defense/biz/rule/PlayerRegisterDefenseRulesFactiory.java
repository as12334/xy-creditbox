package so.wwb.lotterybox.web.defense.biz.rule;

import org.soul.commons.lang.DateTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.support._Module;
import org.soul.model.sys.po.SysParam;
import org.soul.web.session.SessionManagerBase;
import so.wwb.lotterybox.model.base.ParamTool;
import so.wwb.lotterybox.model.enums.base.SiteParamEnum;
import so.wwb.lotterybox.web.defense.biz.enums.Dispose;
import so.wwb.lotterybox.web.defense.biz.enums.TimeLimitType;
import so.wwb.lotterybox.web.defense.core.DefenseRs;
import so.wwb.lotterybox.web.defense.core.IDefenseRs;
import so.wwb.lotterybox.web.defense.core.model.ResetColumns;
import so.wwb.lotterybox.web.defense.core.rule.InTimeAndTimeLimitRule;

import java.util.Date;

/**
 * Created by jessie on 16-3-29.
 */
public class PlayerRegisterDefenseRulesFactiory extends RegisterDefenseRulesFactioryFactory {


    /**
     *
     * @return
     */
    @Override
    public InTimeAndTimeLimitRule isIntervalLimit(){
//        SysParam intervalParam = ParamTool.getSysParam(SiteParamEnum.SETTING_REG_LIMIT_IP_REG_INTERVAL);
//        final Float interval = Float.valueOf(ParamTool.blankThenDefault(intervalParam));//单位小时
//        if (interval <= 0) {//间隔时间小于等于的0等同于不做限制
//            return null;
//        }
//        InTimeAndTimeLimitRule rule = new InTimeAndTimeLimitRule(){
//            @Override
//            public IDefenseRs getResult() {
//                DefenseRs rs = new DefenseRs(Dispose.DISABLED,false);
//                int min = Float.valueOf(interval * 60).intValue();
//                rs.setDisposeEndTime(DateTool.addMinutes(defenseRecord.getOperateEndTime(), min));
//                rs.setMessage(LocaleTool.tranMessage(_Module.Passport, MESSAGE_1,interval));
//                rs.removeReset(ResetColumns.START_TIME);
//                rs.removeReset(ResetColumns.SUCCESS_TIMES);
//                return rs;
//            }
//        };
//        rule.setTimes(1);
//        rule.setIntervalSecond((long) (interval * 3600));
//        rule.setTimeLimitType(TimeLimitType.SUCCESS);
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public InTimeAndTimeLimitRule getTimeLimit4Success(){
//        SysParam regNumParam = ParamTool.getSysParam(SiteParamEnum.SETTING_REG_LIMIT_IP_DAY_MAX_REGNUM);
//        Integer regNum = Integer.valueOf(ParamTool.blankThenDefault(regNumParam));
//        if (regNum <= 0) {//
//            return null;
//        }
//
//        InTimeAndTimeLimitRule rule = new InTimeAndTimeLimitRule(){
//            @Override
//            public IDefenseRs getResult() {
//                DefenseRs rs = new DefenseRs(Dispose.DISABLED,false);
//                if (defenseRecord.getOperateStartTime() == null)
//                    defenseRecord.setOperateStartTime(new Date());
//                rs.setDisposeEndTime(SessionManagerBase.getDate().getTomorrow());
//                rs.setMessage(LocaleTool.tranMessage(_Module.Passport, MESSAGE_2));
//                return rs;
//            }
//        };
//        rule.setTimes(regNum);
//        rule.setIntervalSecond(24 * 3600);
//        rule.setTimeLimitType(TimeLimitType.SUCCESS);
        return null;
    }

}
