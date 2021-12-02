package com.revature.repository;

import com.revature.entity.User;

public interface UserRepository {


        void save(User user);
        boolean validate(String email,String password);
}
