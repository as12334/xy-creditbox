package so.wwb.creditbox.model.enums.base;

import org.soul.commons.ienums.ICodeEnum;

/**
 * ContentCheckEnum
 *
 * @author River
 * @date 15-11-16 下午12:03
 */

public enum ContentCheckEnum implements ICodeEnum{
    CHECKING("0", "待审核","checking"),
    PASS("1", "审核通过","pass"),
    FAIL("2", "审核失败","fail");

    private String code;
    private String trans;
    private String dictCode;

    ContentCheckEnum(String code, String trans, String dictCode) {
        this.code = code;
        this.trans = trans;
        this.dictCode = dictCode;
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

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }
}
