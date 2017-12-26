package com.sec.bbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    @RequestMapping("/index")
    public ModelAndView welcome() {
        logger.trace("I am trace log.");
        logger.debug("I am debug log.");
        logger.warn("I am warn log.");
        logger.error("I am error log.");
        ModelAndView mav = new ModelAndView("/bbs/index");
        return mav;
    }
}
