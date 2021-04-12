package com.ceiba.orden.controlador;

import com.ceiba.usuario.consulta.orden.ManejadorGetDetalleOrden;
import com.ceiba.usuario.consulta.orden.ManejadorListadoOrden;
import com.ceiba.usuario.modelo.dto.DtoOrden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class ConsultaControladorOrden {

    private final ManejadorListadoOrden manejadorListadoOrden;
    private final ManejadorGetDetalleOrden manejadorGetDetalleOrden;

    public ConsultaControladorOrden(ManejadorListadoOrden manejadorListadoOrden, ManejadorGetDetalleOrden manejadorGetDetalleOrden) {
        this.manejadorListadoOrden = manejadorListadoOrden;
        this.manejadorGetDetalleOrden = manejadorGetDetalleOrden;
    }

    @GetMapping
    public List<DtoOrden> listar() {
        return this.manejadorListadoOrden.listar();
    }

    @GetMapping(value = "/{idOrden}")
    public List<DtoOrden> listar(@PathVariable Long idOrden) {
        return this.manejadorGetDetalleOrden.listar(idOrden);
    }

}

