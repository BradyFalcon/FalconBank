package com.revature.repository;

import com.revature.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Enumerated;
import javax.persistence.Query;
import java.util.List;

public class JpaAccountRepository implements AccountRepository {
    private EntityManagerFactory entityManagerFactory;


    public JpaAccountRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }



    @Override
    public void saveAccount(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(account);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public List<Account> findAll(String filter){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from Account";
        Query query=entityManager.createQuery(jpql);
        List<Account> accounts=query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return accounts;
    }

    @Override
    public Account getAccount(String number) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Account account = entityManager.find(Account.class,number);

        entityManager.getTransaction().commit();
        entityManager.close();
        return account;
    }

    @Override
    public void updateAccount(Account number) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Account account = entityManager.find(Account.class, number);

        account.getBalance();

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(account);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAccount(String number) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Account account = entityManager.find(Account.class, number);
        entityManager.remove(account);
        entityManager.getTransaction().commit();

        entityManager.close();


    }
}
