package com.parking.service;

import com.parking.dao.UsuarioDao;
import com.parking.dto.Usuario;
import com.parking.dto.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static void returnToIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    public static void loginClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    public static void closeClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        response.sendRedirect("index.jsp");
    }


    public static void createClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        UserService.returnToIndex(request, response);
    }
}
