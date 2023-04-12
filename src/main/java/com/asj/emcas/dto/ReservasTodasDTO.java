package com.asj.emcas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReservasTodasDTO {

    private Integer idReserva;
    private LocalDate fechaReserva;
    UsuarioDTO usuarioDTO;

}
