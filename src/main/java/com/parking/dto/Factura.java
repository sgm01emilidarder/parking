package com.parking.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Factura {
    private int id;
    private LocalDate data;
    private LocalTime horaInici;
    private LocalTime horaFi;
    private double preu;
    private Usuario usuari;
    private Parking parking;
    private Vehicle vehicle;

    public Factura(int id, LocalDate data, LocalTime horaInici, LocalTime horaFi, double preu, Usuario usuari, Parking parking, Vehicle vehicle) {
        this.id = id;
        this.data = data;
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.preu = preu;
        this.usuari = usuari;
        this.parking = parking;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInici() {
        return horaInici;
    }

    public void setHoraInici(LocalTime horaInici) {
        this.horaInici = horaInici;
    }

    public LocalTime getHoraFi() {
        return horaFi;
    }

    public void setHoraFi(LocalTime horaFi) {
        this.horaFi = horaFi;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public Usuario getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuario usuari) {
        this.usuari = usuari;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura)) return false;
        Factura factura = (Factura) o;
        return id == factura.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", data=" + data +
                ", horaInici=" + horaInici +
                ", horaFi=" + horaFi +
                ", preu=" + preu +
                ", usuari=" + usuari +
                ", parking=" + parking +
                ", vehicle=" + vehicle +
                '}';
    }
}
