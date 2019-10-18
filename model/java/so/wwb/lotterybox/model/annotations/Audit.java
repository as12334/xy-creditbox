package so.wwb.lotterybox.model.annotations;

import org.soul.commons.enums.YesNot;
import org.soul.model.log.audit.enums.OpType;
import so.wwb.lotterybox.model.enums.base.Module;
import so.wwb.lotterybox.model.enums.base.ModuleType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Audit {

	Module module();

	ModuleType moduleType();

	String desc() default "";

	OpType opType() default OpType.QUERY;

	YesNot ignoreForm() default YesNot.YES;

	YesNot isSystem() default YesNot.NOT;
}