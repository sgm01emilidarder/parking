package com.parking.dto;

import java.util.List;
import java.util.Objects;

public class Usuario {

    private int id;
    private String nom;
    private String llinatges;
    private String mail;
    private String contrasenya;
    private List<Vehicle> vehicles;

    public Usuario(int id, String nom, String llinatges, String mail, String contrasenya, List<Vehicle> vehicles) {
        this.id = id;
        this.nom = nom;
        this.llinatges = llinatges;
        this.mail = mail;
        this.contrasenya = contrasenya;
        this.vehicles = vehicles;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
                ", mail='" + mail + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
