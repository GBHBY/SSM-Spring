package com.gyb.jdbctemplate;

import com.gyb.dao.AccountDao;
import com.gyb.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTempalte的最基本用法
 *
 * @author gyb
 */
class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);
        Account accountById = accountDao.findAccountById(3);
        Account ccc = accountDao.findAccountByName("ccc");
        System.out.println(accountById);
        System.out.println(ccc);
    }

}
