package com.ceiba.usuario.servicio.orden;

import com.ceiba.dominio.excepcion.ExepcionOrdenYaIngresada;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;

public class ServicioRegistrarOrden {

    private static final String YA_EXISTE_ESTA_ORDEN="Ya existe esta orden";
    private final RepositorioOrden repositorioOrden;


    public ServicioRegistrarOrden(RepositorioOrden repositorioOrden) {
        this.repositorioOrden = repositorioOrden;
    }

    public Long ejecutar(Orden orden){
        validarExistenciaOrden(orden);
       return this.repositorioOrden.registrar(orden);
    }

    private void validarExistenciaOrden(Orden orden){
        if (this.repositorioOrden.existe(orden.getIdOrden())){
            throw new ExepcionOrdenYaIngresada(YA_EXISTE_ESTA_ORDEN);
        }
    }
}
