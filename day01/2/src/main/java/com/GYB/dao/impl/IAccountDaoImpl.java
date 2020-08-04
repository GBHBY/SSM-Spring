package com.GYB.dao.impl;

import com.GYB.dao.IAccountDao;

public class IAccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
