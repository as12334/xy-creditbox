package so.wwb.gamebox.tools.i18n.impl;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.gamebox.tools.i18n.core.FileScanner;
import so.wwb.gamebox.tools.i18n.core.I18nAction;
import so.wwb.gamebox.tools.i18n.fiter.I18nPropertiesFileFilter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Water on 6/14/17.
 * 修改国际化properties文件的编码，从ascii-->utf8,并且进行排序
 */
public class SortI18n extends FileScanner implements I18nAction {

    public static Log LOG = LogFactory.getLog(SortI18n.class);

    public SortI18n() {

    }

    @Autowired
    public void execute(File file) throws IOException {
        ResourceBundle resourceBundle = FileScanner.bundle(file.getAbsolutePath());
        OutputStreamWriter outputStreamWriter =  null;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
            List<String> sort = new ArrayList<>();
            for (String o : resourceBundle.keySet()) {
                sort.add(o);
            }
            Collections.sort(sort);
            String preKey = "";
            for (String key : sort) {
                String value = resourceBundle.getString(key);
                String kv = I18nTool.ditillI18nKey(key) + "=" + value  + "\n";
                insertNewLineIfNeed(outputStreamWriter,preKey,key);
                preKey = key;
                outputStreamWriter.write(kv);
            }
            outputStreamWriter.flush();
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
    }

    @Override
    public FileFilter getFileFilter() {
        return new I18nPropertiesFileFilter();
    }

    private void insertNewLineIfNeed(OutputStreamWriter outputStreamWriter, String preKey, String key) throws IOException {
        if (StringTool.isBlank(preKey) || StringTool.isBlank(key)) {
            return;
        }
        if (!preKey.substring(0,1).equals(key.substring(0,1))) {
            outputStreamWriter.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        //String path = "/home/longer/workspace/gamebox";
        String path = "/home/longer/workspace/pay-impl";
        FileScanner scanner = new SortI18n();
        scanner.scan(new File(path),scanner);
    }
}
