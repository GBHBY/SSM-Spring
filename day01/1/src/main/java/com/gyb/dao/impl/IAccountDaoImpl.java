package com.gyb.dao.impl;

import com.gyb.dao.IAccountDao;

public class IAccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
