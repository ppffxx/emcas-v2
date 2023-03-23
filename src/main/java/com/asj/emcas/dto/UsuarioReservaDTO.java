package com.asj.emcas.dto;


import com.asj.emcas.entidad.Reserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioReservaDTO {

    private String usuario;
    private String correo;
    private String idUsuario;

    PersonaAcotadaDTO persona;

    List<ReservaAcotadaDTO> reservas;



}
