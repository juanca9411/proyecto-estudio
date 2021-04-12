package com.ceiba.orden.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoOrden;
import com.ceiba.usuario.puerto.dao.DaoOrden;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoOrdenMysql implements DaoOrden {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "orden", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "orden", value = "listarByIdOrden")
    private static String sqlListarByIdOrden;

    public DaoOrdenMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoOrden> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoOrden());
    }

    @Override
    public List<DtoOrden> getDetalle(Long idOrden) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id_orden", idOrden);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarByIdOrden, parameterSource, new MapeoOrden());
    }


}
