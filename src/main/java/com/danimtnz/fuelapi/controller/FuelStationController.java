package com.danimtnz.fuelapi.controller;

import com.danimtnz.fuelapi.model.FuelStation;
import com.danimtnz.fuelapi.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fuelstation")
public class FuelStationController {
    @Autowired
    private FuelStationService fuelStationService;

    @GetMapping
    public ResponseEntity<List<FuelStation>> getAllFuelStations() {
        List<FuelStation> fuelStations = fuelStationService.getAllFuelStations();
        return ResponseEntity.ok(fuelStations);
    }

    @GetMapping("/within-radius")
    public ResponseEntity<List<FuelStation>> getFuelStationsWithinRadius(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("radius") double radiusInKm) {

        List<FuelStation> fuelStations = fuelStationService.getFuelStationsWithinRadius(latitude, longitude, radiusInKm);
        return ResponseEntity.ok(fuelStations);
    }
}