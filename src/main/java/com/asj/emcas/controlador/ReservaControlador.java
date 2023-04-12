package com.asj.emcas.controlador;

import com.asj.emcas.entidad.Reserva;
import com.asj.emcas.servicio.ReservaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/reservas")
public class ReservaControlador {
    private final ReservaServicio reservaServicio;
    @GetMapping("/todas")
    public ResponseEntity<?> obtenerTodas() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservaServicio.obtenerTodas());
    }

    @PostMapping
    public ResponseEntity<?> crearReserva(@Valid @RequestBody Reserva reserva) {
        reservaServicio.crearReserva(reserva);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
