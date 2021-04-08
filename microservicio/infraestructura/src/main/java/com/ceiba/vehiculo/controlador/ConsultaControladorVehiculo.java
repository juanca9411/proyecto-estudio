package com.ceiba.vehiculo.controlador;

import com.ceiba.usuario.consulta.vehiculo.ManejadorListarVehiculo;
import com.ceiba.usuario.consulta.vehiculo.ManejadorListarVehiculoByPlaca;
import com.ceiba.usuario.modelo.dto.DtoVehiculo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class ConsultaControladorVehiculo {

    private ManejadorListarVehiculo manejadorListarVehiculo;
    private ManejadorListarVehiculoByPlaca manejadorListarVehiculoByPlaca;

    public ConsultaControladorVehiculo(ManejadorListarVehiculo manejadorListarVehiculo,ManejadorListarVehiculoByPlaca manejadorListarVehiculoByPlaca){
        this.manejadorListarVehiculo=manejadorListarVehiculo;
        this.manejadorListarVehiculoByPlaca=manejadorListarVehiculoByPlaca;
    }

    @GetMapping
    public List<DtoVehiculo> listar(){
        return this.manejadorListarVehiculo.ejecutar();
    }

    @GetMapping(value = "/{placa}")
    public List<DtoVehiculo> listar(@PathVariable String placa){
        return this.manejadorListarVehiculoByPlaca.ejecutar(placa);
    }
}
