package com.ceiba.orden.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Orden;

import java.time.LocalDateTime;

public class OrdenDataTestBuilder {

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

    public OrdenDataTestBuilder() {
        this.idOrden = ID_ORDEN;
        this.placa = PLACA;
        this.fechaIngreso = FECHA_INGRESO;
        this.fechaSalida = FECHA_SALIDA;
        this.valorTotal = VALOR_TOTAL;
    }

    public OrdenDataTestBuilder conIdOrden(Long idOrden) {
        this.idOrden = idOrden;
        return this;
    }

    public OrdenDataTestBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public OrdenDataTestBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public OrdenDataTestBuilder conFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public OrdenDataTestBuilder conValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Orden build() {
        return new Orden(idOrden, placa, fechaIngreso, fechaSalida, valorTotal);
    }


}
