package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by block on 2019/11/8.
 */
public enum test  implements ICodeEnum {

    ;

    private String code;
    private String trans;


    test(String code, String trans) {
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
