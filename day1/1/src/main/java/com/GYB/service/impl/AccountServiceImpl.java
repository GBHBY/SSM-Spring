package com.GYB.service.impl;

import com.GYB.dao.IAccountDao;
import com.GYB.dao.impl.IAccountDaoImpl;
import com.GYB.factory.BeanFactory;
import com.GYB.service.IAccountService;

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
