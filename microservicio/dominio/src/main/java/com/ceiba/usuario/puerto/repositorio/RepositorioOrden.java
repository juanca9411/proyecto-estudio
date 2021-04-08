package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Orden;

public interface RepositorioOrden {

    Long registrar(Orden orden);

    Boolean actualizar(Orden orden);

    Boolean eliminar(Long idOrden);

    Boolean existe(Long idOrden);

}
