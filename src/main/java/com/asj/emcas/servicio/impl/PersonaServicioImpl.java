package com.asj.emcas.servicio.impl;

import com.asj.emcas.entidad.Persona;
import com.asj.emcas.servicio.PersonaServicio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonaServicioImpl implements PersonaServicio {


    @Override
    public Persona crearPersona(Persona persona) {
        return null;
    }

    @Override
    public Persona obtenerPersona(Integer idUsuario) {
        return null;
    }

    @Override
    public Persona actualizarPersona(Integer idUsuario, Persona tmp) {
        return null;
    }

    @Override
    public void eliminarPersona(Integer idUsuario) {

    }

    @Override
    public List<Persona> getall() {
        return null;
    }
}
