package so.wwb.creditbox.model.enums.message;

import org.soul.commons.enums.ICodeEnum;

/**
 * Created by jeremy on 18-3-31.
 */
public enum MessageStatusEnum implements ICodeEnum{
    NORMAL("0","正常"),
    DELETE("1","删除");
    private String code;
    private String trans;
    MessageStatusEnum(String code, String trans){
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }

}
