package so.wwb.creditbox.manager.lottery.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.sort.Direction;
import org.soul.model.log.audit.enums.OpType;
import org.soul.model.log.audit.vo.BaseLog;
import org.soul.model.log.audit.vo.LogVo;
import org.soul.model.sys.po.SysAuditLog;
import org.soul.web.controller.NoMappingCrudController;
import org.soul.web.log.audit.AuditLogTool;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.manager.session.SessionManager;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeOddEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdd;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdd;
import so.wwb.creditbox.model.manager.lottery.so.LotteryOddSo;
import so.wwb.creditbox.model.manager.lottery.so.SiteLotteryOddSo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOddListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOddVo;
import so.wwb.creditbox.manager.lottery.form.LotteryOddForm;
import org.springframework.stereotype.Controller;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddListVo;
import so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.AuditAddLogTool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 赔率设置表控制器
 *
 * @author block
 * @time 2019-10-21 21:46:34
 */
@Controller
//region your codes 1
@RequestMapping("/lottery/odds")
public class LotteryOddController extends NoMappingCrudController {
//endregion your codes 1


    //region your codes 3
    private static final Log LOG = LogFactory.getLog(LotteryOddController.class);

    private static final String AUDIT_LOTTERY_ODD = "lottery.lotteryodd";

    @Override
    protected String getViewBasePath() {
        return "/lottery/odds";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("oddRule", JsRuleCreator.create(LotteryOddForm.class));
        return getViewBasePath() + "/Index";
    }

    /**
     * 获取彩票种类列表
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping("/{code}/Index")
    public String getCodeIndex(@PathVariable String code, Model model) {
        model.addAttribute("code", code);
        code = handleCode(code);
        String url = getViewBasePath() + "/" + code + "/Index";
        return url;
    }

    /**
     * 获取投注玩法列表
     *
     * @param code
     * @param betting
     * @param oddVo
     * @param model
     * @return
     */
    @RequestMapping("/code/betting/Index")
    public String getCodeBettingIndex(String code, String betting, String page, String siteId, SiteLotteryOddVo oddVo, Model model) {
        String code1;
        if (code.contains("gf")) {
            code1 = code.substring(0, code.length() - 2);
        } else {
            code1 = code;
        }
        code = handleCode(code);
        model.addAttribute("betCode", betting);
        model.addAttribute("code", code1);
        String[] betcodes = {};
        if (StringTool.isNotBlank(betting)) {
            betcodes = betting.split(",");
        }
        String url = getViewBasePath() + "/" + code + "/" + page + "/Index";
        if (StringTool.equals("0", siteId)) {
            if (betcodes.length > 1) {
                Map<String, List<LotteryOdd>> lotteryOdds = searchCompanyLotteryOdd(code1, betcodes);
                model.addAttribute("command", lotteryOdds);
            } else {
                Map<Object, LotteryOdd> lotteryOddMap = searchCompanyLotteryOdd(code1, betting);
                model.addAttribute("command", lotteryOddMap);
            }
            return url;
        }
        oddVo.getSearch().setSiteId(Integer.valueOf(siteId));

        if (betcodes.length > 1) {
            Map<String, List<SiteLotteryOdd>> siteLotteryOdds = searchLotteryOdd(code1, betcodes, oddVo);
            model.addAttribute("command", siteLotteryOdds);
        } else {
            Map<Object, SiteLotteryOdd> siteLotteryOddMap = searchLotteryOdd(code1, betting, oddVo);
            model.addAttribute("command", siteLotteryOddMap);
        }
        return url;
    }

    /**
     * 获取时时彩类别列表
     *
     * @param code
     * @param category
     * @return
     */
    @RequestMapping("/{code}/{category}/categoryIndex")
    public String getSscCodeCategoryIndex(@PathVariable String code, @PathVariable String category) {
        code = handleCode(code);
        String url = getViewBasePath() + "/" + code + "/" + category + "/Index";
        return url;
    }

    @RequestMapping("/oddContent")
    @ResponseBody
    public String oddsContent(@RequestParam("siteId") String siteId) {
        if ("0".equals(siteId)) {
            return "1";
        }
        SiteLotteryOdd odd = new SiteLotteryOdd();
        odd.setSiteId(Integer.valueOf(siteId));
        return ServiceTool.siteLotteryOddService().getOddBySiteId(odd) + "";
    }

    /**
     * odds
     * 获取时时彩类别玩法列别
     *
     * @param code
     * @param category
     * @param betCode
     * @param page
     * @param oddVo
     * @param model
     * @return
     */
    @RequestMapping("/code/play/betCode/Index")
    public String getSscPlayIndex(String code, String siteId, String betCode,
                                  String category, String page,
                                  SiteLotteryOddVo oddVo, Model model) {
        String code1;
        if (code.contains("gf")) {
            code1 = code.substring(0, code.length() - 2);
        } else {
            code1 = code;
        }
        code = handleCode(code);
        model.addAttribute("betCode", betCode);
        model.addAttribute("code", code1);
        String url = getViewBasePath() + "/" + code + "/" + category + "/" + page;
        String[] betcodes = {};
        if (StringTool.isNotBlank(betCode)) {
            betcodes = betCode.split(",");
        }


        if (StringTool.equals("0", siteId)) {
            if (betcodes.length > 1) {
                Map<String, List<LotteryOdd>> lotteryOdds = searchCompanyLotteryOdd(code1, betcodes);
                model.addAttribute("command", lotteryOdds);
            } else {
                Map<Object, LotteryOdd> lotteryOddMap = searchCompanyLotteryOdd(code1, betCode);
                model.addAttribute("command", lotteryOddMap);
            }
            return url;
        }
        oddVo.getSearch().setSiteId(Integer.valueOf(siteId));
        Map<Object, SiteLotteryOdd> siteLotteryOddMap;
        if (betcodes.length > 1) {
            Map<String, List<SiteLotteryOdd>> siteLotteryOdds = searchLotteryOdd(code1, betcodes, oddVo);
            model.addAttribute("command", siteLotteryOdds);
        } else {
            siteLotteryOddMap = searchLotteryOdd(code1, betCode, oddVo);
            model.addAttribute("command", siteLotteryOddMap);
        }
        return url;
    }

    private String handleCode(@PathVariable String code) {
        if (code.contains("ssc") && !code.contains("gf")) {
            code = LotteryTypeOddEnum.SSC.getCode();
        } else if (code.contains("sscgf")) {
            code = LotteryTypeOddEnum.SSCGF.getCode();
        } else if (code.contains("k3") && !code.contains("gf")) {
            code = LotteryTypeOddEnum.K3.getCode();
        } else if (code.contains("k3gf")) {
            code = LotteryTypeOddEnum.K3GF.getCode();
        } else if (code.contains("cqxync") || code.contains("gdkl10")) {
            code = LotteryTypeOddEnum.SFC.getCode();
        } else if ((code.contains("fc3d") || code.contains("tcpl3")) && !code.contains("gf")) {
            code = LotteryTypeOddEnum.PL3.getCode();
        } else if (code.contains("fc3dgf") || code.contains("tcpl3gf")) {
            code = LotteryTypeOddEnum.PL3GF.getCode();
        } else if (code.contains("xyft") || code.contains("jspk10")) {
            code = LotteryTypeOddEnum.PK10.getCode();
        }
        return code;
    }

    private Map<Object, SiteLotteryOdd> searchLotteryOdd(@PathVariable String code, @PathVariable String betting, SiteLotteryOddVo oddVo) {
        SiteLotteryOddListVo listVo = new SiteLotteryOddListVo();
        SiteLotteryOddSo search = oddVo.getSearch();
        oddVo.getSearch().setCode(code);
        oddVo.getSearch().setBetCode(betting);
        listVo.setSearch(search);
        listVo.setPaging(null);
        listVo.getSearch().setSiteId(oddVo.getSearch().getSiteId());
        listVo.getQuery().addOrder(LotteryOdd.PROP_BET_NUM, Direction.ASC);
        listVo = ServiceTool.siteLotteryOddService().search(listVo);
        List<SiteLotteryOdd> result = listVo.getResult();
        addSiteLotteryOddBaseNum(code, result);
        return CollectionTool.toEntityMap(result, SiteLotteryOdd.PROP_BET_NUM);
    }

    private Map<String, List<SiteLotteryOdd>> searchLotteryOdd(@PathVariable String code, @PathVariable String[] betcodes, SiteLotteryOddVo oddVo) {
        SiteLotteryOddListVo listVo = new SiteLotteryOddListVo();
        listVo.getSearch().setCode(code);
        listVo.getSearch().setBetCodes(betcodes);
        listVo.getSearch().setSiteId(oddVo.getSearch().getSiteId());
        listVo.getQuery().addOrder(LotteryOdd.PROP_BET_CODE, Direction.ASC);
        listVo.getQuery().addOrder(LotteryOdd.PROP_BET_NUM, Direction.DESC);
        listVo.setPaging(null);
        listVo = ServiceTool.siteLotteryOddService().search(listVo);
        List<SiteLotteryOdd> result = listVo.getResult();
        addSiteLotteryOddBaseNum(code, result);
        Map<String, List<SiteLotteryOdd>> stringListMap = CollectionTool.groupByProperty(result, LotteryOdd.PROP_BET_CODE, String.class);
        return stringListMap;
    }

    /**
     * sitelotteryodd增加baseNum属性值
     *
     * @param code
     * @param result
     */
    private void addSiteLotteryOddBaseNum(String code, List<SiteLotteryOdd> result) {
        List<LotteryOdd> lotteryOdds = Cache.getLotteryOdd(code);
        if (CollectionTool.isNotEmpty(result) && CollectionTool.isNotEmpty(lotteryOdds)) {
            for (SiteLotteryOdd siteLotteryOdd : result) {
                if (siteLotteryOdd != null && StringTool.isNotEmpty(siteLotteryOdd.getBetCode()) && StringTool.isNotEmpty(siteLotteryOdd.getBetNum())) {
                    for (LotteryOdd lotteryOdd : lotteryOdds) {
                        if (lotteryOdd != null && lotteryOdd.getBaseNum() != null && siteLotteryOdd.getBetCode().equals(lotteryOdd.getBetCode()) && siteLotteryOdd.getBetNum().equals(lotteryOdd.getBetNum())) {
                            siteLotteryOdd.setBaseNum(lotteryOdd.getBaseNum());
                            break;
                        }
                    }
                }
            }
        }
    }

    private Map<String, List<LotteryOdd>> searchCompanyLotteryOdd(@PathVariable String code, @PathVariable String[] betcodes) {
        LotteryOddListVo listVo = new LotteryOddListVo();
        listVo.getSearch().setCode(code);
        listVo.getSearch().setBetcodes(betcodes);
        listVo.setPaging(null);
        listVo.getQuery().addOrder(LotteryOdd.PROP_BET_CODE, Direction.ASC);
        listVo.getQuery().addOrder(LotteryOdd.PROP_BET_NUM, Direction.DESC);
        listVo = ServiceTool.lotteryOddService().search(listVo);
        List<LotteryOdd> result = listVo.getResult();
        Map<String, List<LotteryOdd>> stringListMap = CollectionTool.groupByProperty(result, LotteryOdd.PROP_BET_CODE, String.class);
        return stringListMap;
    }

    private Map<Object, LotteryOdd> searchCompanyLotteryOdd(@PathVariable String code, @PathVariable String betting) {
        LotteryOddListVo listVo = new LotteryOddListVo();
        LotteryOddSo search = new LotteryOddSo();
        search.setCode(code);
        search.setBetCode(betting);
        listVo.setSearch(search);
        listVo.setPaging(null);
        listVo.getQuery().addOrder(LotteryOdd.PROP_BET_NUM, Direction.ASC);
        listVo = ServiceTool.lotteryOddService().search(listVo);
        return CollectionTool.toEntityMap(listVo.getResult(), LotteryOdd.PROP_BET_NUM);
    }

    @Audit(module = Module.LOTTERY, moduleType = ModuleType.LOTTERY_ODD, opType = OpType.UPDATE)
    @RequestMapping(value = "/saveSiteLotteryOdds", method = RequestMethod.POST)
    @ResponseBody
    public Map saveSiteLotteryOdds(HttpServletRequest request, SiteLotteryOddVo siteLotteryOddVo) {

        if (StringTool.isBlank(siteLotteryOddVo.getLotteryOddJson())) {
            return getVoMessage(siteLotteryOddVo);
        }
        JSONArray arr = null;
        try {
            arr = JSONObject.parseArray(siteLotteryOddVo.getLotteryOddJson());
        } catch (Exception e) {
            LOG.error("提交赔率格式有问题，转换出错！{0}", siteLotteryOddVo.getLotteryOddJson());
            siteLotteryOddVo.setSuccess(false);
            return getVoMessage(siteLotteryOddVo);
        }

        if (arr != null && arr.size() > 0) {
            int siteId = arr.getJSONObject(0).getInteger("siteId");
            //company赔率
            if (siteId == 0) {
                LotteryOddVo vo = new LotteryOddVo();
//                vo.setProperties(LotteryOdd.PROP_ODD, LotteryOdd.PROP_REBATE);
                List<LotteryOdd> uplist = new ArrayList<>();
                List<Integer> ids = new ArrayList<>();
                for (int i = 0; i < arr.size(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    if (obj != null) {
                        LotteryOdd o = new LotteryOdd();
                        int id = obj.getInteger("id");
                        o.setId(id);
                        o.setOddA(obj.getDouble("oddA"));
                        o.setOddB(obj.getDouble("oddB"));
                        o.setOddC(obj.getDouble("oddC"));
                        uplist.add(o);
                        ids.add(id);
                    }
                }
                if (!checkCompanyOdd(ids, uplist)) {
                    LOG.info("保存彩票赔率值有误!");
                    vo.setSuccess(false);
                    return getVoMessage(vo);
                }
                if (CollectionTool.isNotEmpty(uplist)) {
                    vo.setEntities(uplist);
                    ServiceTool.lotteryOddService().batchUpdateOnly(vo);
                    Cache.refreshLotteryOdd();
                }
                return getVoMessage(vo);
            }

            SiteLotteryOdd odd = new SiteLotteryOdd();
            odd.setSiteId(siteId);
            if (ServiceTool.siteLotteryOddService().getOddBySiteId(odd) == null) {
                siteLotteryOddVo.setSuccess(false);
                return getVoMessage(siteLotteryOddVo);
            }

//            siteLotteryOddVo.setProperties(SiteLotteryOdd.PROP_ODD, SiteLotteryOdd.PROP_REBATE);
            List<SiteLotteryOdd> updateOdds = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();
            List<String> changeOdd = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                if (obj != null) {
                    SiteLotteryOdd so = new SiteLotteryOdd();
                    int id = obj.getInteger("id");
                    so.setId(id);
                    so.setSiteId(obj.getInteger("siteId"));
                    so.setOddA(obj.getDouble("oddA"));
                    so.setOddB(obj.getDouble("oddB"));
                    so.setOddC(obj.getDouble("oddC"));
                    so.setBaseNum(obj.getDouble("baseNum"));
                    updateOdds.add(so);
                    ids.add(id);
                    changeOdd.add("</br>" + obj.getString("code") + "-" + obj.getString("betCode") + "-" + obj.getString("betNum") + ":"
                            + "oldLotteryOdd=" + obj.getDouble("oldOdd") + ";newLotteryOld=" + obj.getDouble("oddA") +
                            "oldLotteryRebate=" + obj.getDouble("oldRebate") + ";newLotteryRebate=" + obj.getDouble("rebate"));
                }
            }
            if (!checkOdd(ids, updateOdds, siteId)) {
                LOG.info("保存彩票赔率值有误!");
                siteLotteryOddVo.setSuccess(false);
                return getVoMessage(siteLotteryOddVo);
            }
            if (CollectionTool.isNotEmpty(updateOdds)) {
                siteLotteryOddVo.setEntities(updateOdds);
                siteLotteryOddVo.setProperties(SiteLotteryOdd.PROP_ID,SiteLotteryOdd.PROP_ODD_A,SiteLotteryOdd.PROP_ODD_B,SiteLotteryOdd.PROP_ODD_C);
                ServiceTool.siteLotteryOddService().batchUpdateOnly(siteLotteryOddVo);
                Cache.refreshSiteLotteryOdds(siteId);
                //审计日志添加
                List<String> params = new ArrayList<>();
                params.add(Integer.valueOf(siteId).toString());
                params.add(SessionManager.getUserName());
                params.add(changeOdd.toString());
                if (changeOdd.toString().length() < 2048) {
                    AuditAddLogTool.addLog(request, AUDIT_LOTTERY_ODD, params);
                }
            }
        }
        return getVoMessage(siteLotteryOddVo);

    }


    private boolean checkOdd(List<Integer> ids, List<SiteLotteryOdd> updateOdds, int siteId) {
        Map<Integer, SiteLotteryOdd> siteLotteryOddMap = getSiteLotteryOddMap(ids, siteId);
        if (siteLotteryOddMap == null) {
            return false;
        }
        SiteLotteryOdd lotteryOdd;
        for (SiteLotteryOdd odd : updateOdds) {
            lotteryOdd = siteLotteryOddMap.get(odd.getId());
//            if (lotteryOdd.getOdd() == null) {
//                LOG.info("查询查询不到对应的站点赔率,id{0},odd{1}", odd.getId(), odd.getOdd());
//                return false;
//            }
//            if (odd.getOdd() < 0 || odd.getOdd() > lotteryOdd.getOddLimit()) {
//                LOG.info("设置赔率格式不正确,odd:{0},上限{1}", odd.getOdd(), lotteryOdd.getOddLimit());
//                return false;
//            }
//            if (lotteryOdd.getRebate() != null) {
//                if (odd.getRebate() < 0 || odd.getRebate() > lotteryOdd.getRebateLimit()) {
//                    LOG.info("设置赔率格式不正确,rebate:{0},上限{1}", odd.getRebate(), lotteryOdd.getRebateLimit());
//                    return false;
//                }
//            }


        }
        return true;
    }

    private boolean checkCompanyOdd(List<Integer> ids, List<LotteryOdd> updateOdds) {
        Map<Integer, LotteryOdd> lotteryOddMap = getLotteryOddMap(ids);
        if (lotteryOddMap == null) {
            return false;
        }
        LotteryOdd lotteryOdd;
        for (LotteryOdd odd : updateOdds) {
            lotteryOdd = lotteryOddMap.get(odd.getId());
//            if (lotteryOdd.getOdd() == null) {
//                LOG.info("查询查询不到对应的站点赔率,id{0},odd{1}", odd.getId(), odd.getOdd());
//                return false;
//            }
//            if (odd.getOdd() < 0 || odd.getOdd() > lotteryOdd.getOddLimit()) {
//                LOG.info("设置赔率格式不正确,odd:{0},上限{1}", odd.getOdd(), lotteryOdd.getOddLimit());
//                return false;
//            }

        }
        return true;
    }

    private Map<Integer, SiteLotteryOdd> getSiteLotteryOddMap(List<Integer> ids, int siteId) {
        SiteLotteryOddListVo listVo = new SiteLotteryOddListVo();
        listVo.getSearch().setIds(ids);
        listVo.getSearch().setSiteId(siteId);
        listVo.setPaging(null);
        listVo = ServiceTool.siteLotteryOddService().search(listVo);
        if (CollectionTool.isEmpty(listVo.getResult())) {
            return null;
        }
        return CollectionTool.toEntityMap(listVo.getResult(), SiteLotteryOdd.PROP_ID, Integer.class);
    }

    private Map<Integer, LotteryOdd> getLotteryOddMap(List<Integer> ids) {
        LotteryOddListVo listVo = new LotteryOddListVo();
        listVo.getSearch().setIds(ids);
        listVo.setPaging(null);
        listVo = ServiceTool.lotteryOddService().search(listVo);
        if (CollectionTool.isEmpty(listVo.getResult())) {
            return null;
        }
        return CollectionTool.toEntityMap(listVo.getResult(), LotteryOdd.PROP_ID, Integer.class);
    }
    //endregion your codes 3

}