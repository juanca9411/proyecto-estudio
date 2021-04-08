package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoVehiculo;

import java.util.List;

public interface DaoVehiculo {

    public List<DtoVehiculo> listar();

    public List<DtoVehiculo> listarByPlaca(String placa);
}
