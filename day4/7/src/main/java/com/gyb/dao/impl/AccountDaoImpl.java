package com.gyb.dao.impl;

import com.gyb.dao.AccountDao;
import com.gyb.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author gb
 */
@Repository("accountDaoImpl")
public class AccountDaoImpl implements AccountDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> account = jdbcTemplate.query("select * from account where id = ? ",
                new BeanPropertyRowMapper<Account>(Account.class), accountId);

        return account.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> account = jdbcTemplate.query("select * from account where name = ? ",
                new BeanPropertyRowMapper<Account>(Account.class), accountName);
        return account.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?,money = ? where id = ?", account.getName(),
                account.getMoney(), account.getId());

    }
}
