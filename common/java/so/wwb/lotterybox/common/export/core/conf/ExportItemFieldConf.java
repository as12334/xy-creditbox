package so.wwb.lotterybox.common.export.core.conf;

import java.util.Map;

/**
 * Created by mark on 15-8-20:上午11:02.
 */
public class ExportItemFieldConf {


    /**
     * 各种语言的数字格式化或日期格式化格式
     */
    private Map<String/*language*/,String/*pattern*/> patternMap;

    /**
     * 字典字段的配置，dictsCode：字典Code，locale：语言，showText：实际导出的文本。
     */
    private Map<String/*dictsCode*/, Map<String/*language*/,String/*showText*/>> dictsMap;

    public Map<String, Map<String, String>> getDictsMap() {
        return dictsMap;
    }

    public void setDictsMap(Map<String, Map<String, String>> dictsMap) {
        this.dictsMap = dictsMap;
    }

    public Map<String, String> getPatternMap() {
        return patternMap;
    }

    public void setPatternMap(Map<String, String> patternMap) {
        this.patternMap = patternMap;
    }
}
