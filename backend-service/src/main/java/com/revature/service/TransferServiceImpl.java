package com.revature.service;

import com.revature.entity.Account;
import com.revature.entity.Transaction;
import com.revature.entity.TransactionType;
import com.revature.exceptions.BalanceException;
import com.revature.repository.AccountRepository;



import java.util.Date;

public class TransferServiceImpl implements TransferService {
    private AccountRepository accountRepository;


    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public boolean transfer(double amount, String fromAccountNumber, String toAccountNumber) {

        Account fromAccount = accountRepository.getAccount(fromAccountNumber);

        Account toAccount = accountRepository.getAccount(toAccountNumber);
        if (fromAccount.getBalance() < amount) {
            throw new BalanceException(fromAccount.getBalance());
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        Transaction debitTxn=new Transaction();
        Transaction creditTxn=new Transaction();

        debitTxn.type=TransactionType.DEBIT;
        debitTxn.amount= debitTxn.getAmount();
        debitTxn.date=new Date();
        debitTxn.account_number=toAccount;

        creditTxn.type=TransactionType.CREDIT;
        creditTxn.amount=creditTxn.getAmount();
        creditTxn.date=new Date();
        creditTxn.account_number=fromAccount;


        return true;
    }
}
