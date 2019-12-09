package so.wwb.creditbox.model.common;

import org.soul.commons.ienums.ICodeEnum;

/**
 * @author tom
 * @time 2015-10-24 11:58
 */
public enum AnnSubTypeEnum implements ICodeEnum {
    DAILY("daily_announcement", "日常公告"),
    MAINTENANCE("maintenance_announcement","维护公告"),
    MAINTENANCE_SITE("site_operate_maintenance","站点运营维护公告"),
    MAINTENANCE_PLATFORM("platform_operate_maintenance","平台运营维护公告");

    private String code;
    private String trans;

    AnnSubTypeEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    public String getTrans() {
        return trans;
    }

    public String getCode() {
        return code;
    }
}