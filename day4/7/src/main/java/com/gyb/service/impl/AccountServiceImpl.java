package com.gyb.service.impl;

import com.gyb.dao.AccountDao;
import com.gyb.domain.Account;
import com.gyb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author gb
 * @Date 2020/7/5 13:42
 * @Version 1.0
 */
@Service("accountServiceImpl")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        accountDao.updateAccount(sourceAccount);
        int i = 1 / 0;
        Account targetAccount = accountDao.findAccountByName(targetName);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        accountDao.updateAccount(targetAccount);
    }
}
