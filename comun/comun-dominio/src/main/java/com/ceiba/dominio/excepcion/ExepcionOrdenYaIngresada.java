package com.ceiba.dominio.excepcion;

public class ExepcionOrdenYaIngresada extends RuntimeException {

    public ExepcionOrdenYaIngresada(String mensaje) {
        super(mensaje);
    }
}
