package com.ceiba.usuario.comando.fabrica.vehiculo;

import com.ceiba.usuario.comando.ComandoVehiculo;
import com.ceiba.usuario.modelo.entidad.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class FabricaVehiculo {

    public Vehiculo crear(ComandoVehiculo comandoVehiculo) {
        return new Vehiculo(
                comandoVehiculo.getIdVehiculo(),
                comandoVehiculo.getPlaca(),
                comandoVehiculo.getCilindraje(),
                comandoVehiculo.getTipo().toUpperCase()
        );
    }
}
