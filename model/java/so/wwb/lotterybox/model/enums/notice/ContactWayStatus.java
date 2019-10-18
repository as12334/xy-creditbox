package so.wwb.lotterybox.model.enums.notice;

import org.soul.commons.enums.EnumTool;
import org.soul.model.msg.notice.enums.IContactWayType;

public enum ContactWayStatus implements IContactWayType {
    NORMAL("11", "正常"),
    INACTIVE("12", "未激活"),
    NOT_MINE("13", "非本人联系方式"),
    LOST_CONNECT("21", "无法联系"),
    CLEAR("22","被清除");

    ContactWayStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return desc;
    }

    public static ContactWayStatus enumOf(String code) {
        return EnumTool.enumOf(ContactWayStatus.class, code);
    }

}
