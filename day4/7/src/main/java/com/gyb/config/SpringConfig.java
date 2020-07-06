package com.gyb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author gb
 * @Date 2020/7/6 10:22
 * @Version 1.0
 * description:Spring的配置类，取代bean.xml
 */
@Configuration
//配置要扫描的包
@ComponentScan("com.gyb")
@Import({JdbcConfig.class, TransactionManager.class})
@PropertySource("jdbcConfig.properties")
//开启事务注解支持
@EnableTransactionManagement

public class SpringConfig {
}
