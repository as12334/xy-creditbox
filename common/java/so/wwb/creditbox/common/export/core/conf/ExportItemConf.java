package so.wwb.creditbox.common.export.core.conf;

import java.util.Map;

/**
 * Created by mark on 15-8-20:上午11:02.
 */
public class ExportItemConf {

    /**
     * 导出列表中存储数据对应的class
     * 一般都是PO
     */
    private Class exportDataClass;

    /**
     * 导出列表的标题
     */
    private Map<String/*language*/,String/*title*/> titleMap;

    /**
     * 所有导出的字段,以逗号隔开
     */
    private String fields;
    /**
     * 字段宽度
     */
    private Map<String,Integer> fieldWidth;

    /**
     * 是否支持分页
     */
    private Boolean paging=false;
    /**
     * 各种语言的表头，表头列多个以逗号隔开，按顺序与fields的值一一对应
     */
    private Map<String/*language*/,String/*tableHeads*/> tableHeadsMap;

    /**
     * 各个字段对应的格式转换及字典国际化翻译配置等
     */
    private Map<String/*field*/,ExportItemFieldConf> exportItemFieldConfMap;

    private Map<String,ExportStyle> columnMap;

    public Class getExportDataClass() {
        return exportDataClass;
    }

    public void setExportDataClass(Class exportDataClass) {
        this.exportDataClass = exportDataClass;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public Map<String, ExportItemFieldConf> getExportItemFieldConfMap() {
        return exportItemFieldConfMap;
    }

    public void setExportItemFieldConfMap(Map<String, ExportItemFieldConf> exportItemFieldConfMap) {
        this.exportItemFieldConfMap = exportItemFieldConfMap;
    }

    public Map<String, String> getTableHeadsMap() {
        return tableHeadsMap;
    }

    public void setTableHeadsMap(Map<String, String> tableHeadsMap) {
        this.tableHeadsMap = tableHeadsMap;
    }

    public Map<String, String> getTitleMap() {
        return titleMap;
    }

    public void setTitleMap(Map<String, String> titleMap) {
        this.titleMap = titleMap;
    }

    public Boolean getPaging() {
        return paging;
    }

    public void setPaging(Boolean paging) {
        this.paging = paging;
    }

    public Map<String, ExportStyle> getColumnMap() {
        return columnMap;
    }

    public void setColumnMap(Map<String, ExportStyle> columnMap) {
        this.columnMap = columnMap;
    }

    public Map<String,Integer> getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth(Map<String,Integer> fieldWidth) {
        this.fieldWidth = fieldWidth;
    }
}
