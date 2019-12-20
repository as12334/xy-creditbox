package so.wwb.creditbox.company.user.controller;

import org.soul.web.controller.BaseCrudController;
import so.wwb.creditbox.iservice.company.user.ICzUsersService;
import so.wwb.creditbox.model.company.user.po.CzUsers;
import so.wwb.creditbox.model.company.user.vo.CzUsersListVo;
import so.wwb.creditbox.model.company.user.vo.CzUsersVo;
import so.wwb.creditbox.company.user.form.CzUsersSearchForm;
import so.wwb.creditbox.company.user.form.CzUsersForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 控制器
 *
 * @author block
 * @time 2019-12-19 23:19:55
 */
@Controller
//region your codes 1
@RequestMapping("/czUsers")
public class CzUsersController extends BaseCrudController<ICzUsersService, CzUsersListVo, CzUsersVo, CzUsersSearchForm, CzUsersForm, CzUsers, Integer> {
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