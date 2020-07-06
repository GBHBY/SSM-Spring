package com.GYB.Dao;

import com.GYB.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有
     *
     * @return
     */

    List<Account> listFindAllAccount();

    /**
     * 根据Id查询
     *
     * @return
     */
    Account findAccountById(Integer Id);

    /**
     * 保存
     */
    void saveAccount(Account account);

    /**
     * 更新
     */
    void upData(Account account);

    /**
     * 删除
     *
     * @param Id
     */
    void delete(Integer Id);
}
