package com.asj.emcas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioSinIdDTO {

    @NotNull(message = "El usuario no puede estar en blanco")
    @NotBlank(message = "El usuario no puede estar en blanco")
    private String usuario;

    @NotNull(message = "El correo no puede estar en blanco")
    @NotBlank(message = "El correo no puede estar en blanco")
    private String correo;

    @NotNull(message = "La contraseña no puede estar en blanco")
    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String contrasenia;

}
