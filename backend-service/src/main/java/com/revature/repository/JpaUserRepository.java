package com.revature.repository;

import com.revature.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaUserRepository implements UserRepository {
    private EntityManagerFactory entityManagerFactory;

    public JpaUserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public void save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public boolean validate(String email, String password) {
        User user = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            user = (User) entityManager.createQuery("From User U Where U.email=:email").setParameter("email", email);
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }entityManager.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }return false;

    }


}
