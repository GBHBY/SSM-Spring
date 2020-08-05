package com.GYB.Dao.Impl;

import com.GYB.Dao.IAccountDao;
import com.GYB.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }



    @Override
    public List<Account> listFindAllAccount() {
        try {
            return queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Account findAccountById(Integer Id) {
        try {
            return queryRunner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }


    @Override
    public void saveAccount(Account account) {

        try {
            queryRunner.update("insert  into account(name,money)values(?,?)", account.getName(), account.getMoney());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }

    @Override
    public void upData(Account account) {


        try {
            queryRunner.update("update account set name=?,money=? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }

    @Override
    public void delete(Integer Id) {

        try {
            queryRunner.update("delete from account where id = ? ", Id );
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }
}
