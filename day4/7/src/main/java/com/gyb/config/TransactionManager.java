package com.gyb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author gb
 * @Date 2020/7/6 11:20
 * @Version 1.0
 * description:和事务相关的配置类
 */

public class TransactionManager {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/6 11:21
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager creatTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
