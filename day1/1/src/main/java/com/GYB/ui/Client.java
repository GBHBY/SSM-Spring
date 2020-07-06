package com.GYB.ui;

import com.GYB.factory.BeanFactory;
import com.GYB.service.IAccountService;
import com.GYB.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
        IAccountService iAccountService = (IAccountService) BeanFactory.getBean("accountService");
        iAccountService.save();
    }
}
