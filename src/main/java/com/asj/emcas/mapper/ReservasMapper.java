package com.asj.emcas.mapper;


import com.asj.emcas.dto.ReservasTodasDTO;
import com.asj.emcas.entidad.Reserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservasMapper {

    ReservasTodasDTO ReservasEntityToReservasDTO(Reserva reserva);

}
