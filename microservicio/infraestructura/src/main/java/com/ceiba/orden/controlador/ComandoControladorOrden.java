package com.ceiba.orden.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoOrden;
import com.ceiba.usuario.comando.manejador.orden.ManejadorActualizarOrden;
import com.ceiba.usuario.comando.manejador.orden.ManejadorEliminarOrden;
import com.ceiba.usuario.comando.manejador.orden.ManejadorGenerarOrdenSalida;
import com.ceiba.usuario.comando.manejador.orden.ManejadorRegistrarOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordenes")
public class ComandoControladorOrden {

    private final ManejadorRegistrarOrden manejadorRegistrarOrden;
    private final ManejadorActualizarOrden manejadorActualizarOrden;
    private final ManejadorEliminarOrden manejadorEliminarOrden;
    private final ManejadorGenerarOrdenSalida manejadorGenerarOrdenSalida;

    @Autowired
    public ComandoControladorOrden(ManejadorRegistrarOrden manejadorRegistrarOrden, ManejadorActualizarOrden manejadorActualizarOrden, ManejadorEliminarOrden manejadorEliminarOrden, ManejadorGenerarOrdenSalida manejadorGenerarOrdenSalida) {
        this.manejadorRegistrarOrden = manejadorRegistrarOrden;
        this.manejadorActualizarOrden = manejadorActualizarOrden;
        this.manejadorEliminarOrden = manejadorEliminarOrden;
        this.manejadorGenerarOrdenSalida = manejadorGenerarOrdenSalida;
    }

    @PostMapping
    public ComandoRespuesta<Long> registrar(@RequestBody ComandoOrden comandoOrden) {
        return this.manejadorRegistrarOrden.ejecutar(comandoOrden);
    }

    @PutMapping
    public ComandoRespuesta<Boolean> actualizar(@RequestBody ComandoOrden comandoOrden) {
        return this.manejadorActualizarOrden.ejecutar(comandoOrden);
    }

    @PutMapping(value = "/generar-orden")
    public ComandoRespuesta<Boolean> generarOrdenSalida(@RequestBody ComandoOrden comandoOrden) {
        return this.manejadorGenerarOrdenSalida.ejecutar(comandoOrden);
    }

    @DeleteMapping(value = "/{idOrden}")
    public ComandoRespuesta<Boolean> eliminar(@PathVariable Long idOrden) {
        return this.manejadorEliminarOrden.ejecutar(idOrden);
    }
}
