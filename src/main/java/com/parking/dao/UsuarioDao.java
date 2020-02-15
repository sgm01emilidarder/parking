package com.parking.dao;

import java.sql.*;
import java.util.*;

import com.parking.dto.Usuario;
import com.parking.dto.Vehicle;

public class UsuarioDao {

    public UsuarioDao() {}

    public List<Usuario> listar() {
        String SQL_SELECT = "SELECT usu_id, usu_nom, usu_llinatges, usu_username,  usu_password, usu_matricula1, usu_matricula2, usu_matricula3 " + " FROM usuaris";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario user;
        List<Usuario> users = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usu_id");
                String name = rs.getString("usu_nom");
                String surname = rs.getString("usu_llinatges");
                String  username = rs.getString("usu_username");
                String password = rs.getString("usu_password");
                String matricula1 = rs.getString("usu_matricula1");
                String matricula2 = rs.getString("usu_matricula2");
                String matricula3 = rs.getString("usu_matricula3");
                List<Vehicle> matriculas = null;
                matriculas.add(new Vehicle(matricula1));
                matriculas.add(new Vehicle(matricula2));
                matriculas.add(new Vehicle(matricula3));


                user = new Usuario(id, name, surname, username, password, matriculas);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return users;
    }

    public Usuario findById(Usuario user) {
        String SQL_SELECT_BY_ID = "SELECT usu_id, usu_nom, usu_llinatges, usu_username,  usu_password, usu_matricula1, usu_matricula2, usu_matricula3 "
                + " FROM usuaris WHERE usu_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();
            rs.absolute(1);

            int id = rs.getInt("usu_id");
            String name = rs.getString("usu_nom");
            String surname = rs.getString("usu_llinatges");
            String  username = rs.getString("usu_username");
            String password = rs.getString("usu_password");
            String matricula1 = rs.getString("usu_matricula1");
            String matricula2 = rs.getString("usu_matricula2");
            String matricula3 = rs.getString("usu_matricula3");
            List<Vehicle> matriculas = null;
            matriculas.add(new Vehicle(matricula1));
            matriculas.add(new Vehicle(matricula2));
            matriculas.add(new Vehicle(matricula3));

            user.setId(id);
            user.setNom(name);
            user.setLlinatges(surname);
            user.setUsuari(username);
            user.setContrasenya(password);
            user.setVehicles(matriculas);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return user;
    }

    public Usuario findByUserPass(Usuario user) {
        String SQL_SELECT_BY_USER_AND_PASS = "SELECT usu_id, usu_nom, usu_llinatges, usu_username, usu_password, usu_matricula1, usu_matricula2, usu_matricula3 "
                + " FROM usuaris WHERE usu_username = ? AND usu_password = SHA2(?,256)";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_USER_AND_PASS);

            stmt.setString(1, user.getUsuari());
            stmt.setString(2, user.getContrasenya());
            rs = stmt.executeQuery();
            rs.absolute(1);

            int id = rs.getInt("usu_id");
            String name = rs.getString("usu_nom");
            String surname = rs.getString("usu_llinatges");
            String  username = rs.getString("usu_username");
            String password = rs.getString("usu_password");
            String matricula1 = rs.getString("usu_matricula1");
            String matricula2 = rs.getString("usu_matricula2");
            String matricula3 = rs.getString("usu_matricula3");
            List<Vehicle> matriculas = null;
            matriculas.add(new Vehicle(matricula1));
            matriculas.add(new Vehicle(matricula2));
            matriculas.add(new Vehicle(matricula3));

            user.setId(id);
            user.setNom(name);
            user.setLlinatges(surname);
            user.setUsuari(username);
            user.setContrasenya(password);
            user.setVehicles(matriculas);


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return user;
    }

    public int create(Usuario user) {
        String SQL_INSERT = "INSERT INTO usuaris(usu_nom, usu_llinatges, usu_username, usu_password, usu_matricula1, usu_matricula2, usu_matricula3) "
                + " VALUES(?, ?, ?, ?, SHA2(?,256), ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Vehicle> matriculas = user.getVehicles();
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int i = 1;
            stmt.setString(i++, user.getNom());
            stmt.setString(i++, user.getLlinatges());
            stmt.setString(i++, user.getUsuari());
            stmt.setString(i++, user.getContrasenya());
            stmt.setString(i++, matriculas.get(1).toString());
            stmt.setString(i++, matriculas.get(2).toString());
            stmt.setString(i++, matriculas.get(3).toString());
            System.out.println(user.toString());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }

    public int update(Usuario user) {
        String SQL_UPDATE = "UPDATE usuaris "
                + " SET usu_nom=?, usu_llinatges=?, usu_username=?, usu_password=SHA2(?,256),  usu_matricula1=?, usu_matricula2=?, usu_matricula3=? WHERE usu_id=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Vehicle> matriculas = user.getVehicles();
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int i = 1;
            stmt.setString(i++, user.getNom());
            stmt.setString(i++, user.getLlinatges());
            stmt.setString(i++, user.getUsuari());
            stmt.setString(i++, user.getContrasenya());
            stmt.setString(i++, matriculas.get(1).toString());
            stmt.setString(i++, matriculas.get(2).toString());
            stmt.setString(i++, matriculas.get(3).toString());
            stmt.setInt(i++, user.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }

    public int delete(Usuario user) {
        String SQL_DELETE = "DELETE FROM usuaris WHERE usu_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getId());
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
