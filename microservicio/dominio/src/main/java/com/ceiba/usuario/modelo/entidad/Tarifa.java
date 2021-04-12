package com.ceiba.usuario.modelo.entidad;


import java.time.Duration;
import java.time.LocalDateTime;

public class Tarifa {

    private static final Integer FRACCION = 60;
    private static final Double TARIFA_MOTO = 1000.0;
    private static final Double TARIFA_AUTOMOVIL = 1800.0;


    private Double tarifaMoto;
    private Double tarifaAutomovil;

    public Tarifa() {
        this.tarifaMoto = TARIFA_MOTO;
        this.tarifaAutomovil = TARIFA_AUTOMOVIL;
    }

    public Tarifa(Double tarifaMoto, Double tarifaAutomovil) {
        this.tarifaMoto = tarifaMoto;
        this.tarifaAutomovil = tarifaAutomovil;
    }

    public Double calcularTarifaAutomovil(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        Long minutos = Duration.between(fechaIngreso, fechaSalida).toMinutes();
        return (this.tarifaAutomovil * minutos) / FRACCION;
    }

    public Double calcularTarifaMoto(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        Long minutos = Duration.between(fechaIngreso, fechaSalida).toMinutes();
        return (this.tarifaMoto * minutos) / FRACCION;
    }

    public Double calcularTotal(String tipoVehiculo, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        Double valorTotal;
        switch (tipoVehiculo) {
            case "AUTOMOVIL":
                valorTotal = calcularTarifaAutomovil(fechaIngreso, fechaSalida);
                break;
            case "MOTO":
                valorTotal = calcularTarifaMoto(fechaIngreso, fechaSalida);
                break;
            default:
                valorTotal = 0D;
        }
        return valorTotal;
    }

}
