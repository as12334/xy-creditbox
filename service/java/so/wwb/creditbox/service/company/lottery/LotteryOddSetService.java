package so.wwb.creditbox.service.company.lottery;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.init.context.Const;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.company.lottery.LotteryOddSetMapper;
import so.wwb.creditbox.iservice.company.lottery.ILotteryOddSetService;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.company.lottery.po.LotteryOddSet;
import so.wwb.creditbox.model.company.lottery.vo.LotteryOddSetListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryOddSetVo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 彩票赔率设置表服务
 *
 * @author diego
 * @time 2018-02-11
 */
public class LotteryOddSetService extends BaseService<LotteryOddSetMapper, LotteryOddSetListVo, LotteryOddSetVo, LotteryOddSet, Integer> implements ILotteryOddSetService {

    private static final Log LOG = LogFactory.getLog(LotteryOddSetService.class);

    @Override
    public Map<String, Map<String, LotteryOddSet>> load(LotteryOddSetVo vo) {
        DataSource dataSource = DataContext.getDataSource();
        Map<String, Map<String, LotteryOddSet>> cacheMap = new HashMap<>();
        Integer siteId = vo.getSearch().getSiteId();
        if (siteId == null) {
            siteId = vo._getSiteId();
        }
        if (siteId > Const.BOSS_DATASOURCE_ID) {
            DataContext.setDataSource(DatasourceTool.getDruidDatasource(siteId));
        }
//        List<LotteryOddSet> list = mapper.allSearch(Order.asc(LotteryOddSet.PROP_ORDER_NUM));
        List<LotteryOddSet> list = this.mapper.searchAllOdds();
        if(CollectionTool.isNotEmpty(list)){
            for (LotteryOddSet oddSet : list) {
                String cacheKey = CacheKey.getCacheKey(Integer.toString(siteId),Integer.toString(oddSet.getProjectId()), oddSet.getCode());
                if (cacheMap.get(cacheKey) == null) {
                    cacheMap.put(cacheKey, new HashMap<>());
                }
                String valueKey = CacheKey.getCacheKey(oddSet.getBetCode(),oddSet.getBetNum());
                cacheMap.get(cacheKey).put(valueKey, oddSet);
            }
            return cacheMap;
        }
        DataContext.setDataSource(dataSource);
        return cacheMap;
    }

    @Override
    public void initLotteryOddSet(LotteryOddSetVo lotteryOddSetVo) {
        this.mapper.initLotteryOddSet (lotteryOddSetVo.getSearch());
    }

    @Override
    public Integer deleteLotteryOddSetByProject(LotteryOddSet lotteryOddSet) {
        return this.mapper.deleteLotteryOddSetByProject(lotteryOddSet);
    }
}