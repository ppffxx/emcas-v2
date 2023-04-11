package com.asj.emcas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class ServicioSinIdDTO {

    @NotNull(message = "El nombre no puede estar en blanco")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    private String descripcion;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String imagen4;
    private Double precio;


}
