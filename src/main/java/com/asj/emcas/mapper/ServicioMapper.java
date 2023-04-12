package com.asj.emcas.mapper;

import com.asj.emcas.dto.ServicioDTO;
import com.asj.emcas.dto.ServicioSinIdDTO;
import com.asj.emcas.entidad.Servicio;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    Servicio ServicioCreacionDTOToServicioEntity(ServicioSinIdDTO servicioSinIdDTO);

    ServicioDTO ServicioEntityToServicioDTO(Servicio servicio);

    List<ServicioDTO> ServiciosTododEntityToServiciosTodosDTO(List<Servicio> serviciosTodos);

}
