package com.ceiba.usuario.comando.manejador.vehiculo;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoVehiculo;
import com.ceiba.usuario.comando.fabrica.vehiculo.FabricaVehiculo;
import com.ceiba.usuario.modelo.entidad.Vehiculo;
import com.ceiba.usuario.servicio.vehiculo.ServicioActualizarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarVehiculo implements ManejadorComandoRespuesta<ComandoVehiculo,ComandoRespuesta<Boolean>> {

    private final FabricaVehiculo fabricaVehiculo;
    private final ServicioActualizarVehiculo servicioActualizarVehiculo;

    public ManejadorActualizarVehiculo(FabricaVehiculo fabricaVehiculo, ServicioActualizarVehiculo servicioActualizarVehiculo){
        this.fabricaVehiculo=fabricaVehiculo;
        this.servicioActualizarVehiculo=servicioActualizarVehiculo;
    }

    public ComandoRespuesta<Boolean> ejecutar(ComandoVehiculo comandoVehiculo) {
        Vehiculo vehiculo = this.fabricaVehiculo.crear(comandoVehiculo);
       return new ComandoRespuesta<>(this.servicioActualizarVehiculo.ejecutar(vehiculo));
    }
}
