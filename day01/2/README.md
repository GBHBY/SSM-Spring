## Spring
ApplicationContext三个常用实现类：<br>
 1.ClassPathXmlApplicationContext：<br>
  可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载不了<br>
 2.FileSystemXmlApplicationContext：<br>
  可以加载磁盘任意路径下的配置文件（必须有访问权限）<br>
 3.AnnocationConfigApplicationContext：<br>
  用于注解<br>
 `ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");`

***
 ApplicationContext：  
- 它在创建核心容器时，创建对象采用的策略是立即加载的方式，也就是说，下面这行代码运行就会创建对象
` ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");` 
- 适用于单例对象  
 BeanFactory:
- 它在创建对象时，是采用延迟加载的方式，也就是说，什么时候根据ID获取对象了，什么时候才是真正的创建对象，
` Resource resource = new ClassPathResource("bean.xml");`  ，这句话运行后是不会创建对象的，当
`IAccountService as  = (IAccountService)factory.getBean("accountService");`这句话运行时，才会创建对象  
- 多例对象适用，因为如果以加载就创建，会创建很多的对象  

我们通过配置来决定使用立即加载还是延迟加载





 
