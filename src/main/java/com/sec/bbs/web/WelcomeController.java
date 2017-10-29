package com.sec.bbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: WelcomeController
 * Description:
 * Created by liuff on 2017/10/29 10:21.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/index")
    public ModelAndView welcome() {

        ModelAndView mav = new ModelAndView("/bbs/index");
        return mav;
    }
}
