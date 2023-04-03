package com.asj.emcas.servicio.impl;


import com.asj.emcas.entidad.Reserva;
import com.asj.emcas.repositorio.ReservaRepositorio;
import com.asj.emcas.servicio.ReservaServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicioImpl implements ReservaServicio {

    private final ReservaRepositorio reservaRepositorio;

    public ReservaServicioImpl(ReservaRepositorio reservaRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
    }


    @Override
    public List<Reserva> obtenerTodas() {
        return reservaRepositorio.findAll();
    }

    @Override
    public void crearReserva(Reserva reserva) {
        reservaRepositorio.save(reserva);
    }
}
