package com.gyb.service.impl;

import com.gyb.dao.AccountDao;
import com.gyb.domain.Account;
import com.gyb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author gb
 * @Date 2020/7/5 13:42
 * @Version 1.0
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        accountDao.updateAccount(sourceAccount);
        Account targetAccount = accountDao.findAccountByName(targetName);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        accountDao.updateAccount(targetAccount);
    }
}
