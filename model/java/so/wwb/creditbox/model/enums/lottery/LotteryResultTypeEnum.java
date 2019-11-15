package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.enums.ICodeEnum;

/**
 * Created by aaa on 17-9-19.
 */
public enum LotteryResultTypeEnum implements ICodeEnum {
    INSERT("insert", "插入"),
    UPDATE("update", "更新"),
    DELETE("delete", "删除");

    private String code;
    private String trans;

    LotteryResultTypeEnum(String code, String trans) {
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



