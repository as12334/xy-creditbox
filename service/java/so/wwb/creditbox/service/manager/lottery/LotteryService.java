package so.wwb.creditbox.service.manager.lottery;


import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.data.manager.lottery.LotteryMapper;
import so.wwb.creditbox.data.company.lottery.SiteLotteryMapper;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryService;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.vo.GameManageOrderVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryVo;

import java.util.ArrayList;
import java.util.List;

public class LotteryService extends BaseService<LotteryMapper, LotteryListVo, LotteryVo, Lottery, Integer> implements ILotteryService {



    //region your codes 2

    @Autowired
    private SiteLotteryMapper siteLotteryMapper;


    @Override
    @Transactional
    public void changeLotteryGenre(LotteryVo lotteryVo) {
        updateOnly(lotteryVo);
        Lottery lottery = new Lottery();
        lottery.setGenre(lotteryVo.getResult().getGenre());
        lottery.setCode(lotteryVo.getResult().getCode());
        siteLotteryMapper.changeAllSiteGenre(lottery);
    }


    /**
     * 保存彩票顺序
     *
     * @param
     * @author River
     */
    @Override
    @Transactional
    public void saveLotteryOrder(LotteryVo lotteryVo) {
        if (lotteryVo == null || lotteryVo.getOrderList() == null) {
            return;
        }
        GameManageOrderVo[] orderVos = lotteryVo.getOrderList();
        List<Lottery> relationList = new ArrayList<Lottery>();
        List<SiteLottery> siteList = new ArrayList<SiteLottery>();
        for (GameManageOrderVo orderVo : orderVos) {
            Lottery lottery = mapper.get(orderVo.getObjectId());

            if (lottery != null) {
                lottery.setOrderNum(orderVo.getOrder());
                relationList.add(lottery);
                SiteLottery siteLottery = new SiteLottery();
                siteLottery.setOrderNum(orderVo.getOrder());
                siteLottery.setCode(lottery.getCode());
                siteList.add(siteLottery);
            }
        }
        if (relationList.size() > 0) {
            mapper.batchUpdateOnly(relationList, Lottery.PROP_ORDER_NUM);
            siteLotteryMapper.updateAllSiteOrderNum(siteList);
        }
    }
    //endregion your codes 2

}