package com.asj.emcas.mapper;


import com.asj.emcas.dto.ReservaAcotadaDTO;
import com.asj.emcas.dto.ReservasTodasDTO;
import com.asj.emcas.entidad.Reserva;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservasMapper {

    ReservasTodasDTO ReservasEntityToReservasDTO(Reserva reserva);
    List<ReservaAcotadaDTO> ReservasTodasEntityToReservasTodasDTO(List<Reserva> reservasLista);

}
