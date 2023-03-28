package com.asj.emcas.entidad;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(length = 20, nullable = false, unique = true)
    private String usuario;
    @Column(length = 45, nullable = false, unique = true)
    private String correo;
    @Column(length = 30, nullable = false)
    private String contrasenia;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<Reserva> reservas;
    @OneToOne(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private Persona persona;


}
