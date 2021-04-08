package com.ceiba.vehiculo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoVehiculo;
import com.ceiba.usuario.comando.manejador.vehiculo.ManejadorActualizarVehiculo;
import com.ceiba.usuario.comando.manejador.vehiculo.ManejadorRegistrarVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class ComandoControladorVehiculo {

    private final ManejadorRegistrarVehiculo manejadorRegistrarVehiculo;
    private final ManejadorActualizarVehiculo manejadorActualizarVehiculo;

    @Autowired
    public ComandoControladorVehiculo(ManejadorRegistrarVehiculo manejadorRegistrarVehiculo, ManejadorActualizarVehiculo manejadorActualizarVehiculo){
        this.manejadorRegistrarVehiculo=manejadorRegistrarVehiculo;
        this.manejadorActualizarVehiculo=manejadorActualizarVehiculo;
    }

    @PostMapping()
    public ComandoRespuesta<Long> registrar(@RequestBody ComandoVehiculo comandoVehiculo){
        return this.manejadorRegistrarVehiculo.ejecutar(comandoVehiculo);
    }

    @PutMapping()
    public ComandoRespuesta<Boolean> actualizar(@RequestBody ComandoVehiculo comandoVehiculo){
        return this.manejadorActualizarVehiculo.ejecutar(comandoVehiculo);
    }


}
