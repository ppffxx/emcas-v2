package com.asj.emcas.controlador;

import com.asj.emcas.dto.UsuarioLoginDTO;
import com.asj.emcas.dto.UsuarioSinIdDTO;
import com.asj.emcas.servicio.UsuarioServicio;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Api(value = "Allowed actios for the User Entity", tags = "User Controller")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    private final UsuarioServicio usuarioServicio;
    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioServicio.obtenerUsuario(idUsuario));
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UsuarioSinIdDTO usuarioSinIdDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServicio.crearUsuario(usuarioSinIdDTO));
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer idUsuario) {
        usuarioServicio.eliminarUsuario(idUsuario);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioServicio.loginUsuario(usuarioLoginDTO));
    }

}
