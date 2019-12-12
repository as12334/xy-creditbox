package so.wwb.creditbox.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.model.hall.HandlerForm;
import so.wwb.creditbox.web.lottery.controller.BaseLotteryController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LotteryLiveController extends BaseLotteryController{
    private static final String INDEX_URI = "Home";
    private static final String LOGIN_VALIDATE = "LoginValidate";
    private static final String INDEX_CONTENT_URI = "index.include/content";


    Integer generateTotalSum(String[] openCodes) {
        Integer totalSum = 0;
        for (String openCode : openCodes) {
            totalSum += Integer.valueOf(openCode);
        }
        return totalSum;
    }

    @RequestMapping(value = "/{code}/Betimes_1")
    protected String handler(@PathVariable String code, HandlerForm form, HttpServletRequest request, HttpServletResponse response, Model model ) {

        return "/lottery/live/sfc/Betimes_1";
    }
}
