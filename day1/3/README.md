###创建Bean的三种方式
```xml
 <!-- 第一种方式，使用默认构造函数创建，如果构造函数有参数，那么就会报错-->
 <bean id="accountService" class="com.GYB.service.impl.AccountServiceImpl" />
```
<br>

```xml
<!--第二种方式，使用普通工厂创建对象，也就是使用工厂类中的某个方法来创建对象-->
  <bean id="instanceFactory" class="com.GYB.factory.InstanceFactory" />
   <bean id="accountService"  factory-bean="instanceFactory" factory-method="getAccountService" />
```

<br>

```xml
 <!--第三种方式：使用工厂中的静态方法创建对象，使用某个类中的静态方法创建对象，并存入Spring容器-->
    <bean id="accountService" class="com.GYB.factory.StaticFactory" factory-method="getAccountService" />

```

###Spring默认创建的对象是单例的
```xml
  <!--bean的作用范围-->
        <!--用bean的scope标签来调整，属性如下：-->
            <!--singleton: 单例的，默认值-->
            <!--prototype：多例的-->
            <!--request：作用于web应用的请求范围-->
            <!--session：作用域web的会话范围-->
            <!--global-session：作用于集群环境的会话范围，当不是集群环境时，这个值就是session-->

    <!--bean的生命周期-->
        <!--单例对象-->
            <!--一一旦解析完配置文件，对象就会产生对象，只要容器存在，对象就存在-->
<bean id="accountService" class="com.GYB.factory.StaticFactory" factory-method="getAccountService" scope="singleton" init-method="init" destroy-method="destroy" />
<!--上面这段代买中的init-method和destroy-method标签很容易理解，不再赘述，但是destroy-method中的方法要想执行，必须有下面这段代码-->
```

```java
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        根据ID获取Bean对象(第15行其实也需要强转，但是通过第二个参数的字节码，让它自己进行强转)
        IAccountService iAccountService = (IAccountService) applicationContext.getBean("accountService");
        iAccountService.save();
        applicationContext.close();

```

注意第40行是被注释掉了，否则是没有close方法
