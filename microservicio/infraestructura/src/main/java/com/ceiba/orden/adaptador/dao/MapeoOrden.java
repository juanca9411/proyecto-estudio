package com.ceiba.orden.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoOrden;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoOrden implements RowMapper<DtoOrden>, MapperResult {


    @Override
    public DtoOrden mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idOrden = resultSet.getLong("id_orden");
        String placa = resultSet.getString("placa");
        LocalDateTime fechaIngreso = extraerLocalDateTime(resultSet, "fecha_ingreso");
        LocalDateTime fechaSalida = extraerLocalDateTime(resultSet, "fecha_salida");
        Double valorTotal = resultSet.getDouble("valor_total");
        return new DtoOrden(
                idOrden,
                placa,
                fechaIngreso,
                fechaSalida, valorTotal
        );
    }
}
