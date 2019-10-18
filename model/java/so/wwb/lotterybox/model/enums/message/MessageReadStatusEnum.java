package so.wwb.lotterybox.model.enums.message;

import org.soul.commons.enums.ICodeEnum;

/**
 *
 * Created by jeremy on 18-4-3.
 */
public enum MessageReadStatusEnum implements ICodeEnum {
    UNREAD("0","未读"),
    READ("1","已读");
    private String code;
    private String trans;

    MessageReadStatusEnum(String code, String trans){
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
