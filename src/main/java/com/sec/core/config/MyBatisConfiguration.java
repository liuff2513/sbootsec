package com.sec.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * ClassName: MyBatisConfig
 * Description: //TODO
 * Created by feifei.liu on 2017/10/22 13:08
 **/
@Configuration
@MapperScan(basePackages = {"com.sec"})
@EnableTransactionManagement
public class MyBatisConfiguration {
//    @Resource
//    private DataSource dataSource;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//
//    }
}
