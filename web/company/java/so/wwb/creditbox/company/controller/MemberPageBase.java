package so.wwb.creditbox.company.controller;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.Const;
import org.soul.commons.lang.string.StringTool;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestParam;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.model.enums.lottery.UTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.po.UserBean;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.model.message.vo.Message;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.SysParamTool;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.regex.Pattern;

/**
 * Created by block on 2019/12/26.
 */
public class MemberPageBase {
    protected String getUserNameExist(String username) {
        if(StringTool.isNotBlank(username)){
            SysUserExtendVo objectVo = new SysUserExtendVo();
            objectVo.setResult(new SysUserExtend());
            objectVo.getResult().setUsername(username +"@%");
            objectVo.setDataSourceId(SessionManagerCommon.getSiteId());
            boolean site = SysParamTool.checkManageUsername(objectVo);
            objectVo.setDataSourceId(Const.BOSS_DATASOURCE_ID);
            boolean manager = SysParamTool.checkManageUsername(objectVo);
            if(site && manager){
                return "0";
            }
            else {
                return "1";
            }
        }else {
            return "2";
        }
    }
    public void Permission_Aspx_ZJ(String perName,HttpServletResponse response) throws IOException {
        SysUserExtend model = SessionManagerCommon.getSysUserExtend();
        if ((model.getUtype().toLowerCase().equals("zj") && (model.getSessionUserChild() != null)) && (model.getSessionUserChild().getPermissionsName().indexOf(perName) < 0))
        {
            response.sendRedirect("../MessagePage.aspx?code=u100057&url=&issuccess=1&isback=0");
        }
    }

    protected Boolean ValidParamByUserAdd(UserBean bean,String utype, String message, String six, String kc) {
        UTypeEnum uTypeEnum = EnumTool.enumOf(UTypeEnum.class, utype);
        if(uTypeEnum == null){
            //用戶類型不正確
            return false;
        }

        if (StringTool.isBlank(bean.getUserName()))
        {
//          "帳號 不能為空！";
            return false;
        }
        //判斷用戶是否存在
        if(!getUserNameExist(bean.getUserName()).equals("0")){
//            "帳號已存在";
            return false;
        }
        else if(bean.getUserName().trim().length() < 6 || bean.getUserName().trim().length() > 12){

//          帳號 最小長度必須6-12位！
            return false;
        }
        else if(!Pattern.matches(RegexConst.ACCOUNT, bean.getUserName())){
//           帳號必須包含字母和數字，支持‘_’，但開頭和結尾不能用‘_’！
            return false;
        }
        else if(StringTool.isBlank(bean.getUserPassword())){
            message = "密碼 不能為空！";
            return false;
        }
        else if(bean.getUserPassword().trim().length() < 8 || bean.getUserPassword().trim().length() > 20){
            message = "密碼 最小長度必須 8位 或以上（最長20位）！";
            return false;
        }

        if(!StringTool.isBlank(six)){
            return ValidParamByUserAdd_six(bean,uTypeEnum,message);
        }else {
            return ValidParamByUserAdd_kc(bean,uTypeEnum,message);
        }
    }

    protected Boolean ValidParamByUserAdd_six(UserBean bean,UTypeEnum uTypeEnum, String message) {

        if (StringTool.isBlank(bean.getUserCredit_six().trim())) {
            message = "⑥合彩: 信用額度 請務必輸入！";
            return false;
        }
        try {
            if (Integer.parseInt(bean.getUserCredit_six().trim()) < 0) {
                message = "⑥合彩:信用額度 必須大於等於0";
                return false;
            }
        } catch (Exception e) {
            message = "⑥合彩:信用額度 只能為數字！";
            return false;
        }
        if (StringTool.isBlank(bean.getUserRate_six().trim()))

        {
            message = "⑥合彩:上級成數 不能為空！";
            return false;
        }
        try {
            int num2 = Integer.parseInt(bean.getUserRate_six().trim());
            //TODO 最低占成
            if (num2 < 0) {
                message = MessageFormat.format("⑥合彩:上級成數 不能小於{0}%", 0);
                return false;
            }
            if (num2 > 100) {
                message = "⑥合彩:上級占成 不能大于100%！";
                return false;
            }
        } catch (Exception e) {
            message = "⑥合彩:上級成數 只能數字！";
            return false;
        }


        return true;
    }
    protected Boolean ValidParamByUserAdd_kc(UserBean bean,UTypeEnum uTypeEnum, String message) {
        if (StringTool.isBlank(bean.getUserCredit_kc().trim())) {
            message = "⑥合彩: 信用額度 請務必輸入！";
            return false;
        }
        try {
            if (Integer.parseInt(bean.getUserCredit_kc().trim()) < 0) {
                message = "⑥合彩:信用額度 必須大於等於0";
                return false;
            }
        } catch (Exception e) {
            message = "⑥合彩:信用額度 只能為數字！";
            return false;
        }
        if (StringTool.isBlank(bean.getUserRate_kc().trim()))

        {
            message = "⑥合彩:上級成數 不能為空！";
            return false;
        }
        try {
            int num2 = Integer.parseInt(bean.getUserRate_kc().trim());
            //TODO 最低占成
            if (num2 < 0) {
                message = MessageFormat.format("⑥合彩:總監成數 不能小於{0}%", 0);
                return false;
            }
            if (num2 > 100) {
                message = "⑥合彩:上級占成 不能大于100%！";
                return false;
            }
        } catch (Exception e) {
            message = "⑥合彩:上級成數 只能數字！";
            return false;
        }
        return true;
    }
}
