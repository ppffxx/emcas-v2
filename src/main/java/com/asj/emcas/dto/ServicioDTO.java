package com.asj.emcas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServicioDTO {

    private Integer idServicio;
    private String nombre;
    private String descripcion;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String imagen4;
    private Double precio;

}
