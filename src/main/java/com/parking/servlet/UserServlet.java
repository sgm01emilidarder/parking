package com.parking.servlet;

import com.parking.dao.UsuarioDao;
import com.parking.dto.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet {


    private void loginClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userUsername = request.getParameter("userUsername");
        String userPass = request.getParameter("userPass");
        Usuario user = new UsuarioDao().findByUserPass(new Usuario(userUsername, userPass));

        System.out.println(user);

        if(user.getUsuari().equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else if(user.getNom() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "message goes here");
        }

    }
}
