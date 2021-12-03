package com.revature.web;

import com.revature.entity.Account;
import com.revature.entity.Transaction;
import com.revature.repository.JpaTransferRepository;
import com.revature.repository.TransferRepository;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TransferController {

    static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("falconbankdb");
    }

    static TransferRepository transferRepository = new JpaTransferRepository(entityManagerFactory);


    public static Handler TransferMoney = ctx -> {
        String type = ctx.pathParam("type");
        int id = Integer.parseInt(ctx.pathParam("id"));
        double amount = Double.parseDouble(ctx.pathParam("amount"));
        System.out.println(id);
        if (type == "DEBIT") {
            transferRepository.transfer(id, amount);
        }
        if (type == "CREDIT") {
            transferRepository.transfer(id, amount);
        }

    };
    public static Handler getTransaction = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Transaction transaction = transferRepository.getTransaction(id);

        if (id == 0) {
            ctx.status(HttpStatus.NOT_FOUND_404);
        } else
            ctx.json(transaction);

    };

    public static Handler getAllTransactions = ctx->{
        String filter = ctx.queryParam("filter");

        if(filter==null){
            filter="all";
        }
        List<Transaction> transactions= transferRepository.findAllTransactions(filter);
        ctx.json(transactions);
    };


}
