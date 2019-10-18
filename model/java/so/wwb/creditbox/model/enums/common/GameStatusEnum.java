package so.wwb.creditbox.model.enums.common;

import org.soul.commons.enums.ICodeEnum;

/**
 * Created by jeff on 15-11-30.
 */
public enum  GameStatusEnum implements ICodeEnum {
    NORMAL("normal","游戏状态：正常"),
    MAINTAIN("maintain","游戏状态：游戏维护中"),
    DISABLE("disable","游戏状态：停用"),
    PRE_MAINTAIN("pre_maintain","维护前");
    private String code;
    private String trans;

    GameStatusEnum(String code, String trans){
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
