package so.wwb.creditbox.service.company.lottery;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.company.lottery.LotteryQuotaSetMapper;
import so.wwb.creditbox.iservice.company.lottery.ILotteryQuotaSetService;
import so.wwb.creditbox.model.common.Const;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.company.lottery.po.LotteryQuotaSet;
import so.wwb.creditbox.model.company.lottery.vo.LotteryQuotaSetListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryQuotaSetVo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 彩票限额设置表服务
 *
 * @author diego
 * @time 2018-02-11
 */
public class LotteryQuotaSetService extends BaseService<LotteryQuotaSetMapper, LotteryQuotaSetListVo, LotteryQuotaSetVo, LotteryQuotaSet, Integer> implements ILotteryQuotaSetService {

    private static final Log LOG = LogFactory.getLog(LotteryQuotaSetService.class);

    @Override
    public Map<String, Map<String, LotteryQuotaSet>> load(LotteryQuotaSetVo vo) {
        DataSource dataSource = DataContext.getDataSource();
        Map<String, Map<String, LotteryQuotaSet>> cacheMap = new HashMap<>();
        Integer siteId = vo.getSearch().getSiteId();
        if (siteId == null) {
            siteId = vo._getSiteId();
        }
        if (siteId > Const.BOSS_DATASOURCE_ID) {
            DataContext.setDataSource(DatasourceTool.getDruidDatasource(siteId));
        }
        List<LotteryQuotaSet> list = this.mapper.allSearch();
        if(CollectionTool.isNotEmpty(list)){
            for (LotteryQuotaSet quotaSet : list) {
                String cacheKey = CacheKey.getCacheKey(Integer.toString(siteId), quotaSet.getCode());
                if (cacheMap.get(cacheKey) == null) {
                    cacheMap.put(cacheKey, new HashMap<>());
                }
                cacheMap.get(cacheKey).put(quotaSet.getPlayCode(), quotaSet);
            }
            return cacheMap;
        }
        DataContext.setDataSource(dataSource);
        return cacheMap;
    }
}