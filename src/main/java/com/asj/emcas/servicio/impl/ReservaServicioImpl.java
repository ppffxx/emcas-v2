package com.asj.emcas.servicio.impl;

import com.asj.emcas.dto.ReservaAcotadaDTO;
import com.asj.emcas.entidad.Reserva;
import com.asj.emcas.mapper.ReservasMapper;
import com.asj.emcas.repositorio.ReservaRepositorio;
import com.asj.emcas.servicio.ReservaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservaServicioImpl implements ReservaServicio {
    private final ReservaRepositorio reservaRepositorio;
    private final ReservasMapper reservasMapper;
    @Override
    public List<ReservaAcotadaDTO> obtenerTodas() {
        List<Reserva> reservasTodas = reservaRepositorio.findAll();
        List<ReservaAcotadaDTO> reservaAcotadaDTOS = reservasMapper.ReservasTodasEntityToReservasTodasDTO(reservasTodas);
        return reservaAcotadaDTOS;
    }

    @Override
    public void crearReserva(Reserva reserva) {
        reservaRepositorio.save(reserva);
    }
}
