package so.wwb.creditbox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

/**
 * 域名绑定状态枚举:1 待绑定，2绑定中，3待解绑，4解绑中，5完成，6失败
 */
public enum ResolveStatusEnum implements ICodeEnum {

    TOBEBOUND("1", "待绑定"),
    TOBEBIND("2", "绑定中"),
    TOBETIEDUP("3", "待解绑"),
    BOUNDED("4", "解绑中"),
    SUCCESS("5", "完成"),
    FAIL("6", "失败");
    private String code;
    private String trans;

    ResolveStatusEnum(String code, String trans) {
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