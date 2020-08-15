package com.gyb.service;

import com.gyb.domain.Account;

/**
 * 业务层接口
 *
 * @Author gb
 * @Date 2020/7/5 13:52
 * @Version 1.0
 */

public interface AccountService {
    /**
     * create by: gb
     * description: 查找账户
     * create time: 2020/7/5 13:55
     *
     * @param accountId
     * @return Account
     */
    Account findAccountById(Integer accountId);


    /**
     * create by: gb
     * description: 转账
     * create time: 2020/7/5 13:57
     *
     * @param sourceName
     * @param targetName
     * @param money
     * @return Nothing
     */
    void transfer(String sourceName, String targetName, Float money);

}
