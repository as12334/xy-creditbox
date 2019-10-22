package so.wwb.creditbox.model.annotations;

import org.soul.commons.enums.YesNot;
import org.soul.model.log.audit.enums.OpType;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Audit {


	/**
	 * 模块名称
	 */
	Module module();

	/**
	 * 模块类型
	 *
	 * @return
	 */
	ModuleType moduleType();

	/**
	 * 操作描述
	 */
	String desc() default "";

	/**
	 * 操作类型
	 */
	OpType opType() default OpType.QUERY;

	/**
	 * 是否忽略表单数据
	 * 忽略		: reuest提交表单数据将被存储
	 * 不忽略	: reuest提交表单数据将不被存储
	 *
	 * @return
	 */
	YesNot ignoreForm() default YesNot.YES;

	/**
	 * 是否系统级别
	 *
	 * @return
	 */
	YesNot isSystem() default YesNot.YES;
}