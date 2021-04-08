package com.ceiba.usuario.comando.manejador.orden;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoOrden;
import com.ceiba.usuario.comando.fabrica.orden.FabricaOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.servicio.orden.ServicioActualizarOrden;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarOrden implements ManejadorComandoRespuesta<ComandoOrden, ComandoRespuesta<Boolean>> {

    private final ServicioActualizarOrden actualizarOrden;
    private final FabricaOrden fabricaOrden;

    public ManejadorActualizarOrden(ServicioActualizarOrden actualizarOrden, FabricaOrden fabricaOrden) {
        this.actualizarOrden = actualizarOrden;
        this.fabricaOrden = fabricaOrden;
    }

    @Override
    public ComandoRespuesta<Boolean> ejecutar(ComandoOrden comandoOrden) {
        Orden orden = this.fabricaOrden.crear(comandoOrden);
        return new ComandoRespuesta<>(this.actualizarOrden.ejecutar(orden));
    }
}
