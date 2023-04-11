package com.asj.emcas.controlador;

import com.asj.emcas.entidad.Persona;
import com.asj.emcas.servicio.PersonaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/personas")
public class PersonaControlador {
    private final PersonaServicio personaServicio;
    @PutMapping("/{idPersona}")
    public ResponseEntity<?> actualizarPersona(@PathVariable Integer idPersona, @RequestBody Persona persona) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(personaServicio.actualizarPersona(idPersona, persona));
    }


}
