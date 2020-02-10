package com.parking.dto;

import java.util.Objects;

public class Vehicle {

    private String matricula;

    public Vehicle(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return matricula.equals(vehicle.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "matricula='" + matricula + '\'' +
                '}';
    }

}
