package com.sec.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/account/login");
		registry.addViewController("/account/registerPage").setViewName("/account/register");
	}

	/**
	 * 将StringHttpMessageConverter的默认编码设为UTF-8
	 * @return
	 */
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return stringHttpMessageConverter;
	}

	/**
	 * 将Jackson2HttpMessageConverter的默认格式化输出设为true
	 * @return
	 */
	@Bean
	public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jackson2HttpMessageConverter.setPrettyPrint(true);
		return jackson2HttpMessageConverter;
	}

//	/**
//	 * Freemarker参数配置
//	 * @return
//	 */
//	@Bean
//	public FreeMarkerConfigurer freeMarkerConfigurer() {
//		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates/");
//		freeMarkerConfigurer.setDefaultEncoding("UTF-8");
//		Properties properties = new Properties();
//		//Properties value值必须是字符串，不然服务启动时freemarker解析会报空指针异常
//		properties.put("template_update_delay", "0");//模板刷新周期，开发时设置小点，上线再设置大些
//		properties.put("locale", "zh_CN");
////		properties.put("date_format", "yyyy-MM-dd");
////		properties.put("datetime_format", "yyyy-MM-dd HH:mm:ss");
////		properties.put("time_format", "HH:mm:ss");
////		properties.put("number_format", "#.##");
////		properties.put("auto_import", "spring.ftl as spring");
////		properties.put("auto_include", "include.ftl");
//		properties.put("auto_flush", "true");
//		freeMarkerConfigurer.setFreemarkerSettings(properties);
//		//配置使用freemarker的自定义标签
//		Map<String, Object> variables = new HashMap<>();
//		freeMarkerConfigurer.setFreemarkerVariables(variables);
//		return freeMarkerConfigurer;
//	}
//
//	/**
//	 * Freemarker视图配置
//	 * @return
//	 */
//	@Bean
//	public FreeMarkerViewResolver freeMarkerViewResolver(){
//		FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
//		freeMarkerViewResolver.setOrder(2);
//		freeMarkerViewResolver.setCache(false);
//		freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
//		freeMarkerViewResolver.setContentType("text/html;charset=utf-8");
//		freeMarkerViewResolver.setSuffix(".ftl");
//		freeMarkerViewResolver.setRequestContextAttribute("request");
//		freeMarkerViewResolver.setAllowRequestOverride(true);
//		freeMarkerViewResolver.setExposeRequestAttributes(true);
//		freeMarkerViewResolver.setExposeSessionAttributes(true);
//		freeMarkerViewResolver.setExposeSpringMacroHelpers(true);
//		return freeMarkerViewResolver;
////		#Freemarker
////		spring.freemarker.order=2
////		spring.freemarker.allow-request-override=false
////		spring.freemarker.cache=false
////		spring.freemarker.check-template-location=true
////		spring.freemarker.charset=UTF-8
////		spring.freemarker.content-type=text/html
////		spring.freemarker.expose-request-attributes=false
////		spring.freemarker.expose-session-attributes=false
////		spring.freemarker.expose-spring-macro-helpers=false
////#spring.freemarker.prefix=
////				spring.freemarker.request-context-attribute=request
////		spring.freemarker.suffix=.ftl
////		spring.freemarker.template-loader-path=classpath:/templates/
////#spring.freemarker.view-names= # whitelist of view names that can be resolved
////		spring.freemarker.settings.template_update_delay=0
//	}

}
