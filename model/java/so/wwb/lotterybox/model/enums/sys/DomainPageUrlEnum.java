package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;
public enum DomainPageUrlEnum implements ICodeEnum {
    BOSS("/manager/passport/login.html", "manager page"),//后台
    COMPANIES("/companies/passport/login.html", "manager page"),//运营商后台
    COMPANY("/company/passport/login.html", "manager page"),//公司后台
    HALL("/", "manager page");//玩家中心
    private String code;
    private String trans;

    DomainPageUrlEnum(String code, String trans) {
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

    public static DomainPageUrlEnum getDomainPageUrlEnumByCode(String code) {
        for (DomainPageUrlEnum pageUrlEnum : DomainPageUrlEnum.values()) {
            if (pageUrlEnum.getCode().equals(code)) {
                return pageUrlEnum;
            }
        }
        return null;
    }
}