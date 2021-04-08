package com.ceiba.dominio.excepcion;

public class ExcepcionDiaNoHabil extends RuntimeException{

    public ExcepcionDiaNoHabil(String mensaje){
        super(mensaje);
    }
}
