package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.usuario.servicio.orden.ServicioActualizarOrden;
import com.ceiba.usuario.servicio.orden.ServicioEliminarOrden;
import com.ceiba.usuario.servicio.orden.ServicioGenerarOrdenSalida;
import com.ceiba.usuario.servicio.orden.ServicioRegistrarOrden;
import com.ceiba.usuario.servicio.vehiculo.ServicioActualizarVehiculo;
import com.ceiba.usuario.servicio.vehiculo.ServicioRegistrarVehiculo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    
    @Bean
    public ServicioRegistrarVehiculo servicioRegistrarVehiculo(RepositorioVehiculo repositorioVehiculo){
        return  new ServicioRegistrarVehiculo(repositorioVehiculo);
    }

    @Bean
    public ServicioActualizarVehiculo servicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo){
        return new ServicioActualizarVehiculo(repositorioVehiculo);
    }

    @Bean
    public ServicioRegistrarOrden servicioRegistrarOrden(RepositorioOrden repositorioOrden){
        return new ServicioRegistrarOrden(repositorioOrden);
    }

    @Bean
    public ServicioActualizarOrden servicioActualizarOrden(RepositorioOrden repositorioOrden){
        return new ServicioActualizarOrden(repositorioOrden);
    }

    @Bean
    public ServicioEliminarOrden servicioEliminarOrden(RepositorioOrden repositorioOrden){
        return new ServicioEliminarOrden(repositorioOrden);
    }

    @Bean
    public ServicioGenerarOrdenSalida servicioGenerarOrdenSalida(RepositorioOrden repositorioOrden,RepositorioVehiculo repositorioVehiculo){
        return new ServicioGenerarOrdenSalida(repositorioOrden,repositorioVehiculo);
    }


}
