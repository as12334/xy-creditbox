package so.wwb.creditbox.web.init;

import org.soul.commons.spring.utils.SpringTool;
import org.soul.commons.support.CommonConf;
import org.soul.web.support.BaseWebConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tony on 17-7-4.
 */
@Component
public class ConfigBase extends BaseWebConf {

    @Autowired()
    private CommonConf commonConf;
    @Value("${exportFile.maxCount}")
    private Integer maxCount;

    @Value("${data.redis.keyPrefix}")
    private String dataKeyPrefix;

    @Value("${gameApi.redis.keyPrefix}")
    private String apiKeyPrefix;

    @Value("${pageCache.redis.keyPrefix}")
    private String pageKeyPrefix;

    @Value("${gather.redis.keyPrefix}")
    private String gatherKeyPrefix;

    @Value("${session.redis.keyPrefix}")
    private String sessionKeyPrefix;

    @Value("${ds.id.model.lottery}")
    private String dsIdModelLottery;

    @Value("${ds.id.model.mock.account}")
    private String dsIdModelMockAccount;

    @Value("${ds.id.model.platform}")
    private String dsIdModelPlatform;

    /**
     * 导出组件限制的最大导出条数
     * @return
     */
    public Integer getMaxCount() {
        return maxCount;
    }

    /**
     * 获取API缓存key前缀
     * @return
     */
    public String getApiKeyPrefix() {
        return commonConf.getIdc()+commonConf.getSplit()+ apiKeyPrefix;
    }
    public String getApiKeyPrefix(boolean withVersion) {
        if(withVersion) {
            return getApiKeyPrefix();
        }else{
            return apiKeyPrefix;
        }
    }
    /**
     * 获取数据缓存key前缀
     * @return
     */
    public String getDataKeyPrefix() {
        return commonConf.getIdc()+commonConf.getSplit()+ dataKeyPrefix;
    }
    public String getDataKeyPrefix(boolean withVersion) {
        if(withVersion) {
            return getDataKeyPrefix();
        }else{
            return dataKeyPrefix;
        }
    }
    /**
     * 获取页面缓存key前缀
     * @return
     */
    public String getPageKeyPrefix() {
        return commonConf.getIdc()+commonConf.getSplit()+pageKeyPrefix;
    }
    public String getPageKeyPrefix(boolean withVersion) {
        if(withVersion) {
            return getPageKeyPrefix();
        }else{
            return dataKeyPrefix;
        }
    }

    public String getGatherKeyPrefix() {
        return gatherKeyPrefix;
    }

    public String getSessionKeyPrefix() {
        return sessionKeyPrefix;
    }

    public String getDsIdModelLottery() {
        return dsIdModelLottery;
    }

    public String getDsIdModelMockAccount() {
        return dsIdModelMockAccount;
    }

    public String getDsIdModelPlatform() {
        return dsIdModelPlatform;
    }
    public static ConfigBase get() {
        return SpringTool.getBean(ConfigBase.class);
    }
}
