package com.parking.dto;

import java.time.LocalTime;
import java.util.Objects;

public class Parking {
    private int id;
    private String municipi;
    private int numPlaces;
    private String direccio;
    private LocalTime horaInici;
    private LocalTime horaFi;
    private double preuHora;
    private String imatge;
    private String tipus;

    public Parking(int id) {
        this.id = id;
    }

    public Parking(String municipi, int numPlaces, String direccio, LocalTime horaInici, LocalTime horaFi, double preuHora, String imatge, String tipus) {
        this.municipi = municipi;
        this.numPlaces = numPlaces;
        this.direccio = direccio;
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.preuHora = preuHora;
        this.imatge = imatge;
        this.tipus = tipus;
    }


    public Parking(int id, String municipi, int numPlaces, String direccio, LocalTime horaInici, LocalTime horaFi, double preuHora, String imatge, String tipus) {
        this.id = id;
        this.municipi = municipi;
        this.numPlaces = numPlaces;
        this.direccio = direccio;
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.preuHora = preuHora;
        this.imatge = imatge;
        this.tipus = tipus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
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

    public double getPreuHora() {
        return preuHora;
    }

    public void setPreuHora(double preuHora) {
        this.preuHora = preuHora;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parking)) return false;
        Parking parking = (Parking) o;
        return id == parking.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", municipi='" + municipi + '\'' +
                ", numPlaces=" + numPlaces +
                ", direccio='" + direccio + '\'' +
                ", horaInici=" + horaInici +
                ", horaFi=" + horaFi +
                ", preuHora=" + preuHora +
                ", imatge='" + imatge + '\'' +
                ", tipus='" + tipus + '\'' +
                '}';
    }
}
