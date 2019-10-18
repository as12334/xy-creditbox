package so.wwb.gamebox.tools.i18n.impl;

import org.soul.commons.init.context.Const;
import org.soul.commons.io.FileTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.gamebox.tools.i18n.core.FileScanner;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * 扫描增量文件,合并到原始文件中
 * Created by Water on 17-8-3.
 */
public class I18nIncMergeScan extends FileScanner {

    private static Log log = LogFactory.getLog(I18nIncMergeScan.class);

    private String incFileSuffix;

    public void setIncFileSuffix(String incFileSuffix) {
        this.incFileSuffix = incFileSuffix;
    }

    @Override
    public void execute(File file) throws IOException {
        String incFileName = file.getAbsolutePath();
        String targetFileName = incFileName.substring(0,incFileName.lastIndexOf("."));

        Set<String> noExists = new HashSet<>();
        File targetLocaleFile = new File(targetFileName);
        if (!targetLocaleFile.exists()) {
            noExists.add(targetFileName);
            log.warn("待合并的目标文件不存在:{0},复制之",targetFileName);
            FileTool.copyFile(file,targetLocaleFile);
            return;
        }

        StringBuffer inc = new StringBuffer();
        ResourceBundle sourceBundle = FileScanner.bundle(file.getAbsolutePath());
        ResourceBundle targetBuldle = FileScanner.bundle(targetFileName);
        String content = FileTool.readFileToString(targetLocaleFile,Const.DEFAULT_CHARACTER);
        for (String key : sourceBundle.keySet()) {
            String value = sourceBundle.getString(key);
            if (key.indexOf(I18nTool.BOM) != -1) {
                key = key.replaceFirst(I18nTool.BOM,"");
            }
            if (targetBuldle.containsKey(key)) {
                String source = I18nTool.getMatchKey(key);
                try {
                    content = content.replaceAll(source, key+ "=" + value);
                } catch (Exception e) {
                    log.error("文件名:{0},目标文件替换失败",targetFileName);
                    log.error("key:{0} --> value:{1}",key,value);
                }
            } else {
                inc.append("\r");
                inc.append(key).append("=").append(value);
            }
        }
        if (inc.length() > 0) {
            String date = DateTool.formatDate(new Date(),DateTool.yyyyMMdd);
            content = content + "\r# Auto merge by scanner " + date + " begin.";
            content = content + inc.toString();
            content = content + "\r# Auto merge by scanner " + date + " end.";
        }

        if (inc.length() > 0) {
            FileTool.write(targetLocaleFile,content,Const.DEFAULT_CHARACTER);
        }
    }

    @Override
    public FileFilter getFileFilter() {
        return pathname -> {
            if (pathname.isDirectory()) {
                return true;
            }
            if (pathname.getName().endsWith(incFileSuffix)) {
                return true;
            }
            return false;
        };
    }

    public static void main(String[] args) {
        try {
            String path = "/home/leo/IdeaProjects/gamebox";
            I18nIncMergeScan scanner = new I18nIncMergeScan();
            scanner.setIncFileSuffix("ja_JP.properties.171030");//待合并的增量文件的后缀名
            scanner.scan(new File(path),scanner);
        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }
}
