package com.parking.dto;

import java.util.List;
import java.util.Objects;

public class Usuario {

    private int id;
    private String nom;
    private String llinatges;
    private String usuari;
    private String contrasenya;
    private List<Vehicle> vehicles;

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(int id, String nom, String llinatges, String usuari, String contrasenya, List<Vehicle> vehicles) {
        this.id = id;
        this.nom = nom;
        this.llinatges = llinatges;
        this.usuari = usuari;
        this.contrasenya = contrasenya;
        this.vehicles = vehicles;
    }

    public Usuario(String userUsername, String userPass) {
        this.usuari = userUsername;
        this.contrasenya = userPass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", usuari='" + usuari + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
