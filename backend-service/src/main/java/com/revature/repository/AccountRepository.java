package com.revature.repository;

import com.revature.entity.Account;

import java.util.List;

public interface AccountRepository {




    void saveAccount(Account account);
    List<Account> findAll(String filter);
    Account getAccount(String number);

    void updateAccount(Account number);

    void deleteAccount(String number);
}
