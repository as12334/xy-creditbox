package so.wwb.creditbox.model.enums.base;

import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by cj on 15-7-22 上午8:53.
 */
public enum PrivilegeStatusEnum implements ICodeEnum {
    STATUS_OK("OK", "权限检查通过，并且在有效期内。"),
    STATUS_LOCK("LOCK", "密码错误达到上限，正处在锁定时间内"),
    STATUS_ERROR("ERROR", "密码错误，但未到错误上限"),
    CODE_100("100", "密码正确，通过验证"),
    CODE_99("99", "密码错误达到上限，锁定用户"),
    CODE_98("98", "密码错误"),
    CODE_97("97", "验证码错误"),
    CODE_96("96", "密码未设置"),
    CODE_0("0", "未验证过错误"),
    CODE_95("95", "密码过期"),
    CODE_94("94", "真实姓名错误")
    ;
    private String code;
    private String trans;

    PrivilegeStatusEnum(String code, String trans) {
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
}
