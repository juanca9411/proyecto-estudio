package com.ceiba.usuario.consulta.orden;

import com.ceiba.usuario.modelo.dto.DtoOrden;
import com.ceiba.usuario.puerto.dao.DaoOrden;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorGetDetalleOrden {

    private final DaoOrden daoOrden;

    public ManejadorGetDetalleOrden(DaoOrden daoOrden) {
        this.daoOrden = daoOrden;
    }

    public List<DtoOrden> listar(Long idOrden) {
        return this.daoOrden.getDetalle(idOrden);
    }
}
