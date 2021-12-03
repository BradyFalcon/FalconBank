package com.revature.repository;

import com.revature.entity.Account;
import com.revature.entity.Transaction;
import com.revature.entity.TransactionType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class JpaTransferRepository implements TransferRepository {

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
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();



    }

    @Override
    public Transaction getTransaction(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Transaction transaction = entityManager.find(Transaction.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return transaction;
    }



    @Override
    public List<Transaction> findAllTransactions(String filter) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from Transaction WHERE account_number= " + 1;


        Query query=entityManager.createQuery(jpql);
        List<Transaction> transactions=query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return transactions;
    }
}
