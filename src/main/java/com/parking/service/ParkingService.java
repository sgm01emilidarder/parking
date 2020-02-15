package com.parking.service;

import com.parking.dao.ParkingDao;
import com.parking.dto.Parking;

import java.util.List;

public class ParkingService {
    public List<Parking> getParkings(){
        return new ParkingDao().listar();
    }
}
