package com.asj.emcas.servicio;

import com.asj.emcas.entidad.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaServicio {

    Persona crearPersona(Persona persona);
    Persona obtenerPersona(Integer idUsuario);
    Persona actualizarPersona(Integer idUsuario, Persona tmp);
    void eliminarPersona(Integer idUsuario);
    List<Persona> getall();

}
