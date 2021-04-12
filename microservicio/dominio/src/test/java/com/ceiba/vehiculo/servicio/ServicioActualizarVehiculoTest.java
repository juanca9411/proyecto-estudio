package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionVehiculoYaIngresado;
import com.ceiba.usuario.modelo.entidad.Vehiculo;
import com.ceiba.usuario.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.usuario.servicio.vehiculo.ServicioActualizarVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarVehiculoTest {

    @Test
    public void validarVehiculoIngresado() {
        //arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conPlaca("KHW970")
                .build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existe(vehiculo.getPlaca())).thenReturn(false);
        ServicioActualizarVehiculo servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);
        // act-assert
        BasePrueba.assertThrows(() -> servicioActualizarVehiculo.ejecutar(vehiculo), ExcepcionVehiculoYaIngresado.class, "El vehiculo no existe en el sistema");
    }

}
