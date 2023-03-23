package com.asj.emcas.entidad;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicios")

public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(length = 1500)
    private String descripcion;
    @Column(length = 100)
    private String imagen1;

    @Column(length = 100)
    private String imagen2;

    @Column(length = 100)
    private String imagen3;

    @Column(length = 100)
    private String imagen4;

    @Column
    private Double precio;

}
