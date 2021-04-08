package com.ceiba.usuario.servicio.orden;

import com.ceiba.dominio.excepcion.ExepcionOrdenYaIngresada;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;

public class ServicioActualizarOrden {

    private static final String NO_EXISTE_ORDEN="No existe esta orden";
    private final RepositorioOrden repositorioOrden;

    public ServicioActualizarOrden(RepositorioOrden repositorioOrden) {
        this.repositorioOrden = repositorioOrden;
    }

    public Boolean ejecutar(Orden orden){
        validarExistenciaOrden(orden);
        return this.repositorioOrden.actualizar(orden);
    }

    private void validarExistenciaOrden(Orden orden){
        if (this.repositorioOrden.existe(orden.getIdOrden()).equals(false)){
            throw new ExepcionOrdenYaIngresada(NO_EXISTE_ORDEN);
        }
    }
}
