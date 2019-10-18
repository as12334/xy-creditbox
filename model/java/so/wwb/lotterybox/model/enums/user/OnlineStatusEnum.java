package so.wwb.lotterybox.model.enums.user;

import org.soul.commons.enums.ICodeEnum;

public enum OnlineStatusEnum implements ICodeEnum{
    ONLINE("1", "在线"),
    OFFLINE("0", "离线");

    private String code;
    private String trans;

    OnlineStatusEnum(String code, String trans) {
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
