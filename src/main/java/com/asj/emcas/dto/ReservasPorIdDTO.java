package com.asj.emcas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReservasPorIdDTO {

    Integer idReserva;
    String nombre;
    Double precio;
    LocalDate fechaReserva;


}
