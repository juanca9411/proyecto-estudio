package com.ceiba.orden.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDiaNoHabil;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.excepcion.ExepcionOrdenYaIngresada;
import com.ceiba.orden.servicio.testdatabuilder.OrdenDataTestBuilder;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.servicio.orden.ServicioRegistrarOrden;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioRegistrarOrdenTest {

    @Test
    public void validarFechaFindeSemana() {
        //arrange
        OrdenDataTestBuilder ordenDataTestBuilder = new OrdenDataTestBuilder()
                .conFechaIngreso(LocalDateTime.of(2021, 04, 10, 00, 00));
        //act-assert
        BasePrueba.assertThrows(() -> ordenDataTestBuilder.build(), ExcepcionDiaNoHabil.class, "Solo se pueden ingresar o salir vehiculos en dias habiles");
    }

    @Test
    public void validarPlacaNoNull() {
        //arragne
        OrdenDataTestBuilder ordenDataTestBuilder = new OrdenDataTestBuilder()
                .conPlaca(null);

        //act-assert
        BasePrueba.assertThrows(() -> ordenDataTestBuilder.build(), ExcepcionValorObligatorio.class, "La placa del vehiculo es obligatoria");
    }

    @Test
    public void validarFechaIngresoNoNull() {
        // arrange
        OrdenDataTestBuilder ordenDataTestBuilder = new OrdenDataTestBuilder()
                .conFechaIngreso(null);

        //act-assert
        BasePrueba.assertThrows(() -> ordenDataTestBuilder.build(), ExcepcionValorObligatorio.class, "La fecha de ingreso es obligatoria");
    }

    @Test
    public void validarExistenciaOrden(){
        //arrange
        Orden orden = new OrdenDataTestBuilder().build();
        RepositorioOrden repositorioOrden = Mockito.mock(RepositorioOrden.class);
        Mockito.when(repositorioOrden.existe(orden.getIdOrden())).thenReturn(true);
        ServicioRegistrarOrden servicioRegistrarOrden = new ServicioRegistrarOrden(repositorioOrden);
        //act-assert
        BasePrueba.assertThrows(()->servicioRegistrarOrden.ejecutar(orden), ExepcionOrdenYaIngresada.class,"Ya existe esta orden");
    }

}
