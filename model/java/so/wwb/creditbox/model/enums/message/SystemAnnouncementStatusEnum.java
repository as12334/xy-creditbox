package so.wwb.creditbox.model.enums.message;

import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by jeremy on 18-3-23.
 */
public enum SystemAnnouncementStatusEnum implements ICodeEnum{
    NORMAL("0","正常"),
    DELETE("1","删除");

    private String code;
    private String trans;
    SystemAnnouncementStatusEnum(String code, String trans){
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
