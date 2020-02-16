package com.parking.dao;

import java.sql.*;
import java.time.LocalTime;
import java.util.*;

import com.parking.dto.Parking;

public class ParkingDao {

    public ParkingDao() {}

    public List<Parking> listar() {
        String SQL_SELECT = "SELECT `par_id`, `par_municipi`, `par_numPlaces`, `par_direccio`, `par_horaInici`, `par_horaFi`, `par_preuHora`, `par_imatge`, `par_tipus` " + " FROM parkings";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Parking parking;
        List<Parking> parkings = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("par_id");
                String municipi = rs.getString("par_municipi");
                int numPlaces = rs.getInt("par_numPlaces");
                String direccio = rs.getString("par_direccio");
                LocalTime horaInici = rs.getTime("par_horaInici").toLocalTime();
                LocalTime horaFi = rs.getTime("par_horaFi").toLocalTime();
                double preuHora = rs.getDouble("par_preuHora");
                String imatge = rs.getString("par_imatge");
                String tipus = rs.getString("par_tipus");


                parking = new Parking(id, municipi, numPlaces, direccio, horaInici, horaFi, preuHora, imatge, tipus);
                parkings.add(parking);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return parkings;
    }

    public Parking findById(Parking parking) {
        String SQL_SELECT_BY_ID = "SELECT `par_id`, `par_municipi`, `par_numPlaces`, `par_direccio`, `par_horaInici`, `par_horaFi`, `par_preuHora`, `par_imatge`, `par_tipus` "
                + " FROM parkings WHERE par_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

            stmt.setInt(1, parking.getId());
            rs = stmt.executeQuery();
            rs.absolute(1);

            int id = rs.getInt("par_id");
            String municipi = rs.getString("par_municipi");
            int numPlaces = rs.getInt("par_numPlaces");
            String direccio = rs.getString("par_direccio");
            LocalTime horaInici = rs.getTime("par_horaInici").toLocalTime();
            LocalTime horaFi = rs.getTime("par_horaFi").toLocalTime();
            double preuHora = rs.getDouble("par_preuHora");
            String imatge = rs.getString("par_imatge");
            String tipus = rs.getString("par_tipus");

            parking.setId(id);
            parking.setMunicipi(municipi);
            parking.setNumPlaces(numPlaces);
            parking.setDireccio(direccio);
            parking.setHoraInici(horaInici);
            parking.setHoraFi(horaFi);
            parking.setPreuHora(preuHora);
            parking.setImatge(imatge);
            parking.setTipus(tipus);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return parking;
    }

    public List<Parking> listByName(String parkingName) {
        String SQL_SELECT = "SELECT `par_id`, `par_municipi`, `par_numPlaces`, `par_direccio`, `par_horaInici`, `par_horaFi`, `par_preuHora`, `par_imatge`, `par_tipus` "
                + " FROM parkings WHERE par_municipi LIKE ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Parking parking = null;
        List<Parking> parkings = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, "%" + parkingName + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("par_id");
                String municipi = rs.getString("par_municipi");
                int numPlaces = rs.getInt("par_numPlaces");
                String direccio = rs.getString("par_direccio");
                LocalTime horaInici = rs.getTime("par_horaInici").toLocalTime();
                LocalTime horaFi = rs.getTime("par_horaFi").toLocalTime();
                double preuHora = rs.getDouble("par_preuHora");
                String imatge = rs.getString("par_imatge");
                String tipus = rs.getString("par_tipus");

                parking = new Parking(id, municipi, numPlaces, direccio, horaInici, horaFi, preuHora, imatge, tipus);
                parkings.add(parking);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return parkings;
    }

    public int create(Parking parking) {
        String SQL_INSERT = "INSERT INTO parkings(`par_municipi`, `par_numPlaces`, `par_direccio`, `par_horaInici`, `par_horaFi`, `par_preuHora`, `par_imatge`, `par_tipus`) "
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int i = 1;
            stmt.setString(i++, parking.getMunicipi());
            stmt.setInt(i++, parking.getNumPlaces());
            stmt.setString(i++, parking.getDireccio());
            stmt.setTime(i++, java.sql.Time.valueOf(parking.getHoraInici()));
            stmt.setTime(i++, java.sql.Time.valueOf(parking.getHoraFi()));
            stmt.setDouble(i++,parking.getPreuHora());
            stmt.setString(i++, parking.getImatge());
            stmt.setString(i++, parking.getTipus());
            System.out.println(parking.toString());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }

    public int update(Parking parking) {
        String SQL_UPDATE = "UPDATE parkings "
                + " SET par_municipi=?, par_numPlaces=?, par_direccio=?, par_horaInici=?,  par_horaFi=?, par_preuHora=?, par_imatge=?, par_tipus=? WHERE par_id=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int i = 1;
            stmt.setString(i++, parking.getMunicipi());
            stmt.setInt(i++, parking.getNumPlaces());
            stmt.setString(i++, parking.getDireccio());
            stmt.setTime(i++, java.sql.Time.valueOf(parking.getHoraInici()));
            stmt.setTime(i++, java.sql.Time.valueOf(parking.getHoraFi()));
            stmt.setDouble(i++,parking.getPreuHora());
            stmt.setString(i++, parking.getImatge());
            stmt.setString(i++, parking.getTipus());
            stmt.setInt(i++, parking.getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }

    public int delete(Parking parking) {
        String SQL_DELETE = "DELETE FROM parkings WHERE par_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, parking.getId());
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
