package com.asj.emcas.controlador;


import com.asj.emcas.entidad.Persona;
import com.asj.emcas.servicio.PersonaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/personas")
public class PersonaControlador {

    private final PersonaServicio personaServicio;

    public PersonaControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @PutMapping("/{idPersona}")
    public ResponseEntity<?> actualizarPersona(@PathVariable Integer idPersona, @RequestBody Persona persona) {

        try {
            Persona personaActualizada = personaServicio.actualizarPersona(idPersona, persona);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(personaActualizada);
        }

        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }


}
