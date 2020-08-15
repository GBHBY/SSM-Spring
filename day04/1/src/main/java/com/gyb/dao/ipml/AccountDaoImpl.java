package com.gyb.dao.ipml;

import com.gyb.dao.AccountDao;
import com.gyb.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gb
 */
public class AccountDaoImpl implements AccountDao {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
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
