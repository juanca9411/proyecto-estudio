package com.ceiba.orden.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOrdenMysql implements RepositorioOrden {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "orden",value = "registrar")
    private static String sqlRegistrar;

    @SqlStatement(namespace = "orden",value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "orden",value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "orden",value = "existe")
    private static String sqlExiste;

    public RepositorioOrdenMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long registrar(Orden orden) {
        return this.customNamedParameterJdbcTemplate.crear(orden,sqlRegistrar);
    }

    @Override
    public Boolean actualizar(Orden orden) {
        return this.customNamedParameterJdbcTemplate.actualizar(sqlActualizar,orden);
    }

    @Override
    public Boolean eliminar(Long idOrden) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id_orden",idOrden);
        return this.customNamedParameterJdbcTemplate.actualizar(sqlEliminar,parameterSource);

    }

    @Override
    public Boolean existe(Long idOrden) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id_orden",idOrden);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,parameterSource,Boolean.class);
    }
}
