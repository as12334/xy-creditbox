package so.wwb.gamebox.tools.i18n.core;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;

import java.io.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 文件Scan抽象类
 */
public abstract class FileScanner implements I18nAction{

    public static Log LOG = LogFactory.getLog(FileScanner.class);

    public FileScanner() {

    }

    public void scan(File current) throws IOException {
        scan(current,this);
    }

    /**
     * @param current
     * @param action
     * @throws IOException
     */
    public void scan(File current, I18nAction action) throws IOException {
        if (!action.isContinue(current)) {
            return;
        }
        if (current.isDirectory()) {
            for (File sub : current.listFiles(action.getFileFilter())) {
                if (sub.isDirectory()) {
                    scan(sub, action);
                } else {
                    action.execute(sub);
                }
            }
        } else {
            action.execute(current);
        }
    }

    @Override
    public boolean isContinue(File file) {
        return true;
    }

    /**
     * 读取properties国际化内容
     * @param file
     * @return
     */
    public static ResourceBundle bundle(String file) {
        ResourceBundle bundle = null;
        InputStream inputStream = null;
        Reader reader = null;
        try {
            inputStream = new FileInputStream(new File(file));
            reader = new InputStreamReader(inputStream, "UTF-8");
            bundle = new PropertyResourceBundle(reader);
        } catch (Exception e) {
            LOG.error(e, "绑定本地运行环境和资源文件时出错!");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

}
