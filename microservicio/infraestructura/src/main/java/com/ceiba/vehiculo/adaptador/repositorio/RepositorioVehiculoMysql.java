package com.ceiba.vehiculo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Vehiculo;
import com.ceiba.usuario.puerto.repositorio.RepositorioVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVehiculoMysql implements RepositorioVehiculo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "vehiculo", value = "registrar")
    private static String sqlRegistrar;

    @SqlStatement(namespace = "vehiculo", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "vehiculo", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "vehiculo", value = "listarTipoVehiculo")
    private static String sqlSeleccionarTipoVehiculo;

    public RepositorioVehiculoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long registrar(Vehiculo vehiculo) {
        return this.customNamedParameterJdbcTemplate.crear(vehiculo, sqlRegistrar);
    }

    @Override
    public boolean actualizar(Vehiculo vehiculo) {
        return this.customNamedParameterJdbcTemplate.actualizar(sqlActualizar, vehiculo);
    }

    @Override
    public boolean existe(String placa) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("placa", placa);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);

    }

    @Override
    public String getTipoVehiculo(String placa) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("placa", placa);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlSeleccionarTipoVehiculo, parameterSource, String.class);
    }
}
