package com.revature.service;

import com.revature.entity.User;

public interface LoginService {

    User userLogin(String email, String password);
}
