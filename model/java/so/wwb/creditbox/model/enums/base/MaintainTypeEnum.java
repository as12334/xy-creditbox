package so.wwb.creditbox.model.enums.base;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.ICodeEnum;

public enum MaintainTypeEnum implements ICodeEnum {
    MANAGER_CENTER("1", "管理中心"),
    PLAYER_CENTER("2", "游戏中心"),
    API_CENTER("3", "开放中心(API)"),
    DISABLED("4", "站点停用");
    
    private String code;
    private String trans;

    MaintainTypeEnum(String code, String trans) {
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

    public static MaintainTypeEnum enumOf(String code) {
        return EnumTool.enumOf(MaintainTypeEnum.class, code);
    }
}
