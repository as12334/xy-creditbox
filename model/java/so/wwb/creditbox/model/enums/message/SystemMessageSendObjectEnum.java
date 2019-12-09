package so.wwb.creditbox.model.enums.message;

import org.soul.commons.ienums.ICodeEnum;

public enum SystemMessageSendObjectEnum implements ICodeEnum{
    TO_BOSS("1", "发送BOSS"),
    TO_SHAREHOLDER("2", "发送股东"),
    TO_MERCHANT("3", "发送商户"),
    TO_DISTRIBUTOR("4","发送总代"),
    TO_AGENT("5","发送代理"),
    TO_PLAYER("6","发送玩家"),
    TO_MERCHANT_API("7", "发送商户api"),
    TO_DISTRIBUTOR_API("8","发送总代api");

    private String code;
    private String trans;

    SystemMessageSendObjectEnum(String code, String trans){
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
