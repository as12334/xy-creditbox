package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.data.manager.lottery.SiteLotteryMapper;
import so.wwb.creditbox.data.manager.lottery.SiteLotteryOddsMapper;
import so.wwb.creditbox.iservice.manager.lottery.ISiteLotteryOddsService;
import so.wwb.creditbox.model.enums.lottery.LotteryStatusEnum;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.SiteLottery;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsVo;

import java.util.List;


/**
 * 服务
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public class SiteLotteryOddsService extends BaseService<SiteLotteryOddsMapper, SiteLotteryOddsListVo, SiteLotteryOddsVo, SiteLotteryOdds, Integer> implements ISiteLotteryOddsService {

//endregion your codes 1

    //region your codes 2

    @Autowired
    private SiteLotteryMapper siteLotteryMapper;

    @Override
    public SiteLotteryOddsVo initData(SiteLotteryOddsVo vo) {
        List<SiteLottery> search = siteLotteryMapper.search(Criteria.add(SiteLottery.PROP_SITE_ID, Operator.EQ, vo.getSearch().getSiteId())
                .addAnd(SiteLottery.PROP_CODE, Operator.EQ, vo.getSearch().getCode())
                .addAnd(SiteLottery.PROP_STATUS, Operator.EQ, LotteryStatusEnum.NORMAL.getCode()));
        vo.setSiteLotteryList(search);
        return vo;
    }
    //endregion your codes 2

}