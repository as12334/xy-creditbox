package so.wwb.lotterybox.web.defense.biz.rule;

import org.soul.commons.lang.DateTool;
import org.soul.commons.locale.DateQuickPicker;
import so.wwb.lotterybox.model.constants.common.Const;
import so.wwb.lotterybox.web.defense.biz.enums.Dispose;
import so.wwb.lotterybox.web.defense.biz.enums.TimeLimitType;
import so.wwb.lotterybox.web.defense.core.DefenseRs;
import so.wwb.lotterybox.web.defense.core.IDefenseRule;
import so.wwb.lotterybox.web.defense.core.rule.InTimeAndTimeLimitRule;
import so.wwb.lotterybox.web.defense.core.rule.TimesLimitRule;
import so.wwb.lotterybox.web.defense.core.rule.factory.IDefenseRulesFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhoneEmailDefenseRulesFactioryFactory implements IDefenseRulesFactory {

    public static final String MESSAGE_1 = "defense.phone.email.disable.hours";
    public static final String MESSAGE_2 = "defense.phone.email.disable.tomorrow";

    @Override
    public List<IDefenseRule> getRule() {
        List<IDefenseRule> list = new ArrayList<>();

        //是否达到IP限制
        list.addAll(isNeedIpConfine());

        //成功:是否达到 次数限制
        list.add(getTimeLimit4Success());

        //失败:是否达到 次数限制
        list.add(isDisabled4Tomorrow());

        //失败:是否达到 次数限制
        list.add(isDisable4Hours());

        //成功:是否需要验证码
        list.add(isNeedCaptcha4Success());

        //失败:是否需要验证码
        list.add(isNeedCaptcha4Error());
        return list;
    }


    /**
     * 时间限制	出现行为账号个数	该IP锁定时间
     *  10min	    3个	            3 H
     *  30min	    6个	            6 H
     *  60min	    10个         	永久
     * @return
     */
    private List<IDefenseRule> isNeedIpConfine() {
        List<IDefenseRule> ipRules = new ArrayList<>();

        DefenseRs defenseRs = new DefenseRs(Dispose.IP_CONFINE,false);
        defenseRs.setDisposeEndTime(Const.Platform_Forever_Date);
        IpOpUserCountRule rule = new IpOpUserCountRule();
        rule.setTimes(10);
        rule.setIntervalSecond(600);
        rule.setResult(defenseRs);
        ipRules.add(rule);

        defenseRs = new DefenseRs(Dispose.IP_CONFINE,false);
        defenseRs.setDisposeEndTime(DateTool.addHours(new Date(), 6));
        rule = new IpOpUserCountRule();
        rule.setTimes(6);
        rule.setIntervalSecond(600);
        rule.setResult(defenseRs);
        ipRules.add(rule);

        defenseRs = new DefenseRs(Dispose.IP_CONFINE,false);
        defenseRs.setDisposeEndTime(DateTool.addHours(new Date(), 3));
        rule = new IpOpUserCountRule();
        rule.setTimes(3);
        rule.setIntervalSecond(600);
        rule.setResult(defenseRs);
        ipRules.add(rule);

        return ipRules;
    }


    private TimesLimitRule isDisabled4Tomorrow() {
        DefenseRs defenseRs = disableToTomorrow();
        TimesLimitRule rule = new TimesLimitRule();
        rule.setTimes(10);
        rule.setResult(defenseRs);
        return rule;
    }

    private TimesLimitRule isDisable4Hours() {
        DefenseRs defenseRs = new DefenseRs(Dispose.DISABLED,false);
        defenseRs.setDisposeEndTime(DateTool.addHours(new Date(), 3));
        defenseRs.setMessage(MESSAGE_1);

        TimesLimitRule rule = new TimesLimitRule();
        rule.setTimes(5);
        rule.setResult(defenseRs);
        return rule;

    }

    private InTimeAndTimeLimitRule isNeedCaptcha4Error() {
        DefenseRs defenseRs = DefenseRs.D_CAPTCHA;

        InTimeAndTimeLimitRule rule = new InTimeAndTimeLimitRule();
        rule.setTimes(2);
        rule.setIntervalSecond(300);
        rule.setResult(defenseRs);
        rule.setTimeLimitType(TimeLimitType.ERROR);
        return rule;
    }

    private InTimeAndTimeLimitRule isNeedCaptcha4Success() {
        DefenseRs defenseRs = DefenseRs.D_CAPTCHA;
        InTimeAndTimeLimitRule rule = new InTimeAndTimeLimitRule();
        rule.setTimes(1);
        rule.setIntervalSecond(300);
        rule.setResult(defenseRs);
        rule.setTimeLimitType(TimeLimitType.SUCCESS);
        return rule;
    }

    private TimesLimitRule getTimeLimit4Success() {
        DefenseRs defenseRs = disableToTomorrow();
        TimesLimitRule rule = new TimesLimitRule();
        rule.setTimes(3);
        rule.setResult(defenseRs);
        rule.setTimeLimitType(TimeLimitType.SUCCESS);
        return rule;
    }

    /**
     * 限制到第二天
     * @return
     */
    private DefenseRs disableToTomorrow() {
        DefenseRs rs = new DefenseRs(Dispose.DISABLED,false);
        //warning: DateQuickPicker class request session locale
        DateQuickPicker dateQuickPicker = DateQuickPicker.getInstance();
        Date tomorrow = dateQuickPicker.getTomorrow();
        rs.setDisposeEndTime(tomorrow);
        rs.setMessage(MESSAGE_2);
        return rs;
    }
}
