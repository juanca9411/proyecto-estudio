package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCilindrajeMaximoPermitido;
import com.ceiba.dominio.excepcion.ExcepcionTipoVehiculoPermitido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.excepcion.ExcepcionVehiculoYaIngresado;
import com.ceiba.usuario.modelo.entidad.Vehiculo;
import com.ceiba.usuario.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.usuario.servicio.vehiculo.ServicioRegistrarVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioRegistrarVehiculoTest {

    @Test
    public void validarIdVehiculoNull() {
        // arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conIdVehiculo(null).build();
        // act
        String placa = vehiculo.getPlaca();

        //assert
        Assert.assertEquals("KHW980", placa);
    }

    @Test
    public void validarPlacaNull() {
        //arrange
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder()
                .conPlaca(null);
        //act assert
        BasePrueba.assertThrows(() -> vehiculo.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la placa del vehiculo");

    }

    @Test
    public void validarCilindrajeNull() {
        //arrange
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder()
                .conCilindraje(null);
        //act assert
        BasePrueba.assertThrows(() -> vehiculo.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el cilindraje del vehiculo");

    }

    @Test
    public void validarTipoNull() {
        //arrange
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder()
                .conTipo("");
        //act assert
        BasePrueba.assertThrows(() -> vehiculo.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el tipo del vehiculo");

    }

    @Test
    public void validarCilindrajeVehiculo() {
        //arrange
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder()
                .conCilindraje(5001);
        //act-assert
        BasePrueba.assertThrows(() -> vehiculo.build(), ExcepcionCilindrajeMaximoPermitido.class, "El vehiculo tiene un cilindraje mayor al permitido (5000)");
    }

    @Test
    public void validarTipoDeVehiculoPorIngresar(){
        //arragne
        VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder()
                .conTipo("motocarro");
        //act-assert
        BasePrueba.assertThrows(()->vehiculo.build(), ExcepcionTipoVehiculoPermitido.class,"Solo se permiten vehiculos tipo MOTO y AUTOMOVIL");
    }


    @Test
    public void validarExistenciaPrevia() {
        //arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existe(vehiculo.getPlaca())).thenReturn(true);
        ServicioRegistrarVehiculo servicioRegistrarVehiculo = new ServicioRegistrarVehiculo(repositorioVehiculo);
        //act- assert
        BasePrueba.assertThrows(() -> servicioRegistrarVehiculo.ejecutar(vehiculo), ExcepcionVehiculoYaIngresado.class, "El vehiculo ya se encuentra ingresado");
    }
}
