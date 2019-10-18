package so.wwb.creditbox.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by Fei on 2018-01-05
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/boss")
    public String bossHome() {
        return "/home/welcome2";
    }

}
