package so.wwb.creditbox.schedule.init;

import org.soul.commons.spring.utils.SpringTool;
import org.soul.commons.support.CommonConf;
import org.springframework.beans.factory.annotation.Value;

public class ConfigManager extends CommonConf {
    public ConfigManager(String dubboApplicationName, String version){
        setDubboApplicationName(dubboApplicationName);
        setCustomVersion(dubboApplicationName,version);
    }
    public static ConfigManager get() {
        return SpringTool.getBean(ConfigManager.class);
    }
}