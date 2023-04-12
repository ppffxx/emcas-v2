package com.asj.emcas.servicio;

import com.asj.emcas.dto.PersonaAcotadaDTO;
import com.asj.emcas.entidad.Persona;
import org.springframework.stereotype.Service;

@Service
public interface PersonaServicio {

    PersonaAcotadaDTO actualizarPersona(Integer idUsuario, Persona tmp);


}
