package so.wwb.gamebox.tools.i18n.fiter;

import so.wwb.gamebox.tools.i18n.core.FileScanner;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有Web App
 */
public class WebAppScanner extends FileScanner {

    List<File> hasWebContentApp = new ArrayList<>();

    private List<String> excludes = new ArrayList<>();

    /**
     * 增加排除掉的应用
     * @param app
     * @return
     */
    public WebAppScanner exclude(String app) {
        excludes.add(app);
        return this;
    }

    @Override
    public void execute(File current) throws IOException {

    }

    @Override
    public boolean isContinue(File file) {
        if (!file.isDirectory()) {
            return false;
        }
        if (excludes.contains(file.getName())) {
            return false;
        }
        if ("WebContent".equals(file.getName())){
            hasWebContentApp.add(file);
            return false;
        }
        return true;
    }

    public boolean isExclude(File file) {
        if (excludes.contains(file.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public FileFilter getFileFilter() {
        return null;
    }

    public List<File> getWebContents() {
        return this.hasWebContentApp;
    }

    public static WebAppScanner getDefault(){
        WebAppScanner appScanner = new WebAppScanner();
        appScanner
                .exclude("app_lottery")
                .exclude("app_lottery-mobile")
                .exclude("app_import")
                .exclude("app_fserver")
                .exclude("app_boss")
                .exclude("app_ccenter")
                .exclude("app_mdcenter")
                .exclude("app_schedule")
                .exclude("app_service")
                .exclude("app_service-api")
                .exclude("rcenter")
                .exclude("tools")
        ;
        return appScanner;
    }
}