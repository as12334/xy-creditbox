package so.wwb.lotterybox.web.defense.biz.rule;

import org.soul.commons.lang.DateTool;
import org.soul.model.sys.po.SysParam;
import so.wwb.lotterybox.model.base.ParamTool;
import so.wwb.lotterybox.model.enums.base.SiteParamEnum;
import so.wwb.lotterybox.web.defense.biz.enums.Dispose;
import so.wwb.lotterybox.web.defense.biz.enums.TimeLimitType;
import so.wwb.lotterybox.web.defense.core.DefenseRs;
import so.wwb.lotterybox.web.defense.core.IDefenseRs;
import so.wwb.lotterybox.web.defense.core.model.ResetColumns;
import so.wwb.lotterybox.web.defense.core.rule.InTimeAndTimeLimitRule;
import so.wwb.lotterybox.web.defense.core.rule.TimesLimitRule;

import java.util.Date;

/**
 * Created by jessie on 16-3-29.
 */
public class AgentRegisterDefenseRulesFactiory extends RegisterDefenseRulesFactioryFactory {
    public static final String MESSAGE_2 = "defense.register.disable.hours.24";
    @Override
    public InTimeAndTimeLimitRule isIntervalLimit(){
//        SysParam intervalParam = ParamTool.getSysParam(SiteParamEnum.SETTING_REG_LIMIT_IP_REG_INTERVAL_AGENT);
//        final Float interval = Float.valueOf(ParamTool.blankThenDefault(intervalParam));//单位小时
//
//        if (interval <= 0) {
//            //不做限制
//            return null;
//        }
//
//        InTimeAndTimeLimitRule rule = new InTimeAndTimeLimitRule(){
//            @Override
//            public IDefenseRs getResult() {
//                DefenseRs rs = new DefenseRs(Dispose.DISABLED,false);
//                int min = Float.valueOf(interval * 60).intValue();
//                rs.setDisposeEndTime(DateTool.addMinutes(new Date(), min));
//                rs.setMessage(MESSAGE_1);
//                rs.removeReset(ResetColumns.START_TIME);
//                rs.removeReset(ResetColumns.SUCCESS_TIMES);
//                return rs;
//            }
//        };
//        rule.setTimes(1);
//        rule.setTimeLimitType(TimeLimitType.SUCCESS);
        return null;

    }

    @Override
    public TimesLimitRule getTimeLimit4Success(){
//        SysParam regNumParam = ParamTool.getSysParam(SiteParamEnum.SETTING_REG_LIMIT_IP_DAY_MAX_REGNUM_AGENT);
//        Integer regNum = Integer.valueOf(ParamTool.blankThenDefault(regNumParam));
//        if (regNum <= 0) {
//            return null;
//        }
//
//        InTimeAndTimeLimitRule rule = new InTimeAndTimeLimitRule(){
//            @Override
//            public IDefenseRs getResult() {
//                DefenseRs rs = new DefenseRs(Dispose.DISABLED,false);
//                if (defenseRecord.getOperateStartTime() == null)
//                    defenseRecord.setOperateStartTime(new Date());
//                rs.setDisposeEndTime(DateTool.addHours(defenseRecord.getOperateStartTime(),24));
//                rs.setMessage(MESSAGE_2);
//                return rs;
//            }
//        };
//        rule.setTimes(regNum);
//        rule.setIntervalSecond(24 * 3600);
//        rule.setTimeLimitType(TimeLimitType.SUCCESS);
        return null;
    }
    
}
