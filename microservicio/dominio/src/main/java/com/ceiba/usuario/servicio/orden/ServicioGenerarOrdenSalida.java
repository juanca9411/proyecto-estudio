package com.ceiba.usuario.servicio.orden;

import com.ceiba.dominio.excepcion.ExepcionOrdenYaIngresada;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioVehiculo;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


public class ServicioGenerarOrdenSalida {

    private static final String NO_EXISTE_ORDEN="No existe esta orden";
    private static final String EL_TIPO_DEL_VEHICULO_ES_OBLIGATORIO="Se debe ingresar el tipo de vehiculo";
    private final RepositorioOrden repositorioOrden;
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioGenerarOrdenSalida(RepositorioOrden repositorioOrden, RepositorioVehiculo repositorioVehiculo) {
        this.repositorioOrden = repositorioOrden;
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public Boolean ejecutar(Orden orden){
        validarExistenciaOrden(orden);
        generarOrden(orden);
        return this.repositorioOrden.actualizar(orden);
    }

    private void validarExistenciaOrden(Orden orden){
        if (!this.repositorioOrden.existe(orden.getIdOrden())){
            throw new ExepcionOrdenYaIngresada(NO_EXISTE_ORDEN);
        }
    }

    private void generarOrden(Orden orden){
        String tipoVehiculo = this.repositorioVehiculo.getTipoVehiculo(orden.getPlaca());
        validarObligatorio(tipoVehiculo, EL_TIPO_DEL_VEHICULO_ES_OBLIGATORIO);
        orden.generarOrdenSalida(tipoVehiculo.toUpperCase());
    }
}
