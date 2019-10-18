package so.wwb.creditbox.service.manager.lottery;

import com.google.gson.Gson;
import org.apache.commons.collections.map.HashedMap;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.math.NumberTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Order;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;
import org.soul.model.comet.vo.MessageVo;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.data.manager.lottery.LotteryResultMapper;
import so.wwb.creditbox.iservice.common.IMessageService;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryErrorLogService;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryGatherHandle;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.creditbox.iservice.manager.sys.ISysSiteService;
import so.wwb.creditbox.iservice.company.lottery.ILotteryResultNumberService;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.common.Const;
import so.wwb.creditbox.model.enums.lottery.*;
import so.wwb.creditbox.model.enums.notice.CometSubscribeType;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.*;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultSo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryErrorLogVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.model.company.lottery.so.LotteryResultNumberSo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultNumberVo;
import so.wwb.creditbox.service.manager.lottery.gather.LotteryGatherHandleFactory;
import so.wwb.creditbox.service.manager.lottery.task.*;
import so.wwb.creditbox.utility.CacheHashTool;
import so.wwb.creditbox.utility.LotteryResultNumberUtility;
import so.wwb.creditbox.utility.NnResultFormatTool;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class LotteryResultService extends BaseService<LotteryResultMapper, LotteryResultListVo, LotteryResultVo, LotteryResult, Integer> implements ILotteryResultService {

    private Log LOG = LogFactory.getLog(LotteryResultService.class);

    //东八区
    private static int GTM8 = 8;

    // 操作线程池
    @Autowired
    private ExecutorService operateExecutor;

    // 游戏线程池
    @Autowired
    private ExecutorService lotteryExecutor;

    @Autowired
    private ILotteryErrorLogService errLogService;

    @Autowired
    private ILotteryResultNumberService lotteryResultNumberService;

    @Autowired
    private ISysSiteService sysSiteService;

    @Autowired
    private IMessageService messageService;//消息推送


    @Override
    public Map<String, Map<String, LotteryResult>> load(LotteryResultVo vo) {
        Map<String, Map<String, LotteryResult>> result = new LinkedHashMap<>();
        Map<String, LotteryResult> resultMap = new LinkedHashMap<>();
        LotteryResultSo resultSo = vo.getSearch();
        List<LotteryResult> list = mapper.findRecentLotteryResult(resultSo);
        if (CollectionTool.isNotEmpty(list)) {
            resultMap = CollectionTool.toEntityMap(list, LotteryResult.PROP_EXPECT,String.class);
            if(MapTool.isNotEmpty(resultMap)){
                if (result.get(vo.getSearch().getCode()) == null) {
                    result.put(vo.getSearch().getCode(), new LinkedHashMap<>());
                    result.get(vo.getSearch().getCode()).putAll(resultMap);
                }
            }
        }
        return result;
    }

    /**
     * 根据彩种与期数列表获取开奖结果
     * @param resultListVo
     * @return
     */
    @Override
    public LotteryResultListVo searchByExpects(LotteryResultListVo resultListVo) {
        Criteria criteria = Criteria.add(LotteryResult.PROP_CODE, Operator.EQ, resultListVo.getSearch().getCode());
        criteria.addAnd(LotteryResult.PROP_EXPECT, Operator.IN, resultListVo.getSearch().getExpects());
        resultListVo.getQuery().addOrder(LotteryResult.PROP_ID, Direction.DESC);
        return this.search(criteria,resultListVo,this.mapper);
    }

    /**
     * 初始化开奖结果
     */
    @Override
    @Transactional
    public LotteryResultVo initLotteryResult(LotteryResultVo resultVo) {
        resultVo = beforeInitLotteryResult(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        resultVo = excuteInitLotteryResult(resultVo);
        if (!resultVo.isSuccess()) {
            return resultVo;
        }
        LotteryResultNumberVo resultNumberVo = new LotteryResultNumberVo();
        resultNumberVo.getSearch().setInitDate(resultVo.getSearch().getInitDate());
        resultNumberVo.getSearch().setCodes(resultVo.getSearch().getCodes());
        resultVo = initSiteLotteryResult(resultVo, resultNumberVo);
        if (!resultVo.isSuccess()) {
            return resultVo;
        }
        //自动初始化再初始化1天数据
        if(LotteryResultVo.OPERATE_TYPE_AUTO.equals(resultVo.getOperateType())){
            resultVo.getSearch().setInitDate(DateTool.addDays(resultVo.getSearch().getInitDate(),1));
            resultVo = excuteInitLotteryResult(resultVo);
            if (!resultVo.isSuccess()) {
                return resultVo;
            }
            resultNumberVo.getSearch().setInitDate(resultVo.getSearch().getInitDate());
            resultNumberVo.getSearch().setCodes(resultVo.getSearch().getCodes());
            resultVo = initSiteLotteryResult(resultVo, resultNumberVo);
            if (!resultVo.isSuccess()) {
                return resultVo;
            }
        }
        return resultVo;
    }

    public LotteryResultVo initSiteLotteryResult(LotteryResultVo resultVo, LotteryResultNumberVo resultNumberVo) {
        Map<String, List<Lottery>> merchantLotteryMap = CacheBase.getMerchantLotteryMap();
        List<String> siteIds = new ArrayList<>();
        siteIds.addAll(merchantLotteryMap.keySet());
        if(MapTool.isNotEmpty(merchantLotteryMap) && CollectionTool.isNotEmpty(siteIds)){
            List<Future<LotteryResultNumberVo>> futures = new ArrayList<>();
            for(String siteId : siteIds){
                Future<LotteryResultNumberVo> initTask = addInitTask(resultNumberVo, siteId);
                if(initTask != null){
                    futures.add(initTask);
                }
            }
            LotteryResultVo result = validateResultList(futures,"商户:{0}彩票初始化开奖结果失败,原因:{1}", resultVo.getOperateType());
            resultVo.setSuccess(result.isSuccess());
            resultVo.setErrMsg(result.getErrMsg());
        }
        return resultVo;
    }


//    //修改初始化方式,保留原有方法 2018-09-10
//    /**
//     * 初始化开奖结果
//     */
//    @Override
//    @Transactional
//    public LotteryResultVo initLotteryResult(LotteryResultVo resultVo) {
//        LotteryResultListVo listVo = new LotteryResultListVo();
//        resultVo = beforeInitLotteryResult(resultVo);
//        if(!resultVo.isSuccess()){
//            return resultVo;
//        }
//        resultVo = excuteInitLotteryResult(resultVo);
//        if (!resultVo.isSuccess()) {
//            return resultVo;
//        }
//        listVo.getSearch().setCodes(resultVo.getSearch().getCodes());
//        listVo.getSearch().setQueryStartDate(resultVo.getSearch().getInitDate());
//        //自动初始化再初始化1天数据
//        if(LotteryResultVo.OPERATE_TYPE_AUTO.equals(resultVo.getOperateType())){
//            resultVo.getSearch().setInitDate(DateTool.addDays(resultVo.getSearch().getInitDate(),1));
//            resultVo = excuteInitLotteryResult(resultVo);
//            if (!resultVo.isSuccess()) {
//                return resultVo;
//            }
//        }
//        listVo.getSearch().setQueryEndDate(resultVo.getSearch().getInitDate());
//
//        if (listVo.getSearch().getCodes().contains("hklhc")) {
//            listVo.getSearch().getCodes().remove("hklhc");
//            listVo.setResult(mapper.queryHklhcResult(listVo.getSearch()));
//        }
//
//        listVo.getQuery().addOrder(LotteryResult.PROP_CODE, Direction.ASC);
//        listVo.getResult().addAll(this.mapper.search(listVo.getQuery().queryAscriptionTimeCriteria(), listVo.getQuery().getOrders()));
//
//        listVo = beforeInitLotteryResult(listVo);
//        if(!listVo.isSuccess()){
//            resultVo.setSuccess(listVo.isSuccess());
//            resultVo.setErrMsg(listVo.getErrMsg());
//            return resultVo;
//        }
//        List<LotteryResultNumber> list = new ArrayList<>();
//        listVo.getResult().forEach(obj->{
//            list.add(LotteryResultNumberUtility.createByLotteryResult(obj));
//        });
//        Map<String, List<Lottery>> merchantLotteryMap = CacheBase.getMerchantLotteryMap();
//        List<String> siteIds = new ArrayList<>();
//        siteIds.addAll(merchantLotteryMap.keySet());
//        if(MapTool.isNotEmpty(merchantLotteryMap) && CollectionTool.isNotEmpty(siteIds)){
//            List<Future<LotteryResultNumberVo>> futures = new ArrayList<>();
//            for(String siteId : siteIds){
//                Future<LotteryResultNumberVo> initTask = addInitTask(list, listVo, siteId);
//                if(initTask != null){
//                    futures.add(initTask);
//                }
//            }
//            LotteryResultVo result = validateResultList(futures,"商户:{0}彩票初始化开奖结果失败,原因:{1}", resultVo.getOperateType());
//            listVo.setSuccess(result.isSuccess());
//            listVo.setErrMsg(result.getErrMsg());
//        }
//
//        if (!listVo.isSuccess()) {
//            resultVo.setSuccess(listVo.isSuccess());
//            LOG.error("商户初始化开奖结果失败,原因:{1}",resultVo.getErrMsg());
//            resultVo.setErrMsg("商户初始化开奖结果失败!,详情请查看失败日志!");
//        }
//
//        return resultVo;
//    }

    /**
     * 初始化开奖结果前置处理
     */
    private LotteryResultVo beforeInitLotteryResult(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || resultVo.getSearch().getInitDate() == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("初始化开奖结果失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        Date initDate = DateTool.addHours(resultVo.getSearch().getInitDate(),GTM8);
        if(initDate == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("初始化日期格式错误!");
            LOG.error("初始化开奖结果失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        resultVo.getSearch().setInitDate(initDate);
        List<String> codes = resultVo.getSearch().getCodes();
        if(CollectionTool.isEmpty(codes)){
            Map<String, Lottery> map = CacheBase.getLotteryMap(Const.BOSS_DATASOURCE_ID);
            if(LotteryResultVo.OPERATE_TYPE_AUTO.equals(resultVo.getOperateType())){
                codes = new ArrayList<>();
                for (Lottery lottery : map.values()) {
                    if(lottery != null && !LotteryStatusEnum.CLOSE.getCode().equals(lottery.getCode())){
                        codes.add(lottery.getCode());
                    }
                }
            }else if(LotteryResultVo.OPERATE_TYPE_MANUAL.equals(resultVo.getOperateType())){
                codes = CollectionTool.extractToList(map.values(), Lottery.PROP_CODE);
            }
        }
        if(CollectionTool.isEmpty(codes)){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少彩种数据!");
            LOG.error("初始化开奖结果失败,原因:{0}", "缺少主彩种缓存数据");
            return resultVo;
        }
        resultVo.getSearch().setCodes(codes);
        return resultVo;
    }

    /**
     * 调用函数初始化开奖结果
     */
    public LotteryResultVo excuteInitLotteryResult(LotteryResultVo resultVo) {
        Date initDate = resultVo.getSearch().getInitDate();
        String codesStr = StringTool.join(resultVo.getSearch().getCodes(),",");
        Map map = new HashMap();
        map.put("initDate", initDate);
        map.put("codesStr", codesStr);
        String result = mapper.doInitLotteryResult(map);
        if(!"success".equals(result)){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("初始化开奖结果失败");
            LOG.error("调用初始化开奖结果函数失败,原因:{0},返回结果:{1}",resultVo.getErrMsg(),result);
        } else {
            LOG.info("调用初始化开奖结果函数成功,执行结果:{0}", result);
        }
        return resultVo;
    }

    /**
     * 初始化开奖结果前置处理
     */
    private LotteryResultListVo beforeInitLotteryResult(LotteryResultListVo listVo){
        if(CollectionTool.isEmpty(listVo.getResult())) {
            listVo.setSuccess(false);
            listVo.setErrMsg("未存在该时间段内的开奖结果");
            LOG.error("同步初始化开奖结果前置校验未通过,原因:{0}", listVo.getErrMsg());
            return listVo;
        }
        if(CacheHashTool.checkCacheHash("lotteryResultSync")){
            listVo.setSuccess(false);
            listVo.setErrMsg("30S内不可重复操作");
            LOG.error("同步初始化开奖结果前置校验未通过,原因:{0}",listVo.getErrMsg());
            return listVo;
        }
        return listVo;
    }

    /**
     * 同步开奖结果
     */
    @Override
    public LotteryResultListVo doSync(LotteryResultListVo resultVo) {
        resultVo = beforeSync(resultVo);
        if (!resultVo.isSuccess()) {
            return resultVo;
        }
        LotteryResultNumberVo numberVo = new LotteryResultNumberVo();
        numberVo.setEntities(mapper.querySyncLotteryResult(resultVo.getSearch()));
        if(CollectionTool.isEmpty(numberVo.getEntities())) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("未存在已开奖的开奖结果");
            LOG.error("同步开奖结果前置校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
//        Map<String, List<Lottery>> merchantLotteryMap = CacheBase.getMerchantLotteryMap();
//        List<Lottery> lotteries = merchantLotteryMap.get(resultVo.getSearch().getSiteId().toString());
        List<Lottery> lotteries = CacheBase.getLotteryList(resultVo.getSearch().getSiteId());
        if (CollectionTool.isNotEmpty(lotteries)) {
            numberVo._setSiteId(resultVo.getSearch().getSiteId());
            DataContext.setDataSource(DatasourceTool.getDruidDatasource(resultVo.getSearch().getSiteId()));
            resultVo.setSuccess(lotteryResultNumberService.batchInsertNotExist(numberVo) >= 0);
            if (!resultVo.isSuccess()) {
                resultVo.setErrMsg("同步开奖结果失败!");
                LOG.error("同步开奖结果失败,原因:{1}",resultVo.getErrMsg());
            }
        }
        return resultVo;
    }

    /**
     * 添加初始化任务
     */
    private Future<LotteryResultNumberVo> addInitTask(LotteryResultNumberVo resultNumberVo, String siteId) {
        LotteryResultInitTask task = SpringTool.getBean(LotteryResultInitTask.class);
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setSearch(resultNumberVo.getSearch());
        targetVo._setSiteId(Integer.parseInt(siteId));
        task.setNumberVo(targetVo);
        return operateExecutor.submit(task);
    }

//    //修改初始化方式,保留原有方法 2018-09-10
//    /**
//     * 添加初始化任务
//     */
//    private Future<LotteryResultNumberVo> addInitTask(List<LotteryResultNumber> list, LotteryResultListVo listVo, String siteId) {
//        LotteryResultInitTask task = SpringTool.getBean(LotteryResultInitTask.class);
//        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
//        targetVo.setOperationType(LotteryOperationEnum.INIT.getCode());
//        targetVo.setSearch(new LotteryResultNumberSo());
//        targetVo.getSearch().setCodes(listVo.getSearch().getCodes());
//        targetVo.getSearch().setQueryStartDate(listVo.getSearch().getQueryStartDate());
//        targetVo.getSearch().setQueryEndDate(listVo.getSearch().getQueryEndDate());
//        targetVo.setEntities(list);
//        targetVo._setSiteId(Integer.parseInt(siteId));
//        task.setNumberVo(targetVo);
//        return operateExecutor.submit(task);
//    }

    /**
     * 同步开奖结果前置处理
     */
    private LotteryResultListVo beforeSync(LotteryResultListVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || resultVo.getSearch().getSiteId() == null || CollectionTool.isEmpty(resultVo.getSearch().getCodes())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("同步开奖结果前置校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        return resultVo;
    }

    /**
     * 根据彩种返回当前时间之前已经开奖的盘口
     */
    @Override
    public LotteryResult getCurOpenLotteryResult(String code) {
        Map<String, LotteryResult> map = this.getCurOpenLotteryResultMap();
        if(MapTool.isEmpty(map) || !map.containsKey(code) || map.get(code) == null){
            LOG.error("缺少彩种:{0}的已经开奖的LotteryResult的缓存数据！",code);
            return null;
        }
        return map.get(code);
    }

    /**
     * 返回当前时间之前已经开奖的所有彩种盘口
     */
    @Override
    public Map<String, LotteryResult> getCurOpenLotteryResultMap() {
        Map<String, Serializable> map = CacheBase.getLotteryResult();
        if(MapTool.isEmpty(map)){
            return new HashMap<>(0);
        }
        Map<String, LotteryResult> result = new HashMap<>();
        Date curDate = new Date();
        Long curTime = curDate.getTime();
        for (String key : map.keySet()) {
            if(map.get(key) != null && CollectionTool.isNotEmpty((List)map.get(key))){
                List<LotteryResult> list = (List<LotteryResult>)map.get(key);
                for (int i = list.size()-1; i >= 0 ; i--) {
                    LotteryResult value = list.get(i);
                    if(curTime >= value.getOpenTime().getTime()){
                        result.put(key,value);
                        break;
                    }
                }
            }
        }
        if(MapTool.isEmpty(result)){
            LOG.error("缺少当前时间:{0},已经开奖的LotteryResult的缓存数据！", DateTool.formatDate(curDate,DateTool.yyyy_MM_dd_HH_mm_ss));
        }
        return result;
    }

    /**
     * 返回当前时间即将封盘的所有彩种盘口
     */
    @Override
    public Map<String, Map<String,Object>> getCurClosingLotteryResultMap(List<Lottery> lotteryList) {

        Map<String, Map<String,Object>> result = new HashMap<>();
        for (Lottery lottery:lotteryList) {
            long time = new Date().getTime();
            LotteryResult lotteryResult = getCurClosingLotteryResult(lottery.getCode());
            Map <String,Object> map = new HashMap<>();
            map.put("code",lottery.getCode());
            map.put("type",lottery.getType());
            map.put("expect",lotteryResult.getExpect());
            map.put("model",lottery.getModel());
            if(lotteryResult.getCloseTime()!=null){
                map.put("leftTime",(lotteryResult.getCloseTime().getTime() - time)/1000);
            }else{
                map.put("leftTime",null);
            }
            if(lotteryResult.getOpenTime()!=null){
                map.put("leftOpenTime",(lotteryResult.getOpeningTime().getTime() - time)/1000);
            }else{
                map.put("leftOpenTime",null);
            }
            map.put("frequency",lottery.getFrequency());
            map.put("lotteryName",lottery.getName());
            result.put(lottery.getCode(),map);
        }
        return result;
    }

    /**
     * 根据彩种返回当前时间即将封盘的盘口
     */
    @Override
    public LotteryResult getCurClosingLotteryResult(String code) {
        LotteryResult lotteryResult = initClosingLottery(code);
        if(lotteryResult == null){
            LOG.error("缺少彩种:{0}的最新即将封盘的LotteryResult的缓存数据！",code);
        }
        return lotteryResult;
    }

    private LotteryResult initClosingLottery (String code) {
        List<LotteryResult> list = CacheBase.getLotteryResult(code);
        LotteryResult lotteryResult = new LotteryResult();
        Date curDate = new Date();
        Long curTime = curDate.getTime();
        for (int i = 0; i < list.size() ; i++) {
            LotteryResult value = list.get(i);
            if(curTime < value.getCloseTime().getTime()){
                lotteryResult = list.get(i);
                break;
            }
        }
        return lotteryResult;
    }



    /**
     * 返回当前时间已经封盘的所有彩种盘口
     */
    @Override
    public Map<String, LotteryResult> getCurClosedLotteryResultMap() {
        Map<String, Serializable> map = CacheBase.getLotteryResult();
        if(MapTool.isEmpty(map)){
            return new HashMap<>(0);
        }
        Map<String, LotteryResult> result = new HashMap<>();
        Date curDate = new Date();
        Long curTime = curDate.getTime();
        for (String key : map.keySet()) {
            if(map.get(key) != null && CollectionTool.isNotEmpty((List)map.get(key))){
                List<LotteryResult> list = (List<LotteryResult>)map.get(key);
                for (int i = list.size()-1; i >= 0 ; i--) {
                    LotteryResult value = list.get(i);
                    if(curTime >= value.getCloseTime().getTime()){
                        result.put(key,value);
                        break;
                    }
                }
            }
        }
        if(MapTool.isEmpty(result)){
            LOG.error("缺少当前时间:{0},最新已经封盘的LotteryResult的缓存数据！", DateTool.formatDate(curDate,DateTool.yyyy_MM_dd_HH_mm_ss));
        }
        return result;
    }

    /**
     * 根据彩种返回当前时间已经封盘的盘口
     */
    @Override
    public LotteryResult getCurClosedLotteryResult(String code){
        List<LotteryResult> list = CacheBase.getLotteryResult(code);
        LotteryResult lotteryResult = new LotteryResult();
        Date curDate = new Date();
        Long curTime = curDate.getTime();
        for (int i = list.size()-1; i >= 0 ; i--) {
            LotteryResult value = list.get(i);
            if(curTime >= value.getCloseTime().getTime()){
                lotteryResult = value;
                break;
            }
        }
        if(lotteryResult == null){
            LOG.error("缺少当前时间:{0},最新已经封盘的LotteryResult的缓存数据！", DateTool.formatDate(curDate,DateTool.yyyy_MM_dd_HH_mm_ss));
        }
        return lotteryResult;
    }

    /**
     * 返回当前时间即将开奖的所有彩种盘口
     */
    @Override
    public Map<String, LotteryResult> getCurLotteryResultMap() {
        Map<String, Serializable> map = CacheBase.getLotteryResult();
        if(MapTool.isEmpty(map)){
            return new HashMap<>(0);
        }
        Map<String, LotteryResult> result = new HashMap<>();
        Date curDate = new Date();
        Long curTime = curDate.getTime();
        for (String key : map.keySet()) {
            if(map.get(key) != null && CollectionTool.isNotEmpty((List)map.get(key))){
                List<LotteryResult> list = (List<LotteryResult>)map.get(key);
                for (int i = 0; i < list.size() ; i++) {
                    LotteryResult value = list.get(i);
                    if(curTime > value.getCloseTime().getTime() && curTime < value.getOpenTime().getTime()){
                        result.put(key,value);
                        break;
                    }
                }
            }
        }
        if(MapTool.isEmpty(result)){
            LOG.error("缺少当前时间:{0},最新的即将开奖的LotteryResult的缓存数据！", DateTool.formatDate(curDate,DateTool.yyyy_MM_dd_HH_mm_ss));
        }
        return result;
    }


    /**
     * 根据彩种返回当前时间即将开奖的彩种盘口
     */
    @Override
    public LotteryResult getCurLotteryResult(String code) {
        Map<String, LotteryResult> map = this.getCurLotteryResultMap();
        if(MapTool.isEmpty(map) || !map.containsKey(code) || map.get(code) == null){
            LOG.error("缺少彩种:{0}最新的即将开奖的LotteryResult的缓存数据！",code);
            return null;
        }
        return map.get(code);
    }


    /**
     * 返回当前时间即将开奖的彩种盘口
     */
    @Override
    public LotteryResultListVo curLotteryResult(LotteryResultListVo resultListVo) {
        resultListVo.setResult( this.mapper.searchCurLotteryResult());
        return resultListVo;
    }

    /**
     * 返回当前时间即将开奖的彩种盘口
     */
    @Override
    public LotteryResultListVo curLotteryResultByCode(LotteryResultSo lotteryResultSo) {
        LotteryResultListVo listVo = new LotteryResultListVo();
        List<String> codeList = lotteryResultSo.getCodes();
        if(codeList !=null){
            for (String code:codeList) {
                lotteryResultSo.setCode(code);
                listVo.getResult().addAll(this.mapper.searchCurLotteryResultByCode(lotteryResultSo));
            }
        }
        return listVo;
    }

    /**
     * 官方彩派彩
     */
    @Override
    public LotteryResultVo officePayout(LotteryResultVo resultVo){
        resultVo = beforeOfficePayout(resultVo);

        if(!resultVo.isSuccess()){
            payOutError(resultVo);
            return resultVo;
        }
        if (validLotteryResult(resultVo)) {
            return resultVo;
        }
        List<Future<LotteryResultNumberVo>> resultVoList = new ArrayList<>();
        List<Lottery> list = getMerchantOfficialLotteryList(resultVo);

        if(CollectionTool.isEmpty(list)) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("暂无商户官方彩种数据");
            LOG.error("官方彩票派彩失败:站点id:{0},code:{1},expect:{2},openCode:{3},原因:{4}",resultVo.getSearch().getSiteId(),
                    resultVo.getResult().getCode(), resultVo.getResult().getExpect(), resultVo.getResult().getOpenCode(),resultVo.getErrMsg());
            return resultVo;
        }
        for(Lottery lottery : list){
            if(lottery != null){
                LotteryResultVo result = checkUnifyPayout(resultVo,lottery);
                LOG.info("官方彩开发派彩,站点id:{0},code:{1},expect:{2}",lottery.getSiteId(),lottery.getCode(),resultVo.getResult().getExpect());
                if(result.isSuccess()){
                    resultVoList.add(addOfficialPayoutTask(resultVo,lottery.getSiteId()));
                }
            }
        }
        LotteryResultVo result = validateResultList(resultVoList,"商户:{0}彩票派彩失败,原因:{1}", resultVo.getOperateType());
        resultVo.setSuccess(result.isSuccess());
        resultVo.setErrMsg(result.getErrMsg());
        if(!result.isSuccess()){
            LOG.error("官方彩票派彩失败,code:{0},expect:{1},openCode:{2},原因:{3}",
                    resultVo.getResult().getCode(), resultVo.getResult().getExpect(), resultVo.getResult().getOpenCode(),resultVo.getErrMsg());
            resultVo.setErrMsg("派彩失败!,详情请查看失败日志!");
        }

        return resultVo;
    }

    public boolean validLotteryResult(LotteryResultVo resultVo) {
        LOG.info("彩票开奖信息:{0}", JsonTool.toJson(resultVo));
        if (resultVo.getResult() == null || StringTool.isBlank(resultVo.getResult().getExpect())
                || StringTool.isBlank(resultVo.getResult().getCode())
                || StringTool.isBlank(resultVo.getResult().getOpenCode())
                || StringTool.isBlank(resultVo.getResult().getType())
                || resultVo.getResult().getOpenTime() == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖信息不全");
            LOG.info("彩票开奖信息:{0}", JsonTool.toJson(resultVo));
            return true;
        }
        if(resultVo.getResult().getOpenTime().getTime()> System.currentTimeMillis()){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("未到开奖时间！");
            LOG.info("未到开奖时间！");
            return true;
        }
        String openCode = resultVo.getResult().getOpenCode();
        String[] numbers = openCode.split(",");
        int num = numbers.length;
        String code = resultVo.getResult().getCode();
        String type = resultVo.getResult().getType();
        if (StringTool.equals(type, LotteryTypeEnum.SSC.getCode()) && num != 5) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(type, LotteryTypeEnum.K3.getCode()) && num != 3) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(type, LotteryTypeEnum.SFC.getCode()) && num != 8) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(type, LotteryTypeEnum.KENO.getCode()) && num != 20) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(type, LotteryTypeEnum.XY28.getCode()) && num != 3) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(type, LotteryTypeEnum.PL3.getCode()) && num != 3) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(type, LotteryTypeEnum.LHC.getCode()) && num != 7) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if ((StringTool.equals(type, LotteryTypeEnum.PK10.getCode()) ||
                StringTool.equals(type, LotteryTypeEnum.BJL.getCode()) ||
                StringTool.equals(type, LotteryTypeEnum.NN.getCode())) &&
                num != 10) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(type, LotteryTypeEnum.SYX5.getCode()) && num != 5) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        }

        if (StringTool.equals(type, LotteryTypeEnum.LHC.getCode()) ||
                StringTool.equals(type, LotteryTypeEnum.SFC.getCode()) ||
                StringTool.equals(type, LotteryTypeEnum.SYX5.getCode()) ||
                StringTool.equals(type, LotteryTypeEnum.PK10.getCode()) ||
                StringTool.equals(type, LotteryTypeEnum.BJL.getCode()) ||
                StringTool.equals(type, LotteryTypeEnum.NN.getCode()) ||
                StringTool.equals(type, LotteryTypeEnum.KENO.getCode())) {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (StringTool.equals(numbers[i], numbers[j])) {
                        resultVo.setSuccess(false);
                        resultVo.setErrMsg("开奖号码不能相同");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 自主彩彩派彩
     */
    @Override
    public LotteryResultVo ownPayout(LotteryResultVo resultVo){
        resultVo = beforeOwnPayout(resultVo);
        if(!resultVo.isSuccess()){
            payOutError(resultVo);
            return resultVo;
        }
        List<Future<LotteryResultNumberVo>> resultVoList = new ArrayList<>();
        List<Lottery> list = getMerchantOfficialLotteryList(resultVo);
        if(CollectionTool.isEmpty(list)) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("暂无商户自主彩种数据");
            LOG.error("自主彩票派彩失败,code:{0},expect:{1},原因:{2}",
                    resultVo.getResult().getCode(), resultVo.getResult().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        for(Lottery lottery : list){
            if(lottery != null){
                LotteryResultVo result = checkUnifyPayout(resultVo,lottery);
                if(result.isSuccess()){
                    resultVoList.add(addOwnPayoutTask(resultVo,lottery.getSiteId()));
                }
            }
        }
        LotteryResultVo result = validateResultList(resultVoList,"商户:{0}彩票派彩失败,原因:{1}", resultVo.getOperateType());
        resultVo.setSuccess(result.isSuccess());
        resultVo.setErrMsg(result.getErrMsg());
        if(!result.isSuccess()){
            LOG.error("自主彩票派彩失败,code:{0},expect:{1},原因:{3}",
                    resultVo.getResult().getCode(), resultVo.getResult().getExpect(),resultVo.getErrMsg());
            resultVo.setSuccess(false);
            resultVo.setErrMsg("派彩失败!,详情请查看失败日志!");
        }

        return resultVo;
    }


    private void payOutError (LotteryResultVo resultVo) {
        LotteryErrorLogVo errorLogVo = new LotteryErrorLogVo();
        errorLogVo.setResult(new LotteryErrorLog());

        List<Map<String, String>> opnList = new ArrayList<Map<String, String>>();
        Map<String, String> opnMap = new HashedMap();
        opnMap.put("code", resultVo.getResult().getCode());
        opnMap.put("expect", resultVo.getResult().getExpect());
        opnMap.put("open_code", resultVo.getResult().getOpenCode());
        opnList.add(opnMap);
        errorLogVo.getResult().setOperationMsgJson(new Gson().toJson(opnList));

        List<Map<String, String>> errgList = new ArrayList<Map<String, String>>();
        Map<String, String> errMap = new HashedMap();
        errMap.put("errMsg", resultVo.getErrMsg());
        errgList.add(errMap);
        errorLogVo.getResult().setErrMsgJson(new Gson().toJson(errgList));

        errorLogVo.getResult().setOperationType(LotteryOperationEnum.PAYOUT.getCode());
        errorLogVo.getResult().setCreateTime(new Date());
        errLogService.insert(errorLogVo);
        LotteryErrorLog errorLog =  errorLogVo.getResult();
        if (LotteryResultVo.OPERATE_TYPE_AUTO.equals(resultVo.getOperateType())) {
            sendBossMessage(getLotteryErrorMsgBody(EnumTool.enumOf(LotteryOperationEnum.class, errorLog.getOperationType()).getTrans(),
                    opnList.isEmpty()?"":opnList.get(0).containsKey("code")?opnList.get(0).get("code"):"",
                    opnList.isEmpty()?"":opnList.get(0).containsKey("expect")?opnList.get(0).get("expect"):"", errorLog.getErrMsgJson()));
        }
    }

    /**
     * 官方彩派彩前置处理
     */
    private LotteryResultVo beforeOfficePayout(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || StringTool.isBlank(resultVo.getSearch().getCode()) || StringTool.isBlank(resultVo.getSearch().getExpect())){
            resultVo = new LotteryResultVo();
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("官方彩票派彩失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,resultVo.getSearch().getCode());
        if(lotteryEnum == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("彩种错误!");
            LOG.error("官方彩票派彩失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        if(!LotteryClassifyEnum.OFFICE.getCode().equals(lotteryEnum.getClassify())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("非官方彩种暂无手动派彩功能!");
            LOG.error("官方彩票派彩失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        resultVo = this.search(resultVo);
        if(!resultVo.isSuccess() || resultVo.getResult() == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少当期彩种开奖记录!");
            LOG.error("官方彩票派彩失败,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        if(DateTool.secondsBetween(resultVo.getResult().getOpenTime(), new Date()) > 0){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("当期彩种还未开奖,无法派彩!");
            LOG.error("官方彩票派彩失败,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        if(StringTool.isBlank(resultVo.getResult().getOpenCode())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("当期彩种无开奖结果!");
            LOG.error("官方彩票派彩失败,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }

        List<LotteryWinningRecord> winningRecords = LotteryResultNumberUtility.handleWinningRecords(resultVo.getResult());
        if(CollectionTool.isEmpty(winningRecords)){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少中奖记录!");
            LOG.error("官方彩票派彩失败,code:{0},expect:{1},openCode:{2},原因:{3}",
                    resultVo.getResult().getCode(), resultVo.getResult().getExpect(), resultVo.getResult().getOpenCode(),resultVo.getErrMsg());
            return resultVo;
        }
        resultVo.setWinningRecordList(winningRecords);
        return resultVo;
    }

    /**
     * 自主彩彩派彩前置处理
     */
    private LotteryResultVo beforeOwnPayout(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || StringTool.isBlank(resultVo.getSearch().getCode()) || StringTool.isBlank(resultVo.getSearch().getExpect())){
            resultVo = new LotteryResultVo();
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("自主彩票派彩失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,resultVo.getSearch().getCode());
        if(lotteryEnum == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("彩种错误!");
            LOG.error("自主彩票派彩失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        if(!LotteryClassifyEnum.OWN.getCode().equals(lotteryEnum.getClassify())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("非自主彩种，彩种类型错误!");
            LOG.error("自主彩票派彩失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        resultVo = this.search(resultVo);
        if(!resultVo.isSuccess() || resultVo.getResult() == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少当期彩种开奖记录!");
            LOG.error("自主彩票派彩失败,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        if(DateTool.secondsBetween(resultVo.getResult().getOpenTime(), new Date()) > 0){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("当期自主彩种还未开奖,无法派彩!");
            LOG.error("自主彩票派彩失败,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        return resultVo;
    }


    /**
     * 获取线程结果
     */
    private LotteryResultVo validateResultList(List<Future<LotteryResultNumberVo>> futures, String errorMsgFormat, String operateType){
        LotteryResultVo resultVo = new LotteryResultVo();
        StringBuffer sb = new StringBuffer();
        String opnType = "";
        List<Map<String, String>> opnList = new ArrayList<Map<String, String>>();
        List<Map<String, String>> errList = new ArrayList<Map<String, String>>();
        for (Future<LotteryResultNumberVo> future : futures) {
            LotteryResultNumberVo lotteryResultNumberVo = null;
            try {
                lotteryResultNumberVo = future.get();
            } catch (Exception e) {
                LOG.error(e,"获取线程返回结果异常");
            }
            if(lotteryResultNumberVo != null && !lotteryResultNumberVo.isSuccess()){
                sb.append(MessageFormat.format(errorMsgFormat, lotteryResultNumberVo._getSiteId(),lotteryResultNumberVo.getErrMsg()));

                opnType = lotteryResultNumberVo.getOperationType();

                if (opnList.isEmpty()) {
                    if (LotteryOperationEnum.PAYOUT.getCode().equals(opnType) || LotteryOperationEnum.REVOKE.getCode().equals(opnType)
                            || LotteryOperationEnum.REVOCATION.getCode().equals(opnType) || LotteryOperationEnum.RECALCULATE.getCode().equals(opnType)
                            || LotteryOperationEnum.DELETE.getCode().equals(opnType)) {
                        if (lotteryResultNumberVo.getResult() != null) {
                            Map<String, String> opnMap = new HashedMap();
                            opnMap.put("code", lotteryResultNumberVo.getResult().getCode());
                            opnMap.put("expect", lotteryResultNumberVo.getResult().getExpect());
                            opnList.add(opnMap);
                        }
                    }
                    if (LotteryOperationEnum.INIT.getCode().equals(opnType)) {
                        Map<String, String> opnMap = new HashedMap();
                        opnMap.put("code", lotteryResultNumberVo.getSearch().getCodes().toString());
                        String start = DateTool.formatDate(lotteryResultNumberVo.getSearch().getQueryStartDate(), DateTool.yyyyMMdd);
                        String end = DateTool.formatDate(lotteryResultNumberVo.getSearch().getQueryEndDate(), DateTool.yyyyMMdd);
                        if (start.equals(end)) {
                            opnMap.put("initDate", start);
                        } else {
                            opnMap.put("initDate", start + "-" + end);
                        }
                        opnList.add(opnMap);
                    }
                    if (LotteryOperationEnum.OPEN_NUMBER.getCode().equals(opnType)) {
                        Map<String, String> opnMap = new HashedMap();
                        opnMap.put("code", lotteryResultNumberVo.getResult().getCode());
                        opnMap.put("expect", lotteryResultNumberVo.getResult().getExpect());
                        opnMap.put("openCode", lotteryResultNumberVo.getResult().getOpenCode());
                        opnList.add(opnMap);
                    }
                    if (LotteryOperationEnum.ADJUST.getCode().equals(opnType)) {
                        Map<String, String> opnMap = new HashedMap();
                        opnMap.put("code", lotteryResultNumberVo.getResult().getCode());
                        opnMap.put("expect", lotteryResultNumberVo.getResult().getExpect());
                        opnMap.put("openTime", DateTool.formatDate(DateTool.addHours(lotteryResultNumberVo.getResult().getOpenTime(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
                        opnMap.put("openingTime", DateTool.formatDate(DateTool.addHours(lotteryResultNumberVo.getResult().getOpeningTime(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
                        opnMap.put("closeTime", DateTool.formatDate(DateTool.addHours(lotteryResultNumberVo.getResult().getCloseTime(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
                        opnList.add(opnMap);
                    }
                    if (LotteryOperationEnum.BATCH_ADJUST.getCode().equals(opnType)) {
                        Map<String, String> opnMap = new HashedMap();
                        opnMap.put("code", lotteryResultNumberVo.getSearch().getCode());
                        opnMap.put("expect", lotteryResultNumberVo.getSearch().getExpectStart() + "-" + lotteryResultNumberVo.getSearch().getExpectEnd());
                        opnMap.put("openInterval", lotteryResultNumberVo.getSearch().getOpenTimeInterval().toString());
                        opnMap.put("openingInterval", lotteryResultNumberVo.getSearch().getOpeningTimeInterval().toString());
                        opnMap.put("closeInterval", lotteryResultNumberVo.getSearch().getCloseTimeInterval().toString());
                        opnList.add(opnMap);
                    }
                }
                Map<String, String> errMap = new HashedMap();
                errMap.put("siteId", lotteryResultNumberVo._getSiteId().toString());
                errMap.put("errMsg", lotteryResultNumberVo.getErrMsg());
                errList.add(errMap);
            } else if (lotteryResultNumberVo != null && lotteryResultNumberVo.isSuccess()) {

                if (LotteryOperationEnum.PAYOUT.getCode().equals(lotteryResultNumberVo.getOperationType())) {
                    SysSiteVo sysSiteVo = new SysSiteVo();
                    sysSiteVo.getSearch().setId(lotteryResultNumberVo._getSiteId());
                    sysSiteService.get(sysSiteVo);
//                    if (SubSysCodeEnum.COMPANY.getCode().equals(sysSiteVo.getResult().getSiteClassifyKey())) {
//                        sendApiMessage(getApiMsgBody(
//                                lotteryResultNumberVo._getSiteId().toString(),
//                                lotteryResultNumberVo.getResult().getCode(),
//                                lotteryResultNumberVo.getResult().getExpect()));
//                    }
                }
            }
        }
        if(StringTool.isNotBlank(opnType)){
            LotteryErrorLogVo errorLogVo = new LotteryErrorLogVo();
            errorLogVo.setResult(new LotteryErrorLog());
            errorLogVo.getResult().setOperationType(opnType);
            errorLogVo.getResult().setOperationMsgJson(new Gson().toJson(opnList));
            errorLogVo.getResult().setErrMsgJson(new Gson().toJson(errList));
            errorLogVo.getResult().setCreateTime(new Date());
            errLogService.insert(errorLogVo);
            LotteryErrorLog errorLog = errorLogVo.getResult();

            if (LotteryResultVo.OPERATE_TYPE_AUTO.equals(operateType)) {
                sendBossMessage(getLotteryErrorMsgBody(EnumTool.enumOf(LotteryOperationEnum.class, errorLog.getOperationType()).getTrans(),
                        opnList.isEmpty()?"":opnList.get(0).containsKey("code")?opnList.get(0).get("code"):"",
                        opnList.isEmpty()?"":opnList.get(0).containsKey("expect")?opnList.get(0).get("expect"):"",
                        errorLog.getErrMsgJson()));
            }
        }

        if(StringTool.isNotBlank(sb)){
            resultVo.setSuccess(false);
            resultVo.setErrMsg(sb.toString());
        }
        return resultVo;
    }

    /**
     * 添加官方彩派彩任务
     */
    private Future<LotteryResultNumberVo> addOfficialPayoutTask(LotteryResultVo resultVo, Integer siteId) {
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setOperationType(LotteryOperationEnum.PAYOUT.getCode());
        targetVo.setOperator(resultVo.getOperator());
        targetVo.setSearch(new LotteryResultNumberSo());
        targetVo.getSearch().setCode(resultVo.getResult().getCode());
        targetVo.getSearch().setExpect(resultVo.getResult().getExpect());
        targetVo.setResult(LotteryResultNumberUtility.createByLotteryResult(resultVo.getResult()));
        targetVo.setWinningRecordList(resultVo.getWinningRecordList());
        targetVo._setSiteId(siteId);
        LotteryResultPayoutTask task = SpringTool.getBean(LotteryResultPayoutTask.class);
        task.setNumberVo(targetVo);
        return lotteryExecutor.submit(task);
    }

    /**
     * 添加官方彩派彩任务
     */
    private Future<LotteryResultNumberVo> addOwnPayoutTask(LotteryResultVo resultVo, Integer siteId) {
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setOperationType(LotteryOperationEnum.PAYOUT.getCode());
        targetVo.setOperator(resultVo.getOperator());
        targetVo.setSearch(new LotteryResultNumberSo());
        targetVo.getSearch().setCode(resultVo.getResult().getCode());
        targetVo.getSearch().setExpect(resultVo.getResult().getExpect());
        targetVo.setResult(LotteryResultNumberUtility.createByLotteryResult(resultVo.getResult()));
        targetVo._setSiteId(siteId);
        LotteryResultOwnPayoutTask task = SpringTool.getBean(LotteryResultOwnPayoutTask.class);
        task.setNumberVo(targetVo);
        return lotteryExecutor.submit(task);
    }

    /**
     * 检查彩种
     */
    private LotteryResultVo checkUnifyPayout(LotteryResultVo resultVo, Lottery lottery){
        LotteryResultVo result = new LotteryResultVo();
        String code = resultVo.getResult().getCode();
        String operateType = resultVo.getOperateType();
        //针对手动派彩的判断条件
        boolean flag = true;
        //针对自动派彩增加判断条件
        if(LotteryResultVo.OPERATE_TYPE_AUTO.equals(operateType)){
            //判断总控再判断商户
            flag = flag && LotteryStatusEnum.NORMAL.getCode().equals(lottery.getStatus());
        }
        if(!flag){
            LOG.warn("官方彩票{0}派彩判断未通过,siteId:{1},code:{2},lotteryStatus:{3}",
                    LotteryGatherOriginEnum.AUTO.getCode().equals(operateType)?"自动":"手动",lottery.getSiteId(),code,lottery != null?lottery.getStatus():"");
            result.setSuccess(false);
            result.setErrMsg("彩票派彩判断未通过");
            return result;
        }
        return result;
    }

    /**
     * 弹出开号窗口前的检查
     */
    @Override
    public LotteryResultVo checkOpenNumber(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || resultVo.getSearch().getId() == null){
            resultVo = new LotteryResultVo();
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("官方彩开号前校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        resultVo = this.get(resultVo);
        if(!resultVo.isSuccess() || resultVo.getResult() == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少当期彩种开奖记录!");
            LOG.error("官方彩开号前校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,resultVo.getResult().getCode());
        if(lotteryEnum == null || !LotteryClassifyEnum.OFFICE.getCode().equals(lotteryEnum.getClassify())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("非官方彩种!");
            LOG.error("官方彩开号前校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        if(DateTool.secondsBetween(resultVo.getResult().getOpenTime(), new Date()) > 0){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("彩种当期未到开奖时间!");
            LOG.error("官方彩开号前校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        return resultVo;
    }

    /**
     * 官方彩开号
     */
    @Override
    @Transactional
    public LotteryResultVo doOpenNumber(LotteryResultVo resultVo) {
        resultVo = beforeOpenNumber(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        Date date = new Date();
        resultVo.getResult().setOpenCode(resultVo.getSearch().getOpenCode());
        resultVo.getResult().setGather(resultVo.getSearch().getGather());
        resultVo.getResult().setGatherOrigin(LotteryGatherOriginEnum.OPEN_NUMBER.getCode());
        resultVo.getResult().setGatherTime(date);
        resultVo.getResult().setGatherOpenTime(date);
        if(LotteryEnum.HKLHC.getCode().equals(resultVo.getResult().getCode())){
            List<String> zodicList = CacheBase.getLotteryLhcZodiacList(StringTool.split(resultVo.getSearch().getOpenCode(),","));
            resultVo.getResult().setOpenCodeMemo(StringTool.join(zodicList,","));
        }
        if(LotteryEnum.PK10NN.getCode().equals(resultVo.getResult().getCode())){
            List<NnResult> nnResults = NnResultFormatTool.formatOpenCode(resultVo.getSearch().getOpenCode());
            resultVo.getResult().setOpenCodeMemo(JsonTool.toJson(nnResults));
        }
//        if(LotteryEnum.PK10BJL.getCode().equals(resultVo.getResult().getCode())){
//            List<BjlResult> bjlResults = BjlResultFormatTool.formatOpenCode(resultVo.getSearch().getOpenCode());
//            resultVo.getResult().setOpenCodeMemo(JsonTool.toJson(bjlResults));
//        }
        resultVo.setProperties(LotteryResult.PROP_OPEN_CODE, LotteryResult.PROP_OPEN_CODE_MEMO, LotteryResult.PROP_GATHER,
                LotteryResult.PROP_GATHER_TIME, LotteryResult.PROP_GATHER_ORIGIN, LotteryResult.PROP_GATHER_OPEN_TIME);
        resultVo = this.updateOnly(resultVo);

        if (!resultVo.isSuccess()) {
            return resultVo;
        }

        Map<String, List<Lottery>> merchantLotteryMap = CacheBase.getMerchantLotteryMap();
        List<String> siteIds = new ArrayList<>();
        siteIds.addAll(merchantLotteryMap.keySet());
        if(MapTool.isNotEmpty(merchantLotteryMap) && CollectionTool.isNotEmpty(siteIds)){
            List<Future<LotteryResultNumberVo>> futures = new ArrayList<>();
            for(String siteId : siteIds){
                Future<LotteryResultNumberVo> openNumberTask = addOpenNumberTask(resultVo, siteId);
                if(openNumberTask != null){
                    futures.add(openNumberTask);
                }
            }
            LotteryResultVo result = validateResultList(futures,"商户:{0}开号失败,原因:{1}", resultVo.getOperateType());
            if (!result.isSuccess()) {
                resultVo.setSuccess(result.isSuccess());
                LOG.error("商户开号失败,原因:{1}",resultVo.getErrMsg());
                resultVo.setErrMsg("商户开号失败!,详情请查看失败日志!");
            }
        }


        return resultVo;
    }

    /**
     * 官方彩保存开号前置处理
     */
    private LotteryResultVo beforeOpenNumber(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || resultVo.getSearch().getId() == null
                || StringTool.isBlank(resultVo.getSearch().getOpenCode()) || StringTool.isBlank(resultVo.getSearch().getGather())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("官方彩开号前校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        resultVo = checkOpenNumber(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        String openCode=resultVo.getSearch().getOpenCode();
        String type = resultVo.getResult().getType();
        String code = resultVo.getResult().getCode();
        String expect = resultVo.getResult().getExpect();
        String[] numbers = StringTool.split(openCode,",");
        int num=numbers.length;
        boolean checkFlag;
        for (String number : numbers) {
            checkFlag = !NumberTool.isDigits(number) || (StringTool.equals(type, LotteryTypeEnum.SSC.getCode()) && (num != 5 || number.length() != 1 || Integer.parseInt(number) > 9 || Integer.parseInt(number) < 0))
                    || (StringTool.equals(type, LotteryTypeEnum.K3.getCode()) && (num != 3 || number.length() != 1 || Integer.parseInt(number) > 6 || Integer.parseInt(number) < 1))
                    || (StringTool.equals(type, LotteryTypeEnum.SFC.getCode()) && (num != 8 || number.length() != 2 || Integer.parseInt(number) > 20 || Integer.parseInt(number) < 1))
                    || (StringTool.equals(type, LotteryTypeEnum.KENO.getCode()) && (num != 20 || number.length() != 2 || Integer.parseInt(number) > 80 || Integer.parseInt(number) < 1))
                    || (StringTool.equals(type, LotteryTypeEnum.XY28.getCode()) && (num != 3 || number.length() != 1 || Integer.parseInt(number) > 9 || Integer.parseInt(number) < 0))
                    || (StringTool.equals(type, LotteryTypeEnum.PK10.getCode()) && (num != 10 || number.length() != 2 || Integer.parseInt(number) > 10 || Integer.parseInt(number) < 1))
                    || (StringTool.equals(type, LotteryTypeEnum.PL3.getCode()) && (num != 3 || number.length() != 1 || Integer.parseInt(number) > 9 || Integer.parseInt(number) < 0))
                    || (StringTool.equals(type, LotteryTypeEnum.LHC.getCode()) && (num != 7 || number.length() != 2 || Integer.parseInt(number) > 49 || Integer.parseInt(number) < 1));

            if (checkFlag) {
                resultVo.setSuccess(false);
                resultVo.setErrMsg("开奖号码有误!");
                LOG.error("官方彩开号失败,code:{0},expect:{1},原因:{2}", code,expect,resultVo.getErrMsg());
                return resultVo;
            }
        }
        if (StringTool.equals(type, LotteryTypeEnum.LHC.getCode())|| StringTool.equals(type, LotteryTypeEnum.SFC.getCode())
                || StringTool.equals(type, LotteryTypeEnum.KENO.getCode())|| StringTool.equals(type, LotteryTypeEnum.PK10.getCode())) {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (StringTool.equals(numbers[i], numbers[j])) {
                        resultVo.setSuccess(false);
                        resultVo.setErrMsg("开奖号码重复!");
                        LOG.error("官方彩开号失败,code:{0},expect:{1},原因:{2}", code,expect,resultVo.getErrMsg());
                        return resultVo;
                    }
                }
            }
        }
        return resultVo;
    }


    /**
     * 添加开号任务
     */
    private Future<LotteryResultNumberVo> addOpenNumberTask(LotteryResultVo resultVo, String siteId) {
        LotteryResultOpenNumberTask task = SpringTool.getBean(LotteryResultOpenNumberTask.class);
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setOperationType(LotteryOperationEnum.OPEN_NUMBER.getCode());
        targetVo.setSearch(new LotteryResultNumberSo());
        targetVo.getSearch().setCode(resultVo.getResult().getCode());
        targetVo.getSearch().setExpect(resultVo.getResult().getExpect());
        targetVo.setResult(LotteryResultNumberUtility.createByLotteryResult(resultVo.getResult()));
        targetVo._setSiteId(Integer.parseInt(siteId));
        task.setNumberVo(targetVo);
        return operateExecutor.submit(task);
    }

    /**
     * 调盘
     */
    @Override
    @Transactional
    public LotteryResultVo doAdjust(LotteryResultVo resultVo) {
        resultVo = beforeAdjust(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        Date ascriptionTime = DateTool.addHours(resultVo.getSearch().getOpenTime(),GTM8);
        resultVo.getResult().setOpenTime(resultVo.getSearch().getOpenTime());
        resultVo.getResult().setCloseTime(resultVo.getSearch().getCloseTime());
        resultVo.getResult().setOpeningTime(resultVo.getSearch().getOpeningTime());
        resultVo.getResult().setAscriptionTime(ascriptionTime);
        resultVo.setProperties(LotteryResult.PROP_OPEN_TIME, LotteryResult.PROP_CLOSE_TIME, LotteryResult.PROP_OPENING_TIME, LotteryResult.PROP_ASCRIPTON_TIME);
        resultVo = this.updateOnly(resultVo);

        if(!resultVo.isSuccess()){
            return resultVo;
        }

        Map<String, List<Lottery>> merchantLotteryMap = CacheBase.getMerchantLotteryMap();
        List<String> siteIds = new ArrayList<>();
        siteIds.addAll(merchantLotteryMap.keySet());
        if(MapTool.isNotEmpty(merchantLotteryMap) && CollectionTool.isNotEmpty(siteIds)){
            List<Future<LotteryResultNumberVo>> futures = new ArrayList<>();
            for(String siteId : siteIds){
                Future<LotteryResultNumberVo> adjustTask = addAdjustTask(resultVo, siteId);
                if(adjustTask != null){
                    futures.add(adjustTask);
                }
            }
            LotteryResultVo result = validateResultList(futures,"商户:{0}调盘失败,原因:{1}", resultVo.getOperateType());
            if (!result.isSuccess()) {
                resultVo.setSuccess(result.isSuccess());
                LOG.error("商户调盘失败,原因:{1}",resultVo.getErrMsg());
                resultVo.setErrMsg("商户调盘失败!,详情请查看失败日志!");
            }
        }
        return resultVo;
    }

    /**
     * 添加调盘任务
     */
    private Future<LotteryResultNumberVo> addAdjustTask(LotteryResultVo resultVo, String siteId) {
        LotteryResultAdjustTask task = SpringTool.getBean(LotteryResultAdjustTask.class);
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setOperationType(LotteryOperationEnum.ADJUST.getCode());
        targetVo.setSearch(new LotteryResultNumberSo());
        targetVo.getSearch().setCode(resultVo.getResult().getCode());
        targetVo.getSearch().setExpect(resultVo.getResult().getExpect());
        targetVo.setResult(LotteryResultNumberUtility.createByLotteryResult(resultVo.getResult()));
        targetVo._setSiteId(Integer.parseInt(siteId));
        task.setNumberVo(targetVo);
        return operateExecutor.submit(task);
    }


    /**
     * 批量调盘
     */
    @Override
    @Transactional
    public LotteryResultVo doBatchAdjust(LotteryResultVo resultVo) {
        resultVo = beforeBatchAdjust(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        boolean update = this.mapper.batchUpdateAdjust(resultVo.getSearch());
        if (!update) {
            resultVo.setSuccess(update);
            return resultVo;
        }

        Map<String, List<Lottery>> merchantLotteryMap = CacheBase.getMerchantLotteryMap();
        List<String> siteIds = new ArrayList<>();
        siteIds.addAll(merchantLotteryMap.keySet());
        if(MapTool.isNotEmpty(merchantLotteryMap) && CollectionTool.isNotEmpty(siteIds)){
            List<Future<LotteryResultNumberVo>> futures = new ArrayList<>();
            for(String siteId : siteIds){
                Future<LotteryResultNumberVo> batchAdjustTask = addBatchAdjustTask(resultVo, siteId);
                if(batchAdjustTask != null){
                    futures.add(batchAdjustTask);
                }
            }
            LotteryResultVo result = validateResultList(futures,"商户:{0}批量调盘失败,原因:{1}", resultVo.getOperateType());
            if (!result.isSuccess()) {
                resultVo.setSuccess(result.isSuccess());
                LOG.error("商户批量调盘失败,原因:{1}",resultVo.getErrMsg());
                resultVo.setErrMsg("商户批量调盘失败!,详情请查看失败日志!");
            }
        }

        return resultVo;
    }

    /**
     * 添加批量调盘任务
     */
    private Future<LotteryResultNumberVo> addBatchAdjustTask(LotteryResultVo resultVo, String siteId) {
        LotteryResultBatchAdjustTask task = SpringTool.getBean(LotteryResultBatchAdjustTask.class);
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setOperationType(LotteryOperationEnum.BATCH_ADJUST.getCode());
        targetVo.setSearch(new LotteryResultNumberSo());
        targetVo.getSearch().setCode(resultVo.getSearch().getCode());
        targetVo.getSearch().setExpectStart(resultVo.getSearch().getExpectStart());
        targetVo.getSearch().setExpectEnd(resultVo.getSearch().getExpectEnd());
        targetVo.getSearch().setOpenTimeInterval(resultVo.getSearch().getOpenTimeInterval());
        targetVo.getSearch().setOpeningTimeInterval(resultVo.getSearch().getOpeningTimeInterval());
        targetVo.getSearch().setCloseTimeInterval(resultVo.getSearch().getCloseTimeInterval());
        targetVo._setSiteId(Integer.parseInt(siteId));
        task.setNumberVo(targetVo);
        return operateExecutor.submit(task);
    }


    /**
     * 调盘前置处理
     */
    private LotteryResultVo beforeAdjust(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || resultVo.getSearch().getId() == null || resultVo.getSearch().getOpenTime() == null
                || resultVo.getSearch().getCloseTime() == null || resultVo.getSearch().getOpeningTime() == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("调盘校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        if(DateTool.secondsBetween(resultVo.getSearch().getOpenTime(), resultVo.getSearch().getCloseTime()) <= 0){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖时间要大于封盘时间!");
            LOG.error("调盘校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        if(DateTool.secondsBetween(resultVo.getSearch().getCloseTime(), resultVo.getSearch().getOpeningTime()) <= 0){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("封盘时间要大于开盘时间!");
            LOG.error("调盘校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        resultVo = this.get(resultVo);
        if(!resultVo.isSuccess() || resultVo.getResult() == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少当期彩种开奖记录!");
            LOG.error("调盘校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        return resultVo;
    }

    /**
     * 批量调盘前置处理
     */
    private LotteryResultVo beforeBatchAdjust(LotteryResultVo resultVo) {
        if (resultVo == null || resultVo.getSearch().getCode() == null || resultVo.getSearch().getExpectStart() == null || resultVo.getSearch().getExpectEnd() == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("批量调盘校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }

        String expectStart = resultVo.getSearch().getExpectStart();
        String expectEnd = resultVo.getSearch().getExpectEnd();
        if (StringTool.isNotBlank(expectStart) || StringTool.isNotBlank(expectEnd)) {
            resultVo.getSearch().setExpect(expectStart);
            resultVo = this.search(resultVo);
            if(resultVo.getResult() == null){
                resultVo.setSuccess(false);
                resultVo.setErrMsg("起始期数不正确!");
                LOG.error("批量调盘校验未通过,原因:{0}", resultVo.getErrMsg());
                return resultVo;
            }
            resultVo.setResult(null);
            resultVo.getSearch().setExpect(expectEnd);
            resultVo = this.search(resultVo);
            if(resultVo.getResult() == null){
                resultVo.setSuccess(false);
                resultVo.setErrMsg("结束期数不正确!");
                LOG.error("批量调盘校验未通过,原因:{0}", resultVo.getErrMsg());
                return resultVo;
            }
        }
        if (resultVo.getSearch().getOpeningTimeInterval() != null || resultVo.getSearch().getCloseTimeInterval() != null || resultVo.getSearch().getOpenTimeInterval() != null) {
            if (resultVo.getSearch().getOpenTimeInterval() != null) {
                if (resultVo.getSearch().getOpenTimeStatus()) {
                    resultVo.getSearch().setOpenTimeInterval(resultVo.getSearch().getOpenTimeInterval() * -1);
                }
            }
            if (resultVo.getSearch().getCloseTimeInterval() != null) {
                if (resultVo.getSearch().getCloseTimeStatus()) {
                    resultVo.getSearch().setCloseTimeInterval(resultVo.getSearch().getCloseTimeInterval() * -1);
                }
            }
            if (resultVo.getSearch().getOpeningTimeInterval() != null) {
                if (resultVo.getSearch().getOpeningTimeStatus()) {
                    resultVo.getSearch().setOpeningTimeInterval(resultVo.getSearch().getOpeningTimeInterval() * -1);
                }
            }
        } else {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("时间间隔不能为空!");
            LOG.error("批量调盘校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }


        return resultVo;
    }

    @Override
    public LotteryResultVo deleteLotteryResult(LotteryResultVo resultVo) {
        boolean success = this.delete(resultVo);
        if (!success) {
            resultVo.setSuccess(success);
            return resultVo;
        }
        resultVo = beforeDeleteLotteryResult(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        Map<String, List<Lottery>> merchantLotteryMap = CacheBase.getMerchantLotteryMap();
        List<String> siteIds = new ArrayList<>();
        siteIds.addAll(merchantLotteryMap.keySet());
        if(MapTool.isNotEmpty(merchantLotteryMap) && CollectionTool.isNotEmpty(siteIds)){
            List<Future<LotteryResultNumberVo>> futures = new ArrayList<>();
            for(String siteId : siteIds){
                Future<LotteryResultNumberVo> deleteTask = addDeleteTask(resultVo, siteId);
                if(deleteTask != null){
                    futures.add(deleteTask);
                }
            }
            LotteryResultVo result = validateResultList(futures,"商户:{0}删除开奖结果失败,原因:{1}", resultVo.getOperateType());
            if (!result.isSuccess()) {
                resultVo.setSuccess(result.isSuccess());
                LOG.error("删除开奖结果失败,原因:{1}",resultVo.getErrMsg());
                resultVo.setErrMsg("商户删除开奖结果失败!,详情请查看失败日志!");
            }
        }

        return resultVo;
    }

    /**
     * 删除开奖结果前置处理
     */
    private LotteryResultVo beforeDeleteLotteryResult(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getResult() == null || resultVo.getResult().getCode() == null || resultVo.getResult().getExpect() == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("删除开奖结果失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        return resultVo;
    }
    /**
     * 添加删除任务
     */
    private Future<LotteryResultNumberVo> addDeleteTask(LotteryResultVo resultVo, String siteId) {
        LotteryResultDeleteTask task = SpringTool.getBean(LotteryResultDeleteTask.class);
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setOperationType(LotteryOperationEnum.DELETE.getCode());
        targetVo.setSearch(new LotteryResultNumberSo());
        targetVo.getSearch().setCode(resultVo.getResult().getCode());
        targetVo.getSearch().setExpect(resultVo.getResult().getExpect());
        targetVo.setResult(LotteryResultNumberUtility.createByLotteryResult(resultVo.getResult()));
        targetVo._setSiteId(Integer.parseInt(siteId));
        task.setNumberVo(targetVo);
        return operateExecutor.submit(task);
    }


    /**
     * 批量撤单,撤销
     */
    @Override
    @Transactional
    public LotteryResultVo doBatchRevo(LotteryResultVo resultVo) {
        resultVo = beforeBatchRevo(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        LOG.info("开始执行批量{0}任务,code:{1},expect:{2},site:{3}",resultVo.getRevoItemText(),resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),
                resultVo.getSearch().getSiteId()==null?"全站":resultVo.getSearch().getSiteId());
        List<Lottery> list = getMerchantOfficialLotteryList(resultVo);
        if(CollectionTool.isEmpty(list)) {
            resultVo.setOkMsg("不存在需要批量"+resultVo.getRevoItemText()+"的商户");
            LOG.info("批量{0}任务未执行,原因:{1}",resultVo.getRevoItemText(),resultVo.getOkMsg());
            return resultVo;
        }
        List<Future<LotteryResultNumberVo>> resultList = new ArrayList<>();
        for(Lottery lottery : list) {
            Future<LotteryResultNumberVo> future = addRevoTask(lottery.getSiteId(),resultVo);
            if(future != null){
                resultList.add(future);
            }
        }
        LotteryResultVo result = validateResultList(resultList,"商户:{0}彩票批量"+resultVo.getRevoItemText()+"失败,原因:{1}", resultVo.getOperateType());
        resultVo.setSuccess(result.isSuccess());
        resultVo.setErrMsg(result.getErrMsg());
        if(!result.isSuccess()){
            LOG.error("批量"+resultVo.getRevoItemText()+"失败,code:{0},expect:{1},openCode:{2},原因:{3}",
                    resultVo.getResult().getCode(), resultVo.getResult().getExpect(), resultVo.getResult().getOpenCode(),resultVo.getErrMsg());
            resultVo.setErrMsg("批量"+resultVo.getRevoItemText()+"失败!,详情请查看失败日志!");
        }
        return resultVo;
    }

    /**
     * 添加撤单,撤销任务
     *
     */
    private Future<LotteryResultNumberVo> addRevoTask(Integer siteId, LotteryResultVo resultVo) {
////        if(!BillItemEnum.REVOKE_REFUND.getCode().equals(resultVo.getItem()) && !BillItemEnum.REVOCATION_REFUND.getCode().equals(resultVo.getItem())){
////            return null;
////        }
////        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
////        if (BillItemEnum.REVOKE_REFUND.getCode().equals(resultVo.getItem())) {
////            targetVo.setOperationType(LotteryOperationEnum.REVOKE.getCode());
////        }
////        if (BillItemEnum.REVOCATION_REFUND.getCode().equals(resultVo.getItem())) {
////            targetVo.setOperationType(LotteryOperationEnum.REVOCATION.getCode());
////        }
//        targetVo.setItem(resultVo.getItem());
//        targetVo.setSearch(new LotteryResultNumberSo());
//        targetVo.getSearch().setCode(resultVo.getResult().getCode());
//        targetVo.getSearch().setExpect(resultVo.getResult().getExpect());
//        targetVo.setResult(LotteryResultNumberUtility.createByLotteryResult(resultVo.getResult()));
//        targetVo._setSiteId(siteId);
//        LotteryRevoTask task = SpringTool.getBean(LotteryRevoTask.class);
//        task.setNumberVo(targetVo);
        return null;
    }

    /**
     * 批量撤单,撤销前置处理
     */
    private LotteryResultVo beforeBatchRevo(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || StringTool.isBlank(resultVo.getSearch().getCode()) || StringTool.isBlank(resultVo.getSearch().getExpect())
                || StringTool.isBlank(resultVo.getItem())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("彩票批量撤单或撤销校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
//        resultVo = this.search(resultVo);
//        if(!resultVo.isSuccess() || resultVo.getResult() == null) {
//            resultVo.setSuccess(false);
//            resultVo.setErrMsg("缺少当期彩种开奖记录!");
//            LOG.error("彩票批量{0}校验未通过,原因:{1}", resultVo.getRevoItemText(),resultVo.getErrMsg());
//            return resultVo;
//        }if(DateTool.secondsBetween(resultVo.getResult().getOpeningTime(), new Date()) > 0){
//            resultVo.setSuccess(false);
//            resultVo.setErrMsg("当期彩种还未开盘,无法"+resultVo.getRevoItemText()+"!");
//            LOG.error("彩票批量{0}校验未通过,原因:{1}", resultVo.getRevoItemText(),resultVo.getErrMsg());
//            return resultVo;
//        }if(BillItemEnum.REVOCATION_REFUND.getCode().equals(resultVo.getItem()) && DateTool.secondsBetween(resultVo.getResult().getOpenTime(), new Date()) > 0){
//            resultVo.setSuccess(false);
//            resultVo.setErrMsg("当期彩种还未开奖,无法撤销!");
//            LOG.error("彩票批量{0}校验未通过,原因:{1}", resultVo.getRevoItemText(),resultVo.getErrMsg());
//            return resultVo;
//        }
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.setCode(resultVo.getSearch().getCode());
        lotteryResult.setExpect(resultVo.getSearch().getExpect());
        resultVo.setResult(lotteryResult);
        return resultVo;
    }


    /**
     * 补采
     */
    @Override
    @Transactional
    public LotteryResultVo doMakeUp(LotteryResultVo resultVo) {
        resultVo = beforeMakeUp(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        List<LotteryGatherConf> confs = CacheBase.getLotteryGatherConf(LotteryConfTypeEnum.COLLECTION.getCode(),resultVo.getSearch().getCode());
        if(CollectionTool.isEmpty(confs)){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少当前彩种补采配置!");
            LOG.error("补采校验未通过,code:{0},endDate:{1},原因:{2}", resultVo.getSearch().getCode(),
                    DateTool.formatDate(resultVo.getSearch().getQueryEndDate(),DateTool.yyyy_MM_dd),resultVo.getErrMsg());
            return resultVo;
        }
        LotteryGatherConf conf = confs.get(0);
        ILotteryGatherHandle lotterHandle = LotteryGatherHandleFactory.getInstance().getLotterHandle(conf.getAbbrName());
        LotteryGatherParam gatherParam = new LotteryGatherParam();
        gatherParam.setCode(resultVo.getSearch().getCode());
        gatherParam.setDate(DateTool.formatDate(resultVo.getSearch().getQueryEndDate(),DateTool.yyyy_MM_dd));
        gatherParam.setGather(resultVo.getSearch().getGather());
        gatherParam.setLotteryGatherConf(conf);
        LotteryResultListVo resultListVo = lotterHandle.doMakeUp(gatherParam);
        if(!resultListVo.isSuccess() || CollectionTool.isEmpty(resultListVo.getResult())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg(resultListVo.getErrMsg());
            LOG.error("补采失败,code:{0},endDate:{1},原因:{2}", resultVo.getSearch().getCode(),
                    DateTool.formatDate(resultVo.getSearch().getQueryEndDate(),DateTool.yyyy_MM_dd),resultVo.getErrMsg());
            return resultVo;
        }
        this.mapper.batchUpdateOpenCode(resultListVo.getResult());

        //同步到商户动作，
        List<LotteryResultNumber> list = new ArrayList<>();
        resultListVo.getResult().forEach(obj->{
            list.add(LotteryResultNumberUtility.createByLotteryResult(obj));
        });
        Map<String, List<Lottery>> merchantLotteryMap = CacheBase.getMerchantLotteryMap();
        List<String> siteIds = new ArrayList<>();
        siteIds.addAll(merchantLotteryMap.keySet());
        if(MapTool.isNotEmpty(merchantLotteryMap) && CollectionTool.isNotEmpty(siteIds)){
            List<Future<LotteryResultNumberVo>> futures = new ArrayList<>();
            for(String siteId : siteIds){
                Future<LotteryResultNumberVo> makeUpTask = addMakeUpTask(list, siteId);
                if(makeUpTask != null){
                    futures.add(makeUpTask);
                }
            }
            LotteryResultVo result = validateResultList(futures,"商户:{0}彩票补采同步开奖结果失败,原因:{1}", resultVo.getOperateType());
            resultVo.setSuccess(result.isSuccess());
            resultVo.setErrMsg(result.getErrMsg());
        }

        return resultVo;
    }

    /**
     * 补采前置处理
     */
    private LotteryResultVo beforeMakeUp(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || StringTool.isBlank(resultVo.getSearch().getCode()) ||
                resultVo.getSearch().getQueryEndDate() == null  || StringTool.isBlank(resultVo.getSearch().getGather())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("补采校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,resultVo.getSearch().getCode());
        if(lotteryEnum == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("彩种错误!");
            LOG.error("补采校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        if(!LotteryClassifyEnum.OFFICE.getCode().equals(lotteryEnum.getClassify())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("非官方彩种暂无手动派彩功能!");
            LOG.error("补采校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        Date endDate = DateTool.addHours(resultVo.getSearch().getQueryEndDate(),GTM8);
        if(endDate == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("截止日期格式错误!");
            LOG.error("补采校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        if(CacheHashTool.checkMakeUpCacheHash(resultVo.getSearch().getCode(),DateTool.formatDate(endDate,DateTool.yyyy_MM_dd))){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("10S内不可重复操作");
            LOG.error("补采校验未通过,code:{0},endDate:{3},原因:{4}",resultVo.getSearch().getCode(),DateTool.formatDate(endDate,DateTool.yyyy_MM_dd), resultVo.getErrMsg());
            return resultVo;
        }
        resultVo.getSearch().setQueryEndDate(endDate);
        return resultVo;
    }

    /**
     * 添加初始化任务
     */
    private Future<LotteryResultNumberVo> addMakeUpTask(List<LotteryResultNumber> list, String siteId) {
        LotteryMakeUpTask task = SpringTool.getBean(LotteryMakeUpTask.class);
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setOperationType(LotteryOperationEnum.MAKE_UP.getCode());
        targetVo.setEntities(list);
        targetVo._setSiteId(Integer.parseInt(siteId));
        task.setNumberVo(targetVo);
        return operateExecutor.submit(task);
    }
    /**
     * 获取开奖号码
     */
    @Override
    public LotteryResultVo getOpenCode(LotteryResultVo resultVo) {
        if(resultVo == null || resultVo.getSearch() == null || StringTool.isBlank(resultVo.getSearch().getCode()) ||
                StringTool.isBlank(resultVo.getSearch().getExpect())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("获取开奖号码失败,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        resultVo = this.search(resultVo);
        if(!resultVo.isSuccess() || resultVo.getResult() == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("未存在当期彩种!");
            LOG.error("获取开奖号码失败,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }if(StringTool.isBlank(resultVo.getResult().getOpenCode())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("当期彩种未开奖!");
            LOG.error("获取开奖号码失败,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        resultVo.setOkMsg(resultVo.getResult().getOpenCode());
        return resultVo;
    }

    /**
     * 重结
     */
    @Override
    public LotteryResultVo doRecalculate(LotteryResultVo resultVo) {
        resultVo = beforeRecalculate(resultVo);
        if(!resultVo.isSuccess()){
            return resultVo;
        }
        List<Lottery> list = getMerchantOfficialLotteryList(resultVo);
        if(CollectionTool.isEmpty(list)) {
            resultVo.setOkMsg("不存在需要批量重结的商户");
            LOG.info("重结任务未执行,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        List<Future<LotteryResultNumberVo>> resultList = new ArrayList<>();
        for(Lottery lottery : list) {
            Future<LotteryResultNumberVo> future = doRecalculateTask(lottery.getSiteId(),resultVo);
            if(future != null){
                resultList.add(future);
            }
        }
        LotteryResultVo result = validateResultList(resultList,"商户:{0}彩票重结失败,原因:{1}", resultVo.getOperateType());
        resultVo.setSuccess(result.isSuccess());
        resultVo.setErrMsg(result.getErrMsg());
        if(!result.isSuccess()){
            LOG.error("重结失败,code:{0},expect:{1},openCode:{2},原因:{3}",
                    resultVo.getResult().getCode(), resultVo.getResult().getExpect(), resultVo.getResult().getOpenCode(),resultVo.getErrMsg());
            resultVo.setErrMsg("重结失败!,详情请查看失败日志!");
        }
        return resultVo;
    }

    /**
     * 添加重结任务
     */
    private Future<LotteryResultNumberVo> doRecalculateTask(Integer siteId, LotteryResultVo resultVo) {
        LotteryResultNumberVo targetVo = new LotteryResultNumberVo();
        targetVo.setOperationType(LotteryOperationEnum.RECALCULATE.getCode());
        targetVo.setItem(resultVo.getItem());
        targetVo.setSearch(new LotteryResultNumberSo());
        targetVo.getSearch().setCode(resultVo.getResult().getCode());
        targetVo.getSearch().setExpect(resultVo.getResult().getExpect());
        targetVo.setResult(LotteryResultNumberUtility.createByLotteryResult(resultVo.getResult()));
        targetVo._setSiteId(siteId);
        LotteryRecalculateTask task = SpringTool.getBean(LotteryRecalculateTask.class);
        task.setNumberVo(targetVo);
        return lotteryExecutor.submit(task);
    }

    /**
     * 重结前置处理
     */
    private LotteryResultVo beforeRecalculate(LotteryResultVo resultVo){
        if(resultVo == null || resultVo.getSearch() == null || StringTool.isBlank(resultVo.getSearch().getCode()) || StringTool.isBlank(resultVo.getSearch().getExpect())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("参数丢失!");
            LOG.error("重结前置处理校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,resultVo.getSearch().getCode());
        if(lotteryEnum == null){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("彩种错误!");
            LOG.error("重结前置处理校验未通过,原因:{0}", resultVo.getErrMsg());
            return resultVo;
        }if(!LotteryClassifyEnum.OFFICE.getCode().equals(lotteryEnum.getClassify())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("非官方彩种暂无重结功能!");
            LOG.error("重结前置处理校验未通过,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        resultVo = this.search(resultVo);
        if(!resultVo.isSuccess() || resultVo.getResult() == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少当期彩种开奖记录!");
            LOG.error("重结前置处理校验未通过,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }if(DateTool.secondsBetween(resultVo.getResult().getOpenTime(), new Date()) > 0){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("当期彩种还未开奖,无法重结!");
            LOG.error("重结前置处理校验未通过,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }if(StringTool.isBlank(resultVo.getResult().getOpenCode())){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("当期彩种无开奖结果!");
            LOG.error("重结前置处理校验未通过,code:{0},expect:{1},原因:{2}", resultVo.getSearch().getCode(),resultVo.getSearch().getExpect(),resultVo.getErrMsg());
            return resultVo;
        }
        List<LotteryWinningRecord> winningRecords = LotteryResultNumberUtility.handleWinningRecords(resultVo.getResult());
        if(CollectionTool.isEmpty(winningRecords)){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("缺少中奖记录!");
            LOG.error("重结前置处理校验未通过,code:{0},expect:{1},openCode:{2},原因:{3}",
                    resultVo.getResult().getCode(), resultVo.getResult().getExpect(), resultVo.getResult().getOpenCode(),resultVo.getErrMsg());
            return resultVo;
        }
        resultVo.setWinningRecordList(winningRecords);

        return resultVo;
    }

    /**
     * 获取商户官方彩种彩种列表
     */
    private List<Lottery> getMerchantOfficialLotteryList(LotteryResultVo resultVo){
        List<Lottery> result = new ArrayList<>();
        if(resultVo.getSearch().getSiteId() != null) {
            Lottery lottery = CacheBase.getLottery(resultVo.getSearch().getSiteId(),resultVo.getSearch().getCode());
            if(lottery != null) {
                result.add(lottery);
            }
        }else {
            result = CacheBase.getMerchantLotteryList(resultVo.getSearch().getCode());
        }
        return result;
    }

    @Override
    public List<LotteryResult> queryRecentRecords(LotteryResultListVo listVo) {
        return this.mapper.pagingSearch(listVo.getQuery().queryRecentRecordCriteria(), 1, listVo.getPaging().getPageSize(), Order.desc(LotteryResult.PROP_OPEN_TIME));
    }


    @Override
    public Map<String, LotteryResult> queryRecentResult(LotteryResultVo vo) {
        List<LotteryResult> results = this.mapper.queryRecentResult();
        return CollectionTool.toEntityMap(results, LotteryResult.PROP_CODE, String.class);
    }

    @Override
    public List<LotteryResult> queryNoresult(LotteryResultListVo listVo) {
        return this.mapper.queryNoresult(listVo.getSearch());
    }

    @Override
    public List<LotteryResult> queryRecentOpenResult(LotteryResultListVo listVo) {
        return this.mapper.queryRecentOpenResult(listVo);
    }

    @Override
    public LotteryResultListVo queryNotOpenResult(LotteryResultListVo listVo) {
        long count = mapper.count(listVo.getQuery().queryNotOpenResult());
        listVo.getPaging().setTotalCount(count);
        List<LotteryResult> lotteryResults = mapper.pagingSearch(listVo.getQuery().queryNotOpenResult(), listVo.getPaging().getPageNumber(), listVo.getPaging().getPageSize(), listVo.getQuery().getOrders());
        listVo.setResult(lotteryResults);
        listVo.getPaging().cal();
        return listVo;
    }

    @Override
    public LotteryResultListVo queryHaveOpenResult(LotteryResultListVo listVo) {
        return null;
    }

    @Override
    public List<LotteryResult> queryCurHandicap(LotteryResultVo vo) {
        return this.mapper.queryCurHandicap();
    }


    @Override
    public List<LotteryResult> searchLotteryResult(LotteryResultVo lotteryResultVo) {
        Criteria criteria = Criteria.add(LotteryResult.PROP_EXPECT, Operator.EQ, lotteryResultVo.getResult().getExpect());
        criteria.addAnd(LotteryResult.PROP_CODE, Operator.EQ, lotteryResultVo.getResult().getCode());
        criteria.addAnd(LotteryResult.PROP_TYPE, Operator.EQ, lotteryResultVo.getResult().getType());
        List<LotteryResult> lotteryResult = mapper.search(criteria);
        return lotteryResult;
    }

    @Override
    public int batchUpdateProperties(LotteryResultVo vo) {
        Map<String, Object> map = new HashMap(3, 1f);
        map.put(LotteryResult.PROP_OPEN_TIME, vo.getResult().getOpenTime());
        map.put(LotteryResult.PROP_OPENING_TIME, vo.getResult().getOpeningTime());
        map.put(LotteryResult.PROP_CLOSE_TIME, vo.getResult().getCloseTime());
        map.put(LotteryResult.PROP_ASCRIPTON_TIME, vo.getResult().getAscriptionTime());
        Criteria criteria = Criteria.add(LotteryResult.PROP_CODE, Operator.EQ, vo.getResult().getCode());
        criteria.addAnd(LotteryResult.PROP_EXPECT, Operator.EQ, vo.getResult().getExpect());
        criteria.addAnd(LotteryResult.PROP_TYPE, Operator.EQ, vo.getResult().getType());
        return this.mapper.batchUpdateProperties(criteria, map);
    }

    /**
     * 消息发送
     */
    public void sendBossMessage(String mesBody) {
        MessageVo message = new MessageVo();
        // 前端消息订阅类型
        message.setSubscribeType(CometSubscribeType.BOSS_LOTTERY_ERROR.getCode());
        // 设置消息主体内容
        message.setMsgBody(mesBody);
        // 设置消息接收对象
        messageService.sendToBossMsg(message);
    }

    /**
     * 设置失败消息主体内容
     */
    private static String getLotteryErrorMsgBody(String message, String code, String expect, String errMsgJson) {
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("title", message + "失败");
        map.put("code", code);
        map.put("expect", expect);
        map.put("errMsgJson", errMsgJson);
        map.put("message", message + "失败,请及时处理!");
        return JsonTool.toJson(map);
    }

    /**
     * 消息发送
     */
    public void sendApiMessage(String mesBody) {
        MessageVo message = new MessageVo();
        // 前端消息订阅类型
        message.setSubscribeType(CometSubscribeType.MERCHANT_API.getCode());
        // 设置消息主体内容
        message.setMsgBody(mesBody);
        // 设置消息接收对象
        messageService.sendToApiMsg(message);
    }

    /**
     * 设置失败消息主体内容
     */
    private static String getApiMsgBody(String siteId, String code, String expect) {
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("siteId", siteId);
        map.put("code", code);
        map.put("expect", expect);
        return JsonTool.toJson(map);
    }
}