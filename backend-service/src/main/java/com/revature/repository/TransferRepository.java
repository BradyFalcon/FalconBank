package com.revature.repository;

import com.revature.entity.Transaction;

import java.util.List;

public interface TransferRepository {


    void transfer(int id, double amount);

    void select(Transaction transaction);

    Transaction getTransaction(int id);

    List<Transaction> findAllTransactions( String filter);
}
