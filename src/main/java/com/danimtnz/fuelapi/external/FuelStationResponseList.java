package com.danimtnz.fuelapi.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FuelStationResponseList {
    @JsonProperty("ListaEESSPrecio")
    private List<FuelStationResponse> listaEESSPrecio;
}
