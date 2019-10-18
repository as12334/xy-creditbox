package so.wwb.creditbox.service.init;

import org.soul.commons.spring.utils.SpringTool;
import org.soul.commons.support.CommonConf;
import org.springframework.beans.factory.annotation.Value;

public class ConfigManager extends CommonConf {
    public ConfigManager(String dubboApplicationName, String version){
        setDubboApplicationName(dubboApplicationName);
        setCustomVersion(dubboApplicationName,version);
    }
    private String bossDataSourceId = "bossDataSource";

    @Value("${apiResultRetriever.poolSize}")
    private Integer poolSize;

    @Value("${apiResultRetriever.defaultTimeOut}")
    private Integer defaultTimeOut;

    @Value("${apiResultRetriever.defaultPeriod}")
    private Integer defaultPeriod;

    @Value("${apiResultRetriever.syncResultTopic}")
    private String syncResultTopic;

    @Value("${apiResultRetriever.asyncResultTopic}")
    private String asyncResultTopic;

    @Value("${belong.idc}")
    private String belongIDC;

    public String getBossDataSourceId() {
        return bossDataSourceId;
    }

    public Integer getDefaultPeriod() {
        return defaultPeriod;
    }

    public Integer getDefaultTimeOut() {
        return defaultTimeOut;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public String getSyncResultTopic() {
        return syncResultTopic;
    }

    public String getAsyncResultTopic() {
        return asyncResultTopic;
    }

    @Override
    public String getIdc() {
        return belongIDC;
    }

    @Override
    public void setIdc(String idc) {
        this.belongIDC = idc;
    }
    public static ConfigManager get() {
        return  SpringTool.getBean(ConfigManager.class);
    }
}
