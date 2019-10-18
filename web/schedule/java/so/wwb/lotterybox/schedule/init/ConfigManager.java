package so.wwb.lotterybox.schedule.init;

import org.soul.commons.spring.utils.SpringTool;
import org.soul.commons.support.CommonConf;
import org.springframework.beans.factory.annotation.Value;

public class ConfigManager extends CommonConf {
    public ConfigManager(String dubboApplicationName, String version){
        setDubboApplicationName(dubboApplicationName);
        setCustomVersion(dubboApplicationName,version);
    }
    @Value("${belong.idc}")
    private String belongIDC;
    @Value("${filesite.uri}")
    private String fileRoot;
    @Value("${exportFile.catePath}")
    private String catePath;

    public String getBelongIDC() {
        return belongIDC;
    }

    /**
     *
     * @return 站点文件根URL
     */
    public String getFileRoot() {
        return fileRoot;
    }

    /**
     *
     * @return 导出组件导出的文件存储在文件服务器上的目录名
     */
    public String getCatePath() {
        return catePath;
    }
    public static ConfigManager get() {
        return  SpringTool.getBean(ConfigManager.class);
    }
}