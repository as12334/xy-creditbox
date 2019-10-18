package so.wwb.creditbox.schedule.init;

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
     * @return վ���ļ���URL
     */
    public String getFileRoot() {
        return fileRoot;
    }

    /**
     *
     * @return ��������������ļ��洢���ļ��������ϵ�Ŀ¼��
     */
    public String getCatePath() {
        return catePath;
    }
    public static ConfigManager get() {
        return  SpringTool.getBean(ConfigManager.class);
    }
}