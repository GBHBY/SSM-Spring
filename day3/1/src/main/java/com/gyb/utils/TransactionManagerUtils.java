package com.gyb.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * 和事务相关管理相关的工具类，包含：提交事务、回滚事务和释放连接
 */
public class TransactionManagerUtils {
    @Autowired
    private ConnectionUtils connectionUtils;


    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            connectionUtils.getLocalConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getLocalConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 回滚事务
     */
    public void rollBack() {
        try {
            connectionUtils.getLocalConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 释放连接
     */
    public void release() {
        try {
//            把连接关闭，换回连接池中
            connectionUtils.getLocalConnection().close();
//            把线程和连接解绑
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
