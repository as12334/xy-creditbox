package so.wwb.creditbox.model.enums.announcement;

import org.soul.commons.enums.ICodeEnum;

/**
 * @author faker
 * @time 2017-07-12 02:20
 */
public enum AnnouncementTypeEnum implements ICodeEnum {
    PLATFORM("platform", "平台公告"),
    HG("hg", "皇冠公告"),
    MT_PLAYERCENTER("mt_playercenter", "游戏中心维护"),
    MT_CONTROLCENTER("mt_controlcenter", "管理中心维护"),
    MT_APICENTER("mt_apicenter", "开放中心(API)维护"),

    SYSTEM("system_announcement", "系统公告"),
    GAME("game_announcement", "游戏公告"),
    OPERATOR("operator_announcement","运营公告"),
    ADVISORY("advisory_announcement", "咨询消息"),
    MAINTENANCE_ANNOUNCEMENT("maintenance_announcement","维护公告");

    private String code;
    private String trans;

    AnnouncementTypeEnum(String code, String trans) {
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