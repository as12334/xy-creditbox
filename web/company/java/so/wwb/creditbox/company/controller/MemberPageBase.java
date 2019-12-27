package so.wwb.creditbox.company.controller;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.Const;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.model.enums.lottery.UTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.po.UserBean;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.SysParamTool;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.regex.Pattern;

import static org.jsoup.nodes.Entities.EscapeMode.base;

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

//    protected Boolean ValidParamByUserAdd(UserBean bean,String utype, String message, String six, String kc) {
//
//        String str = utype.toLowerCase();
//        UTypeEnum uTypeEnum = EnumTool.enumOf(UTypeEnum.class, str);
//        if (StringTool.isBlank(str)) {
//            message = "用戶類型不正確！";
//            return false;
//        }
//
//        if (StringTool.isBlank(bean.getUserName())) {
//            message = "帳號 不能為空！";
//            return false;
//        }
//        if ((bean.getUserPassword().length() < 6) || (bean.getUserPassword().length() > 12)) {
//            message = "帳號 最小長度必須6-12位！";
//            return false;
//        }
//        if (!Pattern.matches(RegexConst.ACCOUNT, bean.getUserName())) {
//            message = "帳號必須包含字母和數字，支持‘_’，但開頭和結尾不能用‘_’！";
//            return false;
//        }
//        if (StringTool.isBlank(bean.getUserPassword())) {
//            message = "密碼 不能為空！";
//            return false;
//        }
//        if ((bean.getUserPassword().length() < 8) || (bean.getUserPassword().length() > 20)) {
//            message = "密碼 最小長度必須 8位 或以上（最長20位）！";
//            return false;
//        }
//
//        String userNameExist = getUserNameExist(bean.getUserName());
//        if(!userNameExist.equals("0")){
//            message = "账号已存在";
//            return false;
//        }
//
//        if (!StringTool.isBlank(six)) {
//            if (StringTool.isBlank(bean.getUserCredit_six())) {
//                message = "⑥合彩: 信用額度 請務必輸入！";
//                return false;
//            }
//            try {
//                if (Integer.parseInt(bean.getUserCredit_six()) < 0) {
//                    message = "⑥合彩:信用額度 必須大於等於0";
//                    return false;
//                }
//            } catch (Exception e) {
//                message = "⑥合彩:信用額度 只能為數字！";
//                return false;
//            }
//        }else {
//            try {
//                if (Integer.parseInt(bean.getUserCredit_kc()) < 0) {
//                    message = "快彩:信用額度 必須大於等於0";
//                    return false;
//                }
//            } catch (Exception e) {
//                message = "快彩: 信用額度 只能為數字！";
//                return false;
//            }
//
//        }
//
//        Boolean flag = true;
//        if (uTypeEnum == UTypeEnum.FGS) {
//
//            flag = true;
//            if (!StringTool.isBlank(six)) {
//                if (StringTool.isBlank(bean.getUserRate_six())) {
//                    message = "⑥合彩:總監成數 不能為空！";
//                    return false;
//                }
//                try {
//                    int num2 = Integer.parseInt(bean.getUserRate_six());
//                    /// TODO: 2019/12/27  总监设置的最小占成数
//                    if (num2 < 0) {
//                        message = MessageFormat.format("⑥合彩:總監成數 不能小於{0}%", 0);
//                        return false;
//                    }
//                    if (num2 > 100) {
//                        message = "⑥合彩:總監占成 不能大于100%！";
//                        return false;
//                    }
//                    flag = true;
//                } catch (Exception e) {
//                    message = "⑥合彩:總監成數 只能數字！";
//                    return false;
//                }
//            }
//            if (StringTool.isBlank(bean.getUserCredit_kc())) {
//                message = "快彩:信用額度 請務必輸入！";
//                return false;
//            }
//            try {
//                if (Integer.parseInt(bean.getUserCredit_kc()) < 0) {
//                    message = "快彩:信用額度 必須大於等於0";
//                    return false;
//                }
//            } catch (Exception e) {
//                message = "快彩:信用額度 只能為數字！";
//                return false;
//            }
//            if (StringTool.isBlank(bean.getUserRate_kc())) {
//                message = "快彩:總監成數 不能為空！";
//                return false;
//            }
//            try {
//                int num4 = Integer.parseInt(bean.getUserRate_kc());
//                if (num4 < Integer.parseInt(base.get_ZJMinRate_KC())) {
//                    message = MessageFormat.format("快彩:總監成數 不能小於{0}%", base.get_ZJMinRate_KC());
//                    return false;
//                }
//                if (num4 > 100) {
//                    message = "快彩:總監占成 不能大于100%！";
//                    return false;
//                }
//                flag = true;
//            } catch (Exception e) {
//                message = "快彩:總監成數 只能數字！";
//                return false;
//            }
//        }
//        if (str.equals("gd")) {
//            if (StringTool.isBlank(bean.getSltupuser())) {
//                message = "上級分公司 不能為空！";
//                return false;
//            }
//            flag = true;
//            if (!StringTool.isBlank(six)) {
//                if (StringTool.isBlank(bean.getUserCredit_six())) {
//                    message = "⑥合彩: 信用額度 請務必輸入！";
//                    return false;
//                }
//                if (StringTool.isBlank(bean.getUserRate_six())) {
//                    message = "⑥合彩: 分公司成數 不能為空！";
//                    return false;
//                }
//                try {
//                    if (Integer.parseInt(bean.getUserRate_six()) > 100) {
//                        message = "⑥合彩: 分公司占成 不能大于100%！";
//                        return false;
//                    }
//                    flag = true;
//                } catch (Exception e) {
//                    message = "⑥合彩: 分公司成數 只能為數字！";
//                    return false;
//                }
//            }
//            if (StringTool.isBlank(bean.getUserCredit_kc())) {
//                message = "快彩: 信用額度 請務必輸入！";
//                return false;
//            }
//            if (StringTool.isBlank(bean.getUserRate_kc())) {
//                message = "快彩: 分公司成數 不能為空！";
//                return false;
//            }
//            try {
//                if (Integer.parseInt(bean.getUserRate_kc()) > 100) {
//                    message = "快彩: 分公司占成 不能大于100%！";
//                    return false;
//                }
//                flag = true;
//            } catch (Exception e) {
//                message = "快彩: 分公司成數 只能為數字！";
//                return false;
//            }
//        }
//        if (str.equals("zd")) {
//            if (StringTool.isBlank(bean.getSltupuser())) {
//                message = "上級分股東 不能為空！";
//                return false;
//            }
//            flag = true;
//            if (!StringTool.isBlank(six)) {
//                if (StringTool.isBlank(bean.getUserCredit_six())) {
//                    message = "⑥合彩: 信用額度 請務必輸入！";
//                    return false;
//                }
//                if (StringTool.isBlank(bean.getUserRate_six())) {
//                    message = "⑥合彩: 股東成數 不能為空！";
//                    return false;
//                }
//                try {
//                    if (Integer.parseInt(bean.getUserRate_six()) > 100) {
//                        message = "⑥合彩: 股東占成 不能大于100%！";
//                        return false;
//                    }
//                    flag = true;
//                } catch (Exception e) {
//                    message = "⑥合彩: 股東成數 只能為數字！";
//                    return false;
//                }
//            }
//            if (StringTool.isBlank(bean.getUserCredit_kc())) {
//                message = "快彩: 信用額度 請務必輸入！";
//                return false;
//            }
//            if (StringTool.isBlank(bean.getUserRate_kc())) {
//                message = "快彩: 股東成數 不能為空！";
//                return false;
//            }
//            try {
//                if (Integer.parseInt(bean.getUserRate_kc()) > 100) {
//                    message = "快彩: 股東占成 不能大于100%！";
//                    return false;
//                }
//                flag = true;
//            } catch (Exception e) {
//                message = "快彩: 股東成數 只能為數字！";
//                return false;
//            }
//        }
//        if (str.equals("dl")) {
//            if (StringTool.isBlank(bean.getSltupuser())) {
//                message = "上級總代 不能為空！";
//                return false;
//            }
//            if (!bean.getSltlimithy().toLowerCase().equals("0") && !bean.getSltlimithy().toLowerCase().equals("1")) {
//                message = "代理下綫人數上限 錯誤！";
//                return false;
//            }
//            if (bean.getSltlimithy().equals("1")) {
//                if (StringTool.isBlank(bean.getTxtlimithy().toLowerCase())) {
//                    message = "代理下綫人數 不能為空！";
//                    return false;
//                }
//                try {
//                    if (Integer.parseInt(bean.getTxtlimithy().toLowerCase()) <= 0) {
//                        message = "代理下綫人數 必須大於\"0\"！";
//                        return false;
//                    }
//                } catch (Exception e) {
//                    message = "代理下綫人數 只能為數字！";
//                    return false;
//                }
//            }
//            flag = true;
//            if (!StringTool.isBlank(six)) {
//                if (StringTool.isBlank(bean.getUserCredit_six())) {
//                    message = "⑥合彩: 信用額度 請務必輸入！";
//                    return false;
//                }
//                if (StringTool.isBlank(bean.getUserRate_six())) {
//                    message = "⑥合彩: 總代成數 不能為空！";
//                    return false;
//                }
//                try {
//                    if (Integer.parseInt(bean.getUserRate_six()) > 100) {
//                        message = "⑥合彩: 總代占成 不能大于100%！";
//                        return false;
//                    }
//                    flag = true;
//                } catch (Exception e) {
//                    message = "⑥合彩: 總代成數 只能為數字！";
//                    return false;
//                }
//            }
//            if (StringTool.isBlank(bean.getUserCredit_kc())) {
//                message = "快彩: 信用額度 請務必輸入！";
//                return false;
//            }
//            if (StringTool.isBlank(bean.getUserRate_kc())) {
//                message = "快彩: 總代成數 不能為空！";
//                return false;
//            }
//            try {
//                if (Integer.parseInt(bean.getUserRate_kc()) > 100) {
//                    message = "快彩: 總代占成 不能大于100%！";
//                    return false;
//                }
//                flag = true;
//            } catch (Exception e) {
//                message = "快彩: 總代成數 只能為數字！";
//                return false;
//            }
//        }
//        if (str.equals("hy")) {
//            if (StringTool.isBlank(bean.getSltupuser())) {
//                message = "上級代理 不能為空！";
//                return false;
//            }
//            flag = true;
//            if (!StringTool.isBlank(six)) {
//                if (StringTool.isBlank(bean.getUserCredit_six())) {
//                    message = "⑥合彩: 信用額度 請務必輸入！";
//                    return false;
//                }
//                if (StringTool.isBlank(bean.getUserRate_six())) {
//                    message = "⑥合彩: 代理成數 不能為空！";
//                    return false;
//                }
//                try {
//                    if (Integer.parseInt(bean.getUserRate_six()) > 100) {
//                        message = "⑥合彩: 代理占成 不能大于100%！";
//                        return false;
//                    }
//                    flag = true;
//                } catch (Exception e) {
//                    message = "⑥合彩: 代理成數 只能為數字！";
//                    return false;
//                }
//            }
//            if (StringTool.isBlank(bean.getUserCredit_kc())) {
//                message = "快彩: 信用額度 請務必輸入！";
//                return false;
//            }
//            if (StringTool.isBlank(bean.getUserRate_kc())) {
//                message = "快彩: 代理成數 不能為空！";
//                return false;
//            }
//            try {
//                if (Integer.parseInt(bean.getUserRate_kc()) > 100) {
//                    message = "快彩: 代理占成 不能大于100%！";
//                    return false;
//                }
//                flag = true;
//            } catch (Exception e) {
//                message = "快彩: 代理成數 只能為數字！";
//                return false;
//            }
//        }
//        if (str.equals("hydu")) {
//            if (StringTool.isBlank(bean.getRdoutype())) {
//                message = "直屬上級 不能為空！";
//                return false;
//            }
//            String str2 = "";
//            String str3 = bean.getRdoutype();
//            if (str3 != null) {
//                if (!(str3 == "fgs")) {
//                    if (str3 == "gd") {
//                        str2 = "股東";
//                    } else if (str3 == "zd") {
//                        str2 = "總代";
//                    }
//                } else {
//                    str2 = "分公司";
//                }
//            }
//            if (StringTool.isBlank(bean.getSltupuser())) {
//                message = MessageFormat.format("上級{0} 不能為空！", str2);
//                return false;
//            }
//            flag = true;
//            if (!StringTool.isBlank(six)) {
//                if (StringTool.isBlank(bean.getUserCredit_six())) {
//                    message = "⑥合彩: 信用額度 請務必輸入！";
//                    return false;
//                }
//                try {
//                    if (Integer.parseInt(bean.getUserCredit_six()) < 0) {
//                        message = "⑥合彩:信用額度 必須大於等於0";
//                        return false;
//                    }
//                } catch (Exception e) {
//                    message = "⑥合彩: 信用額度 只能為數字！";
//                    return false;
//                }
//                if (StringTool.isBlank(bean.getUserRate_six())) {
//                    message = MessageFormat.format("⑥合彩: {0}成數 不能為空！", str2);
//                    return false;
//                }
//                try {
//                    if (Integer.parseInt(bean.getUserRate_six()) > 100) {
//                        message = MessageFormat.format("⑥合彩: {0}占成 不能大于100%！", str2);
//                        return false;
//                    }
//                    flag = true;
//                } catch (Exception e) {
//                    message = MessageFormat.format("⑥合彩: {0}成數 只能為數字！", str2);
//                    return false;
//                }
//            }
//            if (StringTool.isBlank(bean.getUserCredit_kc())) {
//                message = "快彩: 信用額度 請務必輸入！";
//                return false;
//            }
//            if (StringTool.isBlank(bean.getUserRate_kc())) {
//                message = MessageFormat.format("快彩: {0}成數 不能為空！", str2);
//                return false;
//            }
//            try {
//                if (Integer.parseInt(bean.getUserRate_kc()) > 100) {
//                    message = MessageFormat.format("快彩: {0}占成 不能大于100%！", str2);
//                    return false;
//                }
//                flag = true;
//
//            } catch (Exception e) {
//                message = MessageFormat.format("快彩: {0}成數 只能為數字！", str2);
//                return false;
//            }
//        }
//        if (str.equals("child")) {
//            flag = true;
//        } else if (str.equals("filluser")) {
//            if (StringTool.isBlank(bean.getUserName())) {
//                message = "帳號 不能為空！";
//                return false;
//            }
//        } else {
//            message = "用戶類型不正確！";
//            return false;
//        }
//        return flag;
//    }
}
