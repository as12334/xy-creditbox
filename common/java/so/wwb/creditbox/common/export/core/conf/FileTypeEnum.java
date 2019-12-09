package so.wwb.creditbox.common.export.core.conf;

import org.soul.commons.ienums.ICodeEnum;

/**
 * FileTypeEnum
 *
 * @author younger
 * @date 16-08-05 10:18
 */

public enum FileTypeEnum implements ICodeEnum {
    XLS("xls", "2003EXCEL",""),
    XLSX("xlsx", "2007EXCEL",""),
    CSV("csv", "CSV",""),
    TXT("txt", "TXT",""),
    PDF("pdf", "PDF","");

    private String code;
    private String trans;
    private String dictCode;

    FileTypeEnum(String code, String trans, String dictCode) {
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
