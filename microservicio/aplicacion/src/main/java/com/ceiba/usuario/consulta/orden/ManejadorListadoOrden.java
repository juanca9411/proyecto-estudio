package com.ceiba.usuario.consulta.orden;

import com.ceiba.usuario.modelo.dto.DtoOrden;
import com.ceiba.usuario.puerto.dao.DaoOrden;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListadoOrden {

    private final DaoOrden daoOrden;

    public ManejadorListadoOrden(DaoOrden daoOrden) {
        this.daoOrden = daoOrden;
    }

    public List<DtoOrden> listar(){
        return this.daoOrden.listar();
    }
}
