package com.ceiba.orden.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExepcionOrdenYaIngresada;
import com.ceiba.orden.servicio.testdatabuilder.OrdenDataTestBuilder;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.servicio.orden.ServicioActualizarOrden;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarOrdenTest {
    @Test
    public void validarExistenciaOrden() {
        //arrange
        Orden orden = new OrdenDataTestBuilder().build();
        RepositorioOrden repositorioOrden = Mockito.mock(RepositorioOrden.class);
        Mockito.when(repositorioOrden.existe(orden.getIdOrden())).thenReturn(false);
        ServicioActualizarOrden servicioActualizarOrden = new ServicioActualizarOrden(repositorioOrden);
        //act-assert
        BasePrueba.assertThrows(() -> servicioActualizarOrden.ejecutar(orden), ExepcionOrdenYaIngresada.class, "No existe esta orden");
    }
}
