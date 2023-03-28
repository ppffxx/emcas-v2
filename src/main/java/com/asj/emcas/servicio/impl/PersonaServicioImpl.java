package com.asj.emcas.servicio.impl;

import com.asj.emcas.entidad.Persona;
import com.asj.emcas.repositorio.PersonaRepositorio;
import com.asj.emcas.servicio.PersonaServicio;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class PersonaServicioImpl implements PersonaServicio {

    private final PersonaRepositorio personaRepositorio;

    public PersonaServicioImpl(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    @Override
    public Persona actualizarPersona(Integer idPersona, Persona persona) {
        Persona personaActualizada;
        Optional<Persona> optionalPersona = personaRepositorio.findById(idPersona);
        if(optionalPersona.isPresent()) {
            personaActualizada = optionalPersona.get();

            personaActualizada.setNombre(persona.getNombre());
            personaActualizada.setApellido(persona.getApellido());
            personaActualizada.setTelefono(persona.getTelefono());
            try {
                return personaRepositorio.save(personaActualizada);
            }
            catch (RuntimeException ex) {
                throw new RuntimeException("Error al actualizar persona");
            }

        } else {
            throw new RuntimeException("Persona con el id " + idPersona + " no existe");
        }
    }

}
