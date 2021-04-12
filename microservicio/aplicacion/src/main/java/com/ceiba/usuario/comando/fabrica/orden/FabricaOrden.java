package com.ceiba.usuario.comando.fabrica.orden;

import com.ceiba.usuario.comando.ComandoOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import org.springframework.stereotype.Component;

@Component
public class FabricaOrden {

    public Orden crear(ComandoOrden comandoOrden) {
        return new Orden(
                comandoOrden.getIdOrden(),
                comandoOrden.getPlaca(),
                comandoOrden.getFechaIngreso(),
                comandoOrden.getFechaSalida(),
                comandoOrden.getValorTotal()
        );
    }
}
