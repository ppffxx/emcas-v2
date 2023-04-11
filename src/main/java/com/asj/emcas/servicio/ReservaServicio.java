package com.asj.emcas.servicio;

import com.asj.emcas.dto.ReservaAcotadaDTO;
import com.asj.emcas.entidad.Reserva;
import com.asj.emcas.entidad.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservaServicio {

    List<ReservaAcotadaDTO> obtenerTodas();

    void crearReserva(Reserva reserva);

}
