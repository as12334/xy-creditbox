package so.wwb.lotterybox.company.user.controller;

import org.soul.commons.lang.string.HidTool;
import org.soul.web.controller.BaseCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.company.session.SessionManager;
import so.wwb.lotterybox.company.user.form.VUserManagerForm;
import so.wwb.lotterybox.company.user.form.VUserManagerSearchForm;
import so.wwb.lotterybox.iservice.manager.user.IVUserManagerService;
import so.wwb.lotterybox.model.company.user.so.VUserDetailSo;
import so.wwb.lotterybox.model.company.user.vo.VUserDetailVo;
import so.wwb.lotterybox.model.manager.user.po.VUserManager;
import so.wwb.lotterybox.model.manager.user.so.VUserManagerSo;
import so.wwb.lotterybox.model.manager.user.vo.VUserManagerListVo;
import so.wwb.lotterybox.model.manager.user.vo.VUserManagerVo;
import so.wwb.lotterybox.web.tools.token.Token;

import java.util.Map;


/**
 * 用户管理/详细视图 - Fei  jeremy控制器
 *
 * @author block
 * @time 2019-10-16 18:58:21
 */
@Controller
//region your codes 1
@RequestMapping("/vUserManager")
public class VUserManagerController extends BaseCrudController<IVUserManagerService, VUserManagerListVo, VUserManagerVo, VUserManagerSearchForm, VUserManagerForm, VUserManager, Integer> {
//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/user/";
        //endregion your codes 2
    }

    //region your codes 3
    @RequestMapping("/createManagerUser")
    @Token(generate = true)
    public String create(VUserManagerVo objectVo, Model model) {
        VUserManagerSo search = objectVo.getSearch();
        int i = (Integer.valueOf(search.getUserType()) - 1) * HidTool.FLAG;
        search.setHidLength(i);
        search.setHid(SessionManager.getSysUserExtend().getHid());
        objectVo = ServiceTool.vUserManagerService().searchLevelUser(objectVo);
        model.addAttribute("command", objectVo);
        return getViewBasePath() + "/Edit";
    }

    @RequestMapping("/saveManagerUser")
    @Token(generate = true)
    @ResponseBody
    public Map saveUser(VUserDetailVo objectVo, Model model) {
        VUserDetailSo search = objectVo.getSearch();
        int i = (Integer.valueOf(search.getUserType())* HidTool.FLAG) ;
        search.setHidLength(i);
        search.setHid(SessionManager.getSysUserExtend().getHid());

//        ServiceTool.vUserDetailService().searchLevelUser(objectVo);
        model.addAttribute("command", objectVo);
        return this.getVoMessage(objectVo);
    }
    //endregion your codes 3

}