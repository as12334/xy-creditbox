package so.wwb.creditbox.common.export.core.conf;

import org.soul.commons.ienums.ICodeEnum;

/**
 * ExportTypeEnum
 *
 * @author younger
 * @date 16-11-05 20:11
 */

public enum ExportTypeEnum implements ICodeEnum {
    FILTER("0", "筛选所有的数据",""),
    SELECT("1", "选中的数据",""),
    ALL("2", "所有数据","");

    private String code;
    private String trans;
    private String dictCode;

    ExportTypeEnum(String code, String trans, String dictCode) {
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
