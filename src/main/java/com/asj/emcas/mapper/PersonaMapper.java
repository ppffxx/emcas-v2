package com.asj.emcas.mapper;

import com.asj.emcas.dto.PersonaAcotadaDTO;
import com.asj.emcas.entidad.Persona;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaAcotadaDTO PersonaEntityToPersonaAcotadaDTO(Persona persona);

}
