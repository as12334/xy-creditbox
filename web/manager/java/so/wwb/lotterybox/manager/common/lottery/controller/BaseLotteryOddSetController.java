package so.wwb.lotterybox.manager.common.lottery.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.soul.commons.cache.CacheTool;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.sort.Direction;
import org.soul.web.controller.NoMappingCrudController;
import org.springframework.ui.Model;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.manager.session.SessionManager;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.constants.cache.CacheKey;
import so.wwb.lotterybox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.lotterybox.model.enums.sys.SysUserTypeEnum;
import so.wwb.lotterybox.model.manager.lottery.po.Lottery;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryType;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryVo;
import so.wwb.lotterybox.model.company.lottery.po.LotteryOddSet;
import so.wwb.lotterybox.model.company.lottery.so.LotteryOddSetSo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryOddSetListVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryOddSetVo;
import so.wwb.lotterybox.web.cache.Cache;
import so.wwb.lotterybox.web.tools.AuditAddLogTool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jeremy on 18-4-27.
 */
public class BaseLotteryOddSetController extends NoMappingCrudController {
    private static final Log LOG = LogFactory.getLog(BaseLotteryOddSetController.class);
    private static final String LOTTERY_ODD_UPDATE = "lottery.odd.update";
    protected static final String COMMAND = "command";

    @Override
    protected String getViewBasePath() {
        return null;
    }

    protected Map<Object, LotteryOddSet> searchLotteryOddSet(String code, String betting, LotteryOddSetVo oddVo) {
        LotteryOddSetListVo listVo = new LotteryOddSetListVo();
        LotteryOddSetSo search = oddVo.getSearch();
        oddVo.getSearch().setCode(this.queryCode(code));
        oddVo.getSearch().setBetCode(betting);
        listVo.setSearch(search);
        listVo.setPaging(null);
        listVo._setDataSourceId(oddVo._getDataSourceId());
        listVo = ServiceTool.lotteryOddSetService().search(listVo);
        List<LotteryOddSet> result = listVo.getResult();
        return CollectionTool.toEntityMap(result, LotteryOddSet.PROP_BET_NUM);
    }

    protected Map<String, List<LotteryOddSet>> searchLotteryOddSet(String code, String[] betCodes, LotteryOddSetVo oddVo) {
        LotteryOddSetListVo listVo = new LotteryOddSetListVo();
        listVo.getSearch().setCode(this.queryCode(code));
        listVo.getSearch().setBetcodes(betCodes);
        listVo.getQuery().addOrder(LotteryOddSet.PROP_BET_CODE, Direction.ASC);
        listVo.getQuery().addOrder(LotteryOddSet.PROP_BET_NUM, Direction.DESC);
        listVo.setPaging(null);
        listVo.getSearch().setProjectId(oddVo.getSearch().getProjectId());
        listVo._setDataSourceId(oddVo._getDataSourceId());
        listVo = ServiceTool.lotteryOddSetService().search(listVo);
        List<LotteryOddSet> result = listVo.getResult();
        Map<String, List<LotteryOddSet>> stringListMap = CollectionTool.groupByProperty(result, LotteryOddSet.PROP_BET_CODE, String.class);
        return stringListMap;
    }

    protected LotteryOddSetVo saveLotteryOddSet(LotteryOddSetVo lotteryOddSetVo, Integer siteId, HttpServletRequest request){
        if (StringTool.isBlank(lotteryOddSetVo.getLotteryOddSetJson()) || siteId == null || lotteryOddSetVo.getSearch().getProjectId() == null) {
            lotteryOddSetVo.setSuccess(false);
            lotteryOddSetVo.setErrMsg("提交赔率参数为空，不能保存");
        }else {
            JSONArray arr = null;
            try {
                arr = JSONObject.parseArray(lotteryOddSetVo.getLotteryOddSetJson());
            } catch (Exception e) {
                LOG.error("提交赔率格式有问题，转换出错！{0}", lotteryOddSetVo.getLotteryOddSetJson());
                lotteryOddSetVo.setSuccess(false);
            }
            if (arr != null && arr.size() > 0) {

//                    lotteryOddSetVo.setProperties(LotteryOddSet.PROP_ODD, LotteryOddSet.PROP_REBATE);

                if(SysUserTypeEnum.COMPANY.getCode().equals(SessionManager.getUser().getSubsysCode())) {
                    lotteryOddSetVo.setProperties(LotteryOddSet.PROP_ODD, LotteryOddSet.PROP_REBATE);
                }else {
                    lotteryOddSetVo.setProperties(LotteryOddSet.PROP_ODD, LotteryOddSet.PROP_REBATE, LotteryOddSet.PROP_ODD_LIMIT, LotteryOddSet.PROP_REBATE_LIMIT);
                }
                List<LotteryOddSet> updateOdds = new ArrayList<>();
                List<Integer> ids = new ArrayList<>();
                for (int i = 0; i < arr.size(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    if (obj != null) {
                        LotteryOddSet so = new LotteryOddSet();
                        int id = obj.getInteger("id");

                        LotteryOddSetVo vo = new LotteryOddSetVo();
                        vo.getSearch().setId(id);
                        vo._setDataSourceId(siteId);
                        vo = ServiceTool.lotteryOddSetService().get(vo);

                        so.setId(id);
                        so.setOdd(obj.getDouble("odd"));
                        so.setRebate(obj.getDouble("rebate"));

                        if(!(SysUserTypeEnum.COMPANY.getCode().equals(SessionManager.getUser().getSubsysCode()))) {
                            so.setOddLimit(obj.getDouble("oddLimit") == null ? vo.getResult().getOddLimit() : obj.getDouble("oddLimit"));
                            so.setRebateLimit(obj.getDouble("rebateLimit") == null ? vo.getResult().getRebateLimit() : obj.getDouble("rebateLimit"));
                        }
                        so.setBaseNum(obj.getDouble("baseNum"));
                        updateOdds.add(so);
                        ids.add(id);
                    }
                }
                if (!checkOddSet(ids, updateOdds, siteId)) {
                    LOG.info("保存彩票赔率值有误!");
                    lotteryOddSetVo.setSuccess(false);
                    return lotteryOddSetVo;
                }
                if (CollectionTool.isNotEmpty(updateOdds)) {
                    lotteryOddSetVo.setEntities(updateOdds);
                    lotteryOddSetVo._setDataSourceId(siteId);
                    int updateOnly = ServiceTool.lotteryOddSetService().batchUpdateOnly(lotteryOddSetVo);
                    //添加日志
                    if (updateOnly>0){
                        List<String> params = new ArrayList<>();
                        params.add(siteId.toString());
                        params.add(lotteryOddSetVo.getSearch().getCode());
                        params.add(lotteryOddSetVo.getSearch().getModel());
                        AuditAddLogTool.addLog(request,LOTTERY_ODD_UPDATE,params);
                    }
                    Cache.refreshLotteryOddSet(siteId,lotteryOddSetVo.getSearch().getProjectId());
                }
            }
        }
        return lotteryOddSetVo;
    }

    protected boolean checkOddSet(List<Integer> ids, List<LotteryOddSet> updateOdds, Integer siteId) {
        Map<Integer, LotteryOddSet> oddMap = getLotteryOddSetMap(ids, siteId);
        if (oddMap == null) {
            return false;
        }
        LotteryOddSet lotteryOddSet;
        for (LotteryOddSet odd : updateOdds) {
            lotteryOddSet = oddMap.get(odd.getId());
            if (lotteryOddSet == null || lotteryOddSet.getOdd() == null) {
                LOG.info("查询查询不到对应的站点赔率,id:{0},odd:{1}", odd.getId().toString(), odd.getOdd());
                return false;
            }

            if(SysUserTypeEnum.COMPANY.getCode().equals(SessionManager.getUser().getSubsysCode())) {
                if (odd.getOdd() < 0 || odd.getOdd() > lotteryOddSet.getOddLimit()) {
                    LOG.info("设置赔率格式不正确,odd:{0},上限{1}", odd.getOdd(), lotteryOddSet.getOddLimit());
                    return false;
                }
                if (lotteryOddSet.getRebate() != null) {
                    if (odd.getRebate() != null) {
                        if (odd.getRebate() < 0 || odd.getRebate() > lotteryOddSet.getRebateLimit()) {
                            LOG.info("设置赔率格式不正确,rebate:{0},上限{1}", odd.getRebate(), lotteryOddSet.getRebateLimit());
                            return false;
                        }
                    }
                }
            }else {
                if (odd.getOdd() < 0 || odd.getOdd() > odd.getOddLimit()) {
                    LOG.info("设置赔率格式不正确,odd:{0},上限{1}", odd.getOdd(), odd.getOddLimit());
                    return false;
                }
                if (lotteryOddSet.getRebate() != null) {
                    if (odd.getRebate() != null) {
                        if (odd.getRebate() < 0 || odd.getRebate() > odd.getRebateLimit()) {
                            LOG.info("设置赔率格式不正确,rebate:{0},上限{1}", odd.getRebate(), odd.getRebateLimit());
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    protected Map<Integer, LotteryOddSet> getLotteryOddSetMap(List<Integer> ids, Integer siteId) {
        LotteryOddSetListVo listVo = new LotteryOddSetListVo();
        listVo.getSearch().setIds(ids);
        listVo.setPaging(null);
        listVo._setDataSourceId(siteId);
        listVo = ServiceTool.lotteryOddSetService().search(listVo);
        if (CollectionTool.isEmpty(listVo.getResult())) {
            return null;
        }
        return CollectionTool.toEntityMap(listVo.getResult(), LotteryOddSet.PROP_ID, Integer.class);
    }

    /**
     * 返回彩种赔率表单页面
     * @param siteId 站点ID
     * @param code 彩种代码 LotteryEnum
     * @param betting 具体玩法 LotteryBettingEnum
     * @param page 页面类型
     * @param oddVo
     * @param model
     * @return
     */
    protected void lotteryOddSetIndexData(String code, String betting, String page, Integer siteId, LotteryOddSetVo oddVo, Model model) {
        if (StringTool.isNotBlank(code) && StringTool.isNotBlank(betting) && StringTool.isNotBlank(page) && siteId != null){
            model.addAttribute("betCode", betting);
            model.addAttribute("code", code);
            String[] betCodes = {};
            if (StringTool.isNotBlank(betting)) {
                betCodes = betting.split(",");
            }
            oddVo._setDataSourceId(siteId);
            if (betCodes.length > 1) {
                Map<String, List<LotteryOddSet>> lotteryOddSets = searchLotteryOddSet(code, betCodes, oddVo);
                model.addAttribute(COMMAND, lotteryOddSets);
            } else {
                Map<Object, LotteryOddSet> lotteryOddSetMap = searchLotteryOddSet(code, betting, oddVo);
                model.addAttribute(COMMAND, lotteryOddSetMap);
            }
        }
    }

    /**
     * 用于返回JSP包路径
     * @param code
     * @return
     */
    protected String handleCode(String code) {
        if (code.contains("ssc") && !code.contains("gf")) {
            code = LotteryTypeEnum.SSC.getCode();
        } else if (code.contains("sscgf")){
            code = LotteryTypeEnum.SSC.getCode()+"gf";
        }else if (code.contains("k3") && !code.contains("gf")) {
            code = LotteryTypeEnum.K3.getCode();
        }else if (code.contains("k3gf")) {
            code = LotteryTypeEnum.K3.getCode()+"gf";
        } else if (code.contains("cqxync") || code.contains("gdkl10")) {
            code = LotteryTypeEnum.SFC.getCode();
        } else if ((code.contains("fc3d") || code.contains("tcpl3"))&&!code.contains("gf")) {
            code = LotteryTypeEnum.PL3.getCode();
        } else if (code.contains("fc3dgf") || code.contains("tcpl3gf")) {
            code = LotteryTypeEnum.PL3.getCode() + "gf";
        }else  if(code.contains("bjl")){
            code= LotteryTypeEnum.BJL.getCode();
        } else if ((code.contains("pk10") || code.contains("xyft")) && !code.contains("gf")) {
            code = LotteryTypeEnum.PK10.getCode();
        } else if (code.contains("pk10gf") || code.contains("xyftgf")) {
            code = LotteryTypeEnum.PK10.getCode() + "gf";
        } else if (code.contains("11x5") && !code.contains("gf")) {
            code = LotteryTypeEnum.SYX5.getCode();
        } else if (code.contains("11x5gf")) {
            code = LotteryTypeEnum.SYX5.getCode() + "gf";
        } else if (code.contains("lhc")) {
            code = LotteryTypeEnum.LHC.getCode();
        }

        return code;
    }

    /**
     * 用于返回查询的彩种 code
     * @param code
     * @return
     */
    protected String queryCode(String code) {
        if (StringTool.isNotBlank(code) && code.contains("gf")) {
            code = code.substring(0, code.length() - 2);
        }
        return code;
    }

    protected LotteryVo getLotteryOpenModel(String code, Integer siteId){
        LotteryVo lotteryVo = new LotteryVo();
        if (StringTool.isNotBlank(code) && siteId != null){
            Lottery lottery = CacheBase.getLottery(siteId, code);
            if(lottery == null){
                lotteryVo.setSuccess(false);
                lotteryVo.setErrMsg("缺少当前商户彩种缓存数据");
            }
            lotteryVo.setOkMsg(lottery.getModel());
        }else {
            lotteryVo.setSuccess(false);
            lotteryVo.setErrMsg("参数丢失");
        }
        return lotteryVo;
    }
}
