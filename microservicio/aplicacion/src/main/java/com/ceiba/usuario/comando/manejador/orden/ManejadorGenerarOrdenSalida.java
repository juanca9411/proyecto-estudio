package com.ceiba.usuario.comando.manejador.orden;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoOrden;
import com.ceiba.usuario.comando.fabrica.orden.FabricaOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.servicio.orden.ServicioGenerarOrdenSalida;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGenerarOrdenSalida implements ManejadorComandoRespuesta<ComandoOrden, ComandoRespuesta<Boolean>> {

    private final ServicioGenerarOrdenSalida servicioGenerarOrdenSalida;
    private final FabricaOrden fabricaOrden;

    public ManejadorGenerarOrdenSalida(ServicioGenerarOrdenSalida servicioGenerarOrdenSalida, FabricaOrden fabricaOrden) {
        this.servicioGenerarOrdenSalida = servicioGenerarOrdenSalida;
        this.fabricaOrden = fabricaOrden;
    }

    @Override
    public ComandoRespuesta<Boolean> ejecutar(ComandoOrden comandoOrden) {
        Orden orden = this.fabricaOrden.crear(comandoOrden);
        return new ComandoRespuesta<>(this.servicioGenerarOrdenSalida.ejecutar(orden));
    }
}
