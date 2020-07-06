package com.gyb.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;


    /**
     * 获取当前线程连接
     *
     * @return
     */
    public Connection getLocalConnection() {
        try {
//        先从ThreadLocal上获取
            Connection connection = connectionThreadLocal.get();
//        判断当前线程上是否有链接
            if (connection == null) {
                //         从数据源中获取一个连接
                connection = dataSource.getConnection();
                //            把获取的连接存入ThreadLocal
                connectionThreadLocal.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 作用：把连接和县城解绑
     */
    public void removeConnection() {
        connectionThreadLocal.remove();

    }
}
