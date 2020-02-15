package com.parking.servlet;

import com.parking.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client")
public class UserServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    UserService.editClient(request, response);
                    break;
                default:
                    UserService.showListClient(request, response);
            }
        } else {
            UserService.showListClient(request, response);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                /*case "delete":
                    UserService.deleteClient(request, response);
                    break;
                case "insert":
                    UserService.insertClient(request, response);
                    break;
                case "update":
                    UserService.updateClient(request, response);
                    break;*/
                case "create":
                    UserService.createClient(request, response);
                    break;
                case "login":
                    UserService.loginClient(request, response);
                    break;
                case "close":
                    UserService.closeClient(request, response);
                    break;
                default:
                    UserService.returnToIndex(request, response);
            }
        } else {
            UserService.returnToIndex(request, response);
        }
    }

}
