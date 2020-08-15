package com.gyb.dao.impl;

import com.gyb.dao.AccountDao;
import com.gyb.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author gb
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> account = super.getJdbcTemplate().query("select * from account where id = ? ",
                new BeanPropertyRowMapper<Account>(Account.class), accountId);

        return account.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> account = super.getJdbcTemplate().query("select * from account where name = ? ",
                new BeanPropertyRowMapper<Account>(Account.class), accountName);
        return account.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?,money = ? where id = ?", account.getName(),
                account.getMoney(), account.getId());

    }
}
