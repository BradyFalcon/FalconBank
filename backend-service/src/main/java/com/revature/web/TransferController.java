package com.revature.web;

import com.revature.repository.AccountRepository;
import com.revature.repository.JpaAccountRepository;
import com.revature.repository.JpaTransferRepository;
import com.revature.repository.TransferRepository;
import io.javalin.http.Handler;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TransferController {

    static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory =  Persistence.createEntityManagerFactory("falconbankdb");
    }

    static TransferRepository transferRepository=new JpaTransferRepository(entityManagerFactory);


    public static Handler TransferMoney=ctx->{
        String type=ctx.pathParam("type");
        int id=Integer.parseInt(ctx.pathParam("id"));
        double amount=Double.parseDouble(ctx.pathParam("amount"));
        System.out.println(id);
        if(type=="debit"){
            transferRepository.transfer(id,amount);
        }if(type=="credit"){
            transferRepository.transfer(id,amount);
        }

    };
}
