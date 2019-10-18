package so.wwb.gamebox.tools.i18n.core;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Created by longer on 6/15/17.
 */
public interface I18nAction {

    /**
     * 对文件进行处理
     * @param current
     */
    void execute(File current) throws IOException;

    /**
     * 是否继续
     * @param file
     * @return
     */
    boolean isContinue(File file);

    /**
     * 要过虑的文件
     */
    FileFilter getFileFilter();
}
