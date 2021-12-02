package com.revature.web;

import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;


import static java.lang.Integer.parseInt;

public class UserController {
    public static Handler authenticate= ctx-> {
    /*    try {
            int id = Integer.parseInt("usersId");
            System.out.println(id);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException is handled");
        }
        String email=ctx.pathParam("email");
        String password=ctx.pathParam("password");
        User user =ctx.bodyStreamAsClass(User.class);
        userRepository.save(user);*/
        ctx.status(HttpStatus.CREATED_201);
    };
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }*/


}