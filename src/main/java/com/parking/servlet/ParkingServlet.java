package com.parking.servlet;

import com.parking.dao.ParkingDao;
import com.parking.dao.UsuarioDao;
import com.parking.dto.Parking;
import com.parking.dto.Usuario;
import com.parking.service.ParkingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/" , "/parking"})
public class ParkingServlet extends HttpServlet {
    private static final long serialVersionUID = -7558166539389234332L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();

        if (servletPath.equals("/")) {
            List<Parking> parkings = new ParkingService().getParkings();

            HttpSession session = request.getSession();
            session.setAttribute("parkings", parkings);

            response.sendRedirect("index.jsp");
        } else if (servletPath.equals("/parking")){
            Parking idParking = new Parking(Integer.parseInt(request.getParameter("idParking")));

            Parking parking = new ParkingService().getParking(idParking);

            System.out.println(parking.toString());

            HttpSession session = request.getSession();
            session.setAttribute("parking", parking);

            response.sendRedirect("detallParking.jsp");
        }

        private void loginClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String userUsername = request.getParameter("userUsername");
            String userPass = request.getParameter("userPass");
            Usuario user = new UsuarioDao().findByUserPass(new Usuario(userUsername, userPass));

            System.out.println(user);

            if(user.getUsuari().equals("admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("listClients.jsp");
            } else if(user.getId() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("index.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "message goes here");
            }

        }

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

/*    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recuperam l'acció a realitzar i es crida a la funció corresponent
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "delete":
                    this.deleteClient(request, response);
                    break;
                case "insert":
                    this.insertClient(request, response);
                    break;
                case "update":
                    this.updateClient(request, response);
                    break;
                default:
                    this.showListClient(request, response);
            }
        } else {
            this.showListClient(request, response);
        }
    }*/


}
