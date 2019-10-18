package so.wwb.gamebox.tools.i18n.impl;

import org.soul.commons.init.context.Const;
import org.soul.commons.io.FileTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.gamebox.tools.i18n.core.FileScanner;
import so.wwb.gamebox.tools.i18n.fiter.WebAppScanner;
import so.wwb.gamebox.tools.i18n.fiter.ZhCNPropertiesFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;

/**
 * 扫描国际化资源文件，并生成增量文件
 * Created by fei on 17-7-12.
 */
public class I18nIncScan extends FileScanner {

    private static Log log = LogFactory.getLog(I18nIncScan.class);

    private String targetLocale;

    public void setTargetLocale(String targetLocale) {
        this.targetLocale = targetLocale;
    }

    @Override
    public void execute(File file) throws IOException {
        String targetLocaleStr = file.getAbsolutePath().replaceAll(Const.DEFAUTL_LOCALE,this.targetLocale);
        File targetLocaleFile = new File(targetLocaleStr);

        String targetLocaleIncStr = targetLocaleStr + "." + DateTool.formatDate(new Date(),DateTool.UNFMT_yyMMdd);
        if (!targetLocaleFile.exists()) {
            FileTool.copyFile(file,new File(targetLocaleIncStr));
            return;
        }

        List<String> keys = new ArrayList<>();
        StringBuffer inc = new StringBuffer();
        ResourceBundle sourceBundle = FileScanner.bundle(file.getAbsolutePath());
        ResourceBundle targetBundle = FileScanner.bundle(targetLocaleFile.getAbsolutePath());
        for (String sourceKey : sourceBundle.keySet()) {
            if (!targetBundle.containsKey(sourceKey)) {
                keys.add(sourceKey);
            }
        }

        Collections.sort(keys);
        for (String sourceKey : keys) {
            inc.append(sourceKey + "=" + sourceBundle.getString(sourceKey) + "\r");
        }
        if (inc.length() > 0) {
            FileTool.write(new File(targetLocaleIncStr),inc.toString(),Const.DEFAULT_CHARACTER);
        }
    }

    @Override
    public FileFilter getFileFilter() {
        return new ZhCNPropertiesFileFilter();
    }

    @Override
    public boolean isContinue(File file) {
        WebAppScanner webAppScanner = WebAppScanner.getDefault();
        if (file.isDirectory()) {
            if (webAppScanner.isExclude(file)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            String dir = "/home/leo/IdeaProjects/gamebox";

            I18nIncScan scanner = new I18nIncScan();
            scanner.setTargetLocale("ja_JP"); //设置需要增量国际化的语言
            scanner.scan(new File(dir));
        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }
}
