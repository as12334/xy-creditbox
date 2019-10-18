package so.wwb.lotterybox.model.enums.base;

import org.soul.commons.enums.ICodeEnum;

/**
 * @author: alvin
 * @date: 2017.08.11
 */
public enum StatusEnum implements ICodeEnum {

    // 状态
    NORMAL("1", "正常"),
    STOP("2", "停用"),
    FROZEN("3", "冻结"),
    ;
    private String code;

    private String trans;

    StatusEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    public String getCode() {
        return code;
    }

    public String getTrans() {
        return trans;
    }
}
