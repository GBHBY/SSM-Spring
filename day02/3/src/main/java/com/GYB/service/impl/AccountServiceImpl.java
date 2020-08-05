package com.GYB.service.impl;

import com.GYB.Dao.IAccountDao;
import com.GYB.domain.Account;
import com.GYB.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Resource(name = "accountDao")
    private IAccountDao iAccountDao;


    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }


    @Override
    public List<Account> listFindAllAccount() {
        return iAccountDao.listFindAllAccount();
    }

    @Override
    public Account findAccountById(Integer Id) {
        return iAccountDao.findAccountById(Id);
    }


    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void upData(Account account) {

    }

    @Override
    public void delete(Integer Id) {
        iAccountDao.delete(Id);

    }
}
