package so.wwb.creditbox.company.controller;

import org.soul.commons.enums.EnumTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("html")
public class HtmlController {

    @RequestMapping(value = "/{name}")
    protected String html(@PathVariable String name, HttpServletRequest request, HttpServletResponse response, Model model) {
        String prefix = name.substring(0, name.indexOf("_"));
        String suffix = name.substring(name.indexOf("_"), name.length());
        LotteryEnum anEnum = EnumTool.enumOf(LotteryEnum.class, prefix);
        return "html/"+anEnum.getType()+suffix;
    }



}
