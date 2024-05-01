package com.danimtnz.fuelapi.service;

import com.danimtnz.fuelapi.model.FuelStation;

import java.util.List;

public interface FuelStationService {
    List<FuelStation> getAllFuelStations();
    List<FuelStation> getFuelStationsWithinRadius(double latitude, double longitude, double radiusInKm);
}
