package so.wwb.creditbox.service.company.lottery;

import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.data.manager.lottery.SiteLotteryMapper;
import so.wwb.creditbox.iservice.company.lottery.ISiteLotteryService;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.vo.GameManageOrderVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryVo;

import java.util.ArrayList;
import java.util.List;


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