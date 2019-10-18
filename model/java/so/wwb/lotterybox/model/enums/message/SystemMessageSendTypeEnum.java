package so.wwb.lotterybox.model.enums.message;

import org.soul.commons.enums.ICodeEnum;

/**
 *
 * Created by jeremy on 18-5-4.
 */
public enum SystemMessageSendTypeEnum implements ICodeEnum {
    POP_UP("0","弹窗"),
    NON_POP_UP("1","不弹窗");
    private String code;
    private String trans;

    SystemMessageSendTypeEnum(String code, String trans){
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
