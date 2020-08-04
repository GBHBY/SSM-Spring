package com.gyb.ui;

import com.gyb.factory.BeanFactory;
import com.gyb.service.IAccountService;

/**
 * create by: gb
 * description: TODO
 * create time: 2020/8/4 15:07
 *
 * @author gb
 * @return
 */
public class Client {
    public static void main(String[] args) {
        IAccountService iAccountService = (IAccountService) BeanFactory.getBean("accountService");
        iAccountService.save();
    }
}
