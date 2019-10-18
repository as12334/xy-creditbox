package so.wwb.gamebox.tools.i18n.fiter;

import org.soul.commons.lang.string.I18nLocale;

import java.io.File;
import java.io.FileFilter;

/**
 * 国际化文件扫描器
 */
public class I18nPropertiesFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {

        if (file.isDirectory()) {
            return true;
        }

        for (I18nLocale locale : I18nLocale.values()) {
            if (file.getName().endsWith(locale.getCode() + ".properties")) {
                return true;
            }
        }
        return false;
    }
}