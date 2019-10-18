package so.wwb.lotterybox.model.enums.notice;

import org.soul.commons.enums.EnumTool;
import org.soul.model.msg.notice.enums.IContactWayType;

public enum ContactWayType implements IContactWayType {
    CELLPHONE("110", "手机"),
    PHONE("120", "电话"),
    EMAIL("201", "电子邮箱"),
    QQ("301", "QQ"),
    MSN("302", "MSN"),
    SKYPE("303", "Skype"),
    WEIXIN("304", "微信");

    ContactWayType(String code, String desc) {
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

    public static ContactWayType enumOf(String code) {
        return EnumTool.enumOf(ContactWayType.class, code);
    }
}
