package com.GYB.service.impl;

import com.GYB.service.IAccountService;

/**
 * 业务层调用
 */
public class AccountServiceImpl implements IAccountService {


    @Override
    public void save() {
        System.out.println("AccountServiceImpl中的save方法运行了");


    }

    @Override
    public void init() {
        System.out.println("初始化");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
