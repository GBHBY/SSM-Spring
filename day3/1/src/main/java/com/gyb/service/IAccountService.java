package com.gyb.service;

import com.gyb.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     *
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查账户
     *
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 保存
     *
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     *
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);

    /**
     * 转账
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转入金额
     */
    void transfer(String sourceName, String targetName, float money);


}
