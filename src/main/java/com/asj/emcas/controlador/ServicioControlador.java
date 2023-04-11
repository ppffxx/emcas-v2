package com.asj.emcas.controlador;


import com.asj.emcas.dto.ServicioSinIdDTO;
import com.asj.emcas.entidad.Servicio;
import com.asj.emcas.mapper.ServicioMapper;
import com.asj.emcas.servicio.ServServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/servicios")
public class ServicioControlador {

    private final ServServicio servServicio;
    private final ServicioMapper servicioMapper;

    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servServicio.obtenerTodosServicios());
    }

    @GetMapping("/{idServicio}")
    public ResponseEntity<?> obtenerServicio(@PathVariable Integer idServicio) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servServicio.obtenerServicio(idServicio));
    }

    @PostMapping
    public ResponseEntity<?> crearServicio(@Valid @RequestBody ServicioSinIdDTO servicioSinIdDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servServicio.crearServicio(servicioSinIdDTO));
    }

    @PutMapping("/{idServicio}")
    public ResponseEntity<?> actualizarServicio(@Valid @PathVariable Integer idServicio, @RequestBody ServicioSinIdDTO servicioSinIdDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servServicio.actualizarServicio(idServicio, servicioSinIdDTO));
    }

    @DeleteMapping("/{idServicio}")
    public ResponseEntity<?> eliminarServicio(@PathVariable Integer idServicio) {
        servServicio.eliminarServicio(idServicio);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
