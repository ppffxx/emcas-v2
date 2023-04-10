package com.asj.emcas.controlador;


import com.asj.emcas.dto.UsuarioDTO;
import com.asj.emcas.dto.UsuarioLoginDTO;
import com.asj.emcas.dto.UsuarioReservaDTO;
import com.asj.emcas.dto.UsuarioSinIdDTO;
import com.asj.emcas.entidad.Usuario;
import com.asj.emcas.mapper.UsuarioMapper;
import com.asj.emcas.servicio.UsuarioServicio;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "Allowed actios for the User Entity", tags = "User Controller")
@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;
    private final UsuarioMapper usuarioMapper;

    public UsuarioControlador(UsuarioServicio usuarioServicio, UsuarioMapper usuarioMapper) {
        this.usuarioServicio = usuarioServicio;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Integer idUsuario) {

        try {
            Usuario usuario = usuarioServicio.obtenerUsuario(idUsuario);
            UsuarioReservaDTO usuarioReservaDTO = usuarioMapper.UsuarioEntityToUsuarioReservaDTO(usuario);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioReservaDTO);
        }

        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioSinIdDTO usuarioSinIdDTO) {

        try {
            Usuario usuario = usuarioMapper.UsuarioDTORegistroToUsuarioEntity(usuarioSinIdDTO);
            Usuario usuarioN = usuarioServicio.crearUsuario(usuario);
            UsuarioDTO temp = usuarioMapper.UsuarioEntityToUsuarioDTO(usuarioN);
            return ResponseEntity.status(HttpStatus.CREATED).body(temp);
        }

        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer idUsuario) {
        try {
            usuarioServicio.eliminarUsuario(idUsuario);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {

     try {
         Usuario usuarioTemp  = usuarioMapper.UsuarioLoginDTOToUsuarioEntity(usuarioLoginDTO);
         Usuario usuarioLogueado = usuarioServicio.loginUsuario(usuarioTemp);
         UsuarioDTO usuarioLog = usuarioMapper.UsuarioEntityToUsuarioDTO(usuarioLogueado);
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioLog);
     }

     catch (RuntimeException ex) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
     }

    }

}
