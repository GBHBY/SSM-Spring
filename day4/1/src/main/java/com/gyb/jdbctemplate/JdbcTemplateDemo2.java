package com.gyb.jdbctemplate;

import com.gyb.domain.Account;
import com.mysql.jdbc.JDBC4CallableStatement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTempalte的最基本用法
 *
 * @author gyb
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

//        获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//        1.插入
//        jdbcTemplate.execute("insert into account(name,money)values('eee',1000)");
//        2.查询所有
        List<Account> accountList = jdbcTemplate.query("select * from account where money > ?",
                new BeanPropertyRowMapper<Account>(Account.class), 1000);
        for (Account account : accountList) {
            System.out.println(account);
        }
//        2.2查询所有的第二种方式，注意这个是一个Account返回类型的
        List<Account> accounts = jdbcTemplate.query("select * from account where money > ?", new AccountRowMapper(), 1000);
        for (Account account : accountList) {
            System.out.println(account);
        }
//        3.保存
//        4.更新
//        int aaa = jdbcTemplate.update("update account set name = ?,money = ? where id = 2", "bbb", 1000);
//        System.out.println(aaa);
//        5.查询一个
//        5.1
        List<Account> accounOne = jdbcTemplate.query("select * from account where id =  ?",
                new BeanPropertyRowMapper<Account>(Account.class), 2);
        System.out.println(accounOne);
//      5.2
        Account account3 = jdbcTemplate.query("select * from account where id = ?"
                , new ResultSetExtractor<Account>() {
                    @Override
                    public Account extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        Account account = new Account();
                        while (resultSet.next()) {
                            account.setId(resultSet.getInt("id"));
                            account.setMoney(resultSet.getFloat("money"));
                            account.setName(resultSet.getString("name"));
                        }
                        return account;
                    }
                }, 3);
        System.out.println(account3);
//        6.查询返回一行一列
        Integer count = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Integer.class, 1000f);
        System.out.println(count);

//        7.删除
        jdbcTemplate.update("delete from account where id = 1");


    }


}

class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     *
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}



