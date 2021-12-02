package com.revature.repository;

import com.revature.entity.Transaction;

public interface TransferRepository {


    void transfer(int id, double amount);

    void select(Transaction transaction);
}
