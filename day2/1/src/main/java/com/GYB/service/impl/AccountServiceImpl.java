package com.GYB.service.impl;

import com.GYB.dao.IAccountDao;
import com.GYB.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 业务层调用
 */
@Service(value = "accountService")
@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
    /* @Autowired
     @Qualifier("accountDao2")*/
//     @Resource等同于上面的两个
    @Resource(name = "accountDao2")
    private IAccountDao iAccountDao;

    @Override
    public void save() {
        System.out.println("AccountServiceImpl中的save方法运行了");
        System.out.println(toString());
        iAccountDao.save();
    }

}
