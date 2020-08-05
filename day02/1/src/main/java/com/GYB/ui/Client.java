package com.GYB.ui;

import com.GYB.service.IAccountService;
import com.GYB.service.UserService;
import com.GYB.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    public static void main(String[] args) {

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        此时这个bean的名称是默认的，如果想修改，就在@Component的value中修改，并且getBean的内容也要修改

        IAccountService iAccountService = (IAccountService) classPathXmlApplicationContext.getBean("accountService");
        IAccountService iAccountService1 = (IAccountService) classPathXmlApplicationContext.getBean("accountService");
        System.out.println(iAccountService == iAccountService1);
        iAccountService.save();
//        注意，如果是多例的，销毁方法不会执行
        classPathXmlApplicationContext.close();


    }
}
