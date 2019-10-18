package so.wwb.lotterybox.model.enums.base;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.ICodeEnum;

public enum SubSysCodeEnum implements ICodeEnum {
    BOSS("boss", "总控"),
    COMPANIES("companies", "运营商"),
    COMPANY("company","公司"),
    BRANCH("branch", "分公司"),
    SHAREHOLDER("shareholder", "股东"),
    DISTRIBUTOR("distributor", "总代"),
    AGENT("agent", "代理"),
    HALL("hall", "玩家"),
    ;
    
    private String code;
    private String trans;

    SubSysCodeEnum(String code, String trans) {
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

    public static SubSysCodeEnum enumOf(String code) {
        return EnumTool.enumOf(SubSysCodeEnum.class, code);
    }
}