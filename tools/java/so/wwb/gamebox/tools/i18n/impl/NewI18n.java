package so.wwb.gamebox.tools.i18n.impl;

import org.soul.commons.io.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.gamebox.tools.i18n.core.FileScanner;
import so.wwb.gamebox.tools.i18n.core.I18nAction;
import so.wwb.gamebox.tools.i18n.fiter.I18nPropertiesFileFilter;

import java.io.*;

/**
 * Created by Water on 6/15/17.
 * 平台支持一门新的语言时，添加此语言的i18n properties
 * 新添加的properties文件,编码:UTF-8 without BOM
 */
public class NewI18n extends FileScanner implements I18nAction {

    private String from = "zh_CN.properties";
    private String to = "ja_JP.properties";

    @Autowired
    public void execute(File file) throws IOException {
        if (!file.getName().endsWith(from)) {
            return;
        }

        File toFile = new File(file.getAbsolutePath().replaceAll(from, to));
        if (toFile.exists()) {
            //确保编码without BOM
            removeBom(toFile);
            return;
        }
        String context = FileTool.readFileToString(file, "UTF-8");
        writeToFile(toFile, context);
    }

    private void writeToFile(File toFile, String context) throws IOException {
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(toFile), "UTF-8");
            outputStreamWriter.write(context);
            outputStreamWriter.flush();
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
    }

    private void removeBom(File toFile) throws IOException {
        String content = FileTool.readFileToString(toFile,"UTF-8");
        content = content.replaceAll("\uFEFF","");
        writeToFile(toFile,content);


    }

    @Override
    public FileFilter getFileFilter() {
        return new I18nPropertiesFileFilter();
    }

    public static void main(String[] args) throws IOException {
        String path = "/home/longer/workspace/gamebox";
//        String path = "/home/longer/workspace/gamebox/websites/acenter/resources/conf/i18n/views";
        FileScanner scanner = new NewI18n();
        scanner.scan(new File(path),scanner);
    }
}
