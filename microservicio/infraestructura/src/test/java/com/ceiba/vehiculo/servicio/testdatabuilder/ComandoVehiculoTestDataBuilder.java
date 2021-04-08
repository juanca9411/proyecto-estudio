package com.ceiba.vehiculo.servicio.testdatabuilder;


import com.ceiba.usuario.comando.ComandoVehiculo;

public class ComandoVehiculoTestDataBuilder {
    public static final Long ID_VEHICULO = 1L;
    public static final String PLACA = "KHW980";
    public static final Integer CILINDRAJE = 1600;
    public static final String TIPO = "AUTOMOVIL";

    private Long idVehiculo;
    private String placa;
    private Integer cilindraje;
    private String tipo;

    public ComandoVehiculoTestDataBuilder() {
        this.idVehiculo = ID_VEHICULO;
        this.placa = PLACA;
        this.cilindraje = CILINDRAJE;
        this.tipo = TIPO;
    }

    public ComandoVehiculoTestDataBuilder conIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
        return this;
    }

    public ComandoVehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ComandoVehiculoTestDataBuilder conCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public ComandoVehiculoTestDataBuilder conTipo(String tipo) {
        this.tipo = (tipo.isEmpty() ? null : tipo.toUpperCase());
        return this;
    }

    public ComandoVehiculo build(){
        return new ComandoVehiculo(idVehiculo,placa,cilindraje,tipo);
    }

}
