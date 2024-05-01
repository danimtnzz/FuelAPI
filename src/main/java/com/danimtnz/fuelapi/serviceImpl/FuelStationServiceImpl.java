package com.danimtnz.fuelapi.serviceImpl;

import com.danimtnz.fuelapi.external.FuelStationResponseList;
import com.danimtnz.fuelapi.mappers.FuelStationMapper;
import com.danimtnz.fuelapi.model.FuelStation;
import com.danimtnz.fuelapi.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FuelStationServiceImpl implements FuelStationService {

    @Autowired
    private FuelStationMapper fuelStationMapper;

    @Override
    public List<FuelStation> getAllFuelStations() {
        return callExternalAPIForFuelStations();
    }

    @Override
    public List<FuelStation> getFuelStationsWithinRadius(double latitude, double longitude, double radiusInKm) {
        List<FuelStation> allFuelStations = callExternalAPIForFuelStations();

        List<FuelStation> fuelStationsWithinRadius = new ArrayList<>();

        for (FuelStation station : allFuelStations) {
            double stationLat = Double.parseDouble(station.getLatitud().replace(",", "."));
            double stationLon = Double.parseDouble(station.getLongitud().replace(",", "."));

            double distance = distance(latitude, longitude, stationLat, stationLon);

            if (distance <= radiusInKm) {
                fuelStationsWithinRadius.add(station);
            }
        }

        return fuelStationsWithinRadius;
    }

    // Helper method to calculate distance between two points using Haversine formula
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // distance in km
    }


    private List<FuelStation> callExternalAPIForFuelStations() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<FuelStationResponseList> response = restTemplate.exchange(
                "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/",
                HttpMethod.GET,
                entity,
                FuelStationResponseList.class);

        List<FuelStation> fuelStations = new ArrayList<>();

        if (response.getStatusCode().is2xxSuccessful()) {
            FuelStationResponseList fuelStationResponseList = response.getBody();
            if (fuelStationResponseList != null && fuelStationResponseList.getListaEESSPrecio() != null) {
                // Use mapToFuelStations method to map the entire list
                fuelStations = fuelStationMapper.mapToFuelStations(fuelStationResponseList);
            }
        }

        return fuelStations;
    }
}
