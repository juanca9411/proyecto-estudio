package com.ceiba.dominio.excepcion;

public class ExcepcionCilindrajeMaximoPermitido extends RuntimeException{
    public ExcepcionCilindrajeMaximoPermitido(String mensaje){
        super(mensaje);
    }
}
