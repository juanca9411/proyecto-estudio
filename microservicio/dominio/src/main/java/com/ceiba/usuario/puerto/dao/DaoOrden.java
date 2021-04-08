package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoOrden;

import java.util.List;

public interface DaoOrden {

    List<DtoOrden> listar();

    List<DtoOrden> getDetalle(Long idOrden);
}
