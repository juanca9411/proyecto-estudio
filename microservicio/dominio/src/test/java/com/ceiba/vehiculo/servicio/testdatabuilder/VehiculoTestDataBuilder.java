package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Vehiculo;

import java.util.Locale;

public class VehiculoTestDataBuilder {

    public static final Long ID_VEHICULO = 1L;
    public static final String PLACA = "KHW980";
    public static final Integer CILINDRAJE = 1600;
    public static final String TIPO = "AUTOMOVIL";

    private Long idVehiculo;
    private String placa;
    private Integer cilindraje;
    private String tipo;

    public VehiculoTestDataBuilder() {
        this.idVehiculo = ID_VEHICULO;
        this.placa = PLACA;
        this.cilindraje = CILINDRAJE;
        this.tipo = TIPO;
    }

    public VehiculoTestDataBuilder conIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
        return this;
    }

    public VehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder conCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public VehiculoTestDataBuilder conTipo(String tipo) {
        this.tipo = (tipo.isEmpty() ? null : tipo.toUpperCase());
        return this;
    }

    public Vehiculo build(){
        return new Vehiculo(idVehiculo,placa,cilindraje,tipo);
    }

}
