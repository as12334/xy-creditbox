package so.wwb.lotterybox.web.defense.biz.annotataion;

import so.wwb.lotterybox.web.defense.biz.enums.DefenseAction;
import so.wwb.lotterybox.web.defense.biz.enums.DefenseLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface Defense {
    DefenseAction action();
    DefenseLevel level();
}