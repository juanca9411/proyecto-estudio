package com.ceiba.usuario.servicio.vehiculo;

import com.ceiba.dominio.excepcion.ExcepcionVehiculoYaIngresado;
import com.ceiba.usuario.modelo.entidad.Vehiculo;
import com.ceiba.usuario.puerto.repositorio.RepositorioVehiculo;

public class ServicioRegistrarVehiculo {

    private static final String EXCEPCION_VEHICULO_YA_INGRESADO="El vehiculo ya se encuentra ingresado";
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioRegistrarVehiculo(RepositorioVehiculo repositorioVehiculo){
        this.repositorioVehiculo=repositorioVehiculo;
    }

    public Long ejecutar(Vehiculo vehiculo){
        validarVehiculoIngresado(vehiculo);
        return this.repositorioVehiculo.registrar(vehiculo);
    }

    private void validarVehiculoIngresado(Vehiculo vehiculo){
        if (this.repositorioVehiculo.existe(vehiculo.getPlaca())){
            throw new ExcepcionVehiculoYaIngresado(EXCEPCION_VEHICULO_YA_INGRESADO);
        }
    }

}
