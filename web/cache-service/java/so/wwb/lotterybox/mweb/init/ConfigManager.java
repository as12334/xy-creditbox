package so.wwb.lotterybox.mweb.init;

import org.soul.commons.spring.utils.SpringTool;
import org.soul.commons.support.CommonConf;

/**
 * service≈‰÷√
 * created by tony
 * modified by marz
 */
public class ConfigManager extends CommonConf{

    public ConfigManager(String dubboApplicationName, String version){
        super(dubboApplicationName,version);
    }
    public static ConfigManager get() {
        return SpringTool.getBean(ConfigManager.class);
    }
}
