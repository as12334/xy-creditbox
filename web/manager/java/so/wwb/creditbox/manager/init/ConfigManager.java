package so.wwb.creditbox.manager.init;

import org.soul.commons.spring.utils.SpringTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import so.wwb.creditbox.web.init.ConfigBase;

@Component
public class ConfigManager extends ConfigBase {

    @Value("${exportFile.maxCount}")
    private Integer maxCount;

    /**
     * ����������Ƶ���󵼳�����
     */
    public Integer getMaxCount() {
        return maxCount;
    }

    /**
     * �ܴ���SubSysCode
     */
    public String getTopAgentSubSysCode() {
        return this.getSubsysCode()+"TopAgent";
    }

    /**
     * ����SubSysCode
     */
    public String getAgentSubSysCode() {
        return this.getSubsysCode()+"Agent";
    }

    public static ConfigManager get() {
        return SpringTool.getBean(ConfigManager.class);
    }
}
