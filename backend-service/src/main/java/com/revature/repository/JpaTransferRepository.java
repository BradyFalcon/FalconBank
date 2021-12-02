package com.revature.repository;

import com.revature.entity.Account;
import com.revature.entity.Transaction;
import com.revature.entity.TransactionType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class JpaTransferRepository implements TransferRepository {
    private double balance;

    private EntityManagerFactory entityManagerFactory;


    public JpaTransferRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }
    Account account=new Account();
    Transaction debitTxn=new Transaction();
    Transaction creditTxn=new Transaction();

    @Override
    public void transfer(int id, double amount) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Account fromAccount=entityManager.find(Account.class,account.getNumber());
        Account toAccount=entityManager.find(Account.class,account.getNumber());

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        debitTxn.type=TransactionType.DEBIT;
        debitTxn.amount= debitTxn.getAmount();
        debitTxn.date=new Date();
        debitTxn.account_number=fromAccount;

        creditTxn.type=TransactionType.CREDIT;
        creditTxn.amount=creditTxn.getAmount();
        creditTxn.date=new Date();
        creditTxn.account_number=toAccount;

        entityManager.persist(debitTxn);
        entityManager.persist(creditTxn);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void select(Transaction transaction) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.find(Transaction.class,account.getNumber());
        System.out.println(transaction.id);
        System.out.println(transaction.amount);
        System.out.println(transaction.account_number.getNumber());

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();



    }
}
