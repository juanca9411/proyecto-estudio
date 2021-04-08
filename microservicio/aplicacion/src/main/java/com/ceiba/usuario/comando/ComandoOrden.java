package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ComandoOrden {

    private Long idOrden;
    private String placa;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private Double valorTotal;
}
