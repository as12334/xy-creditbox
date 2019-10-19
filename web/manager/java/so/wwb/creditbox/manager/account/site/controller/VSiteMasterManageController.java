package so.wwb.creditbox.manager.account.site.controller;

import org.soul.web.controller.BaseCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.iservice.manager.sys.IVSiteMasterManageService;
import so.wwb.creditbox.manager.account.site.form.VSiteMasterManageForm;
import so.wwb.creditbox.manager.account.site.form.VSiteMasterManageSearchForm;
import so.wwb.creditbox.model.manager.site.po.VSiteMasterManage;
import so.wwb.creditbox.model.manager.site.vo.VSiteMasterManageListVo;
import so.wwb.creditbox.model.manager.site.vo.VSiteMasterManageVo;


/**
 * 站长管理控制器
 *
 * @author tom
 * @time 2015-11-17 16:57:53
 */
@Controller
//region your codes 1
@RequestMapping("/vSiteMasterManage")
public class VSiteMasterManageController extends BaseCrudController<IVSiteMasterManageService, VSiteMasterManageListVo, VSiteMasterManageVo, VSiteMasterManageSearchForm, VSiteMasterManageForm, VSiteMasterManage, Integer> {
//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/account/site/mastermanage/";
        //endregion your codes 2
    }

    //region your codes 3
    @RequestMapping("/viewBasic")
    public String viewBasic(VSiteMasterManageVo objectVo, Model model) {
        objectVo = this.doView(objectVo, model);
        model.addAttribute("command", objectVo);
        return getViewBasePath()+"ViewMasterBasic";
    }


    //endregion your codes 3

}