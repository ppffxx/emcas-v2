package com.asj.emcas.controlador;

import com.asj.emcas.dto.ReservasTodasDTO;
import com.asj.emcas.entidad.Reserva;
import com.asj.emcas.mapper.ReservasMapper;
import com.asj.emcas.servicio.ReservaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/reservas")
public class ReservaControlador {

    private final ReservaServicio reservaServicio;


    public ReservaControlador(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }


    @GetMapping("/todas")
    public ResponseEntity<?> obtenerTodas() {

        List<Reserva> reservasTodas = reservaServicio.obtenerTodas();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservasTodas);
    }




}
