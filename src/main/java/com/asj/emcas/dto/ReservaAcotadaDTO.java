package com.asj.emcas.dto;

import com.asj.emcas.entidad.Servicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReservaAcotadaDTO {

    private Integer idReserva;

    private LocalDate fechaReserva;

    private ServicioAcotadoDTO servicio;


}
