package so.wwb.creditbox.service.company.lottery;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.data.company.lottery.SiteLotteryMapper;
import so.wwb.creditbox.iservice.company.lottery.ISiteLotteryService;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.vo.GameManageOrderVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryVo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 站点彩票服务
 *
 * @author block
 * @time 2019-10-20 23:13:51
 */
//region your codes 1
public class SiteLotteryService extends BaseService<SiteLotteryMapper, SiteLotteryListVo, SiteLotteryVo, SiteLottery, Integer> implements ISiteLotteryService {
//endregion your codes 1

    //region your codes 2

    @Autowired
    private SiteLotteryMapper siteLotteryMapper;


    @Override
    public Map<String, Map<String, SiteLottery>> load(SiteLotteryVo vo) {
        Integer siteId = vo.getSearch().getSiteId();
        if (siteId == null) {
            siteId = vo._getSiteId();
        }
        Map<String, Map<String, SiteLottery>> cacheMap = new LinkedHashMap<>();
        List<SiteLottery> list = mapper.search(Criteria.add(SiteLottery.PROP_SITE_ID, Operator.EQ, siteId), Order.asc(SiteLottery.PROP_ID));
        if (CollectionTool.isNotEmpty(list)) {
            cacheMap.put(siteId.toString(), CollectionTool.toEntityMap(list, SiteLottery.PROP_CODE, String.class));
        }
        return cacheMap;
    }

    @Override
    public void takeOff(SiteLotteryListVo siteLotteryListVo) {
        siteLotteryMapper.takeOff(siteLotteryListVo.getSearch());
    }


    /**
     * 保存彩票顺序
     *
     * @param
     * @author River
     */
    @Override
    public void saveSiteLotteryOrder(SiteLotteryVo siteLotteryVo) {
        GameManageOrderVo[] orderVos = siteLotteryVo.getOrderList();
        List<SiteLottery> list = new ArrayList<>();
        for (GameManageOrderVo orderVo : orderVos) {
            SiteLottery siteLottery = siteLotteryMapper.get(orderVo.getObjectId());
            if (siteLottery != null) {
                siteLottery.setOrderNum(orderVo.getOrder());
                list.add(siteLottery);
            }
        }
        if (list.size() > 0) {
            siteLotteryMapper.batchUpdateOnly(list, SiteLottery.PROP_ORDER_NUM);
        }
    }



    @Override
    public void takeOffAllByCode(SiteLotteryListVo siteLotteryListVo) {
        siteLotteryMapper.takeOffAllByCode(siteLotteryListVo.getSearch());
    }



    @Override
    public void sync(SiteLotteryListVo siteLotteryListVo) {
        siteLotteryMapper.sync(siteLotteryListVo.getSearch());
    }

    //endregion your codes 2

}