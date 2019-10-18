package so.wwb.creditbox.manager.common.lottery.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.web.controller.NoMappingCrudController;
import org.springframework.ui.Model;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.company.lottery.po.LotteryQuotaSet;
import so.wwb.creditbox.model.company.lottery.vo.LotteryQuotaSetListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryQuotaSetVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.AuditAddLogTool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeremy on 18-4-28.
 */
public class BaseLotteryQuotaController extends NoMappingCrudController {
    private static final Log LOG = LogFactory.getLog(BaseLotteryQuotaController.class);
    protected static final String COMMAND = "command";
    private final static String LOTTERY_QUOTA_UPDATE = "lottery.quota.update";
    @Override
    protected String getViewBasePath() {
        return null;
    }

    /**
     * 装配限额玩法、限额 数据
     * @param code
     * @param siteId
     * @param model
     */
    protected void queryQuotaSetByCode(String code, Integer siteId, Model model){
        Map<String,String> playMap = new LinkedHashMap<>();
        if (StringTool.isNotBlank(code) && siteId != null){
            LotteryQuotaSetListVo listVo = new LotteryQuotaSetListVo();
            listVo.getSearch().setCode(code);
            listVo.setPaging(null);
            listVo._setDataSourceId(siteId);
            listVo = ServiceTool.lotteryQuotaSetService().search(listVo);
            if (CollectionTool.isNotEmpty(listVo.getResult())){
                Map<Object, LotteryQuotaSet> quotaMap = CollectionTool.toEntityMap(listVo.getResult(), LotteryQuotaSet.PROP_PLAY_CODE);
                model.addAttribute(COMMAND, quotaMap);
                for(LotteryQuotaSet quota : listVo.getResult()){
                    LotteryPlayEnum playEnum = EnumTool.enumOf(LotteryPlayEnum.class, quota.getPlayCode());
                    if(playEnum != null){
                        playMap.put(playEnum.getTrans(), playEnum.getCode());
                    }
                }
            }
        }
        model.addAttribute("playMap", playMap);
    }

    /**
     * 保存限额设置
     * @param quotaSetVo
     * @param request
     * @return
     */
    public Map<String, Object> updateQuotaSet(LotteryQuotaSetVo quotaSetVo, HttpServletRequest request) {
        if (StringTool.isBlank(quotaSetVo.getLotteryQuotaSetJson()) && quotaSetVo.getSearch().getSiteId() == null) {
            return getVoMessage(quotaSetVo);
        }
        JSONArray arr;
        try {
            arr = JSONObject.parseArray(quotaSetVo.getLotteryQuotaSetJson());
        } catch (Exception e) {
            LOG.error("提交限额格式有问题，转换出错！{0}", quotaSetVo.getLotteryQuotaSetJson());
            quotaSetVo.setSuccess(false);
            return getVoMessage(quotaSetVo);
        }

        if (arr != null && arr.size() > 0) {
            quotaSetVo.setProperties(LotteryQuotaSet.PROP_BET_HIGH_QUOTA,LotteryQuotaSet.PROP_NUM_HIGH_QUOTA,LotteryQuotaSet.PROP_PLAY_HIGH_QUOTA,LotteryQuotaSet.PROP_BET_LOW_QUOTA);
            List<LotteryQuotaSet> updateQuotas = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                if (obj != null) {
                    LotteryQuotaSet so = new LotteryQuotaSet();
                    int id = obj.getInteger("id");
                    so.setId(id);
                    so.setBetHighQuota(obj.getDouble("betHighQuota"));
                    so.setBetLowQuota(obj.getDouble("betLowQuota"));
                    so.setNumHighQuota(obj.getDouble("numHighQuota"));
                    so.setPlayHighQuota(obj.getDouble("playHighQuota"));
                    updateQuotas.add(so);
                    ids.add(id);
                }
            }
            if (!checkQuota(ids, updateQuotas, quotaSetVo.getSearch().getSiteId())) {
                LOG.info("保存彩票限额值有误!");
                quotaSetVo.setSuccess(false);
                return getVoMessage(quotaSetVo);
            }
            if (CollectionTool.isNotEmpty(updateQuotas)) {
                quotaSetVo.setEntities(updateQuotas);
                quotaSetVo._setDataSourceId(quotaSetVo.getSearch().getSiteId());
                int updateOnly = ServiceTool.lotteryQuotaSetService().batchUpdateOnly(quotaSetVo);
                //添加日志
                if (updateOnly>0){
                    List<String> params = new ArrayList<>();
                    params.add(quotaSetVo.getSearch().getSiteId().toString());
                    params.add(quotaSetVo.getSearch().getCode());
                    AuditAddLogTool.addLog(request,LOTTERY_QUOTA_UPDATE,params);
                }
                Cache.refreshLotteryQuotas(quotaSetVo.getSearch().getSiteId());
            }
        }
        return getVoMessage(quotaSetVo);
    }

    private boolean checkQuota(List<Integer> ids, List<LotteryQuotaSet> updateQuotas , Integer siteId) {
        Map<Integer, LotteryQuotaSet> LotteryQuotaMap = getLotteryQuotaMap(ids, siteId);
        if (LotteryQuotaMap == null) {
            return false;
        }
        LotteryQuotaSet lotteryQuotaSet;
        for (LotteryQuotaSet quota : updateQuotas) {
            lotteryQuotaSet = LotteryQuotaMap.get(quota.getId());
            if(lotteryQuotaSet == null){
                LOG.info("查询查询不到对应的站点限额,id{0}", quota.getId());
                return false;
            }
            if (lotteryQuotaSet.getBetHighQuota() == null) {
                LOG.info("查询查询不到对应的站点单注限额,id{0},betQuota{1}", quota.getId(), quota.getBetHighQuota());
                return false;
            }
            if (lotteryQuotaSet.getBetLowQuota() == null) {
                LOG.info("查询查询不到对应的站点单注最低限额,id{0},betQuota{1}", quota.getId(), quota.getBetLowQuota());
                return false;
            }
            if (lotteryQuotaSet.getNumHighQuota() == null) {
                LOG.info("查询查询不到对应的站点单项限额,id{0},numQuota{1}", quota.getId(), quota.getNumHighQuota());
                return false;
            }
            if (lotteryQuotaSet.getPlayHighQuota() == null && !lotteryQuotaSet.getCode().equals(LotteryEnum.HKLHC.getCode()) && !lotteryQuotaSet.getCode().equals(LotteryEnum.JSLHC.getCode())) {
                LOG.info("查询查询不到对应的站点单类别单项限额,id{0},odd{1}", quota.getId(), quota.getPlayHighQuota());
                return false;
            }
            if (quota.getBetHighQuota() < 0 || quota.getNumHighQuota() < 0) {
                LOG.info("设置限额不能小于0");
                return false;
            }
            if(!LotteryEnum.HKLHC.getCode().equals(lotteryQuotaSet.getCode()) && !LotteryEnum.JSLHC.getCode().equals(lotteryQuotaSet.getCode()) && quota.getPlayHighQuota() < 0 ){
                LOG.info("设置限额不能小于0");
                return false;
            }
        }
        return true;
    }

    private Map<Integer, LotteryQuotaSet> getLotteryQuotaMap(List<Integer> ids , Integer siteId) {
        LotteryQuotaSetListVo listVo = new LotteryQuotaSetListVo();
        listVo.getSearch().setIds(ids);
        listVo.setPaging(null);
        listVo._setDataSourceId(siteId);
        listVo = ServiceTool.lotteryQuotaSetService().search(listVo);
        if (CollectionTool.isEmpty(listVo.getResult())) {
            return null;
        }
        return CollectionTool.toEntityMap(listVo.getResult(), LotteryQuotaSet.PROP_ID, Integer.class);
    }

    /**
     * 用于返回JSP包路径
     * @param code
     * @return
     */
    protected String handleCode(String code) {
        if (code.contains("ssc")) {
            code = LotteryTypeEnum.SSC.getCode();
        }else if (code.contains("k3")) {
            code = LotteryTypeEnum.K3.getCode();
        } else if (code.contains("cqxync") || code.contains("gdkl10")) {
            code = LotteryTypeEnum.SFC.getCode();
        } else if (code.contains("fc3d") || code.contains("tcpl3")) {
            code = LotteryTypeEnum.PL3.getCode();
        }else  if(LotteryEnum.BJPK10.getCode().equals(code) || LotteryEnum.JSPK10.getCode().equals(code) || LotteryEnum.XYFT.getCode().equals(code)){
            code= LotteryTypeEnum.PK10.getCode();
        }else if (code.contains("bjkl8")){
            code= LotteryTypeEnum.KENO.getCode();
        }else if (code.contains("lhc")) {
            code = LotteryTypeEnum.LHC.getCode();
        }else if (LotteryEnum.PK10NN.getCode().equals(code)) {
            code = LotteryTypeEnum.NN.getCode();
        } else if (code.contains("11x5")) {
            code = LotteryTypeEnum.SYX5.getCode();
        }else if (LotteryEnum.PK10BJL.getCode().equals(code)) {
            code = LotteryTypeEnum.BJL.getCode();
        }
        return code;
    }
}
