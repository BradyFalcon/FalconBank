package com.revature;

import com.revature.web.AccountController;
import com.revature.web.TransferController;
import com.revature.web.UserController;
import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {


        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        }).start(8080);


        app.post("/users/{userId}", UserController.authenticate);
        app.get("/users/{userId}/accounts",AccountController.getAllAccounts);
        app.post("/users/{userId}/accounts",AccountController.saveAccount);
        app.get("/users/{usersId}/accounts/{number}", AccountController.getAccount);
        app.post("/users/{userId}/accounts/{number}",AccountController.updateAccount);
        app.delete("/users/{userId}/accounts/{number}", AccountController.deleteAccount);
        app.post("/users/{userId}/accounts/{number}/transactions",TransferController.TransferMoney);



    }
}
