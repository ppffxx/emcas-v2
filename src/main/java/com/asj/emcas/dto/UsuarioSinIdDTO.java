package com.asj.emcas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioSinIdDTO {

    private String usuario;
    private String correo;
    private String contrasenia;


}
