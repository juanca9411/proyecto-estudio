package com.ceiba.usuario.comando.manejador.orden;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.servicio.orden.ServicioEliminarOrden;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarOrden implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Boolean>> {

    private final ServicioEliminarOrden servicioEliminarOrden;

    public ManejadorEliminarOrden(ServicioEliminarOrden servicioEliminarOrden) {
        this.servicioEliminarOrden = servicioEliminarOrden;
    }

    @Override
    public ComandoRespuesta<Boolean> ejecutar(Long idOrden) {
        return new ComandoRespuesta<>(this.servicioEliminarOrden.ejecutar(idOrden));
    }
}
