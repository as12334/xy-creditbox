package so.wwb.lotterybox.manager.common.system.controller;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.web.controller.NoMappingCrudController;
import org.springframework.ui.Model;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.iservice.manager.message.ISystemAnnouncementService;
import so.wwb.lotterybox.manager.common.system.form.SystemAnnouncementForm;
import so.wwb.lotterybox.manager.common.system.form.SystemAnnouncementSearchForm;
import so.wwb.lotterybox.manager.session.SessionManager;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.message.SystemAnnouncementStatusEnum;
import so.wwb.lotterybox.model.manager.site.po.SiteLanguage;
import so.wwb.lotterybox.model.manager.site.vo.SiteLanguageListVo;
import so.wwb.lotterybox.model.message.po.SystemAnnouncement;
import so.wwb.lotterybox.model.message.vo.SystemAnnouncementListVo;
import so.wwb.lotterybox.model.message.vo.SystemAnnouncementVo;
import so.wwb.lotterybox.web.tools.AuditAddLogTool;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremy on 18-6-4.
 */
public class BaseSystemAnnouncementController extends NoMappingCrudController<ISystemAnnouncementService, SystemAnnouncementListVo, SystemAnnouncementVo, SystemAnnouncementSearchForm, SystemAnnouncementForm, SystemAnnouncement, Integer> {
    private static final Log LOG = LogFactory.getLog(BaseSystemAnnouncementController.class);

    protected static final String SUCCESS = "success";
    protected static final String UPDATE = "update";
    protected static final String SYS_ANN_ADD = "sys.ann.add";
    protected static final String SYS_ANN_UPDATE = "sys.ann.update";
    protected static final String SYS_ANN_DELETE = "sys.ann.delete";

    @Override
    protected String getViewBasePath() {
        return null;
    }

    protected void queryAnnData(SystemAnnouncementListVo listVo, Model model, HttpServletRequest request){
        setQueryParams(listVo,request);
        List<SystemAnnouncement> list = ServiceTool.sysAnnouncementService().querySystemAnnouncementList(listVo);
        listVo.setResult(list);
        listVo.getPaging().setTotalCount(ServiceTool.sysAnnouncementService().queryAnnTotalCount(listVo));
        listVo.getPaging().cal();
        model.addAttribute("allStatus", EnumTool.getEnumList(SystemAnnouncementStatusEnum.class));
        model.addAttribute("command",listVo);
    }

    protected void setQueryParams(SystemAnnouncementListVo listVo, HttpServletRequest request){
        String subsysCode = SessionManager.getSysUserExtend().getSubsysCode();
        //默认查询最近3天的数据
        if (listVo.getSearch().getQueryStartDate() == null &&
                listVo.getSearch().getQueryEndDate() == null &&
                !ServletTool.isAjaxSoulRequest(request)) {
            listVo.getSearch().setQueryStartDate(DateTool.addDays(SessionManagerCommon.getDate().getTomorrow(), -3));
            listVo.getSearch().setQueryEndDate(SessionManagerCommon.getDate().getTomorrow());
        }
        //默认语言为用户语言
        if (StringTool.isBlank(listVo.getSearch().getQueryLanguage())){
            listVo.getSearch().setQueryLanguage(SessionManagerCommon.getSysUserExtend().getDefaultLocale());
        }
        //不是总控的只能看到正常状态的公告；总控公告首页默认展示正常状态的公告；总控下拉框选择时不限制
        boolean isBoss = StringTool.equals(SubSysCodeEnum.BOSS.getCode(),subsysCode);
        boolean isSoulAjax = ServletTool.isAjaxSoulRequest(request);
        if (!isBoss || (isBoss && !isSoulAjax)){
            listVo.getSearch().setQueryStatus(SystemAnnouncementStatusEnum.NORMAL.getCode());
        }
    }

//    protected List<SiteLanguage> getSiteLanguageList(){
//        SiteLanguageListVo siteLanguageListVo = new SiteLanguageListVo();
//        siteLanguageListVo.getSearch().setSiteId(SessionManager.getUser().getSiteId());
//        return  ServiceTool.siteLanguageService().availableLanguage(siteLanguageListVo);
//    }


    protected void addAuditLog(SystemAnnouncementVo vo, HttpServletRequest request, String msgKey){
        try {
            if (vo.isSuccess()){
                if (StringTool.equals(SYS_ANN_DELETE,msgKey)){
                    vo = this.getService().get(vo);
                }
                List<String> params = new ArrayList<>();
                String username = "";
                if (StringTool.equals(SYS_ANN_ADD,msgKey)){
                    username = vo.getResult().getCreateUsername();
                }
                if (StringTool.equals(SYS_ANN_UPDATE,msgKey)){
                    username = vo.getResult().getUpdateUsername();
                }
                params.add(username);
                params.add(StringTool.equals(SystemAnnouncementStatusEnum.NORMAL.getCode(),vo.getResult().getStatus())?"正常":"删除");
                AuditAddLogTool.addLog(request, msgKey, params);
            }
        }catch (Exception e){
            LOG.error("保存审计日志出错{0}",e.getMessage());
        }
    }
}
