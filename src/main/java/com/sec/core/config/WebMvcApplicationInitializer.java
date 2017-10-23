package com.sec.core.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName: WebMvcApplicationInitializer
 * Description: Dispatcher Serverlet过滤器
 * Created by feifei.liu on 2017/10/23 12:43
 **/
public class WebMvcApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebSecurityConfiguration.class};//Security注册过滤器
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
