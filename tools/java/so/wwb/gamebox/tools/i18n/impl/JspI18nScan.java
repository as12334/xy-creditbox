package so.wwb.gamebox.tools.i18n.impl;

import so.wwb.gamebox.tools.i18n.core.I18nScan;
import so.wwb.gamebox.tools.i18n.fiter.WebAppScanner;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * HTML|JSP页面的中文扫描到国际化文件
 * 按WebContent目录下的第一级目录做为国际化文件名
 * Created by longer on 5/26/17.
 */
public class JspI18nScan extends I18nScan {



    String[] regexp = {
            ">[\\s]*([\\u4e00-\\u9fa5]+)[：？，:?]?\\s*<",                             //标点在末尾
            ">[\\s]*([\\u4e00-\\u9fa5]+[：？，:?])[：？，:?]?\\s*<",
            "[=]\\s*[\"\'][\\s]*([\\u4e00-\\u9fa5]+)[：？，:?]?\\s*[\"\']",            //标点在末尾
            "[=]\\s*[\"\'][\\s]*([\\u4e00-\\u9fa5]+[：？，:?])[：？，:?]?\\s*[\"\']"
    };

    @Override
    public String[] getRegexp() {
        return regexp;
    }

    @Override
    protected String replaceToMatchWord(String matchAllText,String moduleName, String word) {
        String beReplace = "\\$\\{views." + moduleName + "\\['" + word + "'\\]\\}";
        word = Pattern.quote(word);
        return  matchAllText.replaceFirst(word, beReplace);
    }

    @Override
    protected File createI18nFile(File module, String i18nFileName) {
        //warning: file 对象为WebContent目录下的第一级目录
        String webContentParent = module.getParentFile().getParentFile().getAbsolutePath();
        String moduleI18nName = webContentParent + "/resources/conf/i18n/views/" + i18nFileName;
        File moduleI18nNameFile = new File(moduleI18nName);
        return moduleI18nNameFile;
    }



    public static void main(String[] args) throws IOException {
        String dir = "/home/leo/IdeaProjects/gamebox";

        //只扫描WebContent目录下的文件
        WebAppScanner appScanner = WebAppScanner.getDefault();
        appScanner.scan(new File(dir));
        List<File> dirs = appScanner.getWebContents();

        I18nScan scan = new JspI18nScan();
        for (File appPath: dirs) {
            try {
                scan.scan(appPath.getAbsolutePath());
            } catch (IOException e) {
                log.error(e);
            }
        }
    }
}
