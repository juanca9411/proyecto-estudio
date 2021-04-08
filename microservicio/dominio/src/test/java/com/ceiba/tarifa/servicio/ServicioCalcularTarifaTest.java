package com.ceiba.tarifa.servicio;

import com.ceiba.tarifa.servicio.datatestbuilder.TarifaDataTestBuilder;
import com.ceiba.usuario.modelo.entidad.Tarifa;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class ServicioCalcularTarifaTest {

    @Test
    public void calcularTarifaAutomovil(){
        //arragne
        Tarifa tarifa = new TarifaDataTestBuilder().build();
        LocalDateTime fechaIngreso = LocalDateTime.of(2021,4,7,10,5);
        LocalDateTime fechaSalida = LocalDateTime.of(2021,4,8,10,5);
        //act
        double valorTotal = tarifa.calcularTarifaAutomovil(fechaIngreso,fechaSalida);
        //
        Assert.assertEquals(43200.0,valorTotal,0.0);
    }

    @Test
    public void calcularTarifaMoto(){
        //arragne
        Tarifa tarifa = new TarifaDataTestBuilder().build();
        LocalDateTime fechaIngreso = LocalDateTime.of(2021,4,7,10,5);
        LocalDateTime fechaSalida = LocalDateTime.of(2021,4,8,10,5);
        //act
        double valorTotal = tarifa.calcularTarifaMoto(fechaIngreso,fechaSalida);
        //
        Assert.assertEquals(24000.0,valorTotal,0.0);
    }
}
