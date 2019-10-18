package so.wwb.creditbox.model.enums.common;

import org.soul.commons.enums.ICodeEnum;

/**
 * 数据状态
 */
public enum DataStatusEnum implements ICodeEnum {
    NORMAL("normal","正常"),
    DELETE("delete","删除");


    DataStatusEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    private String code;
    private String trans;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }
}
