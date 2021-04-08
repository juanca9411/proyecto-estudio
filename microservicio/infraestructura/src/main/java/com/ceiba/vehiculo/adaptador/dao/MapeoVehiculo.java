package com.ceiba.vehiculo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoVehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoVehiculo implements RowMapper<DtoVehiculo>, MapperResult {

    @Override
    public DtoVehiculo mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long idVehiculo = rs.getLong("idvehiculo");
        String placa = rs.getString("placa");
        Integer cilindraje = rs.getInt("cilindraje");
        String tipo = rs.getString("tipo");

        return new DtoVehiculo(idVehiculo,placa,cilindraje,tipo);
    }
}
