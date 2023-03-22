package com.asj.emcas.servicio;

import com.asj.emcas.entidad.Persona;

import java.util.List;

public interface PersonaServicio {

    Persona crearPersona(Persona persona);
    Persona obtenerPersona(Integer idUsuario);
    Persona actualizarPersona(Integer idUsuario, Persona tmp);
    void eliminarPersona(Integer idUsuario);
    List<Persona> getall();

}
