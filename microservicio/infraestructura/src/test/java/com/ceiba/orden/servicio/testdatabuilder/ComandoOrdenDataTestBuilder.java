package com.ceiba.orden.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoOrden;

import java.time.LocalDateTime;

public class ComandoOrdenDataTestBuilder {

    private static final Long ID_ORDEN = 1L;
    private static final String PLACA = "KHW980";
    private static final LocalDateTime FECHA_INGRESO = LocalDateTime.now();
    private static final LocalDateTime FECHA_SALIDA = null;
    private static final Double VALOR_TOTAL = 0.0;

    private Long idOrden;
    private String placa;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private Double valorTotal;

    public ComandoOrdenDataTestBuilder(){
        this.idOrden=ID_ORDEN;
        this.placa=PLACA;
        this.fechaIngreso=FECHA_INGRESO;
        this.fechaSalida=FECHA_SALIDA;
        this.valorTotal=VALOR_TOTAL;
    }

    public ComandoOrdenDataTestBuilder conIdOrden(Long idOrden){
        this.idOrden=idOrden;
        return this;
    }

    public ComandoOrdenDataTestBuilder conPlaca(String placa){
        this.placa=placa;
        return this;
    }

    public ComandoOrdenDataTestBuilder conFechaIngreso(LocalDateTime fechaIngreso){
        this.fechaIngreso=fechaIngreso;
        return this;
    }

    public ComandoOrdenDataTestBuilder conFechaSalida(LocalDateTime fechaSalida){
        this.fechaSalida=fechaSalida;
        return this;
    }

    public ComandoOrdenDataTestBuilder conValorTotal(Double valorTotal){
        this.valorTotal=valorTotal;
        return this;
    }

    public ComandoOrden build(){
        return new ComandoOrden(idOrden,placa,fechaIngreso,fechaSalida,valorTotal);
    }






}
