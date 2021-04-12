package com.ceiba.usuario.modelo.entidad;


import com.ceiba.dominio.excepcion.ExcepcionCilindrajeMaximoPermitido;
import com.ceiba.dominio.excepcion.ExcepcionTipoVehiculoPermitido;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Vehiculo {

    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa del vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_CILINDRAJE = "Se debe ingresar el cilindraje del vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_TIPO = "Se debe ingresar el tipo del vehiculo";
    private static final String VEHICULO_SUPERA_EL_CILINDRAJE_MAXIMO_PERMITIDO = "El vehiculo tiene un cilindraje mayor al permitido (5000)";
    private static final String SOLO_SE_PERMITEN_VEHICULOS_TIPO_DEFINIDOS = "Solo se permiten vehiculos tipo MOTO y AUTOMOVIL";

    private static final Integer CILINDRAJE_MAXIMO_PERMITIDO = 5000;
    private static final String TIPO_MOTO_PERMITIDO = "MOTO";
    private static final String TIPO_AUTOMOVIL_PERMITIDO = "AUTOMOVIL";


    private Long idVehiculo;
    private String placa;
    private Integer cilindraje;
    private String tipo;

    public Vehiculo(Long idVehiculo, String placa, Integer cilindraje, String tipo) {
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarObligatorio(cilindraje, SE_DEBE_INGRESAR_EL_CILINDRAJE);
        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO);

        validarCilindrajeVehiculo(cilindraje);
        validarTipoDeVehiculoPorIngresar(tipo);

        this.placa = placa;
        this.cilindraje = cilindraje;
        this.tipo = tipo.toUpperCase();
        this.idVehiculo = idVehiculo;
    }

    private void validarCilindrajeVehiculo(Integer cilindraje) {
        if (cilindraje > CILINDRAJE_MAXIMO_PERMITIDO) {
            throw new ExcepcionCilindrajeMaximoPermitido(VEHICULO_SUPERA_EL_CILINDRAJE_MAXIMO_PERMITIDO);
        }
    }

    private void validarTipoDeVehiculoPorIngresar(String tipo) {
        if (!tipo.equals(TIPO_MOTO_PERMITIDO) && !tipo.equals(TIPO_AUTOMOVIL_PERMITIDO)) {
            throw new ExcepcionTipoVehiculoPermitido(SOLO_SE_PERMITEN_VEHICULOS_TIPO_DEFINIDOS);
        }
    }


}
