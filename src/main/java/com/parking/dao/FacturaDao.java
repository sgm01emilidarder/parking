package com.parking.dao;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import com.parking.dto.Factura;
import com.parking.dto.Usuario;
import com.parking.dto.Parking;

public class FacturaDao {

    public FacturaDao() {}

    public List<Factura> listar() {
        String SQL_SELECT = "SELECT `fac_id`, `fac_data`, `fac_hora_inici`, `fac_hora_final`, `fac_preu`, `fac_usu_id`, `fac_par_id` " + " FROM factures";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Factura factura;
        List<Factura> facturas = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("fac_id");
                LocalDate data = rs.getDate("fac_data").toLocalDate();
                LocalTime horaInici = rs.getTime("fac_hora_inici").toLocalTime();
                LocalTime horaFi = rs.getTime("fac_hora_final").toLocalTime();
                double  preu = rs.getDouble("fac_preu");
                Usuario usuari = new Usuario(rs.getInt("fac_usu_id"));
                Parking parking = new Parking(rs.getInt("fac_par_id"));

                factura = new Factura(id, data, horaInici, horaFi, preu, usuari, parking);
                facturas.add(factura);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return facturas;
    }

    public Factura findById(Factura factura) {
        String SQL_SELECT_BY_ID = "SELECT `fac_id`, `fac_data`, `fac_hora_inici`, `fac_hora_final`, `fac_preu`, `fac_usu_id`, `fac_par_id` "
                + " FROM factures WHERE fac_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

            stmt.setInt(1, factura.getId());
            rs = stmt.executeQuery();
            rs.absolute(1);

            int id = rs.getInt("fac_id");
            LocalDate data = rs.getDate("fac_data").toLocalDate();
            LocalTime horaInici = rs.getTime("fac_hora_inici").toLocalTime();
            LocalTime horaFi = rs.getTime("fac_hora_final").toLocalTime();
            double  preu = rs.getDouble("fac_preu");
            Usuario usuari = new Usuario(rs.getInt("fac_usu_id"));
            Parking parking = new Parking(rs.getInt("fac_par_id"));

            factura.setId(id);
            factura.setData(data);
            factura.setHoraInici(horaInici);
            factura.setHoraFi(horaFi);
            factura.setPreu(preu);
            factura.setUsuari(usuari);
            factura.setParking(parking);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return factura;
    }

    public int create(Factura factura) {
        String SQL_INSERT = "INSERT INTO factures(fac_data, `fac_hora_inici`, `fac_hora_final`, `fac_preu`, `fac_usu_id`, `fac_par_id`) "
                + " VALUES(?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int i = 1;
            Date data = Date.valueOf(factura.getData());
            stmt.setDate(i++, data);
            stmt.setTime(i++, java.sql.Time.valueOf(factura.getHoraInici()));
            stmt.setTime(i++, java.sql.Time.valueOf(factura.getHoraFi()));
            stmt.setDouble(i++, factura.getPreu());
            stmt.setInt(i++, factura.getUsuari().getId());
            stmt.setInt(i++, factura.getParking().getId());
            System.out.println(factura.toString());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }

    public int update(Factura factura) {
        String SQL_UPDATE = "UPDATE factures "
                + " SET fac_data=?, fac_hora_inici=?, fac_hora_final=?, fac_preu=?, fac_usu_id=?,  fac_par_id=? WHERE fac_id=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int i = 1;
            Date data = Date.valueOf(factura.getData());
            stmt.setDate(i++, data);
            stmt.setTime(i++, java.sql.Time.valueOf(factura.getHoraInici()));
            stmt.setTime(i++, java.sql.Time.valueOf(factura.getHoraFi()));
            stmt.setDouble(i++, factura.getPreu());
            stmt.setInt(i++, factura.getUsuari().getId());
            stmt.setInt(i++, factura.getParking().getId());
            stmt.setInt(i++, factura.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }

    public int delete(Factura factura) {
        String SQL_DELETE = "DELETE FROM factures WHERE fac_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, factura.getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }
}
