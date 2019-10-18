package so.wwb.lotterybox.manager.common.system.controller;

import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.web.controller.NoMappingCrudController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.iservice.manager.message.ISystemMessageService;
import so.wwb.lotterybox.manager.common.system.form.SystemMessageForm;
import so.wwb.lotterybox.manager.common.system.form.SystemMessageSearchForm;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.message.SystemMessageSendObjectEnum;
import so.wwb.lotterybox.model.enums.message.SystemMessageSendTypeEnum;
import so.wwb.lotterybox.model.manager.user.po.SysUserExtend;
import so.wwb.lotterybox.model.manager.user.vo.SysUserExtendListVo;
import so.wwb.lotterybox.model.message.po.SystemMessage;
import so.wwb.lotterybox.model.message.vo.SystemMessageListVo;
import so.wwb.lotterybox.model.message.vo.SystemMessageVo;
import so.wwb.lotterybox.web.tools.AuditAddLogTool;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeremy on 18-6-4.
 */
public class BaseSystemMessageController extends NoMappingCrudController<ISystemMessageService, SystemMessageListVo, SystemMessageVo, SystemMessageSearchForm, SystemMessageForm, SystemMessage, Integer> {
    private static final Log LOG = LogFactory.getLog(BaseSystemMessageController.class);
    protected static final String SYS_MSG_ADD = "sys.msg.add";
    protected static final String SUCCESS = "success";
    protected static final String UPDATE = "update";


    @Override
    protected String getViewBasePath() {
        return null;
    }

    protected void queryMyMessageList(SystemMessageListVo listVo, SystemMessageSearchForm form, BindingResult result, Model model,HttpServletRequest request){
        if (listVo.getSearch().getQueryStartDate() == null&&!ServletTool.isAjaxSoulRequest(request)){
            listVo.getSearch().setQueryStartDate(DateTool.addDays(SessionManagerCommon.getDate().getTomorrow(),-3));
        }
        if (listVo.getSearch().getQueryEndDate() == null&&!ServletTool.isAjaxSoulRequest(request)){
            listVo.getSearch().setQueryEndDate(SessionManagerCommon.getDate().getTomorrow());
        }
        if (StringTool.equals(SubSysCodeEnum.BOSS.getCode(),SessionManagerCommon.getSubsysCode())){
            listVo = super.doList(listVo,form,result,model);
        }else {
            listVo.getSearch().setReceiverUserId(SessionManagerCommon.getUserId());
            List<SystemMessage> messages = this.getService().queryMyMessageList(listVo);
            listVo.setResult(messages);
            listVo.getPaging().setTotalCount(this.getService().myMessageTotalCount(listVo));
            listVo.getPaging().cal();
        }
        model.addAttribute("command",listVo);
    }


    protected void addAuditLog(SystemMessageVo messageVo, HttpServletRequest request, String msgKey) {
        try {
            if (messageVo.isSuccess()) {
                String sendType = messageVo.getSearch().getSendType();
                String sendObject = "";
                if (StringTool.isNotBlank(messageVo.getSearch().getShareholder())) {
                    sendObject += AuditAddLogTool.installEnumMsg(SystemMessageSendObjectEnum.class, messageVo.getSearch().getShareholder()) + ";";

                }
                if (StringTool.isNotBlank(messageVo.getSearch().getMerchant())) {
                    sendObject += AuditAddLogTool.installEnumMsg(SystemMessageSendObjectEnum.class, messageVo.getSearch().getMerchant()) + ";";

                }
                if (StringTool.isNotBlank(messageVo.getSearch().getAgent())) {
                    sendObject += AuditAddLogTool.installEnumMsg(SystemMessageSendObjectEnum.class, messageVo.getSearch().getAgent()) + ";";

                }
                List<String> params = new ArrayList<>();
                params.add(messageVo.getResult().getTitle());
                params.add(sendObject);
                params.add(AuditAddLogTool.installEnumMsg(SystemMessageSendTypeEnum.class, sendType));
                AuditAddLogTool.addLog(request, msgKey, params);
            }
        } catch (Exception e) {
            LOG.error("保存审计日志出错{0}", e.getMessage());
        }
    }

    protected Map<String,List<Map<String,Object>>> splitUserInfo(List<SysUserExtendListVo> sysList){
        Map<String,List<Map<String,Object>>> resultMap = new HashMap<>();
        for (SysUserExtendListVo listVo : sysList){
            List<Map<String,Object>> oneList = new ArrayList<>();
            for (SysUserExtend userExtend : listVo.getResult()){
                Map<String, Object> map = new HashMap<>();
                map.put("id",userExtend.getId());
//                map.put("userName",userExtend.getCode() + "(" + userExtend.getUsername() + ")");
                map.put("siteId",userExtend.getSiteId());
                oneList.add(map);
            }
            if(SubSysCodeEnum.COMPANY.getCode().equals(listVo.getSearch().getSubsysCode())){
                resultMap.put("merchantApi",oneList);
            }else if(SubSysCodeEnum.DISTRIBUTOR.getCode().equals(listVo.getSearch().getSubsysCode())){
                resultMap.put("distributorApi",oneList);
            }else{
                resultMap.put(listVo.getSearch().getSubsysCode(),oneList);
            }

        }
        return resultMap;
    }

    protected List<SysUserExtendListVo> querySysUserByType(SysUserExtendListVo sysListVo, SystemMessageVo messageVo){
        List<SysUserExtendListVo> resultList = new ArrayList<>();
        sysListVo.setPaging(null);
        if(SystemMessageSendObjectEnum.TO_SHAREHOLDER.getCode().equals(messageVo.getSearch().getShareholder())){//获取所有的股东
            sysListVo.getSearch().setSubsysCode(SubSysCodeEnum.SHAREHOLDER.getCode());
            resultList.add(ServiceTool.sysUserExtendService().search(sysListVo));
        }

        if(SystemMessageSendObjectEnum.TO_MERCHANT.getCode().equals(messageVo.getSearch().getMerchant())){//获取所有的商户
            sysListVo.getSearch().setSubsysCode(SubSysCodeEnum.COMPANY.getCode());
            resultList.add(ServiceTool.sysUserExtendService().search(sysListVo));
        }

        if(SystemMessageSendObjectEnum.TO_DISTRIBUTOR.getCode().equals(messageVo.getSearch().getAgent())){//获取所有总代
            sysListVo.getSearch().setSubsysCode(SubSysCodeEnum.DISTRIBUTOR.getCode());
            resultList.add(ServiceTool.sysUserExtendService().search(sysListVo));
        }

        if(SystemMessageSendObjectEnum.TO_MERCHANT_API.getCode().equals(messageVo.getSearch().getMerchantApi())){//获取所有的商户api
            sysListVo.getSearch().setSubsysCode(SubSysCodeEnum.COMPANY.getCode());
            resultList.add(ServiceTool.sysUserExtendService().search(sysListVo));
        }

        if(SystemMessageSendObjectEnum.TO_DISTRIBUTOR_API.getCode().equals(messageVo.getSearch().getAgentApi())){//获取所有的总代api
            sysListVo.getSearch().setSubsysCode(SubSysCodeEnum.DISTRIBUTOR.getCode());
            resultList.add(ServiceTool.sysUserExtendService().search(sysListVo));
        }
        return resultList;
    }

}
