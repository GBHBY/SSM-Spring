package com.gyb.dao;

import com.gyb.domain.Account;

/**
 * @author gb
 */
public interface AccountDao {
    /**
     * @
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);
    Account findAccountByName(String accountName);
    void updateAccount(Account account);
}
