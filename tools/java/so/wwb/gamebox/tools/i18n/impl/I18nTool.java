package so.wwb.gamebox.tools.i18n.impl;

import org.soul.commons.lang.string.StringTool;

import java.util.regex.Pattern;

/**
 * Created by longer on 8/3/17.
 */
public class I18nTool {

    public static final String BOM = "\uFEFF";

    public static String removeBom(String content) {
        return content.replaceFirst(BOM, "");
    }

    public static String getMatchKey(String unicodeKey) {
        return Pattern.quote("^" + unicodeKey) + "=.*";
    }

    /**
     * 处理当冒号使用ResourceBundle写入properties时,需要转义的问题
     * @param key
     * @return
     */
    public static String ditillI18nKey(String key) {
        if (StringTool.isBlank(key)) {
            return key;
        }
        if (key.indexOf(":") != -1){
            key = key.replace(":","\\:");
        }
        return key;
    }
}
