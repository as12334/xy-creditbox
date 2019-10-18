package so.wwb.gamebox.tools.i18n.core;

import org.soul.commons.init.context.Const;
import org.soul.commons.io.FileTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTML|JSP页面的中文扫描到国际化文件
 * 按WebContent目录下的第一级目录做为国际化文件名
 * Created by longer on 5/26/17.
 */
public abstract class I18nScan {

    protected static Log log = LogFactory.getLog(I18nScan.class);
    private String[] regexp;

    public void scan(String dir) throws IOException {
        File file = new File(dir);
        if (isUnValidDir(dir, file)) {
            return;
        }

        for (File module : file.listFiles()) {
            if (module.isFile()) {
                continue;
            }
            Set<String> keys = new HashSet<>();
            listFile(module,module,keys);
            showKeys(keys);
            appendToFile(module,keys);
        }
    }

    private void appendToFile(File module,Set<String> keys) throws IOException {
        if (keys.size() <= 0) {
            return;
        }
        String i18nFileName = buildModuleName(module) + "_zh_CN.properties";
        File i18nFile = createI18nFile(module,i18nFileName);
        if (!i18nFile.exists()) {
            i18nFile.createNewFile();

        }

        Set<String> diffKeys = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        ResourceBundle sourceBundle = FileScanner.bundle(i18nFile.getAbsolutePath());
        for (String key : keys) {
            if (sourceBundle.containsKey(key)) {
                if (!key.equals(sourceBundle.getString(key))) {
                    //新的key与老的key的值不一致
                    diffKeys.add(key);
                    continue;
                }
                //key已经存在
                continue;
            }
            sb.append(MessageFormat.format("{0}={0}\n",key));
        }
        try {
            if (sb.length() > 0) {
                FileTool.write(i18nFile, "\n" + sb.toString(),Const.DEFAULT_CHARACTER,true);
            }
            writeDiff(i18nFile.getAbsoluteFile(),diffKeys);
        } catch (Exception e) {
            log.error(e,"写入国际化信息异常!");
        }
    }

    private void writeDiff(File absoluteFile, Set<String> diffKeys) {
        if (diffKeys.size() <= 0) {
            return;
        }
        File diffFile = new File(absoluteFile + ".diff");
        StringBuffer sb = new StringBuffer();
        for (String key : diffKeys) {
            sb.append(MessageFormat.format("{0}={0}\n",key));
        }
        if (sb.length() > 0) {
            FileTool.write(diffFile,"\n" + sb.toString(),Const.DEFAULT_CHARACTER,true);
        }
    }

    private boolean isUnValidDir(String dir, File file) {
        if (!file.exists()) {
            log.error("待扫描路径不存在:{0}",dir);
            return true;
        }
        if ("WebContent".equals(file.getName()) || "js".equals(file.getName())) {
            return false;
        }
        log.error("待扫描路径请指定到WebContent|js目录:{0}",dir);
        return true;
    }

    public abstract String[] getRegexp();

    class JspFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            if (pathname.isDirectory()) {
                return true;
            }
            if (pathname.getName().endsWith(".jsp") || pathname.getName().endsWith(".js")) {
                return true;
            }
            return false;
        }
    }

    private void listFile(File module,File current,Set<String> keys) throws IOException {
        if (current.isDirectory()) {
            for (File sub : current.listFiles(new JspFileFilter())) {
                if (sub.isDirectory()) {
                    listFile(module,sub,keys);
                } else {
                    String content = match(module,sub,keys);
                    writeToFile(sub,content);
                }
            }
        } else {
            String content = match(module,current,keys);
            writeToFile(current,content);
        }
    }

    /**
     * 创建模块化文件国际化文件
     * @param file
     * @param i18nFileName
     */
    protected abstract File createI18nFile(File file, String i18nFileName);

    private void showKeys(Set<String> keys) {
        if (keys.size() <= 0) {
            return;
        }
        int i=1;
        log.info("-----------------------------------------------------");
        log.info("Scan all file total find keys size:{0}",keys.size());
        log.info("-----------------------------------------------------");
        for (String key : keys) {
            log.info("index:{0},key:{1}",i,key);
            i++;
        }
        log.info("-----------------------------------------------------");
        log.info("Scan end");
        log.info("-----------------------------------------------------");
    }

    public String match(File module, File current, Set<String> keys) throws IOException {
        String moduleName = buildModuleName(module);
        String content = FileTool.readFileToString(current, "UTF-8");
        for (String regexp : getRegexp()) {
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(content);

            int newStart = 0;
            while (matcher.find(newStart)) {
                int begin = matcher.start();
                int end = matcher.end();
                if (begin < 0 || end < 0) {
                    log.error(begin + " vs" + end);
                }
                String matchAllText = content.substring(begin, end);
                String word = matcher.group(1);
                log.info("Find Key:{0},pos:{1}-{2}", matchAllText, begin, end);
                String replaced = replaceToMatchWord(matchAllText,moduleName, word);

                content = content.substring(0, begin) + replaced + content.substring(end);
                newStart = begin + replaced.length();
                matcher = pattern.matcher(content);
                keys.add(word);
            }
        }
        return content;
    }

    /**
     * 匹配的文字将被替换成什么?
     * @param moduleName
     * @param word
     * @return
     */
    protected abstract String replaceToMatchWord(String matchAllText,String moduleName, String word);

    private void writeToFile(File current,String content) throws IOException {
        FileWriter fileWriter = new FileWriter(current,false);
        try {
            fileWriter.append(content);
            fileWriter.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    private String buildModuleName(File module) {
        String moduleName = module.getName();
        //waring: jsp's el expression "${}" can't use "."
        int dotPos = moduleName.indexOf(".");
        if (dotPos != -1){
            moduleName = moduleName.substring(0,dotPos);
        }
        return moduleName + "_auto";
    }

    public void repair(String dir) throws IOException {
        File file = new File(dir);
        if (isUnValidDir(dir, file)) {
            return;
        }

        for (File module : file.listFiles()) {
            if (module.isFile()) {
                continue;
            }
            Set<String> keys = new HashSet<>();
            listFile(module,module,keys);
            appendToFile(module,keys);
        }
    }
}
