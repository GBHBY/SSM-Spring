package com.GYB.factory;


import com.GYB.service.IAccountService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    private static Properties properties;

    static {
        properties = new Properties();
//  如果使用比如说绝对路径或者相对路径的时候，换了电脑或者变成web工程的时候，路径是没有的，所以，这种方式最好
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties文件失败");
        }


    }

    /**
     * 根据bean的名称获取bean对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName)  {
        Object bean = null;
        String beanPath = properties.getProperty(beanName);
//        用反射的方式来创建对象，可以减少耦合度
        try {
            bean = Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
