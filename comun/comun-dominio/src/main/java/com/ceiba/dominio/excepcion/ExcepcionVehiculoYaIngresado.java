package com.ceiba.dominio.excepcion;

public class ExcepcionVehiculoYaIngresado extends RuntimeException{

    public ExcepcionVehiculoYaIngresado(String mensaje){
        super(mensaje);
    }
}
