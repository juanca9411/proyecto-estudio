package com.ceiba.usuario.comando.manejador.vehiculo;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoVehiculo;
import com.ceiba.usuario.comando.fabrica.vehiculo.FabricaVehiculo;
import com.ceiba.usuario.modelo.entidad.Vehiculo;
import com.ceiba.usuario.servicio.vehiculo.ServicioRegistrarVehiculo;
import org.springframework.stereotype.Component;


@Component
public class ManejadorRegistrarVehiculo implements ManejadorComandoRespuesta<ComandoVehiculo, ComandoRespuesta<Long>> {


    private final ServicioRegistrarVehiculo servicioRegistrarVehiculo;
    private final FabricaVehiculo fabricaVehiculo;

    public ManejadorRegistrarVehiculo(ServicioRegistrarVehiculo servicioRegistrarVehiculo, FabricaVehiculo fabricaVehiculo) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioRegistrarVehiculo = servicioRegistrarVehiculo;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoVehiculo comandoVehiculo) {
        Vehiculo vehiculo = this.fabricaVehiculo.crear(comandoVehiculo);
        return new ComandoRespuesta<>(this.servicioRegistrarVehiculo.ejecutar(vehiculo));
    }


}
