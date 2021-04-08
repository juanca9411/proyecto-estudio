package com.ceiba.dominio.excepcion;

public class ExcepcionTipoVehiculoPermitido extends RuntimeException{
        public ExcepcionTipoVehiculoPermitido(String mensaje){
            super(mensaje);
        }
}
