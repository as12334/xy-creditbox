package so.wwb.creditbox.company.user.controller;

import org.soul.commons.lang.string.HidTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.web.controller.BaseCrudController;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.company.user.IVUserDetailService;
import so.wwb.creditbox.model.company.user.po.VUserDetail;
import so.wwb.creditbox.model.company.user.so.VUserDetailSo;
import so.wwb.creditbox.model.company.user.vo.VUserDetailListVo;
import so.wwb.creditbox.model.company.user.vo.VUserDetailVo;
import so.wwb.creditbox.company.user.form.VUserDetailSearchForm;
import so.wwb.creditbox.company.user.form.VUserDetailForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.model.manager.sys.vo.SysDomainVo;
import so.wwb.creditbox.model.manager.user.so.VUserManagerSo;
import so.wwb.creditbox.model.manager.user.vo.VUserManagerVo;
import so.wwb.creditbox.web.tools.CommonTool;
import so.wwb.creditbox.web.tools.token.Token;


/**
 * 用户管理/详细视图 - Fei  jeremy控制器
 *
 * @author block
 * @time 2019-10-14 20:59:17
 */
@Controller
//region your codes 1
@RequestMapping("/vUserDetail")
public class VUserDetailController extends BaseCrudController<IVUserDetailService, VUserDetailListVo, VUserDetailVo, VUserDetailSearchForm, VUserDetailForm, VUserDetail, Integer> {
//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/user/";
        //endregion your codes 2
    }

    //region your codes 3

    //endregion your codes 3

}