package com.parking.servlet;

import com.parking.dao.UsuarioDao;
import com.parking.dto.Usuario;
import com.parking.dto.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/client")
public class UserServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.editClient(request, response);
                    break;
                default:
                    this.showListClient(request, response);
            }
        } else {
            this.showListClient(request, response);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                /*case "delete":
                    this.deleteClient(request, response);
                    break;
                case "insert":
                    this.insertClient(request, response);
                    break;
                case "update":
                    this.updateClient(request, response);
                    break;*/
                case "create":
                    this.createClient(request, response);
                    break;
                case "login":
                    this.loginClient(request, response);
                    break;
                case "close":
                    this.closeClient(request, response);
                    break;
                default:
                    this.returnToIndex(request, response);
            }
        } else {
            this.returnToIndex(request, response);
        }
    }

    private void returnToIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    private void loginClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userUsername = request.getParameter("userUsername");
        String userPass = request.getParameter("userPass");
        Usuario user = new UsuarioDao().findByUserPass(new Usuario(userUsername, userPass));

        System.out.println(user);

        if (user.getUsuari().equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else if (user.getNom() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Usuario o contraseña incorrecto");
        }

    }

    private void closeClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        response.sendRedirect("index.jsp");
    }


    private void createClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String llinatges = request.getParameter("llinatges");
        String username = request.getParameter("nom");
        String password = request.getParameter("contrasenya");
        Vehicle vehiculo = new Vehicle(request.getParameter("matricula"));
        Vehicle vehiculo2 = new Vehicle(request.getParameter("matricula2"));
        Vehicle vehiculo3 = new Vehicle(request.getParameter("matricula3"));
        List<Vehicle> matricula = new ArrayList<>();
        matricula.add(vehiculo);
        matricula.add(vehiculo2);
        matricula.add(vehiculo3);

        Usuario user = new Usuario(nom, llinatges, username, password, matricula);

        int registrosModificados = new UsuarioDao().create(user);
        System.out.println("Registres modificats:" + registrosModificados);

        this.returnToIndex(request, response);
    }
}
