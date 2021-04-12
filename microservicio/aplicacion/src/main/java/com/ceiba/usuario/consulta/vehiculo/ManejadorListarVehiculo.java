package com.ceiba.usuario.consulta.vehiculo;

import com.ceiba.usuario.modelo.dto.DtoVehiculo;
import com.ceiba.usuario.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarVehiculo {

    private final DaoVehiculo daoVehiculo;

    public ManejadorListarVehiculo(DaoVehiculo daoVehiculo) {
        this.daoVehiculo = daoVehiculo;
    }

    public List<DtoVehiculo> ejecutar() {
        return this.daoVehiculo.listar();
    }

}
