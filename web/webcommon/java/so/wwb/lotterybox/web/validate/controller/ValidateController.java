package so.wwb.lotterybox.web.validate.controller;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.validation.form.PasswordRule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jeff on 2016/1/28.
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {

    @RequestMapping("/passwordNotWeak")
    @ResponseBody
    public String passwordNotWeak(@RequestParam("sysUser.password")String password,@RequestParam("sysUser.username") String username){
        if(StringTool.isBlank(password))
            return "false";
        if(password.equals(username)){
            return "false";
        }
        if(PasswordRule.isWeak(password)){
            return "false";
        }

        return "true";
    }

    @RequestMapping("/paymentPasswordNotWeak")
    @ResponseBody
    public String paymentPasswordNotWeak(@RequestParam("sysUser.permissionPwd")String password,@RequestParam("sysUser.username") String username){
        if(StringTool.isBlank(password))
            return "false";
        if(password.equals(username)){
            return "false";
        }
        if(PasswordRule.isWeak(password)){
            return "false";
        }

        return "true";
    }
}
