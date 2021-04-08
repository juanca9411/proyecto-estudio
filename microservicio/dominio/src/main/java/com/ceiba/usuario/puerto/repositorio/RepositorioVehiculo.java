package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Vehiculo;


public interface RepositorioVehiculo {

     Long registrar(Vehiculo vehiculo);

     boolean actualizar(Vehiculo vehiculo);

     boolean existe(String placa);

     String getTipoVehiculo(String placa);

}
