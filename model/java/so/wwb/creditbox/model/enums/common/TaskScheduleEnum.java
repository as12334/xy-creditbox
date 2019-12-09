package so.wwb.creditbox.model.enums.common;

import org.soul.commons.ienums.ICodeEnum;

/**
 * 一次性任务枚举
 */
public enum TaskScheduleEnum implements ICodeEnum {
    EXCUTE_EXPORT("exportJob", "列表数据导出");

    TaskScheduleEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    private String code;
    private String trans;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getTrans() {
        return this.trans;
    }
}