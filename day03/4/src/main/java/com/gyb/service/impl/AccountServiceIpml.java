package com.gyb.service.impl;

import com.gyb.service.IAccountService;

public class AccountServiceIpml implements IAccountService {
    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void updata(int i) {
        System.out.println("更新" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
}
