package so.wwb.creditbox.model.common;

import org.soul.commons.ienums.ICodeEnum;

public enum ModeEnum implements ICodeEnum {
    LIVE("1", "正式"),
    DEMO("2", "测试"),
    MIX("3", "混合"),
    TRYPLAY("4","试玩"),
    TAKE_PLAY("5", "带玩");
    private String code;
    private String trans;

    ModeEnum(String code, String trans){
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
