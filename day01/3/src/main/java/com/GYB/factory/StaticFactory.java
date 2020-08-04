package com.GYB.factory;

import com.GYB.service.IAccountService;
import com.GYB.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
    
}
