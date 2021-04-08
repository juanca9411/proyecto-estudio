package com.ceiba.tarifa.servicio.datatestbuilder;

import com.ceiba.usuario.modelo.entidad.Tarifa;

public class TarifaDataTestBuilder {

    private static final Integer FRACCION = 60;
    private static final Double TARIFA_MOTO = 1000.0;
    private static final Double TARIFA_AUTOMOVIL = 1800.0;

    private Double tarifaMoto;
    private Double tarifaAutomovil;

    public TarifaDataTestBuilder() {
        this.tarifaMoto = TARIFA_MOTO;
        this.tarifaAutomovil = TARIFA_AUTOMOVIL;
    }

    public TarifaDataTestBuilder conTarifaMoto(Double tarifaMoto) {
        this.tarifaMoto=tarifaMoto;
        return this;
    }

    public TarifaDataTestBuilder conTarifaAutomovil(Double tarifaAutomovil) {
        this.tarifaAutomovil=tarifaAutomovil;
        return this;
    }

    public Tarifa build(){
        return new Tarifa(tarifaMoto,tarifaAutomovil);
    }

}
