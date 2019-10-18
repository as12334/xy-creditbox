package so.wwb.gamebox.tools.i18n.impl;

import so.wwb.gamebox.tools.i18n.core.I18nScan;

import java.io.File;
import java.io.IOException;

/**
 * HTML|JSP页面的中文扫描到国际化文件
 * 按WebContent目录下的第一级目录做为国际化文件名
 * Created by longer on 5/26/17.
 */
public class JsI18nScan extends I18nScan {

    String[] regexp = {
            "\"([\\u4e00-\\u9fa5]{1,})[?!.]?\"",
    };

    private String gameboxRoot;

    @Override
    public String[] getRegexp() {
        return regexp;
    }

    @Override
    protected File createI18nFile(File module, String i18nFileName) {
        //warning: file 对象为WebContent目录下的第一级目录
        String path = module.getAbsolutePath();
        String flag = "WebContent/";
        int beginPos = path.indexOf(flag);
        beginPos = beginPos + flag.length();
        String projectName = path.substring(beginPos,path.indexOf("/",beginPos));

        String webContentParent = gameboxRoot + "/websites/" + projectName;
        String moduleI18nName = webContentParent + "/resources/conf/i18n/messages/" + i18nFileName;
        File moduleI18nNameFile = new File(moduleI18nName);
        log.info("国际化文件位置:{0}",moduleI18nName);
        return moduleI18nNameFile;
    }

    @Override
    protected String replaceToMatchWord(String matchAllText,String moduleName, String word) {
        return  "window.top.message." + moduleName + "['" + word + "']";
    }

    public void setGameboxRoot(String gameboxRoot) {
        this.gameboxRoot = gameboxRoot;
    }

    public static void main(String[] args) {
        String gameboxRoot = "/home/leo/IdeaProjects/gamebox";
        JsI18nScan scan = new JsI18nScan();
        scan.setGameboxRoot(gameboxRoot);
        String []  dirs = {
            "/home/leo/IdeaProjects/gamebox/rcenter/WebContent/mcenter/js",
//              "/home/leo/IdeaProjects/gamebox/rcenter/WebContent/pcenter/js",
//            "//home/leo/IdeaProjects/gamebox/rcenter/WebContent/acenter/js",
//            "/home/leo/IdeaProjects/gamebox/rcenter/WebContent/tcenter/js",
        };
        for (String dir : dirs) {
            try {
                scan.scan(dir);
            } catch (IOException e) {
                log.error(e);
            }
        }
    }
}
