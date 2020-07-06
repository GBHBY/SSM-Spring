package com.gyb.service.impl;

import com.gyb.dao.IAccountDao;
import com.gyb.domain.Account;
import com.gyb.service.IAccountService;
import com.gyb.utils.TransactionManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private TransactionManagerUtils transactionManagerUtils;

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
//            1开启事务
            transactionManagerUtils.beginTransaction();
//            2执行操作
            List<Account> accounts = accountDao.findAllAccount();
//            3提交事务
            transactionManagerUtils.commit();
//            4返回结果
            return accounts;
        } catch (Exception e) {
//            5回滚操作
            transactionManagerUtils.rollBack();
            throw new RuntimeException(e);
        } finally {
//            6释放资源，释放连接
            transactionManagerUtils.release();

        }

    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
//            1开启事务
            transactionManagerUtils.beginTransaction();
//            2执行操作
            Account account = accountDao.findAccountById(accountId);
//            3提交事务
            transactionManagerUtils.commit();
//            4返回结果
            return account;
        } catch (Exception e) {
//            5回滚操作
            transactionManagerUtils.rollBack();
            throw new RuntimeException(e);
        } finally {
//            6释放资源，释放连接
            transactionManagerUtils.release();

        }

    }

    @Override
    public Account findAccountByName(String accountName) {
        try {
//            1开启事务
            transactionManagerUtils.beginTransaction();
//            2执行操作
            Account account = accountDao.findAccountByName(accountName);
//            3提交事务
            transactionManagerUtils.commit();
//            4返回结果
            return account;
        } catch (Exception e) {
//            5回滚操作
            transactionManagerUtils.rollBack();
            throw new RuntimeException(e);
        } finally {
//            6释放资源，释放连接
            transactionManagerUtils.release();

        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
//            1开启事务
            transactionManagerUtils.beginTransaction();
//            2执行操作
            accountDao.saveAccount(account);
//            3提交事务
            transactionManagerUtils.commit();
//            4返回结果

        } catch (Exception e) {
//            5回滚操作
            transactionManagerUtils.rollBack();
            throw new RuntimeException(e);
        } finally {
//            6释放资源，释放连接
            transactionManagerUtils.release();

        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
//            1开启事务
            transactionManagerUtils.beginTransaction();
//            2执行操作
            accountDao.updateAccount(account);
//            3提交事务
            transactionManagerUtils.commit();
//            4返回结果

        } catch (Exception e) {
//            5回滚操作
            transactionManagerUtils.rollBack();
            throw new RuntimeException(e);
        } finally {
//            6释放资源，释放连接
            transactionManagerUtils.release();

        }
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        try {
//            1开启事务
            transactionManagerUtils.beginTransaction();
//            2执行操作
            accountDao.deleteAccount(acccountId);
//            3提交事务
            transactionManagerUtils.commit();
//            4返回结果

        } catch (Exception e) {
//            5回滚操作
            transactionManagerUtils.rollBack();
            throw new RuntimeException(e);
        } finally {
//            6释放资源，释放连接
            transactionManagerUtils.release();

        }
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        try {
//            1开启事务
            transactionManagerUtils.beginTransaction();
//            2执行操作
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            Account targetAccount = accountDao.findAccountByName(targetName);
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            int i = 1 / 0;
            targetAccount.setMoney(targetAccount.getMoney() + money);
            accountDao.updateAccount(sourceAccount);
            accountDao.updateAccount(targetAccount);


//            3提交事务
            transactionManagerUtils.commit();
//            4返回结果

        } catch (Exception e) {
//            5回滚操作
            transactionManagerUtils.rollBack();
            throw new RuntimeException(e);
        } finally {
//            6释放资源，释放连接
            transactionManagerUtils.release();

        }


    }
}
