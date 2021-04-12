package com.ceiba.usuario.servicio.vehiculo;

import com.ceiba.dominio.excepcion.ExcepcionVehiculoYaIngresado;
import com.ceiba.usuario.modelo.entidad.Vehiculo;
import com.ceiba.usuario.puerto.repositorio.RepositorioVehiculo;

public class ServicioActualizarVehiculo {

    private static final String EXCEPCION_VEHICULO_NO_EXISTE = "El vehiculo no existe en el sistema";
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public boolean ejecutar(Vehiculo vehiculo) {
        validarVehiculoIngresado(vehiculo);
        return this.repositorioVehiculo.actualizar(vehiculo);
    }

    private void validarVehiculoIngresado(Vehiculo vehiculo) {
        if (!this.repositorioVehiculo.existe(vehiculo.getPlaca()))
            throw new ExcepcionVehiculoYaIngresado(EXCEPCION_VEHICULO_NO_EXISTE);
    }
}
