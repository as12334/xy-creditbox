package so.wwb.creditbox.company.lottery.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.log.audit.enums.OpType;
import org.soul.web.controller.BaseCrudController;
import org.soul.web.session.SessionManagerBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.lottery.form.SiteLotteryOddsForm;
import so.wwb.creditbox.company.lottery.form.SiteLotteryOddsSearchForm;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;
import so.wwb.creditbox.iservice.manager.lottery.ISiteLotteryOddsService;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdds;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdds;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.vo.*;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
@Controller
//region your codes 1
@RequestMapping("/siteLotteryOdds")
public class SiteLotteryOddsController extends BaseCrudController<ISiteLotteryOddsService, SiteLotteryOddsListVo, SiteLotteryOddsVo, SiteLotteryOddsSearchForm, SiteLotteryOddsForm, SiteLotteryOdds, Integer> {
    private static final Log LOG = LogFactory.getLog(SiteLotteryOddsController.class);

//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/lottery/";
        //endregion your codes 2
    }

    //region your codes 3
    @RequestMapping("/set/{code}")
    @Token(generate = true)
    public String createUser4(@PathVariable("code") String code,SiteLotteryOddsVo vo, Model model) {
        vo.getSearch().setCode(code);
        vo.getSearch().setSiteId(SessionManagerBase.getSiteId());
        vo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        vo = this.getService().initData(vo);
        model.addAttribute("command",vo);
        return this.getViewBasePath()+code;
    }

    @Audit(module = Module.LOTTERY, moduleType = ModuleType.LOTTERY_ODD, opType = OpType.UPDATE)
    @RequestMapping(value = "/saveSiteLotteryOdds", method = RequestMethod.POST)
    @ResponseBody
    public Map saveSiteLotteryOdds(HttpServletRequest request, SiteLotteryOddsVo siteLotteryOddsVo) {


        siteLotteryOddsVo.getSearch().setSiteId(LotteryCommonContext.get().getSiteId());
        siteLotteryOddsVo.getSearch().setHid(LotteryCommonContext.get().getDomainUserHid());
        siteLotteryOddsVo = this.getService().saveSiteLotteryOdds(siteLotteryOddsVo);


//        if (StringTool.isBlank(siteLotteryOddsVo.getLotteryOddsJson())) {
//            return getVoMessage(siteLotteryOddsVo);
//        }
//        JSONArray arr = null;
//        try {
//            arr = JSONObject.parseArray(siteLotteryOddsVo.getLotteryOddsJson());
//        } catch (Exception e) {
//            LOG.error("提交赔率格式有问题，转换出错！{0}", siteLotteryOddsVo.getLotteryOddsJson());
//            siteLotteryOddsVo.setSuccess(false);
//            return getVoMessage(siteLotteryOddsVo);
//        }
//
//        if (arr != null && arr.size() > 0) {
//            int siteId = arr.getJSONObject(0).getInteger("siteId");
//            //company赔率
//            if (siteId == 0) {
//                LotteryOddsVo vo = new LotteryOddsVo();
////                vo.setProperties(LotteryOdds.PROP_ODD, LotteryOdds.PROP_REBATE);
//                List<LotteryOdds> uplist = new ArrayList<>();
//                List<Integer> ids = new ArrayList<>();
//                for (int i = 0; i < arr.size(); i++) {
//                    JSONObject obj = arr.getJSONObject(i);
//                    if (obj != null) {
//                        LotteryOdds o = new LotteryOdds();
//                        int id = obj.getInteger("id");
//                        o.setId(id);
////                        o.setOdd(obj.getDouble("odd"));
//                        uplist.add(o);
//                        ids.add(id);
//                    }
//                }
//                if (!checkCompanyOdd(ids, uplist)) {
//                    LOG.info("保存彩票赔率值有误!");
//                    vo.setSuccess(false);
//                    return getVoMessage(vo);
//                }
//                if (CollectionTool.isNotEmpty(uplist)) {
//                    vo.setEntities(uplist);
//                    ServiceTool.lotteryOddsService().batchUpdateOnly(vo);
////                    Cache.refreshLotteryOdds();
//                }
//                return getVoMessage(vo);
//            }
//
//            SiteLotteryOdds odd = new SiteLotteryOdds();
//            odd.setSiteId(siteId);
////            if (ServiceTool.siteLotteryOddsService().getOddBySiteId(odd) == null) {
////                siteLotteryOddsVo.setSuccess(false);
////                return getVoMessage(siteLotteryOddsVo);
////            }
//
////            siteLotteryOddsVo.setProperties(SiteLotteryOdds.PROP_ODD, SiteLotteryOdds.PROP_REBATE);
//            List<SiteLotteryOdds> updateOdds = new ArrayList<>();
//            List<Integer> ids = new ArrayList<>();
//            List<String> changeOdd = new ArrayList<>();
//            for (int i = 0; i < arr.size(); i++) {
//                JSONObject obj = arr.getJSONObject(i);
//                if (obj != null) {
//                    SiteLotteryOdds so = new SiteLotteryOdds();
//                    int id = obj.getInteger("id");
//                    so.setId(id);
//                    so.setSiteId(obj.getInteger("siteId"));
////                    so.setOdd(obj.getDouble("odd"));
////                    so.setRebate(obj.getDouble("rebate"));
////                    so.setBaseNum(obj.getDouble("baseNum"));
//                    updateOdds.add(so);
//                    ids.add(id);
//                    changeOdd.add("</br>" + obj.getString("code") + "-" + obj.getString("betCode") + "-" + obj.getString("betNum") + ":"
//                            + "oldLotteryOdds=" + obj.getDouble("oldOdd") + ";newLotteryOld=" + obj.getDouble("odd") +
//                            "oldLotteryRebate=" + obj.getDouble("oldRebate") + ";newLotteryRebate=" + obj.getDouble("rebate"));
//                }
//            }
////            if (!checkOdd(ids, updateOdds, siteId)) {
////                LOG.info("保存彩票赔率值有误!");
////                siteLotteryOddsVo.setSuccess(false);
////                return getVoMessage(siteLotteryOddsVo);
////            }
//            if (CollectionTool.isNotEmpty(updateOdds)) {
//                siteLotteryOddsVo.setEntities(updateOdds);
//                ServiceTool.siteLotteryOddsService().batchUpdateOnly(siteLotteryOddsVo);
//                Cache.refreshSiteLotteryOdds(siteId);
//                //审计日志添加
//                List<String> params = new ArrayList<>();
//                params.add(Integer.valueOf(siteId).toString());
//                params.add(SessionManager.getUserName());
//                params.add(changeOdd.toString());
//                if (changeOdd.toString().length() < 2048) {
////                    addLog(request, AUDIT_LOTTERY_ODD, params);
//                }
//            }
//        }
        return getVoMessage(siteLotteryOddsVo);

    }
    private boolean checkCompanyOdd(List<Integer> ids, List<LotteryOdds> updateOdds) {
        Map<Integer, LotteryOdds> lotteryOddMap = getLotteryOddsMap(ids);
        if (lotteryOddMap == null) {
            return false;
        }
        LotteryOdds lotteryOdd;
        for (LotteryOdds odd : updateOdds) {
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
    private Map<Integer, LotteryOdds> getLotteryOddsMap(List<Integer> ids) {
        LotteryOddsListVo listVo = new LotteryOddsListVo();
//        listVo.getSearch().setIds(ids);
        listVo.setPaging(null);
        listVo = ServiceTool.lotteryOddsService().search(listVo);
        if (CollectionTool.isEmpty(listVo.getResult())) {
            return null;
        }
        return CollectionTool.toEntityMap(listVo.getResult(), LotteryOdds.PROP_ID, Integer.class);
    }
    //endregion your codes 3

}