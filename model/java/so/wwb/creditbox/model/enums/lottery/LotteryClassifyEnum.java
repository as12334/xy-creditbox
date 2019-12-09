package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;

/**
 * 彩种归类
 */
public enum LotteryClassifyEnum implements ICodeEnum {

    OFFICE("office","官方彩"),
    OWN("own","自主彩");

    private String code;
    private String trans;

    LotteryClassifyEnum(String code, String trans) {
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
