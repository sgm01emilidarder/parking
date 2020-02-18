package com.parking.servlet;

import com.parking.dao.UsuarioDao;
import com.parking.dto.Parking;
import com.parking.dto.Usuario;
import com.parking.dto.Vehicle;
import com.parking.service.ParkingService;
import com.parking.service.UserService;

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

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "list":
                    this.listClient(request, response);
                    break;
                case "edit":
                    this.editClient(request, response);
                    break;
                /*default:
                    UserService.showListClient(request, response);*/
            }
        } /*else {
            UserService.showListClient(request, response);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "delete":
                    this.deleteClient(request, response);
                    break;
                case "insert":
                    UserService.insertClient(request, response);
                    break;
                case "update":
                    this.updateClient(request, response);
                    break;
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

    private void listClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = new UserService().getClients();

        HttpSession session = request.getSession();
        session.setAttribute("usuarios", usuarios);

        response.sendRedirect("listClients.jsp");
    }

    private void editClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user = Integer.parseInt(request.getParameter("idUsuario"));
        Usuario usuario = new UserService().getUserById( new Usuario(user));

        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);

        response.sendRedirect("editClient.jsp");
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("idUsuario"));
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

        Usuario user = new Usuario(userId, nom, llinatges, username, password, matricula);

        int registrosModificados = new UsuarioDao().update(user);
        System.out.println("Registres modificats:" + registrosModificados);

        this.listClient(request, response);
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("idUsuario"));

        int registrosModificados = new UserService().deleteClient(new Usuario(userId));

        System.out.println("Registres modificats:" + registrosModificados);

        this.listClient(request, response);
    }


}
