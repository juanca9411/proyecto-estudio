package com.ceiba.usuario.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionDiaNoHabil;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Orden {

    public static final String DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO = "La placa del vehiculo es obligatoria";
    public static final String DEBE_INGRESAR_FECHA_INGRESO = "La fecha de ingreso es obligatoria";
    public static final String ENTRADA_Y_SALIDA_DE_VEHICULOS_SOLO_EN_DIAS_HABILES = "Solo se pueden ingresar o salir vehiculos en dias habiles";
    public static final String DEBE_INGRESAR_FECHA_DE_SALIDA = "Para finalizar la orden es necesario ingresar una fecha de salida";

    private Long idOrden;
    private String placa;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private Double valorTotal;


    public Orden(Long idOrden, String placa, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, Double valorTotal) {

        validarObligatorio(placa, DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO);
        validarObligatorio(fechaIngreso, DEBE_INGRESAR_FECHA_INGRESO);
        validarFechaFindeSemana(fechaIngreso);

        this.idOrden = idOrden;
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.valorTotal = valorTotal;
    }

    private void validarFechaFindeSemana(LocalDateTime fechaValidar) {
        if (fechaValidar.getDayOfWeek() == DayOfWeek.SATURDAY || fechaValidar.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ExcepcionDiaNoHabil(ENTRADA_Y_SALIDA_DE_VEHICULOS_SOLO_EN_DIAS_HABILES);
        }
    }

    public void generarOrdenSalida(String tipoVehiculo){
       Tarifa tarifa = new Tarifa();
        validarObligatorio(this.fechaSalida, DEBE_INGRESAR_FECHA_DE_SALIDA);
        validarFechaFindeSemana(this.fechaSalida);
        this.valorTotal = tarifa.calcularTotal(tipoVehiculo,this.fechaIngreso,this.fechaSalida);
    }

}
