package com.sec.system.account.web;

import com.sec.core.util.SpringContextUtil;
import com.sec.system.account.entity.SysRegister;
import com.sec.system.account.service.SysRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: SysRegisterController
 * Description:
 * Created by liuff on 2017/10/23 23:42.
 */
@Controller
@RequestMapping("/account")
public class SysRegisterController {
    @Autowired(required = false)
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping("/register")
    public ModelMap register(ModelMap mm, SysRegister sysRegister) {
        boolean isregister = SpringContextUtil.getBean(SysRegisterService.class)
                .register(sysRegister, request);
        mm.put("isregister", isregister);
        return mm;
    }
}
