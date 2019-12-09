package so.wwb.creditbox.model.enums.user;

import org.soul.commons.ienums.ICodeEnum;

public enum UserTypeEnum implements ICodeEnum{

    BOSS("1", "总控"),
    BOSS_SUB("11", "总控子账号"),

    COMPANIES("2", "运营"),
    COMPANIES_SUB("21", "运营子账号"),

    COMPANY("3", "公司"),
    COMPANY_SUB("31", "公司子账号"),

    BRANCH("4", "分公司"),
    BRANCH_SUB("41", "分公司子账号"),

    SHAREHOLDER("5", "股东"),
    SHAREHOLDER_SUB("51", "股东子账号"),

    DISTRIBUTOR("6", "总代"),
    DISTRIBUTOR_SUB("61", "总代子账号"),

    AGENT("7", "代理"),
    AGENT_SUB("71", "代理子账号"),

    PLAYER("8", "玩家"),

    ;

    private String code;
    private String trans;

    UserTypeEnum(String code, String trans) {
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
