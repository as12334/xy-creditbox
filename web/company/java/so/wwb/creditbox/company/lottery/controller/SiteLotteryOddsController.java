package so.wwb.creditbox.company.lottery.controller;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.model.log.audit.enums.OpType;
import org.soul.web.controller.BaseCrudController;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.validation.form.js.JsRuleCreator;
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
import so.wwb.creditbox.iservice.company.lottery.ISiteLotteryOddsService;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdds;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.manager.lottery.vo.*;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        return "/lottery/odd/";
        //endregion your codes 2
    }

    //region your codes 3
    @RequestMapping("/set/{code}")
    @Token(generate = true)
    public String editOdds(@PathVariable("code") String code,SiteLotteryOddsVo vo, Model model , HttpServletRequest request, HttpServletResponse response) {
        vo.getSearch().setCode(code);
        vo.getSearch().setSiteId(SessionManagerBase.getSiteId());
//        vo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        vo._setDataSourceId(SessionManagerBase.getSiteId());
        vo = this.getService().initOddsData(vo);
        vo.setValidateRule(JsRuleCreator.create(SiteLotteryOddsForm.class));
        model.addAttribute("command",vo);
        if(ServletTool.isAjaxSoulRequest(request)) {
            return this.getViewBasePath() + "OddEditPartial";
        } else {
            return this.getViewBasePath() + "OddEdit";
        }
    }

    @Audit(module = Module.LOTTERY, moduleType = ModuleType.LOTTERY_ODD, opType = OpType.UPDATE)
    @RequestMapping(value = "/saveSiteLotteryOdds", method = RequestMethod.POST)
    @ResponseBody
    public Map saveSiteLotteryOdds(HttpServletRequest request, SiteLotteryOddsVo siteLotteryOddsVo) {

        siteLotteryOddsVo._setDataSourceId(SessionManagerBase.getSiteId());
        siteLotteryOddsVo.getSearch().setSiteId(LotteryCommonContext.get().getSiteId());
        siteLotteryOddsVo.getSearch().setHid(LotteryCommonContext.get().getDomainUserHid());
        siteLotteryOddsVo = this.getService().saveSiteLotteryOdds(siteLotteryOddsVo);
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