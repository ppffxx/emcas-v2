package com.asj.emcas.mapper;

import com.asj.emcas.dto.ServicioSinIdDTO;
import com.asj.emcas.entidad.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    Servicio ServicioCreacionDTOToServicioEntity(ServicioSinIdDTO servicioSinIdDTO);



}
