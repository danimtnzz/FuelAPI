package com.danimtnz.fuelapi.mappers;

import com.danimtnz.fuelapi.external.FuelStationResponse;
import com.danimtnz.fuelapi.external.FuelStationResponseList;
import com.danimtnz.fuelapi.model.FuelStation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FuelStationMapper {

    public List<FuelStation> mapToFuelStations(FuelStationResponseList responseList) {
        return responseList.getListaEESSPrecio().stream()
                .map(this::mapToFuelStation)
                .collect(Collectors.toList());
    }

    public FuelStation mapToFuelStation(FuelStationResponse response) {
        FuelStation fuelStation = new FuelStation();
        fuelStation.setCp(response.getCp());
        fuelStation.setDireccion(response.getDireccion());
        fuelStation.setHorario(response.getHorario());
        fuelStation.setLatitud(response.getLatitud());
        fuelStation.setLocalidad(response.getLocalidad());
        fuelStation.setLongitud(response.getLongitud());
        fuelStation.setMargen(response.getMargen());
        fuelStation.setMunicipio(response.getMunicipio());
        fuelStation.setPrecioBiodiesel(response.getPrecioBiodiesel());
        fuelStation.setPrecioBioetanol(response.getPrecioBioetanol());
        fuelStation.setPrecioGasNaturalComprimido(response.getPrecioGasNaturalComprimido());
        fuelStation.setPrecioGasNaturalLicuado(response.getPrecioGasNaturalLicuado());
        fuelStation.setPrecioGasesLicuadosDelPetroleo(response.getPrecioGasesLicuadosDelPetroleo());
        fuelStation.setPrecioGasoleoA(response.getPrecioGasoleoA());
        fuelStation.setPrecioGasoleoB(response.getPrecioGasoleoB());
        fuelStation.setPrecioGasoleoPremium(response.getPrecioGasoleoPremium());
        fuelStation.setPrecioGasolina95E10(response.getPrecioGasolina95E10());
        fuelStation.setPrecioGasolina95E5(response.getPrecioGasolina95E5());
        fuelStation.setPrecioGasolina95E5Premium(response.getPrecioGasolina95E5Premium());
        fuelStation.setPrecioGasolina98E10(response.getPrecioGasolina98E10());
        fuelStation.setPrecioGasolina98E5(response.getPrecioGasolina98E5());
        fuelStation.setPrecioHidrogeno(response.getPrecioHidrogeno());
        fuelStation.setProvincia(response.getProvincia());
        fuelStation.setRemision(response.getRemision());
        fuelStation.setRotulo(response.getRotulo());
        fuelStation.setTipoVenta(response.getTipoVenta());
        fuelStation.setBioetanol(response.getBioetanol());
        fuelStation.setEsterMetilico(response.getEsterMetilico());
        fuelStation.setIdEess(response.getIdEess());
        fuelStation.setIdMunicipio(response.getIdMunicipio());
        fuelStation.setIdProvincia(response.getIdProvincia());
        fuelStation.setIdCcaa(response.getIdCcaa());
        return fuelStation;
    }
}
