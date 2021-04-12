package com.ceiba.usuario.comando.manejador.orden;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoOrden;
import com.ceiba.usuario.comando.fabrica.orden.FabricaOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.servicio.orden.ServicioRegistrarOrden;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarOrden implements ManejadorComandoRespuesta<ComandoOrden, ComandoRespuesta<Long>> {

    private final ServicioRegistrarOrden servicioRegistrarOrden;
    private final FabricaOrden fabricaOrden;

    public ManejadorRegistrarOrden(ServicioRegistrarOrden servicioRegistrarOrden, FabricaOrden fabricaOrden) {
        this.servicioRegistrarOrden = servicioRegistrarOrden;
        this.fabricaOrden = fabricaOrden;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoOrden comandoOrden) {
        Orden orden = this.fabricaOrden.crear(comandoOrden);
        return new ComandoRespuesta<>(this.servicioRegistrarOrden.ejecutar(orden));
    }
}
