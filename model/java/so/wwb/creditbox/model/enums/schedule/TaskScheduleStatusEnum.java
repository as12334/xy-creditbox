package so.wwb.creditbox.model.enums.schedule;

import org.soul.commons.enums.ICodeEnum;

public enum TaskScheduleStatusEnum implements ICodeEnum {
    ENABLE("1", "启用"),
    DISABLE("2", "停用");

    TaskScheduleStatusEnum(String code, String trans) {
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