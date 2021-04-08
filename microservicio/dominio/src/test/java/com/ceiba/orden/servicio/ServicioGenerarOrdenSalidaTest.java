package com.ceiba.orden.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDiaNoHabil;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.excepcion.ExepcionOrdenYaIngresada;
import com.ceiba.orden.servicio.testdatabuilder.OrdenDataTestBuilder;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.usuario.servicio.orden.ServicioGenerarOrdenSalida;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class ServicioGenerarOrdenSalidaTest {

    @Test
    public void validarExistenciaOrden() {
        //arrange
        Orden orden = new OrdenDataTestBuilder().build();
        RepositorioOrden repositorioOrden = Mockito.mock(RepositorioOrden.class);
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioOrden.existe(orden.getIdOrden())).thenReturn(false);
        ServicioGenerarOrdenSalida servicioGenerarOrdenSalida = new ServicioGenerarOrdenSalida(repositorioOrden, repositorioVehiculo);
        //act-assert
        BasePrueba.assertThrows(() -> servicioGenerarOrdenSalida.ejecutar(orden), ExepcionOrdenYaIngresada.class, "No existe esta orden");
    }

    @Test
    public void validarGenerarOrden() {
        // arragne
        Orden orden = new OrdenDataTestBuilder()
                .conPlaca("KHW901")
                .build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.getTipoVehiculo(orden.getPlaca())).thenReturn(null);
        //act-assert
        String tipoVehiculo = repositorioVehiculo.getTipoVehiculo(orden.getPlaca());
        BasePrueba.assertThrows(() -> validarObligatorio(tipoVehiculo, "Se debe ingresar el tipo de vehiculo"), ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de vehiculo");

    }

    @Test
    public void validarGenerarOrdenDeSalidaFechaSalidaNull() {
        //arrange
        Orden orden = new OrdenDataTestBuilder()
                .build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.getTipoVehiculo(orden.getPlaca())).thenReturn("AUTOMOVIL");
        String tipoVehiculo = repositorioVehiculo.getTipoVehiculo(orden.getPlaca());
        var valorTotalOld = orden.getValorTotal();
        //act-assert
        BasePrueba.assertThrows(() -> orden.generarOrdenSalida(tipoVehiculo), ExcepcionValorObligatorio.class, "Para finalizar la orden es necesario ingresar una fecha de salida");

    }

    @Test
    public void validarGenerarOrdenDeSalidaFechaSalidaFinDeSemana() {
        //arrange
        Orden orden = new OrdenDataTestBuilder()
                .conFechaSalida(LocalDateTime.of(2021,04,10,5,00))
                .build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.getTipoVehiculo(orden.getPlaca())).thenReturn("AUTOMOVIL");
        String tipoVehiculo = repositorioVehiculo.getTipoVehiculo(orden.getPlaca());
        var valorTotalOld = orden.getValorTotal();
        //act-assert
        BasePrueba.assertThrows(() -> orden.generarOrdenSalida(tipoVehiculo), ExcepcionDiaNoHabil.class, "Solo se pueden ingresar o salir vehiculos en dias habiles");

    }



    @Test
    public void validarGenerarOrdenDeSalida() {
        //arrange
        Orden orden = new OrdenDataTestBuilder()
                .conFechaSalida(LocalDateTime.of(2021, 04, 8, 10, 8))
                .build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.getTipoVehiculo(orden.getPlaca())).thenReturn("AUTOMOVIL");
        String tipoVehiculo = repositorioVehiculo.getTipoVehiculo(orden.getPlaca());
        var valorTotalOld = orden.getValorTotal();
        //act
        orden.generarOrdenSalida(tipoVehiculo);
        //assert
        Assert.assertNotEquals(valorTotalOld, orden.getValorTotal());

    }
}
