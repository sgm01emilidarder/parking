package com.parking.servlet;

import com.parking.dao.UsuarioDao;
import com.parking.dto.Usuario;
import com.parking.dto.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet {

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

    private void returnToIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    private void createClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("name");
        String llinatges = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String matricula = request.getParameter("matricula");
        Vehicle vehiculo = new Vehicle(matricula);
        List<Vehicle>(vehiculo);

        Usuario user = new Usuario(nom, llinatges, username, password, );

        int registrosModificados = new UsuarioDao().create(user);
        System.out.println("Registres modificats:" + registrosModificados);

        this.returnToIndex(request, response);
    }
}
