package com.GYB.dao.impl;

import com.GYB.dao.IAccountDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("accountDao")
public class AccountDaoIpml implements IAccountDao {
    @Override
    public void save() {
        System.out.println("AccountDaoIpml的save方法执行了");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行了");
    }
}
