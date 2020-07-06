package com.GYB.factory;

import com.GYB.service.IAccountService;
import com.GYB.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
