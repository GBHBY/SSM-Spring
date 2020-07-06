package com.gyb.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

/**
 * JdbcTempalte的最基本用法
 *
 * @author gyb
 */
class JdbcTemplateDemo1 {
    public static void main(String[] args) {
//        数据源
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        给jdbcTemplate设置数据源
        jdbcTemplate.setDataSource(driverManagerDataSource);
        jdbcTemplate.execute("insert into account(name,money)values('fff',1000)");
    }

}
