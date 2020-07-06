# 纯注解配置事务控制
- JdbcConfig
```java

/**
 * @Author gb
 * @Date 2020/7/6 10:24
 * @Version 1.0
 * description:和连接数据库相关的配置类
 */

public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/6 10:28
     *
     * @param dataSource
     * @return new JdbcTemplate(dataSource)
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate creatJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/6 10:45
     *
     * @param
     * @return Nothing
     */
    @Bean(name = "dataSource")
    public DataSource createDaSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driver);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(userName);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;

    }

}

```

- Spring