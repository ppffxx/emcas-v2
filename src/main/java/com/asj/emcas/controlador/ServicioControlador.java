package com.asj.emcas.controlador;


import com.asj.emcas.dto.ServicioSinIdDTO;
import com.asj.emcas.entidad.Servicio;
import com.asj.emcas.mapper.ServicioMapper;
import com.asj.emcas.servicio.ServServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioControlador {

    private final ServServicio servServicio;
    private final ServicioMapper servicioMapper;

    public ServicioControlador(ServServicio servServicio, ServicioMapper servicioMapper) {
        this.servServicio = servServicio;
        this.servicioMapper = servicioMapper;
    }


    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodos() {
        List<Servicio> serviciosTodos = servServicio.obtenerTodosServicios();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serviciosTodos);
    }

    @GetMapping("/{idServicio}")
    public ResponseEntity<?> obtenerServicio(@PathVariable Integer idServicio) {

        try {
            Servicio servicio = servServicio.obtenerServicio(idServicio);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio);
        }
        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<?> crearServicio(@RequestBody ServicioSinIdDTO servicioSinIdDTO) {
        try {

            Servicio servicio = servicioMapper.ServicioCreacionDTOToServicioEntity(servicioSinIdDTO);
            Servicio servicioNuevo = servServicio.crearServicio(servicio);
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioNuevo);
        }
        catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        finally {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("error en los datos mandados");
        }
    }

    @PutMapping("/{idServicio}")
    public ResponseEntity<?> actualizarServicio(@PathVariable Integer idServicio, @RequestBody ServicioSinIdDTO servicioSinIdDTO) {

        try {
            Servicio servicioTemp = servicioMapper.ServicioCreacionDTOToServicioEntity(servicioSinIdDTO);
            Servicio servicioAct = servServicio.actualizarServicio(idServicio, servicioTemp);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicioAct);
        }
        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

    @DeleteMapping("/{idServicio}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer idServicio) {
        try {
            servServicio.eliminarServicio(idServicio);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

    }


}
