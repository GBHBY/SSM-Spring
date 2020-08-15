# Spring中基于XML的声明式事务控制

```xml

    <!--Spring中基于xml的生命是事务控制配置步骤 -->
    <!--1.配置事务管理器-->
    <!--2.配置事务的通知（导入事务约束带tx的-->
    <!--3.配置aop中通用的切入点表达式-->
    <!--4.建立事务通知和切入点表达式的对应关系-->
    <!--5.事务的属性-->
    <!--5.1在tx:advice标签内配置-->
    <!--配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    </bean>
    <!--配置事务的通知-->
    <!--属性：
            id:标志
            transaction-manager：事务的引用
            -->

    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <!--事务的属性-->
        <!--isolation=""  用于指定事务的隔离级别，默认值是DEFAULT，表示数据库的默认隔离级别
         propagation=""   用于指定事务的传播行为，默认值是REQUIRED，表示一定会有事务，增删改的选择，查询方法可以选择SUPPORTS值
          read-only=""    用于指定事务是否只读，只有查询方法才能设置为true，默认值是false，表示读写
           rollback-for=""用于指定一个异常，当产生该异常时，事务回滚，产生其他异常时，事务不会滚，没有默认值，表示任何异常都会回滚
           no-rollback-for="" 用于指定一个异常，当产生这个异常时，不回滚，产生其他异常时，会回滚，没有默认值，表示任何异常都回滚
            timeout=""    用于指定事物的超时时间，默认是-1，表示永不超时，如果制定了数值，是以秒为单位
            -->
        <tx:attributes>
            <!--通配符，表示任何方法都用于改该配置-->
            <tx:method name="*" propagation="REQUIRED" read-only="false"/>
            <!--这种方式必须命名规范-->
            <tx:method name="*find" propagation="REQUIRED" read-only="false"/>
        </tx:attributes>
    </tx:advice>
    <!--配置aop-->
    <aop:config>
        <!--配置切入点表达式-->
        <aop:pointcut id="pt1" expression="execution(* com.gyb.service.impl.*.*(..))"/>
        <!--建立事务通知和切入点表达式的对应关系-->
        <aop:advisor advice-ref="txAdvice" pointcut-ref="pt1"/>
    </aop:config>

```