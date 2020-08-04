package com.gyb.service.impl;

import com.gyb.dao.IAccountDao;
import com.gyb.factory.BeanFactory;
import com.gyb.service.IAccountService;

/**
 * 业务层调用
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");


    @Override
    public void save() {
        accountDao.saveAccount();
    }
}
