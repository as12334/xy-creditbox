package so.wwb.creditbox.model.common.annotations;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Instructions {
    /**
     *描述文本
     */
    String value() default "未添加说明";
    /**
     * 是否要在日志中输出
     */
    boolean print() default true;

    /**
     * 没有发生变化时是否输出内容
     * 适用于嵌套对象 标识内容信息的字段
     * 请务必让拥有该属性的字段位于Class的最上方
     */
    boolean isNoChangePrint() default false;
}