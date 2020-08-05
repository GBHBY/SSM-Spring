package com.GYB.dao.impl;

import com.GYB.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {


    @Override
    public void save() {
        System.out.println("AccountDaoImpl2执行了");
    }
}
