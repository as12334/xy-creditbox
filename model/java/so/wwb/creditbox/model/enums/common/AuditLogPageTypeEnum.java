package so.wwb.creditbox.model.enums.common;

import org.soul.commons.ienums.ICodeEnum;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;

/**
 * 审计日志页面类型
 *
 * Created by jeremy on 2018年11月23日
 */
public enum AuditLogPageTypeEnum implements ICodeEnum {

    BOSS(SubSysCodeEnum.BOSS.getCode(), "总控日志", ""),
    COMPANIES(SubSysCodeEnum.COMPANIES.getCode(), "运营商日志", ""),
    COMPANY(SubSysCodeEnum.COMPANY.getCode(), "公司日志", ""),
    BRANCH(SubSysCodeEnum.BRANCH.getCode(), "分公司日志", ""),
    SHAREHOLDER(SubSysCodeEnum.SHAREHOLDER.getCode(), "股东日志", ""),
    DISTRIBUTOR(SubSysCodeEnum.DISTRIBUTOR.getCode(), "总代日志", ""),
    AGENT(SubSysCodeEnum.AGENT.getCode(), "代理日志", ""),
    PLAYER("player", "玩家日志", ""),

    ;

    private String code;
    private String trans;
    private String permission;

    AuditLogPageTypeEnum(String code, String trans, String permission) {
        this.code = code;
        this.trans = trans;
        this.permission = permission;

    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }

    public String getPermission() {
        return permission;
    }
}
