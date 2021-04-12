package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoVehiculo {

    private Long idVehiculo;
    private String placa;
    private Integer cilindraje;
    private String tipo;
}
