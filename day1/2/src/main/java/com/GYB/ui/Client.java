package com.GYB.ui;

import com.GYB.dao.IAccountDao;
import com.GYB.service.IAccountService;
import com.GYB.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        根据ID获取Bean对象(第15行其实也需要强转，但是通过第二个参数的字节码，让它自己进行强转)
        IAccountService iAccountService = (IAccountService) applicationContext.getBean("accountService");
        IAccountDao iAccountDao = applicationContext.getBean("accountDao",IAccountDao.class);
        System.out.println(iAccountDao);
        System.out.println(iAccountService);

        //--------BeanFactory----------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as  = (IAccountService)factory.getBean("accountService");
        System.out.println(as);


    }
}
