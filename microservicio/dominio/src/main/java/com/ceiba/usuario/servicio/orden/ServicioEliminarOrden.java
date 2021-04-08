package com.ceiba.usuario.servicio.orden;

import com.ceiba.dominio.excepcion.ExepcionOrdenYaIngresada;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;

public class ServicioEliminarOrden {

    private static final String NO_EXISTE_ORDEN="No existe esta orden";
    private final RepositorioOrden repositorioOrden;

    public ServicioEliminarOrden(RepositorioOrden repositorioOrden) {
        this.repositorioOrden = repositorioOrden;
    }

    public Boolean ejecutar(Long idOrden){
        validarExistenciaOrden(idOrden);
        return this.repositorioOrden.eliminar(idOrden);
    }

    private void validarExistenciaOrden(Long idOrden){
        if (!this.repositorioOrden.existe(idOrden)){
            throw new ExepcionOrdenYaIngresada(NO_EXISTE_ORDEN);
        }
    }
}
