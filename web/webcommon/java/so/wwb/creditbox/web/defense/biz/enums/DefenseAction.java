package so.wwb.creditbox.web.defense.biz.enums;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.ICodeEnum;

public enum DefenseAction implements ICodeEnum {
    PLAYER_REGISTER("player_register","防御:玩家注册"),
    AGENT_REGISTER("agent_register","防御:代理注册"),
    PHONE("phone","防御:手机验证"),
    MAIL("mail","防御:邮箱验证"),
    PLAYER_LOGIN("player_login", "防御：玩家登录");

    private String code;
    private String trans;

    DefenseAction(String code, String trans) {
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

    public static DefenseAction enumOf(String code) {
        return EnumTool.enumOf(DefenseAction.class, code);
    }
}