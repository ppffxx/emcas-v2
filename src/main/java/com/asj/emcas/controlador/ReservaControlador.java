package com.asj.emcas.controlador;

import com.asj.emcas.entidad.Reserva;
import com.asj.emcas.servicio.ReservaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva) {

        try {
            reservaServicio.crearReserva(reserva);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Datos mal ingresados");
        }

    }



}
