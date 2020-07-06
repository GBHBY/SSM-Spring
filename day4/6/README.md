# 基于注解的声明式事务控制

```xml
    <context:component-scan base-package="com"/>


    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>



    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="url" value="jdbc:mysql://localhost:3306/spring"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    </bean>

    <!--spring中基于注解的生命是事务控制配置步骤 -->
    <!--1.配置事务管理器-->
    <!--2.开启Spring对注解事务的支持-->
    <!--3.在需要事务支持的地方使用@Transactionnal注解（见业务层实现类）-->
    <!--4.建立事务通知和切入点表达式的对应关系-->
    <!--5.事务的属性-->
    <!--5.1在tx:advice标签内配置-->
    <!--配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!--配置事务的通知-->
    <!--属性：
            id:标志
            transaction-manager：事务的引用
            -->
    <!--开启Spring对注解事务的支持-->
    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>

```

`注解配置事务较为麻烦，因为不同的操作需要进行不同的配置，而xml可以统一配置，比如：find类方法进行统一配置，updata类方法可以统一配置，但是注解就需要每个方法都配置，并且不方便管理`

```java

/**
 * @Author gb
 * @Date 2020/7/5 13:42
 * @Version 1.0
 */
@Service("accountServiceImpl")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        accountDao.updateAccount(sourceAccount);
        int i = 1 / 0;
        Account targetAccount = accountDao.findAccountByName(targetName);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        accountDao.updateAccount(targetAccount);
    }
}

```