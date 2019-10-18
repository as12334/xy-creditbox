package so.wwb.creditbox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

/**
 * 系统用户类型枚举
 * @author cogo
 * @time 2016-01-13 20:47:30
 */
public enum SysUserTypeEnum implements ICodeEnum {





    BOSS("boss", "总控"),
    COMPANIES("companies", "运营商"),
    COMPANY("company", "公司"),
    BRANCH("branch", "分公司"),
    SHAREHOLDER("shareholder", "股东"),
    DISTRIBUTOR("distributor", "总代"),
    AGENT("agent", "代理"),
    PLAYER("player", "玩家");


    private String code;
    private String trans;

    SysUserTypeEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}