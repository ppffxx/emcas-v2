package com.asj.emcas.servicio.impl;

import com.asj.emcas.dto.PersonaAcotadaDTO;
import com.asj.emcas.entidad.Persona;
import com.asj.emcas.exceptions.Messages;
import com.asj.emcas.exceptions.NotFoundException;
import com.asj.emcas.mapper.PersonaMapper;
import com.asj.emcas.repositorio.PersonaRepositorio;
import com.asj.emcas.servicio.PersonaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonaServicioImpl implements PersonaServicio {
    private final PersonaRepositorio personaRepositorio;
    private final PersonaMapper personaMapper;
    @Override
    public PersonaAcotadaDTO actualizarPersona(Integer idPersona, Persona persona) {
        Persona personaEnt = personaRepositorio.findById(idPersona).orElseThrow(() -> new NotFoundException(Messages.getMessage("Persona", idPersona)));
        if(persona.getNombre() != null) {personaEnt.setNombre(persona.getNombre());}
        if(persona.getApellido() != null) {personaEnt.setApellido(persona.getApellido());}
        if(persona.getTelefono() != null) {personaEnt.setTelefono(persona.getTelefono());}
        Persona personaResponse = personaRepositorio.save(personaEnt);
        return personaMapper.PersonaEntityToPersonaAcotadaDTO(personaResponse);
    }

}
