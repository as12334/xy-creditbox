package so.wwb.gamebox.tools.i18n.impl;

import org.soul.commons.init.context.Const;
import org.soul.commons.io.FileTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.gamebox.tools.i18n.core.FileScanner;
import so.wwb.gamebox.tools.i18n.core.I18nAction;
import so.wwb.gamebox.tools.i18n.fiter.I18nPropertiesFileFilter;

import java.io.*;
import java.util.ResourceBundle;

/**
 * Created by Water on 6/14/17.
 * 修改国际化properties文件的编码，从ascii-->utf8
 */
public class AsciiToUtf8 extends FileScanner implements I18nAction {

    //UTF-8 BOM


    public static Log LOG = LogFactory.getLog(AsciiToUtf8.class);

    public AsciiToUtf8() {

    }



    @Autowired
    public void execute(File file) throws IOException {
        ResourceBundle resourceBundle = FileScanner.bundle(file.getAbsolutePath());
        FileOutputStream fileOutputStream  = null;
        OutputStreamWriter outputStreamWriter =  null;
        String content = FileTool.readFileToString(file, Const.DEFAULT_CHARACTER);
        try {
            boolean hasChange = false;
            if (content.indexOf(I18nTool.BOM) != -1) {
                content = I18nTool.removeBom(content);
                hasChange = true;

            }
            if (content.indexOf("\\u") != -1) {
                hasChange = true;
                //带\\uXXXX码
                for (String key : resourceBundle.keySet()) {
                    String value = resourceBundle.getString(key);

                    String unicodeKey = StringTool.toUnicode(key);
                    if (content.indexOf(unicodeKey) != -1) {
                        String source = I18nTool.getMatchKey(unicodeKey);
                        content = content.replaceAll(source, I18nTool.ditillI18nKey(key) + "=" + value);
                    } else {
                        String source = I18nTool.getMatchKey(key);
                        content = content.replaceAll(source, I18nTool.ditillI18nKey(key) + "=" + value);
                    }
                }
            }

            if (hasChange){
                FileTool.deleteQuietly(file);
                fileOutputStream = new FileOutputStream(file);
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, Const.DEFAULT_CHARACTER);
                outputStreamWriter.write(content);
                outputStreamWriter.flush();
            }
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
    }



    @Override
    public boolean isContinue(File file) {
        if (file.isDirectory()) {
            if ("rcenter".equals(file.getName()) && "gamebox".equals(file.getParentFile().getName())) {
                return false;
            }
            if ("tools".equals(file.getName()) && "base".equals(file.getParentFile().getName())) {
                return false;
            }
            if (file.getName().startsWith(".")) {
                //排除工具类模块 || 隐藏目录
                return false;
            }
        }
        return true;

    }

    @Override
    public FileFilter getFileFilter() {
        return new I18nPropertiesFileFilter();
    }


    public static void main(String[] args) throws IOException {
//        String path = "/home/longer/workspace/gamebox";
        String path = "/home/longer/workspace/gamebox";
        FileScanner scanner = new AsciiToUtf8();
        scanner.scan(new File(path),scanner);
        
    }

}
