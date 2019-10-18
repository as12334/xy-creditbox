package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.model.sys.po.SysDatasource;
import org.soul.model.sys.vo.SysDatasourceListVo;
import org.soul.model.sys.vo.SysDatasourceVo;
import org.soul.service.support.BaseService;
import org.soul.service.sys.SysDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.data.manager.lottery.LotteryMapper;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryService;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.common.Sort;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.LotteryType;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryService extends BaseService<LotteryMapper, LotteryListVo, LotteryVo, Lottery, Integer> implements ILotteryService {

    @Autowired
    private SysDatasourceService sysDatasourceService;

//    @Override
//    public Map<String, List<Lottery>> load(LotteryVo vo) {
//        Map<String, List<Lottery>> result = new LinkedHashMap<>();
//        List<Lottery> list = mapper.allSearch(Order.asc(Lottery.PROP_SITE_ID), Order.asc(Lottery.PROP_ID));
//        if (CollectionTool.isNotEmpty(list)) {
//            for (Lottery lottery : list) {
//                List<Lottery> values = new ArrayList<>();
//                if (result.containsKey(Integer.toString(lottery.getSiteId()))) {
//                    values = result.get(Integer.toString(lottery.getSiteId()));
//                }
//                values.add(lottery);
//                result.put(String.valueOf(lottery.getSiteId()), values);
//            }
//        }
//        return result;
//    }

    @Override
    public Map<String, Map<String, Lottery>> load(LotteryVo vo) {
        Map<String, Map<String, Lottery>> cacheMap = new HashMap<>();
        List<Lottery> list = mapper.allSearch(Order.asc(Lottery.PROP_SITE_ID), Order.asc(Lottery.PROP_ID));
        if(CollectionTool.isNotEmpty(list)){
            for (Lottery lottery : list) {
                String cacheKey = CacheKey.getCacheKey(Integer.toString(lottery.getSiteId()));
                if (cacheMap.get(cacheKey) == null) {
                    cacheMap.put(cacheKey, new HashMap<>());
                }
                String valueKey = CacheKey.getCacheKey(lottery.getCode());
                cacheMap.get(cacheKey).put(valueKey, lottery);
            }
            return cacheMap;
        }
        return cacheMap;
    }


    @Override
    public LotteryVo saveLotteryOrder(LotteryVo lotteryVo) {
        lotteryVo.setSuccess(false);
        if (lotteryVo == null || lotteryVo.getOrderList() == null || lotteryVo.getSearch().getSiteId() == null) {
            lotteryVo.setErrMsg("保存失败,参数错误");
            return lotteryVo;
        }
        Sort[] orderVos = lotteryVo.getOrderList();
        List<Lottery> relationList = new ArrayList<>();
        for (Sort sort : orderVos) {
            Criteria criteria = new Criteria();
            criteria.addAnd(Lottery.PROP_ID, Operator.EQ,sort.getObjectId());
            criteria.addAnd(Lottery.PROP_SITE_ID,Operator.EQ,lotteryVo.getSearch().getSiteId());
            List<Lottery> lottery = this.mapper.search(criteria);
            if (lottery != null && lottery.size() == 1) {
                lottery.get(0).setOrderNum(sort.getOrder());
                relationList.add(lottery.get(0));
            }
        }
        if (relationList.size() > 0) {
            int updateOnly = this.mapper.batchUpdateOnly(relationList, Lottery.PROP_ORDER_NUM);
            if (updateOnly > 0) {
                lotteryVo.setSuccess(true);
                lotteryVo.setOkMsg("保存成功");
            }else {
                lotteryVo.setErrMsg("保存失败");
            }
        }
        return lotteryVo;
    }

    /**
     * 更改彩种玩法形式
     *
     * @param lotteryVo
     */
    @Override
    @Transactional
    public LotteryVo changeLotteryGenre(LotteryVo lotteryVo) {
        lotteryVo.setSuccess(false);
        if (lotteryVo.getResult() == null || lotteryVo.getResult().getId() == null ||
                lotteryVo.getResult().getSiteId() == null|| StringTool.isBlank(lotteryVo.getResult().getModel())) {
            lotteryVo.setErrMsg("保存失败，参数错误");
            return lotteryVo;
        }
        Criteria criteria = new Criteria();
        criteria.addAnd(Lottery.PROP_ID, Operator.EQ,lotteryVo.getResult().getId());
        criteria.addAnd(Lottery.PROP_SITE_ID,Operator.EQ,lotteryVo.getResult().getSiteId());
        boolean isSuccess = this.mapper.updateOnlyWhen(lotteryVo.getResult(),criteria, Lottery.PROP_MODEL);
        lotteryVo.setSuccess(isSuccess);
        return lotteryVo;
    }


    @Override
    public List<Lottery> queryLotteryCode(String lotteryCode) {
        if (lotteryCode == null) {
            throw new IllegalArgumentException("lotteryCode为空");
        }
        return this.mapper.queryLotteryCode(lotteryCode);
    }

    /**
     * 保存彩种
     *
     * @param objectVo
     */
    //endregion your codes 2
    @Override
    @Transactional
    public LotteryVo saveLottery(LotteryVo objectVo) {
        objectVo.setSuccess(false);
        if (objectVo.getResult().getId() == null || objectVo.getResult().getSiteId() == null ||
                (objectVo.getResult().getName() != null && objectVo.getResult().getName().length() > 7)){
            objectVo.setErrMsg("保存失败，参数错误");
            return objectVo;
        }
        LotteryVo lotteryVo = new LotteryVo();
        lotteryVo.getSearch().setId(objectVo.getResult().getId());
        lotteryVo.getSearch().setSiteId(objectVo.getResult().getSiteId());
        lotteryVo = this.get(lotteryVo);
        if (lotteryVo.getResult() == null || lotteryVo.getResult().getSiteId().intValue() != objectVo.getResult().getSiteId().intValue()){
            objectVo.setErrMsg("保存失败，彩种不存在");
            return objectVo;
        }
        lotteryVo.getResult().setName(objectVo.getResult().getName());
        lotteryVo.getResult().setMemo(objectVo.getResult().getMemo());
        lotteryVo.setProperties(Lottery.PROP_NAME, Lottery.PROP_MEMO );
        lotteryVo = this.updateOnly(lotteryVo);
        return lotteryVo;
    }

    /**
     * 更改彩种状态
     *
     * @param lotteryVo
     */
    @Override
    @Transactional
    public LotteryVo updateLotteryStatus (LotteryVo lotteryVo) {
        Criteria criteria = new Criteria();
        criteria.addAnd(Lottery.PROP_ID, Operator.EQ,lotteryVo.getResult().getId());
        criteria.addAnd(Lottery.PROP_SITE_ID,Operator.EQ,lotteryVo.getResult().getSiteId());
        boolean isSuccess = this.mapper.updateOnlyWhen(lotteryVo.getResult(),criteria, Lottery.PROP_STATUS);
        lotteryVo.setSuccess(isSuccess);
        return lotteryVo;
    }

    /**
     * 彩种同步
     *
     * @param lotteryListVo
     */
    @Override
    @Transactional
    public LotteryVo saveSync(LotteryListVo lotteryListVo, Map map) {
        LotteryVo resultVo = new LotteryVo();

        ArrayList lotteryList = lotteryListVo.getLottery();
        lotteryListVo.setPaging(null);
        if (lotteryList == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("同步失败");
            return resultVo;
        }
        for (int i = 0; i < lotteryList.size(); i++) {
            int lotteryId = Integer.parseInt(lotteryList.get(i) == null ? "" : lotteryList.get(i).toString());
            LotteryVo lottery = new LotteryVo();
            lottery.getSearch().setId(lotteryId);
            LotteryVo lotteryVo = this.search(lottery);
            List<SysDatasource> sysDatasourceList = new ArrayList<>();
            if (lotteryListVo.getSearch().getSiteId() != null && lotteryListVo.getSearch().getSiteId().intValue() != 0) {
                SysDatasourceVo sysDatasourceVo = new SysDatasourceVo();
                sysDatasourceVo.getSearch().setId(lotteryListVo.getSearch().getSiteId());
                SysDatasourceVo sysDatasource = sysDatasourceService.get(sysDatasourceVo);
                sysDatasourceList.add(sysDatasource.getResult());
            } else {
                sysDatasourceList = sysDatasourceService.allSearch(new SysDatasourceListVo());
            }
            for (SysDatasource sysDatasource : sysDatasourceList) {
                int siteId = sysDatasource.getId();
                if (siteId > 0) {
                    lotteryVo.getResult().setSiteId(siteId);
                    lotteryVo.getResult().setId(null);
                    LotteryListVo list = new LotteryListVo();
                    list.getSearch().setSiteId(lotteryVo.getResult().getSiteId());
                    list.getSearch().setCode(lotteryVo.getResult().getCode());
                    LotteryListVo searchLottery = this.search(list);
                    if (searchLottery.getResult().size() == 0) {
                        resultVo = this.insert(lotteryVo);
                    }
                }
            }
        }
        resultVo.setOkMsg("同步成功");
        return resultVo;
    }

    /**
     * 下架彩种
     *
     * @param lotteryListVo
     */
    @Override
    @Transactional
    public LotteryVo saveTakeOff(LotteryListVo lotteryListVo, Map map) {
        LotteryVo resultVo = new LotteryVo();
        resultVo.setSuccess(false);
        Boolean isSuccess = false;

        ArrayList lotteryList = lotteryListVo.getLottery();
        if (lotteryList == null) {
            resultVo.setErrMsg("请选择彩种！");
            return resultVo;
        }
        for (int i = 0; i < lotteryList.size(); i++) {
            LotteryVo lotteryVo = new LotteryVo();
            lotteryVo.getSearch().setId(Integer.parseInt(lotteryList.get(i).toString()));
            lotteryVo = this.search(lotteryVo);
            String code = lotteryVo.getResult().getCode();
            LotteryListVo listVo = new LotteryListVo();
            listVo.getSearch().setCode(code);
            if (lotteryListVo.getSearch().getSiteId() != null && lotteryListVo.getSearch().getSiteId() != 0) {
                listVo.getSearch().setSiteId(lotteryListVo.getSearch().getSiteId());
            }
            LotteryListVo list = this.search(listVo);
            for (int f = 0; f < list.getResult().size(); f++) {
                Lottery lottery = list.getResult().get(f);
                LotteryVo lotteryVo2 = new LotteryVo();
                lotteryVo2.getSearch().setId(lottery.getId());
                LotteryVo lottery3 = this.search(lotteryVo2);
                int site_id = lottery3.getResult().getSiteId();
                if (site_id > 0) {
                    isSuccess = this.delete(lottery3);
                } else if (site_id == 0) {
                    isSuccess = true;
                }
            }
        }
        if (isSuccess) {
            resultVo.setSuccess(true);
            resultVo.setOkMsg("下架成功");
        }
        return resultVo;
    }

    @Override
    public List<LotteryType> queryLotteryTypeBySiteId(LotteryVo vo) {
        return mapper.queryLotteryTypeBySiteId(vo.getSearch());
    }

    @Override
    public List<LotteryType> queryOwnLotteryTypeBySiteId(LotteryListVo listVo) {
        return mapper.queryOwnLotteryTypeBySiteId(listVo);
    }

    @Override
    public List<Lottery> queryLotteryBySiteIdType(Integer siteId, String type) {
        List<Lottery> list = CacheBase.getLotteryListByType(siteId,type);
        return list;
    }

    @Override
    public List<Lottery> queryLotteryBySiteId(Integer siteId) {
        return mapper.queryListBySiteId(siteId);
    }

}