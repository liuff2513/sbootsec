package com.sec.example;

import com.sec.system.accout.service.SysRegisterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: Main
 * Description: //TODO
 * Created by feifei.liu on 2017/11/8 17:25
 **/
@Configuration //@Configuration声明当前类是一个配置类
@ComponentScan("com.sec.example")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        SysRegisterService sysRegisterService = context.getBean(SysRegisterService.class);
        System.out.println(sysRegisterService.encrypt("crm123"));
    }
}
