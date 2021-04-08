package com.ceiba.usuario.consulta.vehiculo;

import com.ceiba.usuario.modelo.dto.DtoVehiculo;
import com.ceiba.usuario.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarVehiculoByPlaca {

    private final DaoVehiculo daoVehiculo;

    public ManejadorListarVehiculoByPlaca(DaoVehiculo daoVehiculo){
        this.daoVehiculo=daoVehiculo;
    }

    public List<DtoVehiculo> ejecutar(String placa){
        return this.daoVehiculo.listarByPlaca(placa);
    }
}
