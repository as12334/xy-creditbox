package so.wwb.gamebox.tools.i18n.fiter;

import java.io.File;
import java.io.FileFilter;

/**
 * 简体中文国际化文件扫描器
 */
public class ZhCNPropertiesFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        if (pathname.getName().endsWith("zh_CN.properties")) {
            return true;
        }
        return false;
    }
}