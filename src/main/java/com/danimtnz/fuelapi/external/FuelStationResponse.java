package com.danimtnz.fuelapi.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FuelStationResponse {

    @JsonProperty("C.P.")
    private String cp;

    @JsonProperty("Dirección")
    private String direccion;

    @JsonProperty("Horario")
    private String horario;

    @JsonProperty("Latitud")
    private String latitud;

    @JsonProperty("Localidad")
    private String localidad;

    @JsonProperty("Longitud (WGS84)")
    private String longitud;

    @JsonProperty("Margen")
    private String margen;

    @JsonProperty("Municipio")
    private String municipio;

    @JsonProperty("Precio Biodiesel")
    private String precioBiodiesel;

    @JsonProperty("Precio Bioetanol")
    private String precioBioetanol;

    @JsonProperty("Precio Gas Natural Comprimido")
    private String precioGasNaturalComprimido;

    @JsonProperty("Precio Gas Natural Licuado")
    private String precioGasNaturalLicuado;

    @JsonProperty("Precio Gases licuados del petróleo")
    private String precioGasesLicuadosDelPetroleo;

    @JsonProperty("Precio Gasoleo A")
    private String precioGasoleoA;

    @JsonProperty("Precio Gasoleo B")
    private String precioGasoleoB;

    @JsonProperty("Precio Gasoleo Premium")
    private String precioGasoleoPremium;

    @JsonProperty("Precio Gasolina 95 E10")
    private String precioGasolina95E10;

    @JsonProperty("Precio Gasolina 95 E5")
    private String precioGasolina95E5;

    @JsonProperty("Precio Gasolina 95 E5 Premium")
    private String precioGasolina95E5Premium;

    @JsonProperty("Precio Gasolina 98 E10")
    private String precioGasolina98E10;

    @JsonProperty("Precio Gasolina 98 E5")
    private String precioGasolina98E5;

    @JsonProperty("Precio Hidrogeno")
    private String precioHidrogeno;

    @JsonProperty("Provincia")
    private String provincia;

    @JsonProperty("Remisión")
    private String remision;

    @JsonProperty("Rótulo")
    private String rotulo;

    @JsonProperty("Tipo Venta")
    private String tipoVenta;

    @JsonProperty("% BioEtanol")
    private String bioetanol;

    @JsonProperty("% Éster metílico")
    private String esterMetilico;

    @JsonProperty("IDEESS")
    private String idEess;

    @JsonProperty("IDMunicipio")
    private String idMunicipio;

    @JsonProperty("IDProvincia")
    private String idProvincia;

    @JsonProperty("IDCCAA")
    private String idCcaa;
}
