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
import java.time.LocalTime;
import java.util.List;

@WebServlet({"/" , "/parking"})
public class ParkingServlet extends HttpServlet {
    private static final long serialVersionUID = -7558166539389234332L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();

        if (servletPath.equals("/")) {
            this.showListParking(request, response);
        } else if (servletPath.equals("/parking")){
          String action = request.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "edit":
                        this.editParking(request, response);
                        break;
                    default:
                        this.showParking(request, response);
                }
            } else {
                Parking idParking = new Parking(Integer.parseInt(request.getParameter("idParking")));

                Parking parking = new ParkingService().getParking(idParking);

                System.out.println(parking.toString());

                HttpSession session = request.getSession();
                session.setAttribute("parking", parking);

                response.sendRedirect("detallParking.jsp");
            }

        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "delete":
                    this.deleteParking(request, response);
                    break;
                case "insert":
                    this.insertParking(request, response);
                    break;
                case "update":
                    this.updateParking(request, response);
                    break;
                case "search":
                    this.showListParkingFiltered(request, response);
                    break;
                default:
                    this.showListParking(request, response);
            }
        } else {
            this.showListParking(request, response);
        }
    }

    private void showListParking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Parking> parkings = new ParkingService().getParkings();

        HttpSession session = request.getSession();
        session.setAttribute("parkings", parkings);

        response.sendRedirect("index.jsp");
    }

    private void showListParkingFiltered(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parkingName = request.getParameter("cerca");
        List<Parking> parkings = new ParkingService().getParkingsFiltered(parkingName);

        HttpSession session = request.getSession();
        session.setAttribute("parkings", parkings);

        response.sendRedirect("index.jsp");
    }

    private void showParking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Parking> parkings = new ParkingService().getParkings();

        HttpSession session = request.getSession();
        session.setAttribute("parkings", parkings);

        response.sendRedirect("listParkings.jsp");
    }

    private void editParking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Parking idParking = new Parking(Integer.parseInt(request.getParameter("idParking")));
        Parking parking = new ParkingService().getParking(idParking);

        request.setAttribute("parking", parking);

        String jspEditar = "/editParking.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    private void updateParking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Modificar producto");

        int idParking = Integer.parseInt(request.getParameter("idParking"));
        String municipi = request.getParameter("municipi");
        int numPlaces = Integer.parseInt(request.getParameter("numPlaces"));
        String direccio = request.getParameter("direccio");
        LocalTime horaInici = LocalTime.parse(request.getParameter("horaInici"));
        LocalTime horaFi = LocalTime.parse(request.getParameter("horaFi"));
        double preuHora = Double.parseDouble(request.getParameter("preuHora"));
        String imatge = request.getParameter("imatge");
        String tipus = request.getParameter("tipus");

        Parking parking = new Parking(idParking, municipi, numPlaces, direccio, horaInici, horaFi, preuHora, imatge, tipus);

        int registrosModificados = new ParkingService().updateParking(parking);
        System.out.println("Registres modificats:" + registrosModificados);

        this.showParking(request, response);
    }

    private void insertParking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String municipi = request.getParameter("municipi");
        int numPlaces = Integer.parseInt(request.getParameter("numPlaces"));
        String direccio = request.getParameter("direccio");
        LocalTime horaInici = LocalTime.parse(request.getParameter("horaInici"));
        LocalTime horaFi = LocalTime.parse(request.getParameter("horaFi"));
        double preuHora = Double.parseDouble(request.getParameter("preuHora"));
        String imatge = request.getParameter("imatge");
        String tipus = request.getParameter("tipus");

        Parking parking = new Parking(municipi, numPlaces, direccio, horaInici, horaFi, preuHora, imatge, tipus);

        int registrosModificados = new ParkingService().insertParking(parking);
        System.out.println("Registres modificats:" + registrosModificados);

        this.showParking(request, response);
    }

    private void deleteParking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int parkingId = Integer.parseInt(request.getParameter("idParking"));

        int registrosModificados = new ParkingService().deleteParking(new Parking(parkingId));

        System.out.println("Registres modificats:" + registrosModificados);

        this.showParking(request, response);
    }
}
