package com.parking.service;

import com.parking.dao.ParkingDao;
import com.parking.dto.Parking;

import java.util.List;

public class ParkingService {
    public List<Parking> getParkings(){
        return new ParkingDao().listar();
    }

    public Parking getParking(Parking parking){
        return new ParkingDao().findById(parking);
    }

    public List<Parking> getParkingsFiltered(String parkingName){
        return new ParkingDao().listByName(parkingName);
    }

    public int updateParking(Parking parking){
        return new ParkingDao().update(parking);
    }

    public int insertParking(Parking parking){
        return new ParkingDao().create(parking);
    }

    public int deleteParking(Parking parking){
        return new ParkingDao().delete(parking);
    }

}
