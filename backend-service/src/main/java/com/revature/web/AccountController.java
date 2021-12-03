package com.revature.web;

import com.revature.entity.Account;
import com.revature.repository.AccountRepository;
import com.revature.repository.JpaAccountRepository;

import javax.persistence.*;

import io.javalin.http.Handler;

import org.eclipse.jetty.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class AccountController {
    static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory =  Persistence.createEntityManagerFactory("falconbankdb");
    }

    static AccountRepository accountRepository=new JpaAccountRepository(entityManagerFactory);

    public static Handler saveAccount=ctx->{
        String number=ctx.pathParam("number");
        accountRepository.getAccount(number);
        Account account=ctx.bodyAsClass(Account.class);
        accountRepository.saveAccount(account);
        ctx.status(HttpStatus.CREATED_201);
    };

    public static Handler getAllAccounts=ctx->{
       String filter = ctx.queryParam("filter");

       if(filter==null){
           filter="all";
       }
        List<Account> accounts= accountRepository.findAll(filter);
       ctx.json(accounts);
    };


    public static Handler getAccount = ctx->{
        String number= ctx.pathParam("number");
        Account account=accountRepository.getAccount(number);

       if(account==null){
           ctx.status(HttpStatus.NOT_FOUND_404);
       }else
           ctx.json(account);

    };
    public static Handler updateAccount=ctx->{
        String number=ctx.pathParam("number");
      accountRepository.getAccount(number);
      Account account=ctx.bodyAsClass(Account.class);
      accountRepository.updateAccount(account);
      ctx.status(HttpStatus.OK_200);
    };

    public static Handler deleteAccount=ctx->{
        String number= ctx.pathParam("number");
        accountRepository.deleteAccount(number);
        ctx.status(HttpStatus.OK_200);
    };




}
